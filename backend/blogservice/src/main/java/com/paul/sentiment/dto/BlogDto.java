package com.paul.sentiment.dto;

import com.paul.sentiment.model.Comment;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private String id;
    private String username;
    private String description;
    private String image;
    private int upVotes;
    private int downVotes;
    private List<Comment> comments;
}

