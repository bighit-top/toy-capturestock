package toy.stock.capturestock.entity.stock;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import toy.stock.capturestock.entity.news.NewsScrap;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class StockDailyPrice {

    /**
     * 종목 일별 시세 아이디: id
     * 종목 아이디: stock_id
     * 개장일: opening_date_id
     */
    @EmbeddedId
    private StockDailyPriceId stockDailyPriceId;

    // 종목
    @MapsId(value = "stock_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    // 종목 개장일
    @MapsId(value = "opening_date_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private StockOpeningDate stockOpeningDate;

    // 종가
    @Column(nullable = false)
    private int close;

    // 시가
    private int open;

    // 고가
    private int highest;

    // 저가
    private int lowest;

    // 등락률
    @Column(nullable = false)
    @Size(min = -30, max = 30)
    private BigDecimal ratio;

    // 대비
    private int vs;

    // 거래량
    @Column(nullable = false)
    private long volume;

    // 거래대금
    @Column(nullable = false)
    private long amount;

    // 시가총액
    @Column(nullable = false)
    private long marketTotalAmount;

    // 뉴스 스크랩
    @OneToMany(mappedBy = "stockDailyPrice")
    private List<NewsScrap> newsScraps = new ArrayList<>();

    // 생성일
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
}
