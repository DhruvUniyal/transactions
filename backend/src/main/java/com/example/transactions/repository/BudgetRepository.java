package com.example.transactions.repository;

import com.example.transactions.model.Budgets;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BudgetRepository extends CrudRepository<Budgets,Long> {

    public List<Budgets> findByBudgetMonthAndBudgetYear(String budget_month, String budget_year);

}
