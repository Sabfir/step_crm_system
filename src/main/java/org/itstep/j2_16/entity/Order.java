package org.itstep.j2_16.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static org.itstep.j2_16.constraint.RegexPattern.DATE_TIME_PATTERN;

@Entity
@Table(name = "order_document")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @JsonProperty(access = READ_ONLY)
    @JsonFormat(shape = STRING, pattern = DATE_TIME_PATTERN)
    private LocalDateTime created;
    @OneToMany(fetch = EAGER, cascade = ALL, mappedBy = "order")
    private List<OrderItem> orderItems;
    @JsonProperty(access = READ_ONLY)
    private Float totalValue;
    private String description;

    public float getTotalValue() {
        return orderItems.stream()
                .map(OrderItem::getValue)
                .filter(Objects::nonNull)
                .reduce((a, b) -> a + b)
                .orElse(0f);
    }
}
