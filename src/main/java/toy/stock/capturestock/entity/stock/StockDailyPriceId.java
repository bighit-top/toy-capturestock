package toy.stock.capturestock.entity.stock;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
public class StockDailyPriceId implements Serializable {

    // 종목 일별 시세 아이디
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 종목
    @Column(name = "stock_id")
    private int stockId;

    // 종목 개장일
    @Column(name = "opening_date_id")
    private LocalDate openingDateId;
}