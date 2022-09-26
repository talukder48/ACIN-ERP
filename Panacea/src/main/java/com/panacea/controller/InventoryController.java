package com.panacea.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

import com.panacea.model.acounting.TransactionList;
import com.panacea.model.inventory.*;
import com.panacea.repository.Accounting.GLCodeRepo;
import com.panacea.repository.inventory.InventoryProductRepo;
import com.panacea.repository.inventory.RequisitionListRepo;
import com.panacea.repository.inventory.RequisitionRepo;
import com.panacea.utils.ProjectUtils;

@Controller
public class InventoryController {
	@Autowired
	InventoryProductRepo inventoryProductRepo;
	@Autowired
	GLCodeRepo glcoderepository;

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

		ModelAndView mav = new ModelAndView("Inventory/add-product-form");
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
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		purchaseList.add(new Purchase("0100", 123, "14-02-2022", 1, "Pen", 120, 1620));
		purchaseList.add(new Purchase("0100", 123, "14-02-2022", 2, "Pen", 100, 1200));
		purchaseList.add(new Purchase("0100", 124, "13-02-2022", 1, "Note Book", 120, 1620));
		purchaseList.add(new Purchase("0100", 124, "13-02-2022", 2, "Note Book", 120, 1620));
		purchaseList.add(new Purchase("0100", 125, "12-02-2022", 1, "Harfik", 7, 840));
		ModelAndView mav = new ModelAndView("Inventory/Entry/list-purchase");
		mav.addObject("purchaseList", purchaseList);
		return mav;
	}

	@GetMapping("/addPurchaseForm")
	public ModelAndView addPurchaseForm() {
		ModelAndView mav = new ModelAndView("Inventory/Entry/add-purchase-form");
		Purchase newPurchase = new Purchase("0100", 125, "12-02-2022", 1, "Harfik", 7, 840);
		mav.addObject("purchase", newPurchase);
		return mav;
	}

	@PostMapping("/savePurchase")
	public String savePurchase(@ModelAttribute Purchase purchase) {
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
		Purchase newPurchase = new Purchase("0100", 125, "12-02-2022", 1, "Harfik", 7, 840);
		mav.addObject("purchase", newPurchase);
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
		List<Disburse> disburseList = new ArrayList<Disburse>();
		disburseList
				.add(new Disburse("0100", 125, "12-02-2022", 1, "Harfik", "S", 7, 840, "to Customer", "item is sold"));
		ModelAndView mav = new ModelAndView("Inventory/Entry/list-disburse");
		mav.addObject("disburseList", disburseList);
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
	private TransactionTemplate template;
	@Autowired
	RequisitionRepo RequisitionRepo;

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
						ReqList.add(new Requisition(BranchCode, RequisitionList.getReqDate(), MaxSL,DataList.get("ProductCode"), Integer.parseInt(DataList.get("NoofItem")),DataList.get("Narration"), DataList.get("Purpose")));
					}
				}
				RequisitionRepo.saveAll(ReqList);
				RequisitionListRepo.save(RequisitionList);
				
				return 1L;
			});
		}

		return "redirect:/RequisitionList";
	}

}
