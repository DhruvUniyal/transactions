package com.example.transactions.serviceImpl;

import com.example.transactions.dto.UpdateBudgetDTO;
import com.example.transactions.model.Budgets;
import com.example.transactions.repository.BudgetRepository;
import com.example.transactions.response.Response;
import com.example.transactions.utils.BudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transactions.utils.constants.Constants;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetMapper budgetMapper;

    public Response<Budgets> addBudget(Budgets budget){
        Response<Budgets> response = new Response<Budgets>();
        try{
            this.budgetRepository.save(budget);
            response.setStatus_code(Constants.HTTP_OK_CODE);
            response.setStatus_message(Constants.SUCCESS_MESSAGE);
        }catch (Exception e){
            response.setStatus_code(Constants.HTTP_ERROR_CODE);
            response.setStatus_message(e.getMessage());
        }
        return response;
    }

    public Response<Budgets> getBudget(String year, String month){
        Response<Budgets> response = new Response<Budgets>();
        try{
            List<Budgets> budgetList = this.budgetRepository.findByBudgetMonthAndBudgetYear(year,month);
            if(budgetList.isEmpty()){
                throw new Exception(Constants.EMPTY_RESULT_RETURNED);
            }
            response.setStatus_code(Constants.HTTP_OK_CODE);
            response.setStatus_message(Constants.SUCCESS_MESSAGE);
            response.setResponse(budgetList);
        } catch(Exception e){
            response.setStatus_code(Constants.HTTP_ERROR_CODE);
            response.setStatus_message(e.getMessage());
        }
        return response;
    }

    public Response<Budgets> updateBudget(long id, UpdateBudgetDTO budget) {
        Response<Budgets> response = new Response<Budgets>();
        Optional<Budgets> budgetVal;
        budgetVal = this.budgetRepository.findById(id);
        if(budgetVal.isEmpty()){
            response.setStatus_code(Constants.HTTP_ERROR_CODE);
            response.setStatus_message(Constants.EMPTY_RESULT_RETURNED);
            return response;
        }
        try{
            budgetMapper.updateEntityFromDto(budget,budgetVal.get());
            this.budgetRepository.save(budgetVal.get());
            response.setStatus_code(Constants.HTTP_OK_CODE);
            response.setStatus_message(Constants.SUCCESS_MESSAGE);
        } catch(Exception e){
            response.setStatus_code(Constants.HTTP_ERROR_CODE);
            response.setStatus_message(e.getMessage());
        }
        return response;
    }

//    public Response<Budgets>
}
