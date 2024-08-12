package com.paul.sentiment.service;

import com.paul.sentiment.dto.BlogDto;
import com.paul.sentiment.dto.CommentDto;
import com.paul.sentiment.exception.BlogNotFoundException;
import com.paul.sentiment.mapper.DataMapper;
import com.paul.sentiment.model.Blog;
import com.paul.sentiment.model.Comment;
import com.paul.sentiment.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {
    
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    DataMapper dataMapper;
    
    public ResponseEntity<List<BlogDto>> getBlogs(){
        
        List<Blog> fetchedBlogs = blogRepository.findAll();
        List<BlogDto> blogs=new ArrayList<>();
        
        for(Blog blog: fetchedBlogs) {
            blogs.add(dataMapper.MaptoBlogDto(blog));
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
//        Cannot connect to database Exception
    }

    public ResponseEntity<Void> addBlog(BlogDto blogDto) {
        Blog blog=dataMapper.MaptoBlog(blogDto);
        BlogDto fetched_blogDto=dataMapper.MaptoBlogDto(blogRepository.save(blog));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<Void> addComment(CommentDto commentDto,String id) {
        Comment comment=dataMapper.MaptoComment(commentDto);
        Optional<Blog> blog=blogRepository.findById(id);
        if(blog.isPresent()){
            blog.get().getComments().add(comment);
            blogRepository.save(blog.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else throw new BlogNotFoundException("Blog is not found in the database");
        
        
    }

    public ResponseEntity<Void> upVote(String id) {
        Optional<Blog> blog=blogRepository.findById(id);
        if(blog.isPresent()){
            blog.get().setUpVotes(blog.get().getUpVotes()+1);
            blogRepository.save(blog.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else throw new BlogNotFoundException("Blog is not found in the database");
    }

    public ResponseEntity<Void> downVote(String id) {
        Optional<Blog> blog=blogRepository.findById(id);
        if(blog.isPresent()){
            blog.get().setDownVotes(blog.get().getDownVotes()+1);
            blogRepository.save(blog.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else throw new BlogNotFoundException("Blog is not found in the database");
    }
}
