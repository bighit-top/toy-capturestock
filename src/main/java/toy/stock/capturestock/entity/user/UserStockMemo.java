package toy.stock.capturestock.entity.user;

import toy.stock.capturestock.entity.DateAudit;
import toy.stock.capturestock.entity.stock.Stock;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserStockMemo extends DateAudit {

    // 사용자 종목 메모 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 제목
    @Column(nullable = false)
    private String title;

    // 내용
    @Size(max = 30000)
    private String content;

    // 삭제유무
    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean deleteOrNot;

    // 사용자
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 종목
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    // 메모 이미지 파일
    @OneToMany(mappedBy = "userStockMemo")
    private List<UserStockMemoImageFile> userStockMemoImageFiles = new ArrayList<>();
}
