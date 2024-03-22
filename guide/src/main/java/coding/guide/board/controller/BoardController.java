package coding.guide.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.guide.board.dto.response.ReadBoardDTO;
import coding.guide.board.service.BoardService;
import coding.guide.board.vo.response.ReadBoardVO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("api/board/")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(final BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("read/{bno}")
    public ResponseEntity<Map<String, ReadBoardVO>> readBoardController(@PathVariable("bno") final Long bno) {
        final ReadBoardDTO readBoardDTO = boardService.readBoard(bno);
        final ReadBoardVO readBoardVO = ReadBoardVO.builder()
                .bno(readBoardDTO.getBno())
                .title(readBoardDTO.getTitle())
                .content(readBoardDTO.getContent())
                .writer(readBoardDTO.getWriter())
                .createDate(readBoardDTO.getCreateDate())
                .updateDate(readBoardDTO.getUpdateDate())
                .build();
        return new ResponseEntity<>(Map.of("readBoard", readBoardVO), HttpStatus.OK);
    }
}
