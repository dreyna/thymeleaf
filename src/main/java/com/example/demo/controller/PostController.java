
package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Docente
 */
@Controller
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("posts", postService.readAll());
        return "index";
    }
    
    @GetMapping("/add")
    public String addPost(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "add";
    }
    
    
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable("id") int id, Model model){
        model.addAttribute("post", postService.read(id));
        return "edit";
    }
    
    @GetMapping("/del/{id}")
    public String delPost(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        postService.delete(id);
        redirectAttributes.addFlashAttribute("flashMessage", "Post deleted Successfull");
        return "redirect:/";
    }
    @PostMapping("/save")
    public String savePost(@Valid Post post, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add";
        }
        postService.create(post);
        return "redirect:/";
    }
    @PostMapping("update/{id}")
    public String updatePost(@PathVariable("id") int id, @Valid Post post, BindingResult result,
        Model model) {
        if (result.hasErrors()) {            
            return "edit";
        }
        postService.update(post);
        model.addAttribute("posts", postService.readAll());
        return "index";
    }
           
}
