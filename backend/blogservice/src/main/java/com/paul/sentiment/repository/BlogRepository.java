package com.paul.sentiment.repository;

import com.paul.sentiment.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {
}
