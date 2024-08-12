package com.paul.sentiment.controller;

import com.paul.sentiment.dto.BlogDto;
import com.paul.sentiment.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;
    
    @GetMapping("/getblogs")
    public ResponseEntity<List<BlogDto>> getBlogs(){
        return blogService.getBlogs();
    }
    
    
}
