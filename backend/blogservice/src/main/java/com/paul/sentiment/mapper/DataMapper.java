package com.paul.sentiment.mapper;

import com.paul.sentiment.dto.BlogDto;
import com.paul.sentiment.model.Blog;
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
                .downVotes(blog.getDownVotes()).build();
    }
    public Blog MaptoBlog(BlogDto blogDto) {
        return Blog.builder()
                .id(blogDto.getId())
                .username(blogDto.getUsername())
                .description(blogDto.getDescription())
                .image(blogDto.getImage())
                .upVotes(blogDto.getUpVotes())
                .downVotes(blogDto.getDownVotes()).build();
    }
}
