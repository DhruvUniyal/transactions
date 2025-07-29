package com.example.transactions.utils;

import com.example.transactions.dto.BudgetDTO;

import com.example.transactions.model.Budgets;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

        BudgetDTO toDto(Budgets entity);
        Budgets toEntity(BudgetDTO dto);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        void updateEntityFromDto(BudgetDTO toDto, @MappingTarget Budgets budget);
}
