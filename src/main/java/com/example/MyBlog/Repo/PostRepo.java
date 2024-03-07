package com.example.MyBlog.Repo;

import com.example.MyBlog.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepo extends JpaRepository<Post , Long> {

    public Optional<Post> getPostById(long id);
}
