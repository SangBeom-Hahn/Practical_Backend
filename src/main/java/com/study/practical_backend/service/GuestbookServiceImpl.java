package com.study.practical_backend.service;

import com.study.practical_backend.domain.Guestbook;
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
    Page<Guestbook> result = guestbookRepository.findAll(pageable);
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
}
