package com.panacea.controller;

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

import com.panacea.model.acounting.Transaction;
import com.panacea.model.acounting.TransactionList;
import com.panacea.repository.Accounting.AccountsProductRepo;
import com.panacea.repository.Accounting.GLCodeRepo;
@Controller
public class TransactionController {
	
	@Autowired
	GLCodeRepo glcoderepository;
	@Autowired
	AccountsProductRepo ProductParamRepo;
	
	
	@GetMapping({ "/TransactionAuthorization" })
	public ModelAndView getAllTransactions() {
		List<TransactionList> TransactionList = new ArrayList<TransactionList>();

		TransactionList.add(new TransactionList("16063", "10-11-2021", 2, "Expenditure"));
		TransactionList.add(new TransactionList("16063", "10-11-2021", 3, "Fund Transfer"));
		TransactionList.add(new TransactionList("16063", "10-11-2021", 4, "Income"));
		TransactionList.add(new TransactionList("16063", "10-11-2021", 8, "Incentive"));
		ModelAndView mav = new ModelAndView("Accounting/Authorization/List-Transactions");
		mav.addObject("TransactionList", TransactionList);
		return mav;
	}

	@GetMapping("/showUpdateTransactionForm")
	public ModelAndView showUpdateTransactionForm(@RequestParam int tran_branch, @RequestParam String tran_date,
			@RequestParam String tran_batch) {
		System.out.println(tran_branch);
		System.out.println(tran_date);
		System.out.println(tran_batch);
		ModelAndView mav = new ModelAndView("Accounting/Authorization/List-Transactions-Items");
		TransactionList TransactionList = new TransactionList( "16063", "10-11-2021", 2, "Fund Transfer");
		mav.addObject("TransactionList", TransactionList);
		List<Transaction> TransactionEntityList = new ArrayList<Transaction>();
		TransactionEntityList.add(new Transaction(1, 1, "16063", "20-01-2022", 2, "101101", 5680, 0, "SND-Debit", "", ""));
		TransactionEntityList.add(new Transaction(1, 2, "16063", "20-01-2022", 2, "101101", 0, 5680,"SND-Debit", "567489", "20-01-2022"));
		mav.addObject("TransactionEntityList", TransactionEntityList);

		return mav;
	}

	@GetMapping("/VoucherEntryForm")
	public ModelAndView VoucherEntryForm(HttpServletRequest request) {
		HttpSession sessionParam = request.getSession();
		
		ModelAndView mav = new ModelAndView("Accounting/Entry/VoucherEntryForm");
		return mav;
	}
	
	
	
	@GetMapping("/VoucherEntryFormNew")
	public ModelAndView addVoucher( Model model,HttpServletRequest request) {
		TransactionList Transaction = new TransactionList();
		model.addAttribute("Transaction", Transaction);
		model.addAttribute("gllist", glcoderepository.findAll());
		ModelAndView mav = new ModelAndView("Accounting/Entry/add-voucher");
		return mav;
	}
	

	@SuppressWarnings("deprecation")
	@PostMapping("/saveTransaction")
	public String saveTransaction(@ModelAttribute TransactionList TransactionList,HttpServletRequest request,Model model) {
		HttpSession sessionParam = request.getSession();
		System.out.println(sessionParam.getValue("UserId"));
		System.out.println(sessionParam.getValue("UserId"));
		System.out.println(sessionParam.getValue("UserBranch"));
		System.out.println(TransactionList.getTran_date());
		System.out.println(TransactionList.getDataGrid());
		System.out.println(TransactionList.getDataGrid());
		return "redirect:/VoucherEntryFormNew";
	}
	
	

	@PostMapping("/AuthorizeSingleTransaction")
	public String AuthorizeTransaction(@ModelAttribute TransactionList transactionList) {

		System.out.println("TransactionAuthorization");
		// eRepo.save(employee);
		return "redirect:/TransactionAuthorization";
	}
}
