package coding.guide.board.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import coding.guide.board.dto.response.ReadBoardDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class BoardMapperTests {
    
    @Autowired
    private BoardMapper boardMapper;

    private static final Long Junit_Test_Bno = 148L;

    @BeforeEach
    public void setUp() {
       
    }

    @Test
    @Transactional
    void 게시물_조회_매퍼_테스트() {
        ReadBoardDTO readBoardDTO = boardMapper.readBoard(Junit_Test_Bno);
        log.info("readBoard: ", readBoardDTO.toString());
        Assertions.assertNotNull(readBoardDTO, "Board Should Be Null");
    }
}
