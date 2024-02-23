package com.example.MyBlog.Service;

import com.example.MyBlog.Entity.Comment;
import com.example.MyBlog.Entity.Post;
import com.example.MyBlog.Repo.CommentRepo;
import com.example.MyBlog.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    CommentRepo commentRepo;

    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    public Post getPostById(long id){
        return postRepo.getPostById(id);
    }

    public Post savePost(Post post){
        return postRepo.save(post);
    }

    public void deletePost(long id){
        postRepo.deleteById(id);
    }




}
