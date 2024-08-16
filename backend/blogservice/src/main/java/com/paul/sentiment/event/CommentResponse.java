package com.paul.sentiment.event;


import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    
    private String post_id;
    private String username;
    private String comment;
    private int rating;
    
}
