package com.example.transactions.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import com.example.transactions.model.Category;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter @Setter @NoArgsConstructor
public class Budgets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_id")
    private long budget_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private long user_id;

    private double budget_amount;

    private double actual_spent;

    @Column(nullable = false)
    private String budget_month;

    @Column(nullable = false)
    private String  budget_year;

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
        if(null == this.budget_month){
            this.budget_month = LocalDate.now().getMonth().name();
        }
        if(null == this.budget_year){
            this.budget_year = Integer.toString(LocalDate.now().getYear());
        }
    }


}
