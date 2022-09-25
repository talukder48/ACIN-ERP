package com.panacea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.panacea.model.inventory.InventoryUser;
import com.panacea.model.login.UserMaster;
import com.panacea.repository.leave.UserMaserRepo;
import com.panacea.utils.AESDecrypt;

@Controller
@RequestMapping({ "/", "/login" })
public class LoginController {
	@Autowired
	UserMaserRepo UserMasterRepo;
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

	

	@GetMapping("/LogOut")
	public String LogOut() {
		return "index";
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	

	@PostMapping("/login")
	public String loginvalidation(@ModelAttribute(name = "loginForm") UserMaster login, Model model,HttpServletRequest request) {
		String ViewName = "";
		String UserID = request.getParameter("username");
		String Password = request.getParameter("password");
		HttpSession sessionParam = request.getSession();
		

		if (UserMasterRepo.existsById(UserID)) {
			UserMaster usermaster = UserMasterRepo.findById(UserID).orElseThrow();
			if (usermaster.getUserID().equals(UserID)
					&& AESDecrypt.decrypt(usermaster.getUserPassword()).equals(Password)) {
				
				sessionParam.setAttribute("UserId", UserID);
				sessionParam.setAttribute("Module", usermaster.getUserModule());
				sessionParam.setAttribute("UserRole", usermaster.getUserRole());
				sessionParam.setAttribute("UserBranch", usermaster.getUserBranch());
				
				if (usermaster.getUserModule().equals("ACCOUNTING")) {
					ViewName = "Accounting/Accounting";
				} else if (usermaster.getUserModule().equals("INVENTORY")) {
					{
						if (usermaster.getUserRole().equals("S")) {
							ViewName = "Inventory/Inventory";
						 }
						 else {
							 ViewName = "Inventory/Inventory";
						 }
					}
					
				} else if (usermaster.getUserModule().equals("LEAVE")) {
					 if (usermaster.getUserRole().equals("M")) {
						 ViewName = "HRM/LeaveManagement";
					 }
					 else {
						 ViewName = "HRM/LeaveEndUser";
					 }
					
				}
				else if (usermaster.getUserModule().equals("HRM")) {
					 if (usermaster.getUserRole().equals("S")) {
						 ViewName = "HRM/HRSuperUser";
					 }
					 
				}

			} else {
				model.addAttribute("error", "Incorrect Username or Password");
				ViewName = "index";
			}
		} else {
			model.addAttribute("error", "User ID not Exist !!");
			ViewName = "index";
		}
		return ViewName;

	}
	
	@GetMapping("/UserHome")
    public String LeaveManagement(HttpServletRequest request,Model model) {
		String ViewName = "";
		try {
			String UserID=request.getSession().getAttribute("UserId").toString();
			if(UserID==null||UserID.equals("")) {
				model.addAttribute("error", "Session Out!!! Please login Again!!");
				ViewName = "index";
			}else {
				if (UserMasterRepo.existsById(UserID)) {
					UserMaster usermaster = UserMasterRepo.findById(UserID).orElseThrow();
					if (usermaster.getUserID().equals(UserID)) {
										
						if (usermaster.getUserModule().equals("ACCOUNTING")) {
							ViewName = "Accounting/Accounting";
						} else if (usermaster.getUserModule().equals("INVENTORY")) {
							{
								if (usermaster.getUserRole().equals("S")) {
									ViewName = "Inventory/Inventory";
								 }
								 else {
									 ViewName = "Inventory/Inventory";
								 }
							}
							
						} else if (usermaster.getUserModule().equals("LEAVE")) {
							 if (usermaster.getUserRole().equals("M")) {
								 ViewName = "HRM/LeaveManagement";
							 }
							 else {
								 ViewName = "HRM/LeaveEndUser";
							 }					
						}
						else if (usermaster.getUserModule().equals("HRM")) {
							 if (usermaster.getUserRole().equals("S")) {
								 ViewName = "HRM/HRSuperUser";
							 }
							 
						}

					} else {
						model.addAttribute("error", "Incorrect User ID or Password");
						ViewName = "index";
					}
				} else {
					model.addAttribute("error", "User ID not Exist !!");
					ViewName = "index";
				}
			}
		}catch(Exception e) {
			model.addAttribute("error", "Server Maybe Suspend Your Session Please login Again !!");
			ViewName = "index";
		}
		
		
        return ViewName;
    }
	
	

	@RequestMapping("/AccountsInfo")
	public ModelAndView AccountInfo(@RequestParam int UserId) {
		ModelAndView mav = new ModelAndView("accounts-profile");
		InventoryUser newUser = new InventoryUser("1457", "Mosharraf Hossain Talukder", "123", "AP", "0400", "M");
		mav.addObject("InventoryUser", newUser);
		return mav;
	}

	@PostMapping("/UpdateUserInfo")
	public String UpdateUserInfo(@ModelAttribute InventoryUser inventoryUser) {
		// eRepo.save(inventoryUser);
		return "redirect:/Inventory";
	}

	@RequestMapping("/AccountsPassword")
	public String AccountsPassword(Model model) {
		return "accounts-password";
	}
	 @GetMapping("/InventoryManagement")
	    public String InventoryManagement() {
	        return "InventoryManagement";
	    }
	    
	    @GetMapping("/Inventory")
	    public String Inventory() {
	        return "Inventory/Inventory";
	    }

	    @GetMapping("{tab}")
	    public String tab(@PathVariable String tab) {
	    	
	    	
	        if (Arrays.asList("tab1", "tab2", "tab3","tab4","tab5","tab6","tab7")
	                  .contains(tab)) {
	        	
	            return "Inventory/_" + tab;
	        }

	        return "Inventory/_empty";
	    }
}