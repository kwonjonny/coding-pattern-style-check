package coding.guide.board.vo.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ListBoardVO(
        Long bno,
        String title,
        String content,
        String writer,
        LocalDateTime createDate,
        LocalDateTime updateDate) {
}