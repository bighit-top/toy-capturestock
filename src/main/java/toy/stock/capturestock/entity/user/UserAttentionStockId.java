package toy.stock.capturestock.entity.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class UserAttentionStockId implements Serializable {

    // 사용자 아이디
    @Column(name = "user_id")
    private long userId;

    // 종목 아이디
    @Column(name = "stock_id")
    private int stockId;
}