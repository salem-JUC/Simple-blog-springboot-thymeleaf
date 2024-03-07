package com.example.MyBlog.Service;

import com.example.MyBlog.Entity.Comment;
import com.example.MyBlog.Entity.Post;
import com.example.MyBlog.Repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Post getPostOfThisCommentById(Long id){
        Optional<Comment> cmnt = commentRepo.findById(id);
        Comment comment;
        if (cmnt.isPresent()){
            comment = cmnt.get();
            return comment.getPost();
        }
        System.out.println("the comment is not exist");
        return null;
    }
    public Comment getCommentById(Long id){
        Optional<Comment> comment = commentRepo.findById(id);
        if (comment.isPresent()){
            return comment.get();
        }
        return null;
    }

}
