package com.example.transactions.service;

import com.example.transactions.dto.BudgetDTO;
import com.example.transactions.model.Budgets;
import com.example.transactions.response.BudgetResponse;
import com.example.transactions.response.Response;

public interface BudgetService {

    Response<Budgets> addBudget(Budgets budget);

    Response<Budgets> getBudget(String year, String month);

    Response<Budgets> updateBudget(long id, BudgetDTO budget);

    Response<Budgets> getAllBudgets();

    BudgetResponse getBudgetById(long id);

    BudgetResponse getCurrentStatus();

    BudgetResponse getCurrentStatusByCategory(long categoryId);
}
