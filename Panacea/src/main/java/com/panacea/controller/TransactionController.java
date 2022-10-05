package com.panacea.controller;

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

import com.panacea.model.acounting.Transaction;
import com.panacea.model.acounting.TransactionList;
import com.panacea.repository.Accounting.*;
import com.panacea.utils.ProjectUtils;

@Controller
public class TransactionController {

	@Autowired
	GLCodeRepo glcoderepository;
	@Autowired
	AccountsProductRepo ProductParamRepo;
	@Autowired
	TransactionListRepo TransactionListRepo;
	@Autowired
	TransactionRepo TransactionRepo;

	@Autowired
	private TransactionTemplate template;

	@GetMapping({ "/TransactionAuthorization" })
	public ModelAndView TransactionAuthorization() {
		List<TransactionList> TransactionList = new ArrayList<TransactionList>();

		ModelAndView mav = new ModelAndView("Accounting/Authorization/List-Transactions");
		mav.addObject("TransactionList", TransactionListRepo.findAll());
		return mav;
	}

	@GetMapping("/showUpdateTransactionForm")
	public ModelAndView showUpdateTransactionForm(@RequestParam int tran_branch, @RequestParam String tran_date,
			@RequestParam String tran_batch) {
		System.out.println(tran_branch);
		System.out.println(tran_date);
		System.out.println(tran_batch);
		ModelAndView mav = new ModelAndView("Accounting/Authorization/List-Transactions-Items");
		TransactionList TransactionList = new TransactionList();
	//	mav.addObject("TransactionList", TransactionRepo.findById(new TransactionId(1,)));
		List<Transaction> TransactionEntityList = new ArrayList<Transaction>();
		TransactionEntityList.add(new Transaction());
		mav.addObject("TransactionEntityList", TransactionEntityList);

		return mav;
	}

	@GetMapping("/VoucherEntryForm")
	public ModelAndView VoucherEntryForm(HttpServletRequest request) {
		HttpSession sessionParam = request.getSession();

		ModelAndView mav = new ModelAndView("Accounting/Entry/VoucherEntryForm");
		return mav;
	}

	@GetMapping({ "/GetVoucherList" })
	public ModelAndView GetVoucherList() {
		List<TransactionList> TransactionList = new ArrayList<TransactionList>();
		ModelAndView mav = new ModelAndView("Accounting/Entry/List-Voucher-Entry");
		mav.addObject("TransactionList", TransactionListRepo.findAll());
		return mav;
	}
	
	
	@GetMapping({ "/GetAUthorizedVoucherList" })
	public ModelAndView GetAUthorizedVoucherList() {
		List<TransactionList> TransactionList = new ArrayList<TransactionList>();
		ModelAndView mav = new ModelAndView("Accounting/Entry/List-Authorized-voucher-List");
		mav.addObject("TransactionList", TransactionListRepo.findAll());
		return mav;
	}
	

	@GetMapping("/VoucherEntryFormNew")
	public ModelAndView VoucherEntryFormNew(Model model, HttpServletRequest request) {
		TransactionList Transaction = new TransactionList();
		model.addAttribute("Transaction", Transaction);
		model.addAttribute("gllist", glcoderepository.FindTransactionGL());
		ModelAndView mav = new ModelAndView("Accounting/Entry/add-voucher");
		return mav;
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	@PostMapping("/saveTransaction")
	public String saveTransaction(@ModelAttribute TransactionList TransactionList, HttpServletRequest request,
			Model model) {

		try {
			HttpSession sessionParam = request.getSession();
			String UserId = sessionParam.getValue("UserId").toString();
			String UserBranch = sessionParam.getValue("UserBranch").toString();

			Long id = template.execute(status -> {
				List<Transaction> TransactionData = new ArrayList<Transaction>();
				int BatchNumber = TransactionListRepo.FindBatchNumber(UserBranch,TransactionList.getTran_date());
				TransactionList.setTran_batch(BatchNumber);
				TransactionList.setTran_branch(UserBranch);
				TransactionList.setEntyBy(UserId);
				TransactionList.setEntyOn(new java.sql.Date(new java.util.Date().getTime()));
				TransactionList.setTran_remarks("Un-Authorized");
				LinkedList<Map> GridData = new LinkedList<Map>();
				GridData = ProjectUtils.GridtoLinkedList(TransactionList.getDataGrid());

				int BatchSL = 1;
				Iterator it = GridData.iterator();

				while (it.hasNext()) {
					Map<String, String> DataList = new HashMap<String, String>();
					DataList = (Map<String, String>) it.next();
					System.out.println(DataList);
					if (DataList != null) {
						TransactionData.add(new Transaction(1, BatchSL, UserBranch, TransactionList.getTran_date(), BatchNumber,DataList.get("transactionHead"), Double.parseDouble(DataList.get("DrAmount")),Double.parseDouble(DataList.get("CrAmount")), DataList.get("Narration"),DataList.get("CHQ_ADV_NO"), DataList.get("IssueDate")));
					}
					BatchSL++;
				}
				TransactionList.setDataGrid("");
				TransactionListRepo.save(TransactionList);
				TransactionRepo.saveAll(TransactionData);
				return 1L;
			});

		} catch (Exception e) {
			return "index";
		}

		return "redirect:/GetVoucherList";
	}

	@PostMapping("/AuthorizeSingleTransaction")
	public String AuthorizeTransaction(@ModelAttribute TransactionList transactionList) {

		System.out.println("TransactionAuthorization");
		// eRepo.save(employee);
		return "redirect:/TransactionAuthorization";
	}
}
