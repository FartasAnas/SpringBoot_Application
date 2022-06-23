package com.superjahiz.api.domain.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userOrders")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shippingAddress;
    private double totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIncludeProperties(value = {"id","username","email","firstName","lastName","phone"})
    @JsonIdentityInfo(scope = AppUser.class,generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private AppUser userId;


    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();
}
