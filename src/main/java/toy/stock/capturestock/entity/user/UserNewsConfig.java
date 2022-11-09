package toy.stock.capturestock.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class UserNewsConfig {

    // 사용자 아아디
    @Id
    private int userId;

    // 등락률
    @Column(nullable = false)
    @Size(min = -30, max = 30)
    private BigDecimal ratio;

    // 자동 스크랩 여부
    @Column(columnDefinition = "bit default 0")
    private boolean autoOrNot;
}
