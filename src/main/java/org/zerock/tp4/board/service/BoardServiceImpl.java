package org.zerock.tp4.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.tp4.board.domain.Board;
import org.zerock.tp4.board.domain.Criteria;
import org.zerock.tp4.board.dto.BoardDTO;
import org.zerock.tp4.board.mapper.BoardMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper; //마이바티즈에 연결하는 기능

    @Override
    public Long register(BoardDTO boardDto) {

        Board board = boardDto.getDomain();

        boardMapper.insert(board);

        return board.getBno();
    }

//    @Override
//    public List<BoardDTO> getDTOList() {
//
//        return boardMapper.getList().stream().map(board -> board.getDTO()).collect(Collectors.toList());
//
//    }


    @Override
    public List<BoardDTO> getDTOList(Criteria cri) {
        log.info("get list with criteria:" + cri);
        return boardMapper.getListWithPaging(cri).stream().map(board -> board.getDTO()).collect(Collectors.toList());
    }

    @Override
    public BoardDTO read(Long bno) {
        Board board = boardMapper.select(bno);

        if(board != null){
            return board.getDTO();
        }
        return null;
    }

    @Override
    public Boolean remove(Long bno) {
        return boardMapper.delete(bno) > 0;
    }

    @Override
    public Boolean modify(BoardDTO boardDTO) {
        return boardMapper.update(boardDTO.getDomain()) > 0;
    }
}
