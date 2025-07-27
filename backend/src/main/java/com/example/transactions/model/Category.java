package com.example.transactions.model;

import com.example.transactions.utils.enums.Enums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long category_id;

    @Column(nullable = false)
    private String category_name;

    @Enumerated(EnumType.STRING)
    private Enums.CategoryType category_type;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate updated_at;

    @Column(nullable = false)
    private String is_active;

    @PrePersist
    private void applyDefaults(){
        if(null == created_at){
            this.created_at = LocalDate.now();
        }
        if(null == updated_at){
            this.updated_at = LocalDate.now();
        }
        if(null == is_active){
            this.is_active = "Y";
        }
    }
}
