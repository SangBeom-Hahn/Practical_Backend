package com.study.practical_backend.service;

import com.study.practical_backend.domain.Guestbook;
import com.study.practical_backend.dto.GuestbookDTO;
import com.study.practical_backend.dto.PageRequestDTO;
import com.study.practical_backend.dto.PageResultDTO;
import com.study.practical_backend.repository.GuestbookRepository;

public interface GuestbookService {
  Long register(GuestbookDTO guestbookDTO);
  
  PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);
  
  default Guestbook dtoToEntity(GuestbookDTO guestbookDTO) {
    Guestbook guestbook = Guestbook.builder()
      .gno(guestbookDTO.getGno())
      .title(guestbookDTO.getTitle())
      .content(guestbookDTO.getContent())
      .writer(guestbookDTO.getWriter())
      .build();
    return guestbook;
  }
  
  default GuestbookDTO entityToDto(Guestbook guestbook) {
    GuestbookDTO guestbookDTO = GuestbookDTO.builder()
      .gno(guestbook.getGno())
      .title(guestbook.getTitle())
      .content(guestbook.getContent())
      .writer(guestbook.getWriter())
      .build();
    return guestbookDTO;
  }
}
