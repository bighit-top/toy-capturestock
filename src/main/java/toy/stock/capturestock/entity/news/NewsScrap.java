package toy.stock.capturestock.entity.news;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import toy.stock.capturestock.entity.stock.Stock;
import toy.stock.capturestock.entity.stock.StockDailyPrice;
import toy.stock.capturestock.entity.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class NewsScrap {

    /**
     * 사용자 아이디: user_id
     * 뉴스 아이디: news_id
     */
    @EmbeddedId
    private NewsScrapId id;

    // 종목
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    // 종목일별시세
    @ManyToOne(fetch = FetchType.LAZY)
    private StockDailyPrice stockDailyPrice;

    // 사용자 아이디
    @MapsId(value = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 뉴스 아이디
    @MapsId(value = "news_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private News news;

    // 생성일
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
}
