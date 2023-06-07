package ru.rrenat358.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;


    @Column(name = "price")
    Integer price;



    @Column(name = "proteins")
    String proteins;

    @Column(name = "fats")
    String fats;

    @Column(name = "carbohydrates")
    String carbohydrates;

    @Column(name = "calories")
    String calories;

    //todo хранить в БД  со @OneToMany/@ManyToOne
    @Column(name = "group_product")
    String groupProduct;


    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }





}
