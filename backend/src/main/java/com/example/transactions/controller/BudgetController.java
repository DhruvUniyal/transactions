package com.example.transactions.controller;

import com.example.transactions.model.Budgets;
import com.example.transactions.response.Response;
import com.example.transactions.serviceImpl.BudgetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BudgetController {

    @Autowired
    private BudgetServiceImpl budgets;

    @PostMapping("/addBudget")
    public Response<Budgets> addBudget(@RequestBody Budgets budget){
        return budgets.addBudget(budget);
    }

    @GetMapping("/getBudget")
    public Response<Budgets> getBudget(@RequestParam String year, @RequestParam String month){
        return budgets.getBudget(year, month);
    }

    @PutMapping("/updateBudget")
    public Response<Budgets> updateBudget(@RequestParam long id){
        return budgets.updateBudget(id);
    }

    @DeleteMapping("/deleteBudget")
    public Response<Budgets> deleteBudget(@RequestParam long id){
        return null;
    }

    @GetMapping("/getAllBudgets")
    public Response<Budgets> getAllBudgets(){
        return null;
    }

    @GetMapping("/getAllBudgets/currentStatus")
    public Response<Budgets> getCurrentStatusBudgets(){
        return null;
    }


}
