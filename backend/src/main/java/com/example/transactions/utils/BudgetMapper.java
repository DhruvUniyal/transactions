package com.example.transactions.utils;

import com.example.transactions.dto.UpdateBudgetDTO;

import com.example.transactions.model.Budgets;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

        UpdateBudgetDTO toDto(Budgets entity);
        Budgets toEntity(UpdateBudgetDTO dto);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        void updateEntityFromDto(UpdateBudgetDTO toDto, @MappingTarget Budgets budget);
}
