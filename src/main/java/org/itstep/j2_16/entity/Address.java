package org.itstep.j2_16.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "country")
    private String country;
    private String region;
    private String district;
    private String city;
    private String street;
    private String house;
    private String appartment;
    private String description;
    @Transient
    private String other;
}
