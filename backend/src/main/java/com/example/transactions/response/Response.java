package com.example.transactions.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class Response<T> {

    private int status_code;
    private String status_message;
    private List<T> response;

}
