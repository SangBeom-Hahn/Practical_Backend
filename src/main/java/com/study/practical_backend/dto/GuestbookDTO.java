package com.study.practical_backend.dto;

import com.study.practical_backend.domain.Guestbook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDTO {
  private Long gno;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;
  
  public GuestbookDTO(Long gno, String title, String content, String writer) {
  }
  
  public static GuestbookDTO of(Guestbook guestbook) {
    return new GuestbookDTO(
      guestbook.getGno(), 
      guestbook.getTitle(),
      guestbook.getContent(),
      guestbook.getWriter()
    );
  }
}
