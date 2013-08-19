package testing.ground.rest;

import java.io.File;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.sun.research.ws.wadl.Response;

@Component
@Path("/jasper")
public class JasperRest {
	@Autowired DataSource dataSource;
	@Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private String path = "WEB-INF/reports/";
	
	@GET
	@Path("/compilefirstreport")
	@Produces(MediaType.APPLICATION_JSON)
	public Response compileFirstReport(@Context ServletContext context) throws JRException{
		String jrxmlPath = context.getRealPath(path + "firstReport.jrxml");
		String jasperPath = context.getRealPath(path + "firstReport.jasper");
		
		File jasperFile = new File(jasperPath);
		//check if jasper already exists
		if(!jasperFile.exists()){
			JasperCompileManager.compileReportToFile(jrxmlPath);
		}

		JasperPrint fillReport = JasperFillManager.fillReport(jasperPath, new HashMap<String, Object>(), new JREmptyDataSource());
		return null;
	}
}

