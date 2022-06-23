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
@Table(name = "pictures")
@JsonIdentityInfo(scope = Product.class,generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIncludeProperties(value = {"id","name"})
    @JoinColumn(name = "productId")
    private Product product;

}
