package testing.ground.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import testing.ground.dao.UserTestDao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class JasperTest {
	private final String JASPER_EXTENSION = ".jasper";
	private final String JRXML_EXTENSTION = ".jrxml";

	public static void main(String[] args) throws JRException, IOException {
		JasperTest test = new JasperTest();
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"D:/appContext.xml");
		UserTestDao userTestDao = (UserTestDao) context.getBean("userTestDao");
		List<Map<String, Object>> allUsers = userTestDao.getAllUsers();
		
		test.buildReport(allUsers);
//		test.writeToFile(allUsers);
//		test.printData(allUsers);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void buildReport(List<Map<String, Object>> data) throws JRException, IOException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", "My DIng dong");

		Collection randomQuery = data;
		JRMapCollectionDataSource collectionDataSource = new JRMapCollectionDataSource(
				randomQuery);
		String path = "D:\\gitProjects\\dummyreports\\";
		String reportName = "testreport";
		File file = new File(path + reportName + JASPER_EXTENSION);

		// check if compiled report exists
		if (!file.exists()) {
			compileReport(path + reportName + JRXML_EXTENSTION);
		}
		
		String source = path + reportName + JASPER_EXTENSION;
		FileInputStream inputStream = new FileInputStream(source);
		
		String destination = "D:\\gitProjects\\dummyreports\\testreport.pdf";
		
		FileOutputStream outputStream = new FileOutputStream(destination);
		
		JasperPrint filledReport = JasperFillManager.fillReport(inputStream, paramMap, collectionDataSource);
		
		JRExporter exportReport = new JRPdfExporter();
		exportReport.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
		exportReport.setParameter(JRExporterParameter.JASPER_PRINT, filledReport);
		exportReport.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
		
		exportReport.exportReport();
		
		/*
		//JasperRunManager.runReportToHtmlFile(source, destination, paramMap,	collectionDataSource);
		
		//JasperRunManager.runReportToPdfFile(source, paramMap, collectionDataSource);
		JasperRunManager.runReportToPdfStream(inputStream, outputStream, paramMap, collectionDataSource);
		*/
		
		System.out.println("report built");
	}

	private void compileReport(String jrxmlPath) throws JRException {
		JasperCompileManager.compileReportToFile(jrxmlPath);
	}
	
	public void printData(List<Map<String, Object>> data){
		Iterator<Map<String, Object>> iterator = data.iterator();
		
		while (iterator.hasNext()) {
			Map<java.lang.String, java.lang.Object> map = (Map<java.lang.String, java.lang.Object>) iterator
					.next();
			
			System.out.println(map);
		}
	}
	
	public void writeToFile(List<Map<String, Object>> data) throws FileNotFoundException{
		File file = new File("D:\\gitprojects\\dummyreports\\testingchar.txt");
		
		PrintWriter writer = new PrintWriter(file);
		
		Iterator<Map<String, Object>> iterator = data.iterator();
		
		while (iterator.hasNext()) {
			Map<java.lang.String, java.lang.Object> map = (Map<java.lang.String, java.lang.Object>) iterator
					.next();
			writer.write(map.get("username")+":"+map.get("name")+"\n");
		}
		
		writer.flush();
		writer.close();
	}
}
