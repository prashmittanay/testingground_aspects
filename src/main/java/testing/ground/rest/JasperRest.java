package testing.ground.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import testing.ground.dao.JqDao;

@Component
@Path("/jasper")
public class JasperRest {
	@Autowired DataSource dataSource;
	@Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired JqDao jqDao;
	private String path = "WEB-INF/reports/";
	private final String JASPER_EXTENSION = ".jasper";
	private final String JRXML_EXTENSTION = ".jrxml";

	/**
	 * simple example no dynamic content
	 * */
	@GET
	@Path("/compilefirstreport")
	@Produces("applicaiton/pdf")
	public Response compileFirstReport(@Context ServletContext context,
			@Context HttpServletResponse response) throws JRException,
			IOException {
		String jrxmlPath = context.getRealPath(path + "firstReport.jrxml");
		String jasperPath = context.getRealPath(path + "firstReport.jasper");

		File jasperFile = new File(jasperPath);
		// check if jasper already exists
		if (!jasperFile.exists()) {
			compileReport(jrxmlPath);
		}

		// fillReport(jasperPath, new HashMap<String, Object>(), new
		// JREmptyDataSource());

		InputStream jasperStream = context
				.getResourceAsStream("WEB-INF/reports/firstReport.jasper");
		byte[] pdfBytes = JasperRunManager.runReportToPdf(jasperStream,
				new HashMap<String, Object>(), new JREmptyDataSource());

		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(pdfBytes);
		ResponseBuilder responseRest = Response.ok();
		responseRest.header("Content-Disposition",
				"attachment; filename=firstReport.pdf");
		return responseRest.build();
	}

	@GET
	@Path("/basicdbreport")
	@Produces("application/pdf")
	public Response basicDbReport(@Context ServletContext context,
			@Context HttpServletResponse response) throws JRException,
			IOException {
		Connection connection = null;
		byte[] reportBytes = null;
		String reportName = "firstsqlexample";

		File file = new File(path + reportName + JASPER_EXTENSION);

		// check if compiled report exists
		if (!file.exists()) {
			compileReport(context.getRealPath(path + reportName
					+ JRXML_EXTENSTION));
		}

		// fill compiled report
		InputStream compiledReportStream = context.getResourceAsStream(path
				+ reportName + JASPER_EXTENSION);

		try {
			connection = dataSource.getConnection();
			reportBytes = JasperRunManager.runReportToPdf(compiledReportStream,
					new HashMap<String, Object>(), connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (reportBytes != null) {
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(reportBytes);
		}

		ResponseBuilder restResponse = Response.ok();
		restResponse.header("Content-Disposition",
				"attachment; filename=firstSQLReport.pdf");
		return restResponse.build();
	}

	@GET
	@Path("/basicreportparameterexample")
	@Produces("application/pdf")
	public Response basicReportParameterExample(
			@Context ServletContext context,
			@Context HttpServletResponse response,
			@QueryParam("position") int position) throws JRException,
			IOException {
		Connection connection = null;
		String reportName = "simpleparameterexample";
		ServletOutputStream outputStream = response.getOutputStream();
		response.setHeader("Content-Disposition",
				"attachment; filename=firstparameterReport.pdf");
		File file = new File(context.getRealPath(path + reportName
				+ JASPER_EXTENSION));

		// check if compiled report exists
		if (!file.exists()) {
			compileReport(context.getRealPath(path + reportName
					+ JRXML_EXTENSTION));
		}

		// fill compiled report
		InputStream compiledReportStream = context.getResourceAsStream(path
				+ reportName + JASPER_EXTENSION);

		try {
			connection = dataSource.getConnection();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("position", position);
			JasperRunManager.runReportToPdfStream(compiledReportStream,
					outputStream, paramMap, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		ResponseBuilder restResponse = Response.ok();
		return restResponse.build();
	}
//simple-jq-jasper
	@GET
	@Path("/jqplot-jasper-intergration")
	@Produces("application/json")
	public Response jqplotJasperIntegration(
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@Context ServletContext context) throws JRException, IOException {
		String query = (String) request.getSession().getAttribute("latestQuery");
		List<Map<String, Object>> randomQueryRunner = jqDao.randomQueryRunner(query);
		Collection randomQuery  = randomQueryRunner;
		JRMapCollectionDataSource collectionDataSource = new JRMapCollectionDataSource(randomQuery);
		
		Connection connection = null;
		String reportName = "simple-jq-jasper";
		ServletOutputStream outputStream = response.getOutputStream();
		response.setHeader("Content-Disposition",
				"attachment; filename=first-jq-jasper-intergration.pdf");
		File file = new File(context.getRealPath(path + reportName
				+ JASPER_EXTENSION));

		// check if compiled report exists
		if (!file.exists()) {
			compileReport(context.getRealPath(path + reportName
					+ JRXML_EXTENSTION));
		}

		// fill compiled report
		InputStream compiledReportStream = context.getResourceAsStream(path
				+ reportName + JASPER_EXTENSION);

		try {
			connection = dataSource.getConnection();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			JasperRunManager.runReportToPdfStream(compiledReportStream,
					outputStream, paramMap, collectionDataSource);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		ResponseBuilder restResponse = Response.ok();
		return restResponse.build();
	}

	private void compileReport(String jrxmlPath) throws JRException {
		JasperCompileManager.compileReportToFile(jrxmlPath);
	}

	@SuppressWarnings("unused")
	private void fillReport(String jasperPath, Map<String, Object> paramMap,
			JRDataSource jrDataSource) throws JRException {
		JasperFillManager.fillReport(jasperPath, paramMap, jrDataSource);
	}
}