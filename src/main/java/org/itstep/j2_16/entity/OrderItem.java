package org.itstep.j2_16.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
import static org.itstep.j2_16.util.FormatterUtil.round;

@Entity
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private String product;
    private Float quantity;
    private Float price;
    @JsonProperty(access = READ_ONLY)
    private Float value;
    private String description;

    @JsonGetter("order")
    public long getOrderForDto() {
        return order.getId();
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
        calculateValue();
    }

    public void setPrice(float price) {
        this.price = price;
        calculateValue();
    }

    private void calculateValue() {
        if (quantity == null || price == null) {
            value = 0f;
        } else {
            value = round(quantity * price, 2);
        }
    }
}
