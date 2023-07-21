package com.study.practical_backend.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.study.practical_backend.domain.Guestbook;
import com.study.practical_backend.domain.QGuestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.stream.IntStream;
@SpringBootTest
class GuestbookRepositoryTest {
  @Autowired
  private GuestbookRepository guestbookRepository;
  
  @Test
  public void insertDummies() {
    IntStream.rangeClosed(1, 300).forEach(i -> {
      Guestbook guestbook = Guestbook.builder()
        .title("title..." + i)
        .content("content..." + i)
        .writer("user" + (i % 10))
        .build();
      System.out.println(guestbookRepository.save(guestbook));
    });
  }
  
  @Test
  public void updateTest() {
    Optional<Guestbook> result = guestbookRepository.findById(300L);
    if (result.isPresent()) {
      Guestbook guestbook = result.get();
      guestbook.changeTitle("change title");
      guestbook.changeContent("change content");
      guestbookRepository.save(guestbook);
    }
  }
  
  @Test
  public void testQuery1() {
    Pageable pageRequest = PageRequest.of(0, 10, Sort.by("gno").descending());
    QGuestbook qGuestbook = QGuestbook.guestbook;
    String keyword = "1";
    BooleanBuilder builder = new BooleanBuilder();
    BooleanExpression expression = qGuestbook.title.contains(keyword);
    builder.and(expression);
    Page<Guestbook> result = guestbookRepository.findAll(builder, pageRequest);
    
    result.stream().forEach(System.out::println);
  }
  
  @Test
  public void testQuery2() {
    Pageable pageRequest = PageRequest.of(0, 10, Sort.by("gno").descending());
    QGuestbook qGuestbook = QGuestbook.guestbook;
    String keyword = "1";
    BooleanBuilder builder = new BooleanBuilder();
    
    BooleanExpression exTitle = qGuestbook.title.contains(keyword);
    BooleanExpression exContent = qGuestbook.content.contains(keyword);
    builder.and(exTitle).or(exContent).and(qGuestbook.gno.gt(0L));
    Page<Guestbook> result = guestbookRepository.findAll(builder, pageRequest);
    
    result.stream().forEach(System.out::println);
  }
}