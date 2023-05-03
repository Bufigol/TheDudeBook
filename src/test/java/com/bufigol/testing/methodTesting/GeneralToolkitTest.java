/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bufigol.testing.methodTesting;

import com.bufigol.tools.GeneralToolkit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Felipe
 */
public class GeneralToolkitTest {

    @Test
    public void testCheckMailValidEmail() {
        // Arrange
        String email = "example@gmail.com";

        // Act
        boolean result = GeneralToolkit.checkMail(email);

        // Assert
        assertTrue(result);
    }
}
