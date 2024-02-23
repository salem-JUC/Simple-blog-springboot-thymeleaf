package com.example.MyBlog;

import com.example.MyBlog.Entity.Comment;
import com.example.MyBlog.Entity.Post;
import com.example.MyBlog.Service.CommentService;
import com.example.MyBlog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;
    @Override
    public void run(String... args) {
        List<Post> list = postService.getAllPosts();

        if (list.isEmpty()){
            Post post1 = new Post("Blog 1" , "Content of blog 1" , "Salem");
            postService.savePost(post1);
            commentService.save(new Comment(post1 , "Comment 1 for blog 1"));
            commentService.save(new Comment(post1 , "Comment 2 for blog 1"));

            Post post2 = new Post("Blog 2" , "Content of blog 2" , "Saleh");
            postService.savePost(post2);
            commentService.save(new Comment(post2 , "Comment 1 for blog 2"));
            commentService.save(new Comment(post2 , "Comment 2 for blog 2"));




        }

    }
}
