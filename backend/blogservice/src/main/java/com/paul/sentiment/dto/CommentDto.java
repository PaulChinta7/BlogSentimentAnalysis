package com.paul.sentiment.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    
    private String username;
    private String comment;
    private int rating;
}
