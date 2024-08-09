package com.paul.sentiment.service;

import com.paul.sentiment.dto.BlogDto;
import com.paul.sentiment.mapper.DataMapper;
import com.paul.sentiment.model.Blog;
import com.paul.sentiment.repository.BlogRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
    
}
