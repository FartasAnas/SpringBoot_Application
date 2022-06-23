package com.superjahiz.api.domain.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private float price;
    private long inStock;
    private long sold;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StoreId")
    @JsonIncludeProperties(value = {"id","domainName","logoUrl","accentColor","contrastColor"})
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    @JsonIncludeProperties(value = {"id","quantity","total"})
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIncludeProperties(value = {"id","url"})
    private List<Picture> pictures = new ArrayList<Picture>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIncludeProperties(value = {"id","name","content"})
    private List<Spec> specs = new ArrayList<Spec>();
}
