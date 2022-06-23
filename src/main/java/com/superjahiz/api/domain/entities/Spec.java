package com.superjahiz.api.domain.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specs")
@JsonIdentityInfo(scope = Product.class,generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Spec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIncludeProperties(value = {"id","name"})
    @JoinColumn(name = "productId")
    private Product product;

}