package com.study.practical_backend.repository.search;

import com.study.practical_backend.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {

  Board search1();

  Page<Object[]> searchPage(String type, String keyword, Pageable pageable);

}
