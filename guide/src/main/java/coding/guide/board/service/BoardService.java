package coding.guide.board.service;

import coding.guide.board.dto.response.ReadBoardDTO;

public interface BoardService {
    ReadBoardDTO readBoard(Long bno);
}
