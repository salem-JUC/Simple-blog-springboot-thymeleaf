package com.example.MyBlog.Controller.publik;

import com.example.MyBlog.Entity.Post;
import com.example.MyBlog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "/")
public class mainController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/")
    @ResponseBody
    public List<Post> AllPostsController(){
        return postService.getAllPosts();
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Post getPostById(@PathVariable long id){
        return postService.getPostById(id);
    }
}
