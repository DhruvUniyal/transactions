package com.example.transactions.response;

import com.example.transactions.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CategoryResponse {

    private int status_code;
    private String status_message;
    private Category response;
}
