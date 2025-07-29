package com.example.transactions.serviceImpl;

import com.example.transactions.dto.BudgetDTO;
import com.example.transactions.model.Budgets;
import com.example.transactions.repository.BudgetRepository;
import com.example.transactions.response.BudgetResponse;
import com.example.transactions.response.Response;
import com.example.transactions.service.BudgetService;
import com.example.transactions.utils.BudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transactions.utils.constants.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

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

    public Response<Budgets> updateBudget(long id, BudgetDTO budget) {
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

    public Response<Budgets> getAllBudgets(){
        Response<Budgets> budgets = new Response<Budgets>();
        try{
            Iterable<Budgets> response = this.budgetRepository.findAll();
            List<Budgets> budgetList = new ArrayList<Budgets>();
            if(!response.iterator().hasNext()) throw new Exception(Constants.EMPTY_RESULT_RETURNED);
            response.forEach(budgetList::add);
            if(budgetList.isEmpty()) throw new Exception(Constants.ERROR_RETURNING_DATA);
            budgets.setStatus_code(Constants.HTTP_OK_CODE);
            budgets.setStatus_message(Constants.SUCCESS_MESSAGE);
            budgets.setResponse(budgetList);
        } catch(Exception e){
            budgets.setStatus_code(Constants.HTTP_ERROR_CODE);
            budgets.setStatus_message(e.getMessage());
        }
        return budgets;
    }

    public BudgetResponse getBudgetById(long id){
        BudgetResponse budgets = new BudgetResponse();
        try{
            Optional<Budgets> resp = this.budgetRepository.findById(id);
            if(resp.isEmpty()) throw new Exception(Constants.EMPTY_RESULT_RETURNED);
            budgets.setStatus_message(Constants.SUCCESS_MESSAGE);
            budgets.setStatus_code(Constants.HTTP_OK_CODE);
            budgets.setResponse(resp.get());
        } catch(Exception e){
            budgets.setStatus_code(Constants.HTTP_ERROR_CODE);
            budgets.setStatus_message(e.getMessage());
        }
        return budgets;
    }

    public BudgetResponse getCurrentStatus(){
        BudgetResponse budgets = new BudgetResponse();
        try{
            String budget_month = LocalDate.now().getMonth().name();
            String budget_year = Integer.toString(LocalDate.now().getYear());
            Optional<Budgets> response = this.budgetRepository.getCurrentStatus(budget_month,budget_year);
            if(response.isEmpty()) throw new Exception(Constants.EMPTY_RESULT_RETURNED);
            budgets.setStatus_code(Constants.HTTP_OK_CODE);
            budgets.setStatus_message(Constants.SUCCESS_MESSAGE);
            budgets.setResponse(response.get());
        }
        catch(Exception e){
            budgets.setStatus_code(Constants.HTTP_ERROR_CODE);
            budgets.setStatus_message(e.getMessage());
        }
        return budgets;
    }

    public BudgetResponse getCurrentStatusByCategory(long categoryId){
        BudgetResponse budgets = new BudgetResponse();
        try{
            String budget_month = LocalDate.now().getMonth().name();
            String budget_year = Integer.toString(LocalDate.now().getYear());
            Optional<Budgets> response = this.budgetRepository.getCurrentStatusByCategory(budget_month,budget_year,categoryId);
            if(response.isEmpty()) throw new Exception(Constants.EMPTY_RESULT_RETURNED);
            budgets.setStatus_code(Constants.HTTP_OK_CODE);
            budgets.setStatus_message(Constants.SUCCESS_MESSAGE);
            budgets.setResponse(response.get());
        } catch(Exception e){
            budgets.setStatus_code(Constants.HTTP_ERROR_CODE);
            budgets.setStatus_message(e.getMessage());
        }
        return budgets;
    }


}
