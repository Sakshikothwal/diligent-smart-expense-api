package com.diligent.expense_tracker.controller;

import com.diligent.expense_tracker.model.Expense;
import com.diligent.expense_tracker.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@Tag(
        name = "Expense Tracker API",
        description = "REST APIs for managing personal expenses"
)
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Operation(
            summary = "Add a new expense",
            description = "Creates a new expense with an auto-generated ID."
    )
    @PostMapping
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense) {
        Expense savedExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get all expenses",
            description = "Returns the complete list of expenses."
    )
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @Operation(
            summary = "Filter expenses by category",
            description = "Returns all expenses belonging to the specified category."
    )
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(expenseService.getExpensesByCategory(category));
    }

    @Operation(
            summary = "Calculate total expenses",
            description = "Returns the total amount of all recorded expenses."
    )
    @GetMapping("/total")
    public ResponseEntity<Double> getTotalExpenses() {
        return ResponseEntity.ok(expenseService.getTotalExpenses());
    }

    @Operation(
            summary = "Calculate total expenses by category",
            description = "Returns the total expense amount for a specific category."
    )
    @GetMapping("/total/{category}")
    public ResponseEntity<Double> getTotalByCategory(@PathVariable String category) {
        return ResponseEntity.ok(expenseService.getTotalByCategory(category));
    }

    @Operation(
            summary = "Delete an expense",
            description = "Deletes an expense using its ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully.");
    }
}