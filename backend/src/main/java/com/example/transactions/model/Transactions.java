package com.example.transactions.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.transactions.utils.enums.Enums;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;

    private long user_id;

    @Enumerated(EnumType.STRING)
    private Enums.PaymentType payment_method;

    @Column(nullable = false)
    private double transaction_amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private LocalDate transaction_date;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Enums.TransactionType transaction_type;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updated_at;

    @PrePersist
    private void applyDefaults(){
        if(null == transaction_date){
            transaction_date = LocalDate.now();
        }
        if(null == payment_method){
            payment_method = Enums.PaymentType.UPI;
        }
        if(null == transaction_type){
            transaction_type = Enums.TransactionType.DEBIT;
        }
    }
}
