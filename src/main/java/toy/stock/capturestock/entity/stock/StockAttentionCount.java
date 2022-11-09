package toy.stock.capturestock.entity.stock;

import javax.persistence.*;

@Entity
public class StockAttentionCount {

    @Id
    private int stockId;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int attentionCount;
}
