package com.paul.sentiment.service;


import com.paul.sentiment.model.Blog;
import com.paul.sentiment.dto.BlogDto;
import com.paul.sentiment.mapper.DataMapper;
import com.paul.sentiment.repository.BlogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


class BlogServiceTest {

    @InjectMocks
    private BlogService blogService;
    @Mock
    private BlogRepository blogRepository;
    @Mock
    private DataMapper dataMapper;
    
    
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void getBlogs() {
        List<Blog> blog_list=new ArrayList<>();
        Blog blog1=Blog.builder()
                .username("Randy Orton")
                .description("Oth nondisp fx of base of 1st MC bone, r hand, 7thB")
                .image("http://dummyimage.com/223x100.png/dddddd/000000")
                .upVotes(50)
                .downVotes(40)
                .build();
        Blog blog2=Blog.builder()
                .username("John Whaye")
                .description("Oth nondisp fx of base of 1st MC bone, r hand, 7thB")
                .image("http://dummyimage.com/223x100.png/dddddd/000000")
                .upVotes(20)
                .downVotes(15)
                .build();
        blog_list.add(blog1);
        blog_list.add(blog2);

        List<BlogDto> blogDto_list=new ArrayList<>();
        BlogDto blogDto1=BlogDto.builder()
                .username("Randy Orton")
                .description("Oth nondisp fx of base of 1st MC bone, r hand, 7thB")
                .image("http://dummyimage.com/223x100.png/dddddd/000000")
                .upVotes(50)
                .downVotes(40)
                .build();
        BlogDto blogDto2=BlogDto.builder()
                .username("John Whaye")
                .description("Oth nondisp fx of base of 1st MC bone, r hand, 7thB")
                .image("http://dummyimage.com/223x100.png/dddddd/000000")
                .upVotes(20)
                .downVotes(15)
                .build();
        blogDto_list.add(blogDto1);
        blogDto_list.add(blogDto2);
        when(blogRepository.findAll()).thenReturn(blog_list);
       when(dataMapper.MaptoBlogDto(blog1)).thenReturn(blogDto1);
       when(dataMapper.MaptoBlogDto(blog2)).thenReturn(blogDto2);
       
       List<BlogDto>converted_blogDto=blogService.getBlogs().getBody();

        Assertions.assertEquals(blogDto_list.size(),converted_blogDto.size());
        Assertions.assertTrue(converted_blogDto.contains(blogDto1));
        Assertions.assertTrue(converted_blogDto.contains(blogDto2));
        
        
        verify(blogRepository,times(1)).findAll();
        
        
        
        
        
    }
}