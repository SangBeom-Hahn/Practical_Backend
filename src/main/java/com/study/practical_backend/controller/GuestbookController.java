package com.study.practical_backend.controller;

import com.study.practical_backend.dto.PageRequestDTO;
import com.study.practical_backend.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestbookController {
  private final GuestbookService guestbookService;

  @GetMapping({"/"})
  public String guestbooks() {
    return "redirect:/guestbook/list";
  }

  @GetMapping("/list")
  public String list(@ModelAttribute PageRequestDTO pageRequestDTO, Model model) {
    model.addAttribute("result", guestbookService.getList(pageRequestDTO));
    return "/guestbook/list";
  }
}
