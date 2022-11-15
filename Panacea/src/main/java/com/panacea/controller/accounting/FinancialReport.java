package com.panacea.controller.accounting;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.panacea.model.common.DropDownType;
import com.panacea.repository.Accounting.GLCodeRepo;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class FinancialReport {
	@Autowired
	DataSource dataSource;
	@Autowired
	GLCodeRepo glcoderepository;
	
	@GetMapping({ "/GetCashBook" })
	public ModelAndView GetCashBook() {
		ModelAndView mav = new ModelAndView("Accounting/Report/view-CashBook");
		List<DropDownType> ReportType = new ArrayList<DropDownType>();
		ReportType.add(new DropDownType("Summary", "Summary Report"));
		ReportType.add(new DropDownType("Details", "Details Report"));
		mav.addObject("ReportType", ReportType);
		return mav;
	}

	
	@GetMapping({ "/GetLedgerStatement" })
	public ModelAndView GetLedgerStatement() {
		ModelAndView mav = new ModelAndView("Accounting/Report/View-Ledger-Statement");
		
		List<DropDownType> ReportType = new ArrayList<DropDownType>();
		ReportType.add(new DropDownType("LedgerStmt", "Ledger Statement"));
		mav.addObject("ReportType", ReportType);
		mav.addObject("gllist", glcoderepository.FindTransactionGL());
		return mav;
	}
	
	
	@GetMapping({ "/GetLedgerBalance" })
	public ModelAndView GetLedgerBalance() {
		ModelAndView mav = new ModelAndView("Accounting/Report/View-Ledger-Balance");
		List<DropDownType> ReportType = new ArrayList<DropDownType>();
		ReportType.add(new DropDownType("LedgerBal", "Ledger Balance"));
		mav.addObject("ReportType", ReportType);
		mav.addObject("gllist", glcoderepository.FindPrimeGL());
		return mav;
	}
	@GetMapping({ "/GetFinancialStatement" })
	public ModelAndView GetFinancialStatement() {
		ModelAndView mav = new ModelAndView("Accounting/Report/View-Financial-Statement");
		List<DropDownType> ReportType = new ArrayList<DropDownType>();
		ReportType.add(new DropDownType("TB", "Financial Statement:Trail Balance"));
		ReportType.add(new DropDownType("IN", "Financial Statement:Income Statement"));
		ReportType.add(new DropDownType("EX", "Financial Statement:Expenditure Statement"));
		ReportType.add(new DropDownType("PL", "Financial Statement:Profit & Loss Account"));
		ReportType.add(new DropDownType("BS", "Financial Statement:Balance Sheet"));
		mav.addObject("ReportType", ReportType);
		return mav;
	}
	@GetMapping("/ViewCashBook")
	public ResponseEntity<byte[]> ViewCashBook(HttpServletRequest request ) {		
		Map<String, Object> parameter = new HashMap<String, Object>();	
		try {
			
			JasperPrint empReport =JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:templates/Accounting/ReportTemplate/fs_cashbook.jrxml").getAbsolutePath()) , parameter , dataSource.getConnection());
			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "Cashbook:"+new java.sql.Date(new java.util.Date().getTime())+".pdf");
			//create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	
	
	
	@GetMapping("/ViewFinancialStatement")
	public ResponseEntity<byte[]> ViewFinancialStatement(HttpServletRequest request ) {		
		Map<String, Object> parameter = new HashMap<String, Object>();	
		try {
			JasperPrint empReport;
			String reportTypeString=request.getParameter("ReportType");
			if(reportTypeString.equals("TB")) {
				 empReport =JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:templates/Accounting/ReportTemplate/fs_trial_balance.jrxml").getAbsolutePath()) , parameter , dataSource.getConnection());

			}
			else {
				 empReport =JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:templates/Accounting/ReportTemplate/fs_balance_sheet.jrxml").getAbsolutePath()) , parameter , dataSource.getConnection());

			}
			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", reportTypeString+":"+new java.sql.Date(new java.util.Date().getTime())+".pdf");
			//create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	

	@GetMapping("/PrintVoucher")
	public ResponseEntity<byte[]> PrintVoucher(@RequestParam String tran_branch,@RequestParam Date tran_date,@RequestParam int tran_batch) {		
		Map<String, Object> parameter = new HashMap<String, Object>();	
		try {
			JasperPrint empReport=JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:templates/Accounting/ReportTemplate/fs_voucher.jrxml").getAbsolutePath()) , parameter , dataSource.getConnection());
			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "Voucher"+":"+new java.sql.Date(new java.util.Date().getTime())+".pdf");
			//create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
}
