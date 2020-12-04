package com.infodev.emart.emart.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;

    @Column(name = "name", nullable = false)
    private String categoryName;


    @OneToMany(targetEntity = Subcategory.class , mappedBy="category",cascade = CascadeType.ALL)
    @Nullable
    @JsonManagedReference
    private List<Subcategory> subcategorys = new ArrayList<>();
}
