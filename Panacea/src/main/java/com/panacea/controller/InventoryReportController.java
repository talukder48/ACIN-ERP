package com.panacea.controller;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@Controller
public class InventoryReportController {
	
	@GetMapping({"/ReportProductList.do"})
	public String ReportProductList() {		
		return "Inventory/report-product";
	}
	@GetMapping({"/ReportDailyActivity.do"})
	public String ReportDailyActivity() {		
		return "Inventory/report-daily-works";
	}
	
	@GetMapping({"/ReportProductStatement.do"})
	public String ReportProductStatement() {		
		return "Inventory/report-product-statement";
	}
	
	@GetMapping({"/ReportPurchaseList.do"})
	public String ReportPurchaseList() {		
		return "Inventory/report-purchase";
	}
	@GetMapping({"/ReportDisburseList.do"})
	public String ReportDisburseList() {		
		return "Inventory/report-disburse";
	}
	@Autowired
	DataSource dataSource;
	
	@RequestMapping(value = "/ViewProductReport", method = RequestMethod.POST)
	public void ViewProductReport(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("reportType"));
		String str = "byte array size example";
		
		File file = new File("src/main/resources/employee-rpt-database.jrxml");
		Map<String, Object> parameter = new HashMap<String, Object>();
		
		
		try {
			byte[] bytes = JasperRunManager.runReportToPdf(file.getCanonicalPath(), parameter, dataSource.getConnection());
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		byte DataBytes[] = str.getBytes();
		response.setContentType("application/pdf");
		response.setContentLength(DataBytes.length);
		ServletOutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(DataBytes, 0, DataBytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/ViewInventoryDailyReport", method = RequestMethod.POST)
	public void ViewInventoryDailyReport(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("reportType"));
		System.out.println(request.getParameter("fromDate"));
		System.out.println(request.getParameter("ToDate"));
		String str = "byte array size example";
		byte DataBytes[] = str.getBytes();
		response.setContentType("application/pdf");
		response.setContentLength(DataBytes.length);
		ServletOutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(DataBytes, 0, DataBytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/ViewInventoryProductReport", method = RequestMethod.POST)
	public void ViewInventoryProductReport(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("productId"));
		System.out.println(request.getParameter("reportType"));
		System.out.println(request.getParameter("fromDate"));
		System.out.println(request.getParameter("ToDate"));
		String str = "byte array size example";
		byte DataBytes[] = str.getBytes();
		response.setContentType("application/pdf");
		response.setContentLength(DataBytes.length);
		ServletOutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(DataBytes, 0, DataBytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/ViewInventoryDisburseReport", method = RequestMethod.POST)
	public void ViewInventoryDisburseReport(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("reportType"));
		System.out.println(request.getParameter("fromDate"));
		System.out.println(request.getParameter("ToDate"));
		String str = "byte array size example";
		byte DataBytes[] = str.getBytes();
		response.setContentType("application/pdf");
		response.setContentLength(DataBytes.length);
		ServletOutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(DataBytes, 0, DataBytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/ViewInventoryPurchaseReport", method = RequestMethod.POST)
	public void ViewInventoryPurchaseReport(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("reportType"));
		System.out.println(request.getParameter("fromDate"));
		System.out.println(request.getParameter("ToDate"));
		String str = "byte array size example";
		byte DataBytes[] = str.getBytes();
		response.setContentType("application/pdf");
		response.setContentLength(DataBytes.length);
		ServletOutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(DataBytes, 0, DataBytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

