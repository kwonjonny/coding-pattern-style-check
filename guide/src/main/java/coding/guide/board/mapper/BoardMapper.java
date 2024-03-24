package coding.guide.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import coding.guide.board.dto.request.CreateBoardDTO;
import coding.guide.board.dto.request.UpdateBoardDTO;
import coding.guide.board.dto.response.ListBoardDTO;
import coding.guide.board.dto.response.ReadBoardDTO;
import coding.guide.util.paging.PageRequestDTO;

/**
 * @author 권성준
 */
@Mapper
public interface BoardMapper {

    /**
     * 게시물 조회 
     */
    ReadBoardDTO readBoard(Long bno);

    /**
     * 게시물 존재 검증
     */
    Long existByBoardId(Long bno);

    /**
     * 게시글 수정 
     */
    Long updateBoard(UpdateBoardDTO updateBoardDTO);

    /**
     * 게시글 생성 
     */
    Long createBoard(CreateBoardDTO createBoardDTO);

    /**
     * 게시물 삭제
     */
    Long deleteBoard(Long bno);

    /**
     * 게시물 리스트
     */
    List<ListBoardDTO> listBoard(PageRequestDTO pageRequestDTO);

    /**
     * 게시물 토탈 값 
     */
    int boardTotal(PageRequestDTO pageRequestDTO);

    /**
     * 게시물 마지막 페이지
     */
    int boardLastPage(PageRequestDTO pageRequestDTO);
}
