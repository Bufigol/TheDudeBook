package com.bufigol.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bufigol.constantes.CONST_CONFIG_KEYS;
import fileManagment.ConfigReader;
import fileManagment.ErrorLogger;

public class DDBB_Conection {
	private Connection conexion;
	private String url, user, pwd;

	public DDBB_Conection() {
		try {
			ConfigReader cr = new ConfigReader();
			this.url = cr.obtenerValor(CONST_CONFIG_KEYS.CONFIGINI_KEYS[0]);
			this.user = cr.obtenerValor(CONST_CONFIG_KEYS.CONFIGINI_KEYS[1]);
			this.pwd = cr.obtenerValor(CONST_CONFIG_KEYS.CONFIGINI_KEYS[2]);

			// Cargar el controlador JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establecer la conexión
			conexion = DriverManager.getConnection(url, user, pwd);
			ErrorLogger.logInfo("Conexión con la base de datos establecida");
		} catch (SQLException e) {
			ErrorLogger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// El controlador JDBC no se encontró en el classpath
			ErrorLogger.logErrorWithErrorCode(-1, "Controlador JDBC no encontrado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection getConexion() {
		ErrorLogger.logInfo("Conexión con la base de datos devuelta");
		return conexion;
	}

	public void cerrarConexion() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
				ErrorLogger.logInfo("Conexión con la base de datos cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorLogger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
		}
	}

	public void openConection() {
		try {
			if (conexion != null && conexion.isClosed()) {
				conexion = DriverManager.getConnection(url, user, pwd);
				ErrorLogger.logInfo("Conexión con la base de datos restablecida");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorLogger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
		}
	}

	public void closeConection() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
