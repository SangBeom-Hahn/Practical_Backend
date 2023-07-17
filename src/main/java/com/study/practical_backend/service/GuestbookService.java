package com.study.practical_backend.service;

import com.study.practical_backend.domain.Guestbook;
import com.study.practical_backend.dto.GuestbookDTO;

public interface GuestbookService {
  Long register(GuestbookDTO guestbookDTO);
  
  default Guestbook dtoToEntity(GuestbookDTO guestbookDTO) {
    Guestbook guestbook = Guestbook.builder()
      .gno(guestbookDTO.getGno())
      .title(guestbookDTO.getTitle())
      .content(guestbookDTO.getContent())
      .writer(guestbookDTO.getWriter())
      .build();
    return guestbook;
  }
}
