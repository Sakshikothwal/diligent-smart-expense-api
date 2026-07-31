package com.diligent.expense_tracker.service;
import com.diligent.expense_tracker.exception.ExpenseNotFoundException;
import com.diligent.expense_tracker.model.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final List<Expense> expenses = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Expense addExpense(Expense expense) {
        expense.setId(idGenerator.getAndIncrement());
        expenses.add(expense);
        return expense;
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public double getTotalExpenses() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double getTotalByCategory(String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public void deleteExpense(Long id) {

        Expense expense = expenses.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ExpenseNotFoundException("Expense with ID " + id + " not found.")
                );

        expenses.remove(expense);
    }
}