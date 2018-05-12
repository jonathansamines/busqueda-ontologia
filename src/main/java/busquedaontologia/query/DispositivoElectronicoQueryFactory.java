package busquedaontologia.query;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class DispositivoElectronicoQueryFactory {
	public static String crearConsulta() {
		StringBuilder result = new StringBuilder("");

		// Obtenemos el archivo de consulta del directorio de recursos
		ClassLoader classLoader = DispositivoElectronicoQueryFactory.class.getClassLoader();
		File file = new File(classLoader.getResource("busqueda.query").getFile());

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result.toString();
	}
}
