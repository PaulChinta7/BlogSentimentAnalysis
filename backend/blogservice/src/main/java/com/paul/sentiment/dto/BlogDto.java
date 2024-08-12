package com.paul.sentiment.dto;

import lombok.*;

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
}

