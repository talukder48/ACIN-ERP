package com.panacea.controller.accounting;

import java.sql.Date;
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
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.panacea.model.acounting.GLBalance;
import com.panacea.model.acounting.Transaction;
import com.panacea.model.acounting.TransactionList;
import com.panacea.model.inventory.PurchaseDetails;
import com.panacea.model.key.GLBalanceId;
import com.panacea.model.key.TransactionListId;
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
	GLCodeRepo GLCodeRepo;
	@Autowired
	private TransactionTemplate template;
	@Autowired
	GLBalanceRepo GLBalanceRepo;
	
	@GetMapping({ "/OnlyAuthorizableList" })
	public ModelAndView TransactionAuthorization() {
		ModelAndView mav = new ModelAndView("Accounting/Authorization/List-Transactions");
		mav.addObject("TransactionList", TransactionListRepo.GetUnAuthorizedTransaction());
		return mav;
	}
	
	
	@GetMapping("/showUnauthorizedVoucherDetailsForm")
	public ModelAndView showUnauthorizedVoucherDetailsForm(@RequestParam String tran_branch, @RequestParam Date tran_date,@RequestParam int tran_batch) {
		TransactionList TransactionList=new TransactionList();
		TransactionList.setTran_branch(tran_branch);
		TransactionList.setTran_date(tran_date);
		TransactionList.setTran_batch(tran_batch);		
		ModelAndView mav = new ModelAndView("Accounting/Authorization/List-Transactions-Items");				
		mav.addObject("TransactionList", TransactionList);
		mav.addObject("TransactionEntityList", TransactionRepo.FindVoucherDetails(tran_branch,tran_date,tran_batch));
		return mav;
	}
	
	@PostMapping("/AuthorizeVoucher")
	public String AuthorizeVoucher(@ModelAttribute TransactionList transactionList) {
		System.out.println(transactionList.getTran_branch());
		
		Long id = template.execute(status -> {
		
		TransactionList TransactionList=TransactionListRepo.findById(new TransactionListId(transactionList.getTran_branch(), transactionList.getTran_date(), transactionList.getTran_batch())).get();
		List<Transaction> transactionDetailsList=TransactionRepo.FindVoucherDetails(transactionList.getTran_branch(),transactionList.getTran_date(),transactionList.getTran_batch());
		Iterator it = transactionDetailsList.iterator();
		while (it.hasNext()) {
			Transaction Transaction = (Transaction) it.next();
			String glcodeString=Transaction.getGlcode();
			while (glcodeString!=null && !glcodeString.equals("")) {
				GLBalance GLBalance=GLBalanceRepo.findById(new GLBalanceId(Transaction.getTran_branch(),glcodeString)).get();
				GLBalance.setGlBalance(GLBalance.getGlBalance()-Transaction.getDebit_amt()+Transaction.getCredit_amt());
				GLBalanceRepo.save(GLBalance);
				glcodeString=GLCodeRepo.GetPrimeGL(glcodeString);
			}			
		}
		TransactionList.setAuthBy("Auth");
		TransactionList.setAuthOn(new java.sql.Date(new java.util.Date().getTime()));
		TransactionListRepo.save(TransactionList);
		return 1L;
		});
		return "redirect:/OnlyAuthorizableList";
	}
	
	

	@GetMapping({ "/GetVoucherList" })
	public ModelAndView GetVoucherList() {
		ModelAndView mav = new ModelAndView("Accounting/Entry/List-Voucher-Entry");
		mav.addObject("TransactionList", TransactionListRepo.findAll());
		return mav;
	}
	@GetMapping("/showUpdateTransactionForm")
	public ModelAndView showUpdateTransactionForm(@RequestParam String tran_branch, @RequestParam Date tran_date,@RequestParam int tran_batch) {
		TransactionList TransactionList=new TransactionList();
		TransactionList.setTran_branch(tran_branch);
		TransactionList.setTran_date(tran_date);
		TransactionList.setTran_batch(tran_batch);		
		ModelAndView mav = new ModelAndView("Accounting/Entry/view-voucher-details");				
		mav.addObject("TransactionList", TransactionList);
		mav.addObject("TransactionEntityList", TransactionRepo.FindVoucherDetails(tran_branch,tran_date,tran_batch));
		return mav;
	}
	@PostMapping("/AuthorizeSingleTransaction")
	public String AuthorizeTransaction(@ModelAttribute TransactionList transactionList) {
		System.out.println(transactionList.getTran_branch());
		System.out.println("TransactionAuthorization");
		//to do lots of things
		
		
		
		
		return "redirect:/GetVoucherList";
	}
	
	
	
	@GetMapping({ "/GetAUthorizedVoucherList" })
	public ModelAndView GetAUthorizedVoucherList() {
		ModelAndView mav = new ModelAndView("Accounting/Entry/List-Authorized-voucher-List");
		mav.addObject("TransactionList", TransactionListRepo.findAll());
		return mav;
	}
	@GetMapping("/showUpdateAuthVoucherDetails")
	public ModelAndView showUpdateAuthVoucherDetails(@RequestParam String tran_branch, @RequestParam Date tran_date,@RequestParam int tran_batch) {
		TransactionList TransactionList=new TransactionList();
		TransactionList.setTran_branch(tran_branch);
		TransactionList.setTran_date(tran_date);
		TransactionList.setTran_batch(tran_batch);		
		ModelAndView mav = new ModelAndView("Accounting/Entry/view-Authorized-voucher-details");				
		mav.addObject("TransactionList", TransactionList);
		mav.addObject("TransactionEntityList", TransactionRepo.FindVoucherDetails(tran_branch,tran_date,tran_batch));
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
	public String saveTransaction(@ModelAttribute TransactionList TransactionList, Errors errors,HttpServletRequest request,Model model,RedirectAttributes redirectAttributes) {
		if (null != errors && errors.getErrorCount() > 0) {
            return "redirect:/VoucherEntryFormNew";
        }{
        
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
    						TransactionData.add(new Transaction(1, 
    								BatchSL, 
    								UserBranch, 
    								TransactionList.getTran_date(), 
    								BatchNumber,
    								ProjectUtils.GetCode(DataList.get("transactionHead")),
    								glcoderepository.TransactionHead(ProjectUtils.GetCode(DataList.get("transactionHead"))),
    								Double.parseDouble(DataList.get("DrAmount")),
    								Double.parseDouble(DataList.get("CrAmount")),
    								DataList.get("Narration"),
    								DataList.get("CHQ_ADV_NO"),
    								DataList.get("IssueDate")));
    					
    					BatchSL++;
    				}
    				TransactionList.setDataGrid("");
    				TransactionListRepo.save(TransactionList);
    				TransactionRepo.saveAll(TransactionData);
    				return 1L;
    			});

    		} catch (Exception e) {
    			return "redirect:/";
    		}
            redirectAttributes.addFlashAttribute("message", "Voucher Sucessfully Done ");

    		return "redirect:/GetVoucherList";
        }
		
		
	}

	
}
