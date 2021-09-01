package org.zerock.tp4.board.mapper;

import org.zerock.tp4.board.domain.Board;
import org.zerock.tp4.board.domain.Criteria;

import java.util.List;

public interface BoardMapper {

    void insert(Board board); //

    List<Board> getList();

    List<Board> getListWithPaging(Criteria cri);

    Board select(Long bno);

    //삭제
    int delete(Long bno);

    int update(Board board);


}
