package com.example.transactions.dto;

import com.example.transactions.utils.enums.Enums;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class CategoryDTO {

    private long category_id;

    private String category_name;

    private Enums.CategoryType categoryType;

    private LocalDate created_at;

    private LocalDate updated_at;

    private String is_active;
}
