package com.anna.gierat.blogApplication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date added = new Date();


    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post(){

    }
}
