package org.zerock.tp4.board.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.tp4.board.dto.BoardDTO;
import org.zerock.tp4.common.dto.PageRequestDTO;
import org.zerock.tp4.common.dto.PageResponseDTO;

@Transactional
public interface BoardService {

    Long register(BoardDTO boardDTO);

    PageResponseDTO<BoardDTO> getDTOList(PageRequestDTO pageRequestDTO);

    BoardDTO read(Long bno);

    boolean remove(Long bno);

    boolean modify(BoardDTO boardDTO);


}