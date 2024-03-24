package coding.guide.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coding.guide.board.dto.request.CreateBoardDTO;
import coding.guide.board.dto.request.UpdateBoardDTO;
import coding.guide.board.dto.response.ListBoardDTO;
import coding.guide.board.dto.response.ReadBoardDTO;
import coding.guide.board.exception.BoardValidationService;
import coding.guide.board.mapper.BoardMapper;
import coding.guide.board.service.BoardService;
import coding.guide.util.paging.PageRequestDTO;
import coding.guide.util.paging.PageResponseDTO;
import lombok.extern.log4j.Log4j2;

/**
 * @author 권성준
 */
@Log4j2
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final BoardValidationService boardValidationService;

    @Autowired
    public BoardServiceImpl(final BoardMapper boardMapper, final BoardValidationService boardValidationService) {
        this.boardMapper = boardMapper;
        this.boardValidationService = boardValidationService;
    }

    /**
     * 게시물 조회
     * 
     * @author 권성준
     * @date 2024-03-24
     * @see ReadBoardDTO 
     * @throws BoardNotFoundException 게시물이 존재 하지 않을때 발생하는 예외
     */
    @Override
    @Transactional(readOnly = true)
    public ReadBoardDTO readBoard(Long bno) {
        boardValidationService.existByBoardId(bno);
        ReadBoardDTO readBoard = boardMapper.readBoard(bno);
        return readBoard;
    }

    /**
     * 게시물 리스트 
     * 
     * @author 권성준 
     * @date 2024-03-24
     * @see PageRequestDTO
     */
    @Override
    @Transactional(readOnly = true)
    public PageResponseDTO<ListBoardDTO> listBoard(final PageRequestDTO pageRequestDTO) {
        List<ListBoardDTO> listBoard = boardMapper.listBoard(pageRequestDTO);
        int boardTotal = boardMapper.boardTotal(pageRequestDTO);
        int boardLastPage = boardMapper.boardLastPage(pageRequestDTO);
        return PageResponseDTO.<ListBoardDTO>withAll()
                .list(listBoard)
                .total(boardTotal)
                .pageRequestDTO(pageRequestDTO)
                .totalList(boardLastPage)
                .build();
    }

    @Override
    @Transactional
    public Long createBoard(CreateBoardDTO createBoardDTO) {
        Long createBoard = boardMapper.createBoard(createBoardDTO);
        return createBoard;
    }

    @Override
    @Transactional
    public Long deleteBoard(Long bno) {
        boardValidationService.existByBoardId(bno);
        Long deleteBoard = boardMapper.deleteBoard(bno);
        return deleteBoard;
    }

    @Override
    @Transactional
    public Long updateBoard(UpdateBoardDTO updateBoardDTO) {
        boardValidationService.existByBoardId(updateBoardDTO.getBno());
        Long updateBoard = boardMapper.updateBoard(updateBoardDTO);
        return updateBoard;
    }
}
