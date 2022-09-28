package com.panacea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.panacea.model.hrm.ArmyEmployee;
import com.panacea.model.hrm.LeaveRegister;
import com.panacea.model.inventory.DropDownType;
import com.panacea.model.login.UserMaster;
import com.panacea.repository.hrm.ArmyCompayRepo;
import com.panacea.repository.hrm.ArmyEmployeeRepo;
import com.panacea.repository.hrm.ArmyRankRepo;
import com.panacea.repository.hrm.ArmyTradeRepo;
import com.panacea.repository.hrm.EmployeeRepo;
import com.panacea.repository.leave.LeaveDescriptionRepo;
import com.panacea.repository.leave.LeaveRegisterRepo;
import com.panacea.repository.leave.UserMaserRepo;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@Controller
public class LeaveController {

	@GetMapping("/LeaveEndUser")
	public String LeaveEndUser() {
		return "HRM/LeaveEndUser";
	}

	@GetMapping("/LeaveDataEntry")
	public String LeaveDataEntry() {
		return "HRM/LeaveDataEntry";
	}

	@Autowired
	LeaveRegisterRepo leaveregisterRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	ArmyCompayRepo ArmyCompayRepo;
	@Autowired
	ArmyRankRepo ArmyRankRepo;
	@Autowired
	ArmyTradeRepo ArmyTradeRepo;

	

	@Autowired
	ArmyEmployeeRepo ArmyEmployeeRepo;

	@GetMapping({ "/EmployeeList" })
	public ModelAndView getEmployeeList() {
		ModelAndView mav = new ModelAndView("HRM/List-Employee");
		mav.addObject("EmployeeList", ArmyEmployeeRepo.findAll());
		return mav;
	}

	@GetMapping("/AddNewEmployeeData")
	public String addNewEmployee(Model model) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("O", "O-Officer"));
		typeList.add(new DropDownType("S", "S-Staff"));
		List<DropDownType> LivingList = new ArrayList<DropDownType>();
		LivingList.add(new DropDownType("L", "L-Line member"));
		LivingList.add(new DropDownType("I", "I-In living family member"));
		LivingList.add(new DropDownType("O", "O-Out living family member"));
		List<DropDownType> GenderList = new ArrayList<DropDownType>();
		GenderList.add(new DropDownType("M", "M-Male"));
		GenderList.add(new DropDownType("F", "F-Female"));
		GenderList.add(new DropDownType("O", "O-Others"));
		List<DropDownType> BloodgroupList = new ArrayList<DropDownType>();
		BloodgroupList.add(new DropDownType("AP", "A+"));
		BloodgroupList.add(new DropDownType("AN", "A-"));
		BloodgroupList.add(new DropDownType("BP", "B+"));
		BloodgroupList.add(new DropDownType("BN", "B-"));
		BloodgroupList.add(new DropDownType("ABP", "AB+"));
		BloodgroupList.add(new DropDownType("ABN", "AB-"));
		BloodgroupList.add(new DropDownType("OP", "O+"));
		BloodgroupList.add(new DropDownType("ON", "O-"));

		ArmyEmployee ArmyEmployee = new ArmyEmployee();
		model.addAttribute("GenderList", GenderList);
		model.addAttribute("BloodgroupList", BloodgroupList);
		model.addAttribute("LivingList", LivingList);
		model.addAttribute("typeList", typeList);
		model.addAttribute("Employee", ArmyEmployee);
		model.addAttribute("RankList", ArmyRankRepo.findAll());
		model.addAttribute("TradeList", ArmyTradeRepo.findAll());
		model.addAttribute("CompanyList", ArmyCompayRepo.findAll());
		return "HRM/add-Employee";
	}

	@PostMapping("/saveEmployee")
	public String saveAccountsProduct(@ModelAttribute ArmyEmployee ArmyEmployee) {
		ArmyEmployeeRepo.save(ArmyEmployee);
		return "redirect:/EmployeeList";
	}

	@GetMapping("/showUpdateEmployeeForm")
	public ModelAndView showUpdateAccountingProductForm(@RequestParam String EmployeeId) {
		List<DropDownType> typeList = new ArrayList<DropDownType>();
		typeList.add(new DropDownType("O", "O-Officer"));
		typeList.add(new DropDownType("S", "S-Staff"));
		List<DropDownType> LivingList = new ArrayList<DropDownType>();
		LivingList.add(new DropDownType("L", "L-Line member"));
		LivingList.add(new DropDownType("I", "I-In living family member"));
		LivingList.add(new DropDownType("O", "O-Out living family member"));
		List<DropDownType> GenderList = new ArrayList<DropDownType>();
		GenderList.add(new DropDownType("M", "M-Male"));
		GenderList.add(new DropDownType("F", "F-Female"));
		GenderList.add(new DropDownType("O", "O-Others"));
		List<DropDownType> BloodgroupList = new ArrayList<DropDownType>();
		BloodgroupList.add(new DropDownType("AP", "A+"));
		BloodgroupList.add(new DropDownType("AN", "A-"));
		BloodgroupList.add(new DropDownType("BP", "B+"));
		BloodgroupList.add(new DropDownType("BN", "B-"));
		BloodgroupList.add(new DropDownType("ABP", "AB+"));
		BloodgroupList.add(new DropDownType("ABN", "AB-"));
		BloodgroupList.add(new DropDownType("OP", "O+"));
		BloodgroupList.add(new DropDownType("ON", "O-"));

		ModelAndView model = new ModelAndView("HRM/add-Employee");
		ArmyEmployee ArmyEmployee = ArmyEmployeeRepo.findById(EmployeeId).get();
		model.addObject("GenderList", GenderList);
		model.addObject("BloodgroupList", BloodgroupList);
		model.addObject("Employee", ArmyEmployee);
		model.addObject("typeList", typeList);
		model.addObject("LivingList", LivingList);
		model.addObject("RankList", ArmyRankRepo.findAll());
		model.addObject("TradeList", ArmyTradeRepo.findAll());
		model.addObject("CompanyList", ArmyCompayRepo.findAll());
		return model;
	}

	@GetMapping({ "/LeaveDashBoard" })
	public ModelAndView LeaveDashBoard() {
		ModelAndView mav = new ModelAndView("HRM/LeaveDashBoard");
		try {
			
			
			mav.addObject("LeaveList", leaveregisterRepo.FindToBeRecomendedList());
			
			
			
		}catch(Exception e) {
			
		}
		return mav;

	}

	@GetMapping({ "/LeaveAuthorization" })
	public ModelAndView LeaveAuthorization() {
		ModelAndView mav = new ModelAndView("HRM/LeaveAuthorization");
		mav.addObject("LeaveList", leaveregisterRepo.FindToBeApprovalList());
		return mav;

	}

	@GetMapping({ "/LeaveList" })
	public ModelAndView getLeaveList(HttpServletRequest request) {
		HttpSession sessionParam = request.getSession();
		String EmployeeId=null;
		try {
			EmployeeId=sessionParam.getValue("EmployeeId").toString();
		}catch(Exception e) {
			EmployeeId="NF";
		}
		
		ModelAndView mav = new ModelAndView("HRM/List-Leave");
		mav.addObject("LeaveList", leaveregisterRepo.FindAppliedList(EmployeeId));
		return mav;
	}

	@Autowired
	LeaveDescriptionRepo LeaveDescriptionRepo;

	@GetMapping("/AddEmployeeLeaveData")
	public String AddEmployeeLeaveData(Model model) {
		LeaveRegister LeaveRegister = new LeaveRegister();
		model.addAttribute("LeaveRegister", LeaveRegister);
		model.addAttribute("EmployeeList", ArmyEmployeeRepo.findAll());
		model.addAttribute("Leavelist", LeaveDescriptionRepo.findAll());
		return "HRM/add-leave";
	}

	@PostMapping("/saveLeaveData")
	public String saveLeaveData(@ModelAttribute LeaveRegister LeaveRegister,HttpServletRequest request) {
		
		if (LeaveRegister.getLeaveID() == null) {
			ArmyEmployee ArmyEmployee = ArmyEmployeeRepo.findById(LeaveRegister.getEmployeeId()).get();
			LeaveRegister.setEmployeeName(ArmyEmployee.getEmployeeName());
			LeaveRegister.setLeaveStatus("Recomendation Pending");
			leaveregisterRepo.save(LeaveRegister);
		} else {

			if (leaveregisterRepo.existsById(LeaveRegister.getLeaveID())) {

				LeaveRegister leaveregister = leaveregisterRepo.findById(LeaveRegister.getLeaveID()).orElseThrow();
				ArmyEmployee ArmyEmployee = ArmyEmployeeRepo.findById(LeaveRegister.getEmployeeId()).get();
				leaveregister.setEmployeeName(ArmyEmployee.getEmployeeName());
				leaveregister.setEmployeeId(LeaveRegister.getEmployeeId());
				leaveregister.setApplyDate(LeaveRegister.getApplyDate());
				leaveregister.setStartDate(LeaveRegister.getStartDate());
				leaveregister.setEndDate(LeaveRegister.getEndDate());
				leaveregister.setLeaveReason(LeaveRegister.getLeaveReason());
				leaveregister.setLeaveType(LeaveRegister.getLeaveType());
				leaveregister.setLeaveStatus(LeaveRegister.getLeaveStatus());
				leaveregisterRepo.save(leaveregister);
			} else {
				ArmyEmployee ArmyEmployee = ArmyEmployeeRepo.findById(LeaveRegister.getEmployeeId()).get();
				LeaveRegister.setEmployeeName(ArmyEmployee.getEmployeeName());
				leaveregisterRepo.save(LeaveRegister);
			}

		}

		return "redirect:/LeaveList";
	}
	
	@PostMapping("/saveLeaveRecomendationData")
	public String saveLeaveRecomendationData(@ModelAttribute LeaveRegister LeaveRegister,HttpServletRequest request) {
		HttpSession sessionParam = request.getSession();
		if (LeaveRegister.getLeaveID() == null) {
			return "redirect:/LeaveDashBoard";
		} else {

			if (leaveregisterRepo.existsById(LeaveRegister.getLeaveID())) {
				LeaveRegister leaveregister = leaveregisterRepo.findById(LeaveRegister.getLeaveID()).orElseThrow();
				ArmyEmployee ArmyEmployee = ArmyEmployeeRepo.findById(LeaveRegister.getEmployeeId()).get();
				leaveregister.setEmployeeName(ArmyEmployee.getEmployeeName());
				leaveregister.setEmployeeId(LeaveRegister.getEmployeeId());
				leaveregister.setApplyDate(LeaveRegister.getApplyDate());
				leaveregister.setStartDate(LeaveRegister.getStartDate());
				leaveregister.setEndDate(LeaveRegister.getEndDate());
				leaveregister.setLeaveReason(LeaveRegister.getLeaveReason());
				leaveregister.setLeaveType(LeaveRegister.getLeaveType());
				leaveregister.setRecomendRemarks(LeaveRegister.getRecomendRemarks());
				leaveregister.setRecomendBy(sessionParam.getValue("UserId").toString());
				leaveregister.setLeaveStatus("Approval Pending");
				leaveregisterRepo.save(leaveregister);
			} 
			return "redirect:/LeaveDashBoard";
		}
	}
	
	@PostMapping("/saveLeaveApprovalData")
	public String saveLeaveApprovalData(@ModelAttribute LeaveRegister LeaveRegister,HttpServletRequest request) {
		HttpSession sessionParam = request.getSession();
		if (LeaveRegister.getLeaveID() == null) {
			return "redirect:/LeaveAuthorization";
		} else {

			if (leaveregisterRepo.existsById(LeaveRegister.getLeaveID())) {
				LeaveRegister leaveregister = leaveregisterRepo.findById(LeaveRegister.getLeaveID()).orElseThrow();
				ArmyEmployee ArmyEmployee = ArmyEmployeeRepo.findById(LeaveRegister.getEmployeeId()).get();
				leaveregister.setEmployeeName(ArmyEmployee.getEmployeeName());
				leaveregister.setEmployeeId(LeaveRegister.getEmployeeId());
				leaveregister.setApplyDate(LeaveRegister.getApplyDate());
				leaveregister.setStartDate(LeaveRegister.getStartDate());
				leaveregister.setEndDate(LeaveRegister.getEndDate());
				leaveregister.setLeaveReason(LeaveRegister.getLeaveReason());
				leaveregister.setLeaveType(LeaveRegister.getLeaveType());
				leaveregister.setRecomendRemarks(LeaveRegister.getRecomendRemarks());
				leaveregister.setApprovedRemarks(LeaveRegister.getApprovedRemarks());
				leaveregister.setApproveBy(sessionParam.getValue("UserId").toString());
				leaveregister.setLeaveStatus("Approved");
				leaveregisterRepo.save(leaveregister);
			} 
			return "redirect:/LeaveAuthorization";
		}
	}
	
	

	@GetMapping("/showUpdateLeaveForm")
	public ModelAndView showUpdateLeaveForm(@RequestParam Long LeaveID) {
		System.out.println("showUpdateLeaveForm");
		ModelAndView model = new ModelAndView("HRM/add-leave");
		LeaveRegister LeaveRegister = leaveregisterRepo.findById((LeaveID)).get();
		model.addObject("LeaveRegister", LeaveRegister);
		model.addObject("EmployeeList", ArmyEmployeeRepo.findAll());
		model.addObject("Leavelist", LeaveDescriptionRepo.findAll());		
		return model;
	}
	

	@GetMapping("/showUpdateLeaveRecomendation")
	public ModelAndView showUpdateLeaveRecomendation(@RequestParam Long LeaveID) {
		ModelAndView model = new ModelAndView("HRM/add-leaveRecomendation");
		LeaveRegister LeaveRegister = leaveregisterRepo.findById((LeaveID)).get();
		model.addObject("LeaveRegister", LeaveRegister);
		model.addObject("EmployeeList", ArmyEmployeeRepo.findAll());
		model.addObject("Leavelist", LeaveDescriptionRepo.findAll());

		return model;
	}

	@GetMapping("/showUpdateLeaveAuthorizationForm")
	public ModelAndView showUpdateLeaveAuthorizationForm(@RequestParam Long LeaveID) {
		ModelAndView model = new ModelAndView("HRM/add-leaveApproval");
		LeaveRegister LeaveRegister = leaveregisterRepo.findById((LeaveID)).get();
		model.addObject("LeaveRegister", LeaveRegister);
		model.addObject("EmployeeList", ArmyEmployeeRepo.findAll());
		model.addObject("Leavelist", LeaveDescriptionRepo.findAll());

		return model;
	}
	
	@GetMapping("/RejectLeave")
	public ModelAndView RejectLeave(@RequestParam Long LeaveID,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("HRM/LeaveAuthorization");
		HttpSession sessionParam = request.getSession();
		String UserId=null;
		try {
			UserId=sessionParam.getValue("UserId").toString();
		}catch(Exception e) {
			UserId="NF";
		}
		
		if(leaveregisterRepo.existsById(LeaveID)) {
			LeaveRegister leaveregister = leaveregisterRepo.findById(LeaveID).orElseThrow();
			leaveregister.setRejectBy(UserId);
			leaveregister.setLeaveStatus("Rejected");
			leaveregisterRepo.save(leaveregister);
		}
		
		
		mav.addObject("LeaveList", leaveregisterRepo.FindToBeApprovalList());
	return mav;
	}

	
	/*Leave Report Controller*/
	
	@Autowired
	DataSource dataSource;
	
	
	@GetMapping("/PrintLeaveForm")
	public ResponseEntity<byte[]> PrintLeaveForm(@RequestParam Long LeaveID) {		
		Map<String, Object> parameter = new HashMap<String, Object>();	
		parameter.put("P_LEAVEID", LeaveID);
		try {
			
			JasperPrint empReport =JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:templates/report-templates/ULMS/LeaveCard.jrxml").getAbsolutePath()) , parameter , dataSource.getConnection());
			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "LeaveCard ID#"+LeaveID+".pdf");
			//create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	
	@GetMapping("/PrintPersonalInfo")
	public ResponseEntity<byte[]> PrintPersonalInfo(@RequestParam String EmployeeId) {		
		Map<String, Object> parameter = new HashMap<String, Object>();	
		parameter.put("P_EMPLOYEE_ID", EmployeeId);
		try {
			
			JasperPrint empReport =JasperFillManager.fillReport(JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:templates/report-templates/ULMS/PersonalInfoData.jrxml").getAbsolutePath()) , parameter , dataSource.getConnection());
			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "Personal Info- ID#"+EmployeeId+".pdf");
			//create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	

}
