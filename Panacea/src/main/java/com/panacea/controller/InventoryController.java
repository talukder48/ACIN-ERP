package com.panacea.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.panacea.model.common.DropDownType;
import com.panacea.model.inventory.*;
import com.panacea.model.key.RequisitionListId;
import com.panacea.repository.Accounting.GLCodeRepo;
import com.panacea.repository.inventory.*;


import com.panacea.utils.ProjectUtils;

@Controller
public class InventoryController<RequsitionList> {
	@Autowired
	InventoryProductRepo inventoryProductRepo;
	@Autowired
	GLCodeRepo glcoderepository;
	@Autowired
	PurchaseListRepo PurchaseListRepo;
	@Autowired
	DisburseListRepo DisburseListRepo;
	@GetMapping({ "/ProductList" })
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView("Inventory/Parameter/list-products");
		mav.addObject("productLists", inventoryProductRepo.findAll());
		return mav;
	}

	@GetMapping("/addProductForm")
	public String addProductForm(Model model) {

		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("H", "H-Hardware"));
		typeList.add(new DropDownType("S", "S-Software"));
		model.addAttribute("typeList", typeList);
		InventoryProduct inventoryproduct = new InventoryProduct();
		model.addAttribute("product", inventoryproduct);
		return "Inventory/Parameter/add-product-form";
	}

	@GetMapping("/showUpdateProductForm")
	public ModelAndView showUpdateForm(@RequestParam String ProductCode) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("H", "H-Hardware"));
		typeList.add(new DropDownType("S", "S-Software"));
		
		
		

		ModelAndView mav = new ModelAndView("Inventory/Parameter/add-product-form");
		InventoryProduct Product = inventoryProductRepo.findById(ProductCode).get();
		mav.addObject("product", Product);
		mav.addObject("typeList", typeList);
		return mav;
	}

	@GetMapping("/deleteProducById")
	public String DeleteProduct(@RequestParam String ProductCode) {
		inventoryProductRepo.deleteById(ProductCode);
		return "redirect:/ProductList";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute InventoryProduct product) {
		inventoryProductRepo.save(product);
		return "redirect:/ProductList";
	}

	@GetMapping({ "/PurchaseList" })
	public ModelAndView getAllPurchases() {		
		ModelAndView mav = new ModelAndView("Inventory/Entry/list-purchase");
	    mav.addObject("PurchaseList", PurchaseListRepo.findAll());
		return mav;
	}

	@GetMapping("/addPurchaseForm")
	public ModelAndView addPurchaseForm() {
		ModelAndView mav = new ModelAndView("Inventory/Entry/add-purchase-form");
	
		return mav;
	}

	@PostMapping("/savePurchase")
	public String savePurchase(@ModelAttribute PurchaseList purchase) {
		// eRepo.save(employee);
		return "redirect:/PurchaseList";
	}

	@GetMapping("/showUpdatePurchaseForm")
	public ModelAndView showUpdatePurchaseForm(@RequestParam int ProductCode, @RequestParam String Branch,
			@RequestParam String Date, @RequestParam int PurchaseSL) {
		System.out.println(ProductCode);
		System.out.println(Branch);
		System.out.println(Date);
		System.out.println(PurchaseSL);
		ModelAndView mav = new ModelAndView("Inventory/Entry/add-purchase-form");
		/*
		 * Employee employee = eRepo.findById(employeeId).get();
		 * mav.addObject("employee", employee);
		 */
		//mav.addObject("purchase", newPurchase);
		return mav;
	}

	@GetMapping("/deletePurchase")
	public String DeletePurchase(@RequestParam int ProductCode, @RequestParam String Branch, @RequestParam String Date,
			@RequestParam int PurchaseSL) {
		System.out.println(ProductCode);
		System.out.println(Branch);
		System.out.println(Date);
		System.out.println(PurchaseSL);

		return "redirect:/PurchaseList";
	}

	
	
	
	@GetMapping({ "/DisburseList" })
	public ModelAndView getAllDisburse() {
		
		ModelAndView mav = new ModelAndView("Inventory/Entry/list-disburse");
		mav.addObject("disburseList", DisburseListRepo.findAll());
		return mav;
	}

	@GetMapping("/addDisburseForm")
	public ModelAndView addDisburseForm() {
		ModelAndView mav = new ModelAndView("Inventory/Entry/add-disburse-list");
		Disburse newDisburse = new Disburse("0100", 125, "12-02-2022", 1, "Harfik", "S", 7, 840, "to Customer",
				"item is sold");
		mav.addObject("Disburse", newDisburse);
		return mav;
	}

	@PostMapping("/SaveDisbursement")
	public String SaveDisbursement(@ModelAttribute Disburse disburse) {
		// eRepo.save(employee);
		return "redirect:/DisburseList";
	}

	@GetMapping("/showUpdateDisburseForm")
	public ModelAndView showUpdateDisburseForm(@RequestParam int ProductCode, @RequestParam String Branch,
			@RequestParam String Date, @RequestParam int disbursesl) {
		System.out.println(ProductCode);
		System.out.println(Branch);
		System.out.println(Date);
		System.out.println(disbursesl);
		ModelAndView mav = new ModelAndView("Inventory/Entry/add-disburse-list");
		Disburse newDisburse = new Disburse("0100", 125, "12-02-2022", 1, "Harfik", "S", 7, 840, "to Customer",
				"item is sold");

		/*
		 * Employee employee = eRepo.findById(employeeId).get();
		 * mav.addObject("employee", employee);
		 */

		mav.addObject("Disburse", newDisburse);
		return mav;
	}

	@GetMapping("/deleteDisburse")
	public String deleteDisburse(@RequestParam int ProductCode, @RequestParam String Branch, @RequestParam String Date,
			@RequestParam int disbursesl) {
		System.out.println(ProductCode);
		System.out.println(Branch);
		System.out.println(Date);
		System.out.println(disbursesl);

		return "redirect:/DisburseList";
	}

	@Autowired
	RequisitionListRepo RequisitionListRepo;
	
	@Autowired
	private TransactionTemplate template;
	@Autowired
	RequisitionRepo RequisitionRepo;
	
	
	@GetMapping({ "/RequisitionList" })
	public ModelAndView RequisitionList() {
		ModelAndView mav = new ModelAndView("Inventory/Entry/List-requisition");
		mav.addObject("RequisitionList", RequisitionListRepo.FindAllbyQuery());
		return mav;
	}

	@GetMapping("/addRequisitionForm")
	public String addRequisitionForm(Model model) {
		RequisitionList Requisition = new RequisitionList();
		model.addAttribute("Requisition", Requisition);
		model.addAttribute("ProductList", inventoryProductRepo.findAll());
		return "Inventory/Entry/add-requisition";
	}
@Autowired
InventoryProductRepo InventoryProductRepo;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@PostMapping("/saveRequisition")
	public String saveRequisition(@ModelAttribute RequisitionList RequisitionList, HttpServletRequest request,
			Model model) {
		HttpSession sessionParam = request.getSession();
		String BranchCode = sessionParam.getValue("UserBranch").toString();
		if (BranchCode == null || BranchCode.equals("")) {
			model.addAttribute("error", "User Session Timeout.");
			return "index";
		} else {
			int MaxSL = RequisitionListRepo.FindMaxSl(BranchCode, RequisitionList.getReqDate());
			RequisitionList.setBranchCode(BranchCode);
			RequisitionList.setReqSL(MaxSL);
			RequisitionList.setEntyBy(sessionParam.getValue("UserId").toString());
			RequisitionList.setEntryOn(new java.sql.Date(new java.util.Date().getTime()));
			List<Requisition> ReqList = new ArrayList<Requisition>();

			Long id = template.execute(status -> {
				LinkedList<Map> GridData = new LinkedList<Map>();
				GridData = ProjectUtils.GridtoLinkedList(RequisitionList.getRequisitionGrid());
				Iterator it = GridData.iterator();
				while (it.hasNext()) {
					Map<String, String> DataList = new HashMap<String, String>();
					DataList = (Map<String, String>) it.next();
					System.out.println(DataList);
					if(DataList!=null) {
						ReqList.add(new Requisition(BranchCode, RequisitionList.getReqDate(), MaxSL,DataList.get("ProductCode"), InventoryProductRepo.GetProductName(DataList.get("ProductCode")),Integer.parseInt(DataList.get("NoofItem")),DataList.get("Narration"), DataList.get("Purpose")));
					}
				}
				RequisitionRepo.saveAll(ReqList);
				RequisitionList.setRequisitionGrid("");
				RequisitionList.setRemarks("Requisition Approval Pending");
				RequisitionListRepo.save(RequisitionList);
				
				return 1L;
			});
		}

		return "redirect:/RequisitionList";
	}
	
	
	
	
	@GetMapping("/showUpdateRequisitionForm")
	public ModelAndView showRequisitionDetails(@RequestParam String BranchCode, @RequestParam Date ReqDate,@RequestParam int ReqSL) {		
		ModelAndView mav = new ModelAndView("Inventory/Entry/View-RequisitionDetails");			
		mav.addObject("RequsitionDetailsList", RequisitionRepo.FindByRequisitionDetails(BranchCode, ReqDate, ReqSL));
		return mav;
	}
	
	

	@GetMapping("/RejectByCreator")
	public String RejectByCreator(@RequestParam String BranchCode, @RequestParam Date ReqDate,@RequestParam int ReqSL,HttpServletRequest request) {		
		
		HttpSession sessionParam = request.getSession();
		String UserId=null;
		try {
			 UserId = sessionParam.getValue("UserId").toString();
		}catch(Exception e) {
			
		}
		
		RequisitionList RequisitionList = RequisitionListRepo.findById(new RequisitionListId(BranchCode, ReqDate,ReqSL)).orElse(null);
		RequisitionList.setRemarks("Rejected By Creator");
		RequisitionList.setRejBy(UserId);
		RequisitionList.setRejOn(new java.sql.Date(new java.util.Date().getTime()));
		RequisitionListRepo.save(RequisitionList);
		return "redirect:/RequisitionList";
		
	}
	
	@GetMapping("/BacktoPurchaseList")
	public String BacktoPurchaseList(HttpServletRequest request){		
		return "redirect:/RequisitionList";
	}

	
	@GetMapping({ "/AprrovalRequisitionList" })
	public ModelAndView AprrovalRequisitionList() {
		ModelAndView mav = new ModelAndView("Inventory/Authorization/list-requisition-Approval");
		mav.addObject("RequisitionList", RequisitionListRepo.FindUnApproveList());
		return mav;
	}
	
	
	
	@GetMapping("/showUpdateRequisitionApprovalForm")
	public ModelAndView showUpdateRequisitionApprovalForm(@RequestParam String BranchCode, @RequestParam Date ReqDate,@RequestParam int ReqSL) {		
		ModelAndView mav = new ModelAndView("Inventory/Authorization/View-RequisitionDetails-Approval");			
		mav.addObject("RequsitionDetailsList", RequisitionRepo.FindByRequisitionDetails(BranchCode, ReqDate, ReqSL));
		return mav;
	}
	
	

	@GetMapping("/AuthorizeRequisitionApprovalForm")
	public String AuthorizeRequisitionApprovalForm(@RequestParam String BranchCode, @RequestParam Date ReqDate,@RequestParam int ReqSL,HttpServletRequest request) {	
		HttpSession sessionParam = request.getSession();
		String UserId=null;
		try {
			 UserId = sessionParam.getValue("UserId").toString();
		}catch(Exception e) {
			
		}
		RequisitionList RequisitionList = RequisitionListRepo.findById(new RequisitionListId(BranchCode, ReqDate,ReqSL)).orElse(null);
		RequisitionList.setRemarks("Approved: Pending For Order Generation");
		RequisitionList.setApproveBy(UserId);
		RequisitionList.setApproveOn(new java.sql.Date(new java.util.Date().getTime()));
		RequisitionListRepo.save(RequisitionList);
		return "redirect:/AprrovalRequisitionList";
		
	}
	@GetMapping("/RejectByApprover")
	public String RejectByApprover(@RequestParam String BranchCode, @RequestParam Date ReqDate,@RequestParam int ReqSL,HttpServletRequest request) {		
		
		HttpSession sessionParam = request.getSession();
		String UserId=null;
		try {
			 UserId = sessionParam.getValue("UserId").toString();
		}catch(Exception e) {
			
		}
		
		RequisitionList RequisitionList = RequisitionListRepo.findById(new RequisitionListId(BranchCode, ReqDate,ReqSL)).orElse(null);
		RequisitionList.setRemarks("Rejected By Approver");
		RequisitionList.setRejBy(UserId);
		RequisitionList.setRejOn(new java.sql.Date(new java.util.Date().getTime()));
		RequisitionListRepo.save(RequisitionList);
		return "redirect:/AprrovalRequisitionList";
		
	}
	
	@GetMapping("/BacktoApprovePurchaseList")
	public String BacktoApprovePurchaseList(HttpServletRequest request){		
		return "redirect:/AprrovalRequisitionList";
	}
	
	
	@GetMapping({ "/OrderGenerationList" })
	public ModelAndView OrderGenerationList() {
		ModelAndView mav = new ModelAndView("Inventory/Entry/list-order-generation");
		mav.addObject("RequisitionList", RequisitionListRepo.FindUnGeneratedRequisitionList());
		return mav;
	}
	
	
	
	@GetMapping("/showUpdateOrderApprovalForm")
	public ModelAndView showUpdateOrderApprovalForm(@RequestParam String BranchCode, @RequestParam Date ReqDate,@RequestParam int ReqSL) {		
		ModelAndView mav = new ModelAndView("Inventory/Entry/view-ordergeneration-data");			
		mav.addObject("RequsitionDetailsList", RequisitionRepo.FindByRequisitionDetails(BranchCode, ReqDate, ReqSL));
		return mav;
	}
	
	
	@GetMapping("/PurchaseOrderGenerate")
	public String PurchaseOrderGenerate(@RequestParam String BranchCode, @RequestParam Date ReqDate,@RequestParam int ReqSL,HttpServletRequest request) {		
		
		HttpSession sessionParam = request.getSession();
		String UserId=null;
		try {
			 UserId = sessionParam.getValue("UserId").toString();
		}catch(Exception e) {
			
		}
		
		RequisitionList RequisitionList = RequisitionListRepo.findById(new RequisitionListId(BranchCode, ReqDate,ReqSL)).orElse(null);
		RequisitionList.setRemarks("Purchase Order Generated");
		RequisitionList.setOrdeBy(UserId);
		RequisitionList.setOrderId(RequisitionListRepo.GetOrderID(BranchCode, ReqDate, ReqSL));
		RequisitionList.setOrderOn(new java.sql.Date(new java.util.Date().getTime()));
		RequisitionListRepo.save(RequisitionList);
		return "redirect:/OrderGenerationList";
		
	}
	
	
	
	@GetMapping("/RejectedByGenerator")
	public String RejectedByGenerator(@RequestParam String BranchCode, @RequestParam Date ReqDate,@RequestParam int ReqSL,HttpServletRequest request) {		
		
		HttpSession sessionParam = request.getSession();
		String UserId=null;
		try {
			 UserId = sessionParam.getValue("UserId").toString();
		}catch(Exception e) {
			
		}
		
		RequisitionList RequisitionList = RequisitionListRepo.findById(new RequisitionListId(BranchCode, ReqDate,ReqSL)).orElse(null);
		RequisitionList.setRemarks("Rejected By Generator");
		RequisitionList.setRejBy(UserId);
		RequisitionList.setRejOn(new java.sql.Date(new java.util.Date().getTime()));
		RequisitionListRepo.save(RequisitionList);
		return "redirect:/OrderGenerationList";
		
	}
	
	
	
	@GetMapping("/BacktoOrderList")
	public String BacktoOrderList(HttpServletRequest request){		
		return "redirect:/OrderGenerationList";
	}
	
	
	@GetMapping({ "/ApprovalPurchaseList" })
	public ModelAndView ApprovalPurchaseList() {		
		ModelAndView mav = new ModelAndView("Inventory/Authorization/list-purchase-Approval");
	    mav.addObject("PurchaseList", PurchaseListRepo.findAll());
		return mav;
	}
	
	@GetMapping({ "/ApprovalDisburseList" })
	public ModelAndView ApprovalDisburseList() {
		
		ModelAndView mav = new ModelAndView("Inventory/Authorization/list-disburse-Approval");
		mav.addObject("disburseList", DisburseListRepo.findAll());
		return mav;
	}
	
	
	
	
}
