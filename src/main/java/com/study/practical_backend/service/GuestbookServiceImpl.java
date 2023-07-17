package com.study.practical_backend.service;

import com.study.practical_backend.domain.Guestbook;
import com.study.practical_backend.dto.GuestbookDTO;
import com.study.practical_backend.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
  private final GuestbookRepository guestbookRepository;
  @Override
  public Long register(GuestbookDTO guestbookDTO) {
    log.info("DTO----------------------------");
    log.info(guestbookDTO.toString());
    Guestbook guestbook = new Guestbook(
      guestbookDTO.getGno(),
      guestbookDTO.getTitle(),
      guestbookDTO.getContent(),
      guestbookDTO.getWriter()
    );
    log.info(guestbook.toString());
  
    return guestbookRepository.save(guestbook).getGno();
  }
}
