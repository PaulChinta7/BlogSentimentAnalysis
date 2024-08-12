package com.paul.sentiment.mapper;

import com.paul.sentiment.dto.BlogDto;
import com.paul.sentiment.model.Blog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class DataMapperTest {

    private DataMapper dataMapper;
    
    @BeforeEach
    void setUp(){
        dataMapper=new DataMapper();
    }
    
    @Test
    void maptoBlogDto() {
        Blog blog=Blog.builder()
                .username("Randy Orton")
                .description("Oth nondisp fx of base of 1st MC bone, r hand, 7thB")
                .image("http://dummyimage.com/223x100.png/dddddd/000000")
                .upVotes(50)
                .downVotes(40)
                .build();
        BlogDto blogDto = dataMapper.MaptoBlogDto(blog);

        Assertions.assertEquals(blog.getUsername(),blogDto.getUsername());
        Assertions.assertEquals(blog.getDescription(),blogDto.getDescription());
        Assertions.assertEquals(blog.getImage(),blogDto.getImage());
        Assertions.assertEquals(blog.getUpVotes(),blogDto.getUpVotes());
        Assertions.assertEquals(blog.getDownVotes(),blogDto.getDownVotes());
        Assertions.assertNotNull(blogDto);

    }

    @Test
    void maptoBlog() {
        BlogDto blogDto=BlogDto.builder()
                .username("Randy Orton")
                .description("Oth nondisp fx of base of 1st MC bone, r hand, 7thB")
                .image("http://dummyimage.com/223x100.png/dddddd/000000")
                .upVotes(50)
                .downVotes(40)
                .build();
        Blog blog = dataMapper.MaptoBlog(blogDto);

        assertEquals(blog.getUsername(),blogDto.getUsername());
        assertEquals(blog.getDescription(),blogDto.getDescription());
        assertEquals(blog.getImage(),blogDto.getImage());
        assertEquals(blog.getUpVotes(),blogDto.getUpVotes());
        assertEquals(blog.getDownVotes(),blogDto.getDownVotes());
        assertNotNull(blogDto);
    }
}