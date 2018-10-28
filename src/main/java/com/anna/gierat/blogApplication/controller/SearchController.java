package com.anna.gierat.blogApplication.controller;


import com.anna.gierat.blogApplication.model.Post;
import com.anna.gierat.blogApplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/search")
    public String search (@RequestParam String searchPhrase, Model model){
        List<Post> postList = postRepository.findAllByTitleContainsOrContentContains(searchPhrase,searchPhrase);
        model.addAttribute("posts",postList);
        model.addAttribute("searchPhrase",searchPhrase);
        return "posts";
    }

}
