package toy.stock.capturestock.entity.news;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import toy.stock.capturestock.entity.stock.Stock;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class News {

    // 뉴스아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 종목
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    // 발행일
    @Column(nullable = false)
    private LocalDate pubDay;

    // 제목
    @Column(nullable = false)
    private String title;

    // 내용
    @Size(max = 30000)
    private String content;

    // 내용 요약
    @Size(max = 500)
    private String description;

    // 네이버 경로
    @Column(name = "naver_link")
    @Size(max = 500)
    private String link;

    // 원본 경로
    @Column(nullable = false)
    @Size(max = 500)
    private String originalLink;

    // 조회수
    @Column(nullable = false, columnDefinition = "int default 0")
    private int viewCount;

    // 스크랩 수
    @Column(nullable = false, columnDefinition = "int default 0")
    private int scrapCount;

    // 뉴스 스크랩
    @OneToMany(mappedBy = "news")
    private List<NewsScrap> newsScraps = new ArrayList<>();

    // 생성일
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
}
