package com.anna.gierat.blogApplication.controller;


import com.anna.gierat.blogApplication.model.Post;
import com.anna.gierat.blogApplication.repository.PostRepository;
import javafx.geometry.Pos;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class MainController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    public String getIndexPage(Model model){
        model.addAttribute("name","Anna");
        return "index";
    }

    @GetMapping("/addPost")
    public String addPostPage(){
        return "addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam (value="title") String title,
                          @RequestParam(value="content") String content){
        Post post = new Post(title, content);
        postRepository.save(post);
        System.out.println("Params: " + title + ", " + content);
        return "addPost";
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts";
    }
    @GetMapping("/posts/{title}")
    public String getPostsById(@PathVariable String title,Model model ) {
        model.addAttribute("posts",postRepository.findAllByTitleContains(title));
        return "posts";
    }
//    List<Post> postsList = new ArrayList<>();
//    Iterable<Post> postIterable = postRepository.findAll();
//
//        for(Post post: postIterable){
//            postsList.add(post);
//        }
//        model.addAttribute("posts", postsList);
//        return "posts";
//    }

    @GetMapping("/posts/{title}/{sortField}/{sortDirection}")
    public String sortPostsByTitle(@PathVariable String title,
                                   @PathVariable String sortField,
                                   @PathVariable String sortDirection, Model model ) {

        Sort.Direction direction = Sort.Direction.ASC;
        if("desc".equals(sortDirection)){
            direction = Sort.Direction.DESC;
        }

        List <Post> postList = postRepository.findAllByTitleContains(title,Sort.by(Sort.Direction.ASC,sortField));
        model.addAttribute("posts",postList);
        return "posts";
    }

}
