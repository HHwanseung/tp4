package org.zerock.tp4.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.tp4.board.mapper.TimeMapper;

@Log4j2
@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService{

    private final TimeMapper timeMapper;

    @Override

    public String getNow() {

        return timeMapper.getTime2();
    }

    @Override
    public void addString(String str) {
        timeMapper.insertE1(str);
        timeMapper.insertE2(str);
    }
}
