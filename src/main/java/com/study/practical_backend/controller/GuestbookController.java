package com.study.practical_backend.controller;

import com.study.practical_backend.dto.GuestbookDTO;
import com.study.practical_backend.dto.PageRequestDTO;
import com.study.practical_backend.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestbookController {
  private final GuestbookService guestbookService;

  @GetMapping("/")
  public String guestbooks() {
    return "redirect:/guestbook/list";
  }

  @GetMapping("/list")
  public void list(@ModelAttribute PageRequestDTO pageRequestDTO, Model model) {
    model.addAttribute("result", guestbookService.getList(pageRequestDTO));
  }

  @GetMapping("/register")
  public String registerFrom() {
    return "/guestbook/register";
  }

  @PostMapping("/register")
  public String register(GuestbookDTO guestbookDTO, RedirectAttributes redirectAttributes) {
    Long gno = guestbookService.register(guestbookDTO);
    redirectAttributes.addFlashAttribute("msg", gno);
    return "redirect:/guestbook/list";
  }

  @GetMapping({"/read", "/modify"})
  public void read(long gno, Model model, @ModelAttribute("requestDTO") PageRequestDTO requestDTO) {
    GuestbookDTO dto = guestbookService.read(gno);
    model.addAttribute("dto", dto);
  }

  @PostMapping("/modify")
  public String modify(GuestbookDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes) {
    guestbookService.modify(dto);
    redirectAttributes.addAttribute("page", requestDTO.getPage());
    redirectAttributes.addAttribute("gno", dto.getGno());
    redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());
    redirectAttributes.addAttribute("gno", dto.getGno());
    return "redirect:/guestbook/read";
  }

  @PostMapping("/remove")
  public String remove(long gno, RedirectAttributes redirectAttributes) {
    guestbookService.remove(gno);
    redirectAttributes.addFlashAttribute("gno", gno);
    return "redirect:/guestbook/list";
  }
}
