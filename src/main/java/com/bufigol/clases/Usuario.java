/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bufigol.clases;

import java.util.Date;

import com.bufigol.tools.GeneralToolkit;

/**
 *
 * @author Bufigol
 */
public class Usuario {

	private String usrName;
	private Date fechaNacimiento;
	private String email, Nombre, Apellido, pwd;

	public Usuario(String usrName, Date fechaNacimiento, String email, String Nombre, String Apellido, String pwd) {
		this.usrName = usrName;
		if (GeneralToolkit.mayorDeEdad(fechaNacimiento)) {
			this.fechaNacimiento = fechaNacimiento;
		} else {
			this.fechaNacimiento = null;
		}
		if (GeneralToolkit.checkMail(email)) {
			this.email = email;
		} else {
			this.email = null;
		}
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.pwd = pwd;

	}

}
