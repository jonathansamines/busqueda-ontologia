package busquedaontologia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

import busquedaontologia.datasource.DispositivoElectronicoDataSource;

@WebServlet(
        name = "busquedaOntologiaServlet",
        urlPatterns = {"/ontologia"}
    )
public class BusquedaOntologiaServlet extends HttpServlet {
	private DispositivoElectronicoDataSource source;

	public BusquedaOntologiaServlet() {
		this.source = new DispositivoElectronicoDataSource();
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String query = req.getParameter("query");
        ServletOutputStream out = resp.getOutputStream();
        
        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        
        ResultSet result = this.source.realizarConsulta(query).execSelect();
        ResultSetFormatter.outputAsJSON(out, result);
    }

}