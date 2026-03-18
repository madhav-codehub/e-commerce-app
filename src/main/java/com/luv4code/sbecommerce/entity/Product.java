package com.luv4code.sbecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "ec_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", nullable = false, updatable = false)
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private boolean sale = false;
    private double salePrice = 0;
    private int views = 0;
    private boolean featured = false;
    private String featureImage;
    private LocalDateTime createAt;
    private String color;
    private String size;

    @Column(name = "category_id", columnDefinition = "BINARY(16)")
    @JdbcTypeCode(SqlTypes.BINARY)
    protected UUID categoryId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, insertable = false, name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Cart> items;
}
