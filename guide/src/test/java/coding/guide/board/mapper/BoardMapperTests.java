package coding.guide.board.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import coding.guide.board.dto.response.ListBoardDTO;
import coding.guide.board.dto.response.ReadBoardDTO;
import coding.guide.board.exception.BoardErrorEnum;
import coding.guide.board.service.BoardService;
import coding.guide.exception.custom.ServiceException;
import coding.guide.util.paging.PageRequestDTO;
import coding.guide.util.paging.PageResponseDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class BoardMapperTests {

    @Autowired
    private BoardMapper boardMapper;

    private static final Long Junit_Test_Bno = 148L;
    private static final Long Junit_Test_Fail_Bno = 0L;

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

    @Test
    @Transactional
    void 게시물_조회_매퍼_실패_테스트() {
        Assertions.assertThrows(ServiceException.class, () -> {
            ReadBoardDTO readBoardDTO = boardMapper.readBoard(Junit_Test_Fail_Bno);
            if (readBoardDTO == null) {
                throw new ServiceException(BoardErrorEnum.NOT_FOUND_BOARD);
            }
        }, "Expected ServiceException to be thrown for non-existing board ID");
    }

    @Autowired
    private BoardService boardService;


   

    @Test
    @Transactional
    void 게시물_리스트_매퍼_테스트() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .keyword("writer")
        .type("t")
        .startDate(LocalDate.now())
        .endDate(LocalDate.now())
        .build();
        log.info(pageRequestDTO.toString());
       PageResponseDTO<ListBoardDTO> listboard = boardService.listBoard(pageRequestDTO);

    }
}
