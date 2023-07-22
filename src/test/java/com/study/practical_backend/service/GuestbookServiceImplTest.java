package com.study.practical_backend.service;

import com.study.practical_backend.domain.Guestbook;
import com.study.practical_backend.dto.GuestbookDTO;
import com.study.practical_backend.dto.PageRequestDTO;
import com.study.practical_backend.dto.PageResultDTO;
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
  
  @Test
  void GuestbookServiceImplTest() {
    // given
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
      .page(1)
      .size(10)
      .build();
  
    // when
    PageResultDTO<GuestbookDTO, Guestbook> resultDTO = guestbookService.getList(pageRequestDTO);
  
    // then
    for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
      System.out.println(guestbookDTO);
    }
  }

  @Test
  public void testList(){

    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
      .page(1)
      .size(10)
      .build();

    PageResultDTO<GuestbookDTO, Guestbook> resultDTO = guestbookService.getList(pageRequestDTO);

    System.out.println("PREV: "+resultDTO.isPrev());
    System.out.println("NEXT: "+resultDTO.isNext());
    System.out.println("TOTAL: " + resultDTO.getTotalPage());

    System.out.println("-------------------------------------");
    for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
      System.out.println(guestbookDTO);
    }

    System.out.println("========================================");
    resultDTO.getPageList().forEach(i -> System.out.println(i));
  }
}
