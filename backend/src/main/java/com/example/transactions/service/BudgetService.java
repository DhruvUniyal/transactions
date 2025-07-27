package com.example.transactions.service;

import com.example.transactions.model.Budgets;
import com.example.transactions.response.Response;

public interface BudgetService {

    Response<Budgets> addBudget(Budgets budget);

    Response<Budgets> getBudget(String year, String month);

    Response<Budgets> updateBudget(long id);
}
