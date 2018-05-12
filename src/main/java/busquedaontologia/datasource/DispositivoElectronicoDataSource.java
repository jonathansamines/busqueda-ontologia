package busquedaontologia.datasource;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolutionMap;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import busquedaontologia.query.DispositivoElectronicoQueryFactory;

public class DispositivoElectronicoDataSource {
	private Model modelo;
	private final String nombreArchivoModelo = "ontologia.ttl";
	
	public DispositivoElectronicoDataSource() {
		this.modelo = DispositivoElectronicoModelFactory.construirModelo(this.nombreArchivoModelo);
	}
	
	public QuerySolutionMap parametrizarConsulta(String busqueda) {
		QuerySolutionMap parametros = new QuerySolutionMap();
		
		Resource recurso = this.modelo.getResource(busqueda);
		
		parametros.add("busqueda", recurso);

		return parametros;
	}
	
	public QueryExecution realizarConsulta(String busqueda) {
		String consulta = DispositivoElectronicoQueryFactory.crearConsulta();
		QuerySolutionMap parametros = this.parametrizarConsulta(busqueda);
		
		return QueryExecutionFactory.create(consulta, this.modelo, parametros);
	}
}
