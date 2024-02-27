package com.bufigol.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fileManagment.ErrorLogger;

public class DDBB_Conection {
	private Connection conexion;
	private String url, user, pwd;

	public DDBB_Conection() {
		try {
			conexion = DriverManager.getConnection(url, user, pwd);
			ErrorLogger.logInfo("Conexión con la base de datos establecida");
		} catch (SQLException e) {
			ErrorLogger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection getConexion() {
		ErrorLogger.logInfo("Conexión con la base de datos devuelta");
		return conexion;
	}

	public void cerrarConexion() {
		try {
			conexion.close();
			ErrorLogger.logInfo("Conexión con la base de datos cerrada");
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorLogger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
		}

	}

	public void openConection() {
		try {
			conexion = DriverManager.getConnection(url, user, pwd);
			ErrorLogger.logInfo("Conexión con la base de datos reestablecida");
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorLogger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
		}

	}
}
