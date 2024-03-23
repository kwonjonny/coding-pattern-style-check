package coding.guide.board.service;

import coding.guide.board.dto.request.CreateBoardDTO;
import coding.guide.board.dto.request.UpdateBoardDTO;
import coding.guide.board.dto.response.ListBoardDTO;
import coding.guide.board.dto.response.ReadBoardDTO;
import coding.guide.util.paging.PageRequestDTO;
import coding.guide.util.paging.PageResponseDTO;

/**
 * @author 권성준 
 */
public interface BoardService {
    ReadBoardDTO readBoard(Long bno);
    Integer createBoard(CreateBoardDTO createBoardDTO);
    Integer deleteBoard(Long bno);
    Integer updateBoard(UpdateBoardDTO updateBoardDTO);
    PageResponseDTO<ListBoardDTO> listBoard(PageRequestDTO pageRequestDTO);
}
