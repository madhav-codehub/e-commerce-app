package com.luv4code.sbecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Table(name = "ec_order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", nullable = false, updatable = false)
    private UUID id;

    private UUID productId;

    private String productDescription;

    private String productImage;

    private double price;

    @Column(name = "category_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID categoryId;

    private String categoryName;

    private int quantity;

    @Column(name = "order_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID orderId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "order_id")
    private Order order;
}
