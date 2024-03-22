package coding.guide.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import coding.guide.board.dto.response.ReadBoardDTO;

/**
 * @author 권성준
 */
@Mapper
public interface BoardMapper {

    /**
     * 게시물 조회 
     */
    ReadBoardDTO readBoard(Long bno);
}
