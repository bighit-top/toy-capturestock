package toy.stock.capturestock.entity.news;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class NewsScrapId implements Serializable {

    // 사용자 아이디
    @Column(name = "user_id")
    private long userId;

    // 뉴스 아이디
    @Column(name = "news_id")
    private long newsId;
}