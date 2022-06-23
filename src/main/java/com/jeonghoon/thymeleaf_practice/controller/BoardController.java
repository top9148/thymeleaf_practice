package com.jeonghoon.thymeleaf_practice.controller;

import com.jeonghoon.thymeleaf_practice.model.Board;
import com.jeonghoon.thymeleaf_practice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardRepository boardRepository;

  @GetMapping("/list")
  public String list(Model model) {
    List<Board> boards = boardRepository.findAll();
    model.addAttribute("boards", boards);
    return "board/list";
  }

  @GetMapping("/form")
  public String form(Model model, @RequestParam(required = false) Long id) {
    if(id == null) {
      model.addAttribute("board", new Board());
    } else {
      Board board = boardRepository.findById(id).orElse(null);
      model.addAttribute("board", board);
    }

    return "board/form";
  }

  @PostMapping("/form")
  public String boardSave(@Valid Board board, BindingResult bindingResult) {
    // 바인딩한 에러가 넘어올 경우(에러 발생)
    if(bindingResult.hasErrors()) {
      System.out.println("bindingResult!!!!");
      System.out.println(bindingResult.hasErrors());
      return "board/form";
    }

    boardRepository.save(board);
    return "redirect:/board/list";
  }

}
