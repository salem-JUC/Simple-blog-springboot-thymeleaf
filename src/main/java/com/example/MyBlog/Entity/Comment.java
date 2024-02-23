package com.example.MyBlog.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id" ,  referencedColumnName = "post_id")
    private Post post;

    @Column(nullable = false, columnDefinition = "TEXT" , name = "content")
    private String commentText;

    @Column(nullable = false, updatable = false , name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Constructors, getters, and setters

    public Comment() {
        this.createdAt = new Date();
    }

    public Comment(Post post , String commentText) {
        this.post = post;
        this.commentText = commentText;
        this.createdAt = new Date();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

