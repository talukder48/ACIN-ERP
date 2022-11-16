package com.panacea.controller.inventory;


import java.util.HashMap;
import java.util.Map;

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

import com.panacea.repository.inventory.InvoiceOrderRepo;
import com.panacea.repository.inventory.*;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class InventoryReportController {
	
	
	@Autowired
	DataSource dataSource;
	@Autowired
	InvoiceOrderRepo InvoiceOrderRepo;
	@Autowired
	RequisitionListRepo RequisitionListRepo;
	@Autowired
	PurchaseListRepo PurchaseListRepo;
	
	
	@GetMapping({ "/ListAuthorizedPurchase" })
	public ModelAndView ListAuthorizedPurchase() {
		ModelAndView mav = new ModelAndView("Inventory/Report/list-print-purchase");
		mav.addObject("PurchaseList", PurchaseListRepo.GetAuthorizedPurchase());
		return mav;
	}
	
	@GetMapping({ "/ListAuthorizedRequisition" })
	public ModelAndView ListAuthorizedRequisition() {

		ModelAndView mav = new ModelAndView("Inventory/Report/list-print-requisition");
		mav.addObject("RequisitionList", RequisitionListRepo.GetAuthorizedRequisition());
		return mav;
	}
	
	@GetMapping({ "/ListInvoiceOrder" })
	public ModelAndView ListInvoiceOrder() {

		ModelAndView mav = new ModelAndView("Inventory/Report/list-print-invoice-order-print");
		mav.addObject("InvoiceOrderList", InvoiceOrderRepo.GetAuthorizedInvoiceOrder());
		return mav;
	}
	@GetMapping("/DownloadInvoiceOrder")
	public ResponseEntity<byte[]> DownloadInvoiceOrder(@RequestParam String OrderId,@RequestParam int InvoiceNo) {		
		Map<String, Object> parameter = new HashMap<String, Object>();	
		parameter.put("p_order_no", OrderId);
		parameter.put("p_invoice_no", InvoiceNo);
		try {
			JasperPrint empReport=JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:templates/Inventory/ReportTemplate/in_invoice_order_details.jrxml").getAbsolutePath()) , parameter , dataSource.getConnection());
			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "InvoiceOrder"+":"+OrderId+"|"+InvoiceNo+".pdf");
			//create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/PrintAuthorizedPurchase")
	public ResponseEntity<byte[]> PrintAuthorizedPurchase(@RequestParam String OrderId,@RequestParam int InvoiceNo) {		
		Map<String, Object> parameter = new HashMap<String, Object>();	
		parameter.put("p_order_no", OrderId);
		parameter.put("p_invoice_no", InvoiceNo);
		try {
			JasperPrint empReport=JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:templates/Inventory/ReportTemplate/in_invoice_order_details.jrxml").getAbsolutePath()) , parameter , dataSource.getConnection());
			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "InvoiceOrder"+":"+OrderId+"|"+InvoiceNo+".pdf");
			//create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	
	
	
}

