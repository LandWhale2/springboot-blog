package com.common.forum.controller;

import lombok.RequiredArgsConstructor;



import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequiredArgsConstructor
public class IndexController {

  private final PostRepository postRepository;

  @GetMapping("/")
  public String home(Model model, Pageable pageable){
    model.addAttribute("posts", postRepository.findAll(pageable));
    return "index";
  }
}