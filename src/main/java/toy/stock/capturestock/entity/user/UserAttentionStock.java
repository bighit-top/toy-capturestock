package toy.stock.capturestock.entity.user;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import toy.stock.capturestock.entity.stock.Stock;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserAttentionStock {

    /**
     * 사용자 아이디: user_id
     * 종목 아이디: stock_id
     */
    @EmbeddedId
    private UserAttentionStockId id;

    // 사용자 아이디
    @MapsId(value = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 종목 아이디
    @MapsId(value = "stock_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    // 자동스크랩
    @Column(columnDefinition = "bit default 0")
    private boolean autoOrNot;

    // 생성일
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
}
