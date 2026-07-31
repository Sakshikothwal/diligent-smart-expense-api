package com.diligent.expense_tracker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    private Long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Positive(message = "Amount must be greater than zero")
    private double amount;

    @NotBlank(message = "Category cannot be empty")
    private String category;

    private LocalDate date;
}
