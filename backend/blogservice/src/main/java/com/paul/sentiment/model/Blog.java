package com.paul.sentiment.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(value="Blogs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Blog {
    @Id
    private UUID id;
    private String username;
    private String description;
    private String image;
    private int upVotes;
    private int downVotes;
    
    
    

}
