package com.panacea.controller.hrm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.panacea.model.common.DropDownType;
import com.panacea.model.common.UserMaster;
import com.panacea.model.hrm.ArmyEmployee;
import com.panacea.model.hrm.Employee;
import com.panacea.repository.hrm.*;
import com.panacea.utils.AESEncrypt;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	DesignationRepo DesignationRepo;
	@Autowired 
	BloodGroupRepo BloodGroupRepo;
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

	

}
