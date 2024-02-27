package fileManagment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.bufigol.constantes.CONST_CUSTOM_ERROR_CODES;
import com.bufigol.constantes.CONST_FILES;

public class ConfigReader {
	Properties properties;
	private String configFile;

	/**
	 * @param properties
	 */
	public ConfigReader() {
		this.properties = new Properties();
		this.configFile = CONST_FILES.CONFIG_FILE_PATH;
		leerConfiguracion();
	}

	public ConfigReader(String configFile) {
		this.configFile = configFile;
		properties = new Properties();
		leerConfiguracion();
	}

	public void escribirConfiguracion(String comments) {
		try (FileOutputStream output = new FileOutputStream(configFile)) {
			properties.store(output, comments);
		} catch (IOException e) {
			e.printStackTrace();
			ErrorLogger.logErrorWithErrorCode(CONST_CUSTOM_ERROR_CODES.IOException, e.getMessage());
		}
	}

	public String obtenerValor(String clave) {
		return properties.getProperty(clave);
	}

	public void establecerValor(String clave, String valor) {
		properties.setProperty(clave, valor);
	}

	public void crearNuevaCategoria(String nombreCategoria) {
		properties.setProperty(nombreCategoria, "");
	}

	private void leerConfiguracion() {
		FileInputStream input;
		try {
			input = new FileInputStream(configFile);
			properties.load(input);
		} catch (FileNotFoundException e) {
			ErrorLogger.logErrorWithErrorCode(CONST_CUSTOM_ERROR_CODES.FileNotFoundException, e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			ErrorLogger.logErrorWithErrorCode(CONST_CUSTOM_ERROR_CODES.IOException, e.getMessage());
		}

	}
}
