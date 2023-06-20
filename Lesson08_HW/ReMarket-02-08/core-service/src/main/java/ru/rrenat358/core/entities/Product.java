package ru.rrenat358.core.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;


    @Column(name = "price")
    private Integer price;



    @Column(name = "proteins")
    private String proteins;

    @Column(name = "fats")
    private String fats;

    @Column(name = "carbohydrates")
    private String carbohydrates;

    @Column(name = "calories")
    private String calories;

    //todo хранить в БД  со @OneToMany/@ManyToOne
    @Column(name = "group_product")
    private String groupProduct;


    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    public Product(Long id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }





}
