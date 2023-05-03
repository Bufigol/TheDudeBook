/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bufigol.tools;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

/**
 *
 * @author Bufigol
 */
public class GeneralToolkit {

    public static boolean checkMail(String email) {
        boolean exit;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if(email != null){
            exit=pat.matcher(email).matches();
        }else{
            exit=false;
        }
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
