package com.example.transactions.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class BudgetDTO {

    private long budget_id;

    private long category;

    private long user_id;

    private double budget_amount;

    private double actual_spent;

    private String budget_month;

    private String budget_year;

    private LocalDate created_at;

    private LocalDate updated_at;

    private String is_active;
}
