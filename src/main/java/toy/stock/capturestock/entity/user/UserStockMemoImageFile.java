package toy.stock.capturestock.entity.user;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import toy.stock.capturestock.entity.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "memo_image_file")
public class UserStockMemoImageFile extends DateAudit {

    // 파일 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 파일명
    private String name;

    // 파일티입
    @Size(max = 10)
    private String type;

    // 사용자
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 사용자 종목 메모
    @ManyToOne(fetch = FetchType.LAZY)
    private UserStockMemo userStockMemo;
}
