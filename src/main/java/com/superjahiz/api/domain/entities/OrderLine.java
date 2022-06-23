package com.superjahiz.api.domain.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    @JsonBackReference
    private UserOrder order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIdentityInfo(scope = Product.class,generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    @JsonIncludeProperties(value = {"id","name","description","price","inStock","sold","pictures"})
    @JoinColumn(name = "productId")
    private Product product;

    private Long quantity;
    private float total;
}
