package coding.guide.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.guide.board.dto.request.CreateBoardDTO;
import coding.guide.board.dto.request.UpdateBoardDTO;
import coding.guide.board.dto.response.ListBoardDTO;
import coding.guide.board.dto.response.ReadBoardDTO;
import coding.guide.board.service.BoardService;
import coding.guide.board.vo.response.ListBoardVO;
import coding.guide.board.vo.response.ReadBoardVO;
import coding.guide.util.paging.PageRequestDTO;
import coding.guide.util.paging.PageResponseDTO;
import jakarta.validation.Valid;
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

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createBoardController(@RequestBody @Valid final CreateBoardDTO createBoardDTO) {
        final Long createResult = boardService.createBoard(createBoardDTO);
        return createResult > 0 ? new ResponseEntity<>(Map.of("createBoard", "ok"), HttpStatus.OK) : new ResponseEntity<>(Map.of("createBoard", "fail"), HttpStatus.BAD_REQUEST) ;
    }

    @PutMapping("update/{bno}")
    public ResponseEntity<Map<String, Object>> updateBoardController(@RequestBody @Valid final UpdateBoardDTO updateBoardDTO) {
        final Long updateResult = boardService.updateBoard(updateBoardDTO);
        return updateResult > 0 ? new ResponseEntity<>(Map.of("updateBoard", "ok"), HttpStatus.OK) : new ResponseEntity<>(Map.of("updateBoard", "fail"), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{bno}")
    public ResponseEntity<Map<String, Object>> deleteBoardController(@PathVariable("bno") final Long bno) {
        final Long deleteResult = boardService.deleteBoard(bno);
        return deleteResult > 0 ? new ResponseEntity<>(Map.of("deleteBoard", "ok"), HttpStatus.OK) : new ResponseEntity<>(Map.of("deleteBoard", "fail"), HttpStatus.BAD_REQUEST); 
    }

    // @GetMapping("list")
    // public ResponseEntity<Map<String, PageResponseDTO<ListBoardVO>>> listBoardController(final PageRequestDTO pageRequestDTO) {
    //     final PageResponseDTO<ListBoardDTO> listBoardDTO = boardService.listBoard(pageRequestDTO);
        
    //     return new ResponseEntity<>("listBoard", )
    // }
}
