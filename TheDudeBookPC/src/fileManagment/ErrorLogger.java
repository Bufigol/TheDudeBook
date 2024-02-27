package fileManagment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bufigol.constantes.CONST_FILES;

public class ErrorLogger {
	private static void initializeLogFile() {
		File logFile = new File(CONST_FILES.LOG_FILE_PATH);
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void logErrorWithErrorCode(int errorCode, String errorMessage) {
		initializeLogFile();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONST_FILES.LOG_FILE_PATH, true))) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.append(timeStamp + " - ERROR CODE: " + errorCode + "\n");
			writer.append(timeStamp + " - ERROR: " + errorMessage + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logError(String errorMessage) {
		initializeLogFile();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONST_FILES.LOG_FILE_PATH, true))) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.append(timeStamp + " - ERROR: " + errorMessage + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logInfo(String infoMessage) {
		initializeLogFile();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONST_FILES.LOG_FILE_PATH, true))) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.append(timeStamp + " - INFO: " + infoMessage + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logWarning(String warningMessage) {
		initializeLogFile();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONST_FILES.LOG_FILE_PATH, true))) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.append(timeStamp + " - WARNING: " + warningMessage + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
