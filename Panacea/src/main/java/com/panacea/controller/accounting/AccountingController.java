 package com.panacea.controller.accounting;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.panacea.model.acounting.Charges;
import com.panacea.model.acounting.GLCode;
import com.panacea.model.acounting.ProductParam;
import com.panacea.model.acounting.Transaction;
import com.panacea.model.acounting.TransactionList;
import com.panacea.model.common.DropDownType;
import com.panacea.repository.Accounting.AccountsProductRepo;
import com.panacea.repository.Accounting.ChargesRepo;
import com.panacea.repository.Accounting.GLCodeRepo;

@Controller
public class AccountingController {

	@Autowired
	GLCodeRepo glcoderepository;
	@Autowired
	AccountsProductRepo ProductParamRepo;
	@Autowired
	ChargesRepo chargesRepo;
	
	@GetMapping("/Accounting")
	public String Inventory() {
		return "Accounting/Accounting";
	}

	@GetMapping({ "/ProductParameterList" })
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView("Accounting/Parameter/List-ProductParameter");
		mav.addObject("productLists", ProductParamRepo.findAll());
		return mav;
	}

	@GetMapping("/addAccountingProductForm")
	public String addAccountingProductForm(Model model) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("L", "L-Loan"));
		typeList.add(new DropDownType("D", "D-Deposit"));
		List<DropDownType> levelList = new ArrayList<DropDownType>();
		levelList.add(new DropDownType("A", "A-Active"));
		levelList.add(new DropDownType("I", "I-Inactive"));
		model.addAttribute("typeList", typeList);
		model.addAttribute("levelList", levelList);
		ProductParam ProductParam = new ProductParam();
		model.addAttribute("ProductParam", ProductParam);
		return "Accounting/Parameter/add-product";
	}

	@PostMapping("/saveAccountsProduct")
	public String saveAccountsProduct(@ModelAttribute ProductParam ProductParam) {
		ProductParamRepo.save(ProductParam);
		return "redirect:/ProductParameterList";
	}

	@GetMapping("/showUpdateAccountingProductForm")
	public ModelAndView showUpdateAccountingProductForm(@RequestParam String productCode) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("L", "L-Loan"));
		typeList.add(new DropDownType("D", "D-Deposit"));
		List<DropDownType> levelList = new ArrayList<DropDownType>();
		levelList.add(new DropDownType("A", "A-Active"));
		levelList.add(new DropDownType("I", "I-Inactive"));

		ModelAndView mav = new ModelAndView("Accounting/Parameter/add-product");
		ProductParam ProductParam = ProductParamRepo.findById(productCode).get();
		mav.addObject("ProductParam", ProductParam);
		mav.addObject("typeList", typeList);
		mav.addObject("levelList", levelList);
		return mav;
	}

	@GetMapping({ "/LedgerParameterList" })
	public ModelAndView getAllLedgers() {
		ModelAndView mav = new ModelAndView("Accounting/Parameter/List-LedgerParameter");
		mav.addObject("LedgerList", glcoderepository.findAll());
		return mav;
	}

	@GetMapping("/addAccountingGLForm")
	public String addAccountingGLForm(Model model) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("A", "A-Asset"));
		typeList.add(new DropDownType("L", "L-Liablity"));
		typeList.add(new DropDownType("I", "I-Income"));
		typeList.add(new DropDownType("E", "I-Expenditure"));
		List<DropDownType> levelList = new ArrayList<DropDownType>();
		levelList.add(new DropDownType("M", "M-Main GL"));
		levelList.add(new DropDownType("L", "Level GL"));
		levelList.add(new DropDownType("T", "T-Transaction GL"));
		levelList.add(new DropDownType("B", "B-Bank Product"));
		model.addAttribute("typeList", typeList);
		model.addAttribute("levelList", levelList);
		GLCode glcodeModel = new GLCode();
		model.addAttribute("glcodeModel", glcodeModel);
		return "Accounting/Parameter/add-GLLedger";
	}

	@GetMapping("/showUpdateAccountingGLForm")
	public ModelAndView showUpdateForm(@RequestParam String glcode) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("A", "A-Asset"));
		typeList.add(new DropDownType("L", "L-Liablity"));
		typeList.add(new DropDownType("I", "I-Income"));
		typeList.add(new DropDownType("E", "I-Expenditure"));
		List<DropDownType> levelList = new ArrayList<DropDownType>();
		levelList.add(new DropDownType("P", "P-Prime"));
		levelList.add(new DropDownType("M", "M-Mid Level"));
		levelList.add(new DropDownType("L", "I-L-Leaf"));

		ModelAndView mav = new ModelAndView("Accounting/Parameter/add-GLLedger");
		GLCode glcodeModel = glcoderepository.findById(glcode).get();
		mav.addObject("glcodeModel", glcodeModel);
		mav.addObject("typeList", typeList);
		mav.addObject("levelList", levelList);
		return mav;
	}

	@PostMapping("/saveGeneralLedger")
	public String saveProduct(@ModelAttribute GLCode GLCode) {
		glcoderepository.save(GLCode);
		return "redirect:/LedgerParameterList";
	}



	@GetMapping({ "/FeesAndChargesList" })
	public ModelAndView getAllCharges() {
		ModelAndView mav = new ModelAndView("Accounting/Parameter/List-Charges");
		mav.addObject("ChargesList", chargesRepo.findAll());
		return mav;
	}
	@GetMapping("/addAccountingChargesForm")
	public String addAccountingChargesForm(Model model) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("Y", "Y-Yes"));
		typeList.add(new DropDownType("N", "N-No"));
		List<DropDownType> levelList = new ArrayList<DropDownType>();
		levelList.add(new DropDownType("A", "A-Active"));
		levelList.add(new DropDownType("I", "I-Inactive"));
		
		model.addAttribute("typeList", typeList);
		model.addAttribute("levelList", levelList);
		model.addAttribute("gllist", glcoderepository.findAll());
		Charges Charges = new Charges();
		model.addAttribute("Charges", Charges);
		return "Accounting/Parameter/add-charges";
	}
	@GetMapping("/showUpdateAccountingChargesForm")
	public ModelAndView showUpdateAccountingChargesForm(@RequestParam String chgcode) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("Y", "Y-Yes"));
		typeList.add(new DropDownType("N", "N-No"));
		List<DropDownType> levelList = new ArrayList<DropDownType>();
		levelList.add(new DropDownType("A", "A-Active"));
		levelList.add(new DropDownType("I", "I-Inactive"));
		ModelAndView mav = new ModelAndView("Accounting/Parameter/add-charges");
		Charges Charges = chargesRepo.findById(chgcode).get();
		mav.addObject("Charges", Charges);
		mav.addObject("gllist", glcoderepository.findAll());
		mav.addObject("typeList", typeList);
		mav.addObject("levelList", levelList);
		return mav;
	}
	@PostMapping("/saveFeesAndChargesLedger")
	public String saveProduct(@ModelAttribute Charges chgcode) {
		chargesRepo.save(chgcode);
		return "redirect:/FeesAndChargesList";
	}

	

}
