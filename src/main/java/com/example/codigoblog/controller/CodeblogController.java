package com.example.codigoblog.controller;

import com.example.codigoblog.model.Post;

import com.example.codigoblog.repository.CodeblogRepository;
import com.example.codigoblog.service.CodeblogService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CodeblogController {

    @Autowired
    CodeblogService codeblogService;

    @RequestMapping(value="/posts", method=RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = codeblogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value="/newpost", method= RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value="/newpost", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";
    }
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public ModelAndView deletePostDetails(@PathVariable("id") long id){
        codeblogService.delete(id);
        return  new ModelAndView("redirect/posts");
    }

    //continuar os metodos

}
