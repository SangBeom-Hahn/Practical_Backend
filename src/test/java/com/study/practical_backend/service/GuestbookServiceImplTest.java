package com.study.practical_backend.service;

import com.study.practical_backend.dto.GuestbookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GuestbookServiceImplTest {
  @Autowired
  private GuestbookService guestbookService;
  
  @Test
  public void testRegister() {
    GuestbookDTO guestbookDTO = GuestbookDTO.builder()
      .title("Sample Title")
      .content("sample content")
      .writer("user0")
      .build();
    guestbookService.register(guestbookDTO);
  }
}