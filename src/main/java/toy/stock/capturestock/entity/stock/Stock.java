package toy.stock.capturestock.entity.stock;

import toy.stock.capturestock.entity.DateAudit;
import toy.stock.capturestock.entity.news.News;
import toy.stock.capturestock.entity.news.NewsScrap;
import toy.stock.capturestock.entity.user.UserAttentionStock;
import toy.stock.capturestock.entity.user.UserStockMemo;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock extends DateAudit {

    // 종목 아이디: 고유코드
    @Id
    private int id;

    // 거래소
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StockMarket market;

    // 종목명
    @Column(nullable = false)
    @Size(max = 50)
    private String stockName;

    // 법인명
    @Size(max = 100)
    private String corporationName;

    // 업종
    @Column(nullable = false)
    private String sector;

    // 주요제품
    @Column(nullable = false)
    private String product;

    // 상장일
    private LocalDate publicDate;

    // 결산월
    @Size(max = 5)
    private String settlementMonth;

    // 홈페이지
    @Size(max = 500)
    private String homepageUrl;

    // 종목 일별 시세
    @OneToMany(mappedBy = "stock")
    private List<StockDailyPrice> stockDailyPrices = new ArrayList<>();

    // 뉴스
    @OneToMany(mappedBy = "stock")
    private List<News> news = new ArrayList<>();

    // 뉴스 스크랩
    @OneToMany(mappedBy = "stock")
    private List<NewsScrap> newsScraps = new ArrayList<>();

    // 사용자 종목 메모
    @OneToMany(mappedBy = "stock")
    private List<UserStockMemo> userStockMemos = new ArrayList<>();

    // 사용자 관심 종목
    @OneToMany(mappedBy = "stock")
    private List<UserAttentionStock> userAttentionStocks = new ArrayList<>();

    // 종목 관심수
    @OneToOne(fetch = FetchType.LAZY)
    private StockAttentionCount stockAttentionCount;
}
