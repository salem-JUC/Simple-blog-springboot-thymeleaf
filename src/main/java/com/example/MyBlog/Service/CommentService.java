package com.example.MyBlog.Service;

import com.example.MyBlog.Entity.Comment;
import com.example.MyBlog.Repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public Comment save(Comment comment){
        return commentRepo.save(comment);
    }

    public void deleteCommentById(long id){
        commentRepo.deleteById(id);
    }

}
