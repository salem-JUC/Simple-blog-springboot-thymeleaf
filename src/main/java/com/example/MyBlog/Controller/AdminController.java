package com.example.MyBlog.Controller;

import com.example.MyBlog.Entity.Post;
import com.example.MyBlog.Service.CommentService;
import com.example.MyBlog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "deleteComment/{id}" , method = RequestMethod.GET)
    public String deleteCommentPost (@PathVariable long id){
        Long idOfPost = commentService.getPostOfThisCommentById(id).getId();
        commentService.deleteCommentById(id);
        return "redirect:/Post/"+idOfPost;
    }

    @RequestMapping(value = "deletePost/{id}" , method = RequestMethod.GET)
    public String deletePost (@PathVariable long id){
        postService.deletePostById(id);
        return "redirect:/Post";
    }

    @RequestMapping(value = "/newPost" , method = RequestMethod.GET)
    public String showPostForm(){
        return "PostForm.html";
    }

    @RequestMapping(value = "/newPost" , method = RequestMethod.POST)
    public String saveNewPost(@RequestParam("title") String title, @RequestParam("content") String content){
        postService.savePost(new Post(title , content));
        return "redirect:/Post";
    }
}
