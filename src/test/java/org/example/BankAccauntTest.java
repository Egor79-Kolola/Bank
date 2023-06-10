package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccauntTest {
    private BankAccaunt bankAccaunt;

    @BeforeEach
    void setUp(){
        bankAccaunt = new BankAccaunt(1000, 500);
    }

    @AfterEach
    void afterEach(){
        System.out.println("Test saccessfully compleated");
    }

    @Nested
    class DepositTests{
        @Test
        void deposit() {
            int acnual = bankAccaunt.deposit(500);
            int expected = 1500;
            assertEquals(expected, acnual, "Incorrected balance");
        }
    }

    @Nested
    class WithdrawTesys{
        @Test
        void withdraw_Throw_IllegalArgumentException_When_Wrong_Amount() {
            assertAll(
                    ()->assertThrows(IllegalArgumentException.class, ()->bankAccaunt.withdraw(600)),
                    ()->assertThrows(IllegalArgumentException.class, ()->bankAccaunt.withdraw(0))
            );
        }

        @Test
        void withdraw_Shoud_Return_CorectedBalance(){
            int actual = bankAccaunt.withdraw(300);
            int expected = 700;
            assertEquals(expected, actual, "Incorrected balance");
        }
    }

}