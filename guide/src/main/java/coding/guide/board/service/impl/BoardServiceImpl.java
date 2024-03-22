package coding.guide.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.guide.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BoardServiceImpl {
    
    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(final BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }
}
