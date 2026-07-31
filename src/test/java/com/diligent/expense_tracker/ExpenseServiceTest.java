package com.diligent.expense_tracker;

import com.diligent.expense_tracker.model.Expense;
import com.diligent.expense_tracker.service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {

    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseService();
    }

    @Test
    void testAddExpense() {

        Expense expense = new Expense(
                null,
                "Lunch",
                250,
                "Food",
                LocalDate.now()
        );

        Expense saved = expenseService.addExpense(expense);

        assertNotNull(saved.getId());
        assertEquals("Lunch", saved.getTitle());
    }

    @Test
    void testGetAllExpenses() {

        expenseService.addExpense(
                new Expense(null, "Bus", 50, "Travel", LocalDate.now())
        );

        assertEquals(1, expenseService.getAllExpenses().size());
    }

    @Test
    void testGetTotalExpenses() {

        expenseService.addExpense(
                new Expense(null, "Lunch", 250, "Food", LocalDate.now())
        );

        expenseService.addExpense(
                new Expense(null, "Bus", 100, "Travel", LocalDate.now())
        );

        assertEquals(350, expenseService.getTotalExpenses());
    }

    @Test
    void testDeleteExpense() {

        Expense expense = expenseService.addExpense(
                new Expense(null, "Coffee", 80, "Food", LocalDate.now())
        );

        expenseService.deleteExpense(expense.getId());

        assertTrue(expenseService.getAllExpenses().isEmpty());
    }
}
