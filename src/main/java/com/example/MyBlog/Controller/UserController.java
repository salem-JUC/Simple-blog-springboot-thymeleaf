package com.example.MyBlog.Controller;

import com.example.MyBlog.Entity.Comment;
import com.example.MyBlog.Entity.Post;
import com.example.MyBlog.Service.CommentService;
import com.example.MyBlog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping( value = "Post")
public class UserController {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @RequestMapping
    public String AllPostsController(ModelMap model){
        model.put("posts" , postService.getAllPosts());
        return "main.html";
    }

    @RequestMapping(value = "/{id}")
    public String showPostById(@PathVariable long id , ModelMap model){
        System.out.println(getLoggedUsername());
        Optional<Post> post1 = postService.getPostById(id);
        if (post1.isPresent()){
            Post post = post1.get();
            model.put("post" , post);
            model.put("comments" ,post.getCommentList());
            model.addAttribute("comment" , new Comment());
            return "post.html";
        }else {
            return "Error.html";
        }

    }

    @RequestMapping(value = "/newComment/{id}", method = RequestMethod.POST)
    public String newCommentPost(@ModelAttribute Comment comment ,@PathVariable Long id){
        Post post = postService.getPostById(id).get();
        comment.setPost(post);
        commentService.save(comment);
        return "redirect:/Post/"+id;
    }

    private Collection<? extends GrantedAuthority> getLoggedUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
}
