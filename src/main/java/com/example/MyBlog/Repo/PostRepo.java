package com.example.MyBlog.Repo;

import com.example.MyBlog.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post , Long> {

    public Post getPostById(long id);
}
