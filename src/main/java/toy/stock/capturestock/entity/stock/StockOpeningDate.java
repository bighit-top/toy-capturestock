package toy.stock.capturestock.entity.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StockOpeningDate {

    // 개장일
    @Id
    @Column(name = "id")
    private LocalDate id;

    // 요일
    @Size(max = 3)
    private String dayOfWeek;

    // 종목 일별 시세
    @OneToMany(mappedBy = "stock")
    private List<StockDailyPrice> stockDailyPrices = new ArrayList<>();
}
