package org.itstep.j2_16.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
public class OrderDocument {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime orderDate;
    @OneToMany(fetch = EAGER, mappedBy = "orderDocument")
    private List<OrderItem> items = new ArrayList<>();
//    @Transient
//    @Setter(AccessLevel.PRIVATE)
//    private Float totalSum;
    private String description;

//    public float getTotalSum() {
//        return items.stream()
//                .map(OrderItem::getSum)
//                .filter(Objects::nonNull)
//                .reduce((a, b) -> a + b)
//                .orElse(0f);
//    }
}
