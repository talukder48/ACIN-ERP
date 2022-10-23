package com.panacea.controller.inventory;


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
import org.springframework.web.servlet.ModelAndView;

import com.panacea.repository.inventory.InvoiceOrderRepo;
import com.panacea.repository.inventory.RequisitionListRepo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@Controller
public class InventoryReportController {
	
	
	@Autowired
	DataSource dataSource;
	@Autowired
	InvoiceOrderRepo InvoiceOrderRepo;
	@Autowired
	RequisitionListRepo RequisitionListRepo;
	
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
	
}

