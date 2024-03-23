package coding.guide.board.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import coding.guide.board.mapper.BoardMapper;
import coding.guide.exception.custom.ServiceException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class BoardValidationService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardValidationService(final BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    /**
     * 게시물 존재 검증 
     */
    @Transactional(readOnly = true)
    public void existByBoardId(Long bno) {
        final Long countResult = boardMapper.existByBoardId(bno);
        if(countResult == 0) {
            throw new ServiceException(BoardErrorEnum.NOT_FOUND_BOARD);
        }
    }
}
