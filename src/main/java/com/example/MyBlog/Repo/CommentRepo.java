package com.example.MyBlog.Repo;

import com.example.MyBlog.Entity.Comment;
import com.example.MyBlog.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment , Long> {
    public List<Comment> findByPost(Post post);
}
