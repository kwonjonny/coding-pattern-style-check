package coding.guide.util.paging;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageResponseDTO<E> {
    private List<E> list;
    private int total;
    private int page;
    private int size;
    private int startNum;
    private int endNum;
    private boolean prevBtn;
    private boolean nextBtn;

    private int lasPage;
    private int totalList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(List<E> list, int total, PageRequestDTO pageRequestDTO, int totalList) {
        this.list = list;
        this.total = total;
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.startNum = ((int) (Math.ceil(this.page / 10.0) * 10) - 9);
        this.endNum = this.startNum + 9;
        int last = (int) (Math.ceil((total / (double) size)));
        this.endNum = endNum > last ? last : endNum;
        this.prevBtn = this.startNum > 1;
        this.nextBtn = total > this.endNum * this.size;
        this.lasPage = (int) Math.ceil((double) totalList / this.size);
    }
}