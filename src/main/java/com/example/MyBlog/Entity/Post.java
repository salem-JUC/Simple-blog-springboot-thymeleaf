package com.example.MyBlog.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "author_name" , nullable = false)
    private String author_name;

    @Column(nullable = false, updatable = false , name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToMany(mappedBy = "post" , cascade = CascadeType.REMOVE , orphanRemoval = true , fetch = FetchType.LAZY)
    private List<Comment> comments;
    public Post() {
        this.createdAt = new Date();
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.author_name = "Salem";
        this.createdAt = new Date();
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getCommentList() {
        return comments;
    }


    public void setCommentList(List<Comment> comments) {
        this.comments = comments;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

