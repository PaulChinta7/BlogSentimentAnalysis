package com.paul.sentiment.model;


import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Comment {
    private String username;
    private String comment;
    private int rating;
}
