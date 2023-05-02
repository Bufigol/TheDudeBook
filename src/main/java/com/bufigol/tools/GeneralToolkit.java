/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bufigol.tools;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Bufigol
 */
public class GeneralToolkit {

    public static boolean checkMail(String email) {
        boolean exit = false;
        // Expresión regular para validar una dirección de correo electrónico
        String regex = "^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.-]+\\.(gmail|yahoo|hotmail|outlook)\\.(com|es|net)$";
        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);
        // Obtener un objeto Matcher para la dirección de correo electrónico
        Matcher matcher = pattern.matcher(email);
        exit = matcher.matches();
        return exit;
    }

    public static boolean mayorDeEdad(Date fechaNacimiento) {
        boolean exit = false;
        Period edad = Period.between(LocalDate.parse(fechaNacimiento.toString()), LocalDate.now());
        if (edad.getYears() >= 18) {
            exit = true;
        }
        return exit;
    }
}
