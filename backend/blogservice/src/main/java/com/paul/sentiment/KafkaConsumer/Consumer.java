package com.paul.sentiment.KafkaConsumer;


import com.paul.sentiment.model.Comment;
import com.paul.sentiment.event.CommentResponse;
import com.paul.sentiment.exception.BlogNotFoundException;
import com.paul.sentiment.model.Blog;
import com.paul.sentiment.repository.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

@Service
public class Consumer {


    private static final Logger log = LoggerFactory.getLogger(Consumer.class);
    @Autowired
    private BlogRepository blogRepository;

    @KafkaListener(topics = "COMMENT_TOPIC",groupId = "comment-consumer-group")
    public void commentConsumer(CommentResponse commentResponse){
        Optional<Blog> fetched_blog=blogRepository.findById(commentResponse.getPost_id());
        if(fetched_blog.isPresent()){
            fetched_blog.get().getComments().add(Comment.builder()
                    .username(commentResponse.getUsername())
                    .comment(commentResponse.getComment())
                    .rating(commentResponse.getRating()).build());
            fetched_blog.get().getComments().sort(Comparator.comparingInt(Comment::getRating).reversed());
            blogRepository.save(fetched_blog.get());
        }
        else{
            throw new BlogNotFoundException("Blog is not found in the database to add the comment");
        }
        log.info("RECEIVED KAFKA MESSAGE CONSUMED:{}",commentResponse);
    }
    
    
}
