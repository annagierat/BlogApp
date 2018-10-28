package com.anna.gierat.blogApplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comment;

    private Date added = new Date();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postId")
    private Post post;


    public void setPost(Post post){
        this.post = post;
    }

    public void setComment(String comment) {

        this.comment = comment;

    }

}
