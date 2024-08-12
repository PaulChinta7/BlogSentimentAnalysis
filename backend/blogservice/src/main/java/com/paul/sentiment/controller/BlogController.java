package com.paul.sentiment.controller;

import com.paul.sentiment.dto.BlogDto;
import com.paul.sentiment.dto.CommentDto;
import com.paul.sentiment.model.Comment;
import com.paul.sentiment.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    
    @PostMapping("/addBlog")
    public ResponseEntity<Void> addBlog(@RequestBody BlogDto blogDto){
        return blogService.addBlog(blogDto);
    }
    
    @PostMapping("/addComment")
    public ResponseEntity<Void> addComment(@RequestBody CommentDto commentDto,@RequestParam String id){
        return blogService.addComment(commentDto,id);
    }
    @PostMapping("/upVote")
    public ResponseEntity<Void> upVote(@RequestParam String id){
        return blogService.upVote(id);
    }

    @PostMapping("/downVote")
    public ResponseEntity<Void> downVote(@RequestParam String id){
        return blogService.downVote(id);
    }
}
