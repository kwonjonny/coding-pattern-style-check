package coding.guide.util.paging;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    private Integer size = 10;

    private String type;
    private String keyword;
    private String link;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public void setPage(Integer page) {
        if (page == null || page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public void setSize(Integer size) {
        if (size < 0 || size > 100) {
            this.size = 10;
        } else {
            this.size = size;
        }
    }

    public Integer getSkip() {
        Integer getSkip = (this.page - 1) * this.size;
        return getSkip;
    }

    public Integer getCountEnd() {
        return ((int) Math.ceil(this.page / 10.0) * (10 * this.size)) + 1;
    }

    public String[] getTypes() {
        if (this.type == null || this.type.isEmpty()) {
            return null;
        }
        return this.type.split(",");
    }

    public String getLink() {
        if (link == null) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("page=" + this.page);
            strBuilder.append("&size=" + this.size);
            if (type != null && type.length() > 0) {
                strBuilder.append("&type=" + this.type);
            }
            if (keyword != null && keyword.length() > 0) {
                try {
                    strBuilder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (startDate != null) {
                strBuilder.append("&startDate=" + startDate.toString());
            }
            if (endDate != null) {
                strBuilder.append("&endDate=" + endDate.toString());
            }
            link = strBuilder.toString();
        }
        return link;
    }
}