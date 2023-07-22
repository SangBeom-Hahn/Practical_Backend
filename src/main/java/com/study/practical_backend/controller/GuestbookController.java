package com.study.practical_backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/guestbook")
public class GuestbookController {
  @GetMapping({"/", "/list"})
  public String guestbooks() {
    return "guestbook/list";
  }
}
