package com.example.transactions.repository;

import com.example.transactions.model.Budgets;
import com.example.transactions.response.BudgetResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends CrudRepository<Budgets,Long> {

    List<Budgets> findByBudgetMonthAndBudgetYear(String budget_month, String budget_year);

    @Query("SELECT budget_amount-actual_spent AS current_status FROM budgets WHERE budget_month = ?1 and budget_year = ?2")
    Optional<Budgets> getCurrentStatus(String budget_month, String budget_year);

    @Query("SELECT budget_amount-actual_spent AS current_status FROM budgets WHERE budget_month = ?1 and budget_year = ?2 and category_id = ?3")
    Optional<Budgets> getCurrentStatusByCategory(String budget_month, String budget_year, long category_id);
}
