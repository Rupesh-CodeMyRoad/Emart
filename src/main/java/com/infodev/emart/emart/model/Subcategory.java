package com.infodev.emart.emart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subcategory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subCategoryId;

    @Column(nullable=false)
    private String subCategoryName;

    @OneToMany(mappedBy="subcategory",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();


    @ManyToOne
    @JsonBackReference
    @JoinColumn(referencedColumnName = "categoryId", nullable = false)
    private Category category;
}
