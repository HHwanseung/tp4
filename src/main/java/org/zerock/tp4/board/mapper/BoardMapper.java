package org.zerock.tp4.board.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.tp4.board.domain.Board;
import org.zerock.tp4.board.domain.BoardAttach;
import org.zerock.tp4.common.dto.PageRequestDTO;

import java.util.List;

public interface BoardMapper {

    void insert(Board board); //

    List<Board> getList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

    Board select(Long bno);

    //삭제
    int delete(Long bno);

    int update(Board board);

    int updateReplyCnt(@Param("bno") Long bno, @Param("num") int num);

    int insertAttach(BoardAttach attach);

    int deleteAttach(long bno);


}
