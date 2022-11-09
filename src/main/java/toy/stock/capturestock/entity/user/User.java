package toy.stock.capturestock.entity.user;

import toy.stock.capturestock.entity.DateAudit;
import toy.stock.capturestock.entity.news.NewsScrap;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends DateAudit {

    // 사용자 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 사용자명
    @Size(max = 20)
    private String userName;

    // 비밀번호
    @Column(nullable = false)
    @Size(max = 500)
    private String password;

    // 권한
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    // 이메일
    @Column(nullable = false)
    private String email;

    // OAuth 제공처
    @Size(max = 10)
    private String provider;

    // OAuth 아이디
    @Size(max = 20)
    private String providerId;

    // 계정삭제여부
    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean deleteOrNot;

    // 뉴스 스크랩
    @OneToMany(mappedBy = "news")
    private List<NewsScrap> newsScraps = new ArrayList<>();

    // 사용자 뉴스 설정
    @OneToOne(fetch = FetchType.LAZY)
    private UserNewsConfig userNewsConfig;

    // 사용자 관심 종목
    @OneToMany(mappedBy = "user")
    private List<UserAttentionStock> userAttentionStocks = new ArrayList<>();

    // 사용자 종목 메모
    @OneToMany(mappedBy = "user")
    private List<UserStockMemo> userStockMemos = new ArrayList<>();

    // 사용자 종목 메모 이미지
    @OneToMany(mappedBy = "user")
    private List<UserStockMemoImageFile> userStockMemoImageFiles = new ArrayList<>();
}
