package com.study.practical_backend.repository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemberRepositoryTests {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  public void insertMembers() {

    IntStream.rangeClosed(1, 100).forEach(i -> {

      Member member = Member.builder()
        .email("user" + i + "@aaa.com")
        .password("1111")
        .name("USER" + i)
        .build();

      memberRepository.save(member);
    });
  }
}