package com.study.practical_backend.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.study.practical_backend.domain.Guestbook;
import com.study.practical_backend.domain.QGuestbook;
import com.study.practical_backend.dto.GuestbookDTO;
import com.study.practical_backend.dto.PageRequestDTO;
import com.study.practical_backend.dto.PageResultDTO;
import com.study.practical_backend.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

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
  
  @Override
  public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
    Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
    BooleanBuilder booleanBuilder = getSearch(requestDTO);
    Page<Guestbook> result = guestbookRepository.findAll(booleanBuilder, pageable);
    Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
    return new PageResultDTO<>(result, fn);
  }

  @Override
  public GuestbookDTO read(Long gno) {
    Optional<Guestbook> result = guestbookRepository.findById(gno);
    return result.isPresent() ? entityToDto(result.get()) : null;
  }

  @Override
  public void remove(Long gno) {
    guestbookRepository.deleteById(gno);
  }

  @Override
  public void modify(GuestbookDTO dto) {
    Optional<Guestbook> result = guestbookRepository.findById(dto.getGno());
    if (result.isPresent()) {
      Guestbook guestbook = result.get();
      guestbook.changeTitle(dto.getTitle());
      guestbook.changeContent(dto.getContent());

      guestbookRepository.save(guestbook);
    }
  }

  private BooleanBuilder getSearch(PageRequestDTO requestDTO){

    String type = requestDTO.getType();

    BooleanBuilder booleanBuilder = new BooleanBuilder();

    QGuestbook qGuestbook = QGuestbook.guestbook;

    String keyword = requestDTO.getKeyword();

    BooleanExpression expression = qGuestbook.gno.gt(0L); // gno > 0 조건만 생성

    booleanBuilder.and(expression);

    if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우
      return booleanBuilder;
    }


    //검색 조건을 작성하기
    BooleanBuilder conditionBuilder = new BooleanBuilder();

    if(type.contains("t")){
      conditionBuilder.or(qGuestbook.title.contains(keyword));
    }
    if(type.contains("c")){
      conditionBuilder.or(qGuestbook.content.contains(keyword));
    }
    if(type.contains("w")){
      conditionBuilder.or(qGuestbook.writer.contains(keyword));
    }

    //모든 조건 통합
    booleanBuilder.and(conditionBuilder);

    return booleanBuilder;
  }
}
