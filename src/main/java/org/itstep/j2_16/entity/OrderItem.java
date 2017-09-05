package org.itstep.j2_16.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itstep.j2_16.util.FormatterUtil;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static org.itstep.j2_16.util.FormatterUtil.round;

@Entity
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    private String item;
    private Float quantity;
    private Float price;
    @Setter(AccessLevel.PRIVATE)
    private Float sum;
    private String description;

    public void setQuantity(float quantity) {
        this.quantity = quantity;
        calculateSum();
    }

    public void setPrice(float price) {
        this.price = price;
        calculateSum();
    }

    private void calculateSum() {
        sum = round(quantity * price, 2);
    }
}
