package com.panacea.controller.hrm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
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

import com.panacea.model.common.DropDownType;
import com.panacea.model.hrm.AllawanceData;
import com.panacea.model.hrm.DeductionData;
import com.panacea.model.hrm.Employee;
import com.panacea.model.hrm.SalaryTransaction;
import com.panacea.model.key.SalaryTransactionId;
import com.panacea.repository.hrm.*;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	DesignationRepo DesignationRepo;
	@Autowired
	BloodGroupRepo BloodGroupRepo;
	@Autowired
	AllawanceDataRepo AllawanceDataRepo;
	@Autowired
	DeductionDataRepo DeductionDataRepo;
	@Autowired
	SalaryTransactionRepo SalaryTransactionRepo;

	@GetMapping({ "/EmployeeList" })
	public ModelAndView getEmployeeList() {
		ModelAndView mav = new ModelAndView("HRM/Entry/List-Employee");
		mav.addObject("EmployeeList", employeeRepo.findAll());
		return mav;
	}

	@GetMapping({ "/AddEmployee" })
	public String AddEmployee(Model model) {
		List<DropDownType> GenderList = new ArrayList<DropDownType>();
		GenderList.add(new DropDownType("M", "M-Male"));
		GenderList.add(new DropDownType("F", "F-Female"));
		GenderList.add(new DropDownType("O", "O-Others"));
		Employee Employee = new Employee();
		model.addAttribute("GenderList", GenderList);
		model.addAttribute("BloodgroupList", BloodGroupRepo.findAll());
		model.addAttribute("Employee", Employee);
		model.addAttribute("DesignationList", DesignationRepo.findAll());
		return "HRM/Entry/add-Employee";
	}

	@GetMapping("/showUpdateEmployeeForm")
	public ModelAndView showUpdateAccountingProductForm(@RequestParam String EmployeeId) {
		List<DropDownType> GenderList = new ArrayList<DropDownType>();
		GenderList.add(new DropDownType("M", "M-Male"));
		GenderList.add(new DropDownType("F", "F-Female"));
		GenderList.add(new DropDownType("O", "O-Others"));
		ModelAndView model = new ModelAndView("HRM/Entry/add-Employee");
		Employee Employee = employeeRepo.findById(EmployeeId).get();
		model.addObject("GenderList", GenderList);
		model.addObject("BloodgroupList", BloodGroupRepo.findAll());
		model.addObject("Employee", Employee);
		model.addObject("DesignationList", DesignationRepo.findAll());
		return model;
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee Employee) {
		employeeRepo.save(Employee);
		return "redirect:/EmployeeList";
	}

	@GetMapping("/showUpdateAllawance")
	public ModelAndView showUpdateAllawance(@RequestParam String EmployeeId) {
		AllawanceData allawanceData;
		if (AllawanceDataRepo.existsById(EmployeeId)) {
			allawanceData = AllawanceDataRepo.findById(EmployeeId).get();
		} else {
			allawanceData = new AllawanceData();
			allawanceData.setEmployeeId(EmployeeId);
		}
		ModelAndView model = new ModelAndView("HRM/Entry/add-Allawance");
		model.addObject("EmployeeAllwance", allawanceData);
		return model;
	}

	@PostMapping("/saveEmployeeAllawance")
	public String saveEmployeeAllawance(@ModelAttribute AllawanceData allawanceData) {
		AllawanceDataRepo.save(allawanceData);
		return "redirect:/EmployeeList";
	}

	@GetMapping("/showUpdateDeduction")
	public ModelAndView showUpdateDeduction(@RequestParam String EmployeeId) {
		DeductionData deductionData;
		if (DeductionDataRepo.existsById(EmployeeId)) {
			deductionData = DeductionDataRepo.findById(EmployeeId).get();
		} else {
			deductionData = new DeductionData();
			deductionData.setEmployeeId(EmployeeId);
		}
		ModelAndView model = new ModelAndView("HRM/Entry/add-Deduction");
		model.addObject("EmployeeDeduction", deductionData);
		return model;
	}

	@PostMapping("/saveEmployeeDeduction")
	public String saveEmployeeDeduction(@ModelAttribute DeductionData deductionData) {
		DeductionDataRepo.save(deductionData);
		return "redirect:/EmployeeList";
	}

	@GetMapping({ "/EmployeeEducation" })
	public ModelAndView EmployeeEducation() {
		ModelAndView mav = new ModelAndView("HRM/Entry/List-Education");
		mav.addObject("EmployeeList", employeeRepo.findAll());
		return mav;
	}

	@GetMapping({ "/EmployeeProfessionalDegree" })
	public ModelAndView EmployeeProfessionalDegree() {
		ModelAndView mav = new ModelAndView("HRM/Entry/List-Professional");
		mav.addObject("EmployeeList", employeeRepo.findAll());
		return mav;
	}

	@GetMapping({ "/GetSalaryProcess" })
	public ModelAndView GetSalaryProcess() {
		
		ModelAndView mav = new ModelAndView("HRM/Process/process-salary");
		mav.addObject("message", "");
		return mav;
	}

	@PostMapping("/RunSalaryProcess")
	public String ViewCashBook(HttpServletRequest request,Model model) {
		HttpSession sessionParam = request.getSession();
		String UserBranch = sessionParam.getValue("UserBranch").toString();
		Date SalaryDate = Date.valueOf(request.getParameter("SalaryDate"));
		int Year =SalaryTransactionRepo.GetSalaryYear(SalaryDate);
		int Month = SalaryDate.getMonth();
		List<Employee> employees = employeeRepo.findAll();
		Iterator<Employee> it = employees.iterator();
		double GrossPay;
		double TotalDeduction;
		double NetPay;
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			if(SalaryTransactionRepo.existsById(new SalaryTransactionId(UserBranch, Year, Month, employee.getEmployeeId())))				
			{
				SalaryTransactionRepo.deleteById(new SalaryTransactionId(UserBranch, Year, Month, employee.getEmployeeId()));

			}
			AllawanceData allawanceData = AllawanceDataRepo.getById(employee.getEmployeeId());
			DeductionData deductionData = DeductionDataRepo.getById(employee.getEmployeeId());

			BigDecimal providentFunDecimal = new BigDecimal(
					(allawanceData.getBasicSalary() * deductionData.getProvidentFundPct() / 100)
							+ deductionData.getProvidentFund()).setScale(2, RoundingMode.HALF_DOWN);

			GrossPay = allawanceData.getBasicSalary() + allawanceData.getConveyanceAllaw()
					+ allawanceData.getHouseRent() + allawanceData.getMedicalAllaw() + allawanceData.getOthersAllaw()
					+ allawanceData.getSpecialAllaw() + allawanceData.getVariablePay();
			TotalDeduction = deductionData.getIncomeTax() + deductionData.getLoanRepayment()
					+ deductionData.getOtherDed() + deductionData.getRevenue() + providentFunDecimal.doubleValue();

			NetPay = GrossPay - TotalDeduction;

			SalaryTransaction salaryTransaction = new SalaryTransaction(UserBranch, Year, Month,
					employee.getEmployeeId(), employee.getDesignation(), employee.getBankAcc(),
					allawanceData.getBasicSalary(), allawanceData.getHouseRent(), allawanceData.getConveyanceAllaw(),
					allawanceData.getVariablePay(), allawanceData.getMedicalAllaw(), allawanceData.getSpecialAllaw(),
					allawanceData.getOthersAllaw(), providentFunDecimal.doubleValue(),
					deductionData.getProvidentFundPct(), deductionData.getIncomeTax(), deductionData.getLoanRepayment(),
					deductionData.getRevenue(), deductionData.getOtherDed(), GrossPay, TotalDeduction, NetPay);
			SalaryTransactionRepo.save(salaryTransaction);
		}
		model.addAttribute("message", "Salary Process sucessfully Done for "+ SalaryDate);

		return "HRM/Process/process-salary";
	}

}
