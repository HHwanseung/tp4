package org.zerock.tp4.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.tp4.board.config.BoardRootConfig;
import org.zerock.tp4.common.config.RootConfig;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {BoardRootConfig.class, RootConfig.class} )//특정 파일을 무엇을 쓸꺼냐
public class TimeMapperTests {

    @Autowired
    TimeMapper timeMapper;

    @Test
    public void testGetTime() {
        log.info("-------------------");
        log.info("-------------------");
        log.info(timeMapper.getTime2());
        log.info("-------------------");
        log.info("-------------------");
    }
}
