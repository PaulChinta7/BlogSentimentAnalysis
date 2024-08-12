package com.paul.sentiment.mapper;

import com.paul.sentiment.dto.BlogDto;
import com.paul.sentiment.dto.CommentDto;
import com.paul.sentiment.model.Blog;
import com.paul.sentiment.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {


    public BlogDto MaptoBlogDto(Blog blog) {
        return BlogDto.builder()
                .id(blog.getId())
                .username(blog.getUsername())
                .description(blog.getDescription())
                .image(blog.getImage())
                .upVotes(blog.getUpVotes())
                .downVotes(blog.getDownVotes())
                .comments(blog.getComments()).build();
    }
    public Blog MaptoBlog(BlogDto blogDto) {
        return Blog.builder()
                .id(blogDto.getId())
                .username(blogDto.getUsername())
                .description(blogDto.getDescription())
                .image(blogDto.getImage())
                .upVotes(blogDto.getUpVotes())
                .downVotes(blogDto.getDownVotes())
                .comments(blogDto.getComments()).build();
    }

    public Comment MaptoComment(CommentDto commentDto) {
        return Comment.builder()
                .username(commentDto.getUsername())
                .comment(commentDto.getComment())
                .rating(commentDto.getRating())
                .build();
    }

    public CommentDto MaptoCommentDto(Comment comment) {
        return CommentDto.builder()
                .username(comment.getUsername())
                .comment(comment.getComment())
                .rating(comment.getRating())
                .build();
    }
    
}
