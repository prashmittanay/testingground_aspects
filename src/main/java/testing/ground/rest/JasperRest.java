package testing.ground.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperRunManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@Component
@Path("/jasper")
public class JasperRest {
	@Autowired DataSource dataSource;
	@Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private String path = "WEB-INF/reports/";
	
	@GET
	@Path("/compilefirstreport")
	@Produces("applicaiton/pdf")
	public Response compileFirstReport(@Context ServletContext context, @Context HttpServletResponse response) throws JRException, IOException{
		String jrxmlPath = context.getRealPath(path + "firstReport.jrxml");
		String jasperPath = context.getRealPath(path + "firstReport.jasper");
		
		File jasperFile = new File(jasperPath);
		//check if jasper already exists
		if(!jasperFile.exists()){
			compileReport(jrxmlPath);
		}

//		fillReport(jasperPath, new HashMap<String, Object>(), new JREmptyDataSource());
		
		InputStream jasperStream = context.getResourceAsStream("WEB-INF/reports/firstReport.jasper");
		byte[] pdfBytes = JasperRunManager.runReportToPdf(jasperStream, new HashMap<String, Object>(), new JREmptyDataSource());

		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(pdfBytes);
		ResponseBuilder responseRest = Response.ok();
		responseRest.header("Content-Disposition","attachment; filename=firstReport.pdf");
		return responseRest.build();
		
	}
	
	private void compileReport(String jrxmlPath) throws JRException{
		JasperCompileManager.compileReportToFile(jrxmlPath);
	}
	
	@SuppressWarnings("unused")
	private void fillReport(String jasperPath, Map<String, Object> paramMap, JRDataSource jrDataSource) throws JRException{
		JasperFillManager.fillReport(jasperPath, paramMap, jrDataSource);
	}
}

