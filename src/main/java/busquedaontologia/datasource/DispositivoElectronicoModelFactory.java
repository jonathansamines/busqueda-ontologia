package busquedaontologia.datasource;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class DispositivoElectronicoModelFactory {
	public static Model construirModelo(String nombreArchivoModelo) {
		Model modelo = ModelFactory.createDefaultModel();
		
		// Cargamos el modelo en el archivo a memoria
		modelo.read(nombreArchivoModelo);
		
		return modelo;
	}
}
