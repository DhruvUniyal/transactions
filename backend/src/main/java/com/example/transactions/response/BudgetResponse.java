package com.example.transactions.response;

import com.example.transactions.model.Budgets;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class BudgetResponse {

    private int status_code;
    private String status_message;
    private Budgets response;

}
