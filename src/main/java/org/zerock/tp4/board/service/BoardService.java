package org.zerock.tp4.board.service;

import org.zerock.tp4.board.domain.Criteria;
import org.zerock.tp4.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    Long register(BoardDTO boardDto);

//    List<BoardDTO> getDTOList();

    List<BoardDTO> getDTOList(Criteria cri);

    BoardDTO read(Long bno);

    Boolean remove(Long bno);

    Boolean modify(BoardDTO boardDTO);
}
