package org.zerock.tp4.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.tp4.board.domain.Board;
import org.zerock.tp4.board.dto.BoardDTO;
import org.zerock.tp4.board.mapper.BoardMapper;
import org.zerock.tp4.common.dto.PageRequestDTO;
import org.zerock.tp4.common.dto.PageResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public Long register(BoardDTO boardDTO) {

        Board board = boardDTO.getDomain();

        boardMapper.insert(board);

        Long bno = board.getBno();

        board.getAttachList().forEach(attach -> {
            attach.setBno(bno);
            boardMapper.insertAttach(attach);
        });

        return board.getBno();
    }

    @Override
    public PageResponseDTO<BoardDTO> getDTOList(PageRequestDTO pageRequestDTO) {

        List<BoardDTO> dtoList = boardMapper.getList(pageRequestDTO).stream().map(board -> board.getDTO()).collect(Collectors.toList());
        int count = boardMapper.getCount(pageRequestDTO);

        PageResponseDTO<BoardDTO> pageResponseDTO = PageResponseDTO.<BoardDTO>builder()
                .dtoList(dtoList)
                .count(count)
                .build();

        return pageResponseDTO;

    }

    @Override
    public BoardDTO read(Long bno) {
        Board board =  boardMapper.select(bno);

        if(board != null){
            return board.getDTO();
        }
        return null;
    }

    @Override
    public boolean remove(Long bno) {
        return boardMapper.delete(bno) > 0;
    }

    @Override
    public boolean modify(BoardDTO boardDTO) {

        boardMapper.deleteAttach(boardDTO.getBno()); //기존에 있던 첨부파일 삭제

        Board board = boardDTO.getDomain();

        Long bno = board.getBno();

        board.getAttachList().forEach(attach -> {
            attach.setBno(bno);
            boardMapper.insertAttach(attach);
        });

        return boardMapper.update(board) > 0; //업데이트 해주고 기존의 있던 첨부파일 지우고 새로운 첨부파일 추가해줘야함
    }
}