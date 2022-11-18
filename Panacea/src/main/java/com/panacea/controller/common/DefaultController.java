package com.panacea.controller.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.panacea.model.acounting.Charges;
import com.panacea.model.acounting.GLCode;
import com.panacea.model.acounting.ProductParam;
import com.panacea.model.common.UserMaster;
import com.panacea.model.hrm.Designation;
import com.panacea.model.hrm.BloodGroup;
import com.panacea.model.hrm.Employee;
import com.panacea.model.hrm.LeaveDescription;
import com.panacea.model.inventory.InventoryProduct;
import com.panacea.model.inventory.Requisition;
import com.panacea.model.inventory.RequisitionList;
import com.panacea.repository.Accounting.AccountsProductRepo;
import com.panacea.repository.Accounting.ChargesRepo;
import com.panacea.repository.Accounting.GLCodeRepo;
import com.panacea.repository.common.UserMaserRepo;
import com.panacea.repository.hrm.*;
import com.panacea.repository.inventory.*;
import com.panacea.repository.leave.*;
import com.panacea.utils.AESEncrypt;

@Controller
public class DefaultController {
    @Autowired
    InventoryProductRepo inventoryProductRepo;
    @Autowired
    GLCodeRepo glcoderepository;
    @Autowired
	LeaveRegisterRepo leaveregisterRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	UserMaserRepo UserMasterRepo;
	@Autowired
	AccountsProductRepo ProductParamRepo;
	@Autowired
	ChargesRepo chargesRepo;
	
	
	@GetMapping("/DefaultUserCreation")
	public String DefaultUserCreation() {
		if (UserMasterRepo.count() == 0) {
			List<UserMaster> UserList = new ArrayList<UserMaster>();
			UserList.add(new UserMaster("10000", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "SYSTEM","S","","A"));
			UserList.add(new UserMaster("20001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "INVENTORY","E","","A"));
			UserList.add(new UserMaster("20002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "INVENTORY","S","","A"));
			UserList.add(new UserMaster("30001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com","ACCOUNTING", "E","","A"));
			UserList.add(new UserMaster("30002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com","ACCOUNTING", "S","","A"));
			UserList.add(new UserMaster("50001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "HRM","S","","A"));
			UserList.add(new UserMaster("60001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "TRACKER","S","","A"));
			UserList.add(new UserMaster("60002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "TRACKER","E","","A"));
			
			UserMasterRepo.saveAll(UserList);
		}
		return "index";
	}


	@GetMapping("/DefaultSetup")
	public String DefaultSetup() {
		if (UserMasterRepo.count() == 0) {
			List<UserMaster> UserList = new ArrayList<UserMaster>();
			UserList.add(new UserMaster("10000", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "SYSTEM","S","","A"));
			UserList.add(new UserMaster("20001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "INVENTORY","E","","A"));
			UserList.add(new UserMaster("20002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "INVENTORY","S","","A"));
			UserList.add(new UserMaster("30001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com","ACCOUNTING", "E","","A"));
			UserList.add(new UserMaster("30002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com","ACCOUNTING", "S","","A"));
			UserList.add(new UserMaster("60001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "TRACKER","S","","A"));
			UserList.add(new UserMaster("60002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "TRACKER","E","","A"));
			
			UserMasterRepo.saveAll(UserList);
		}
		if (employeeRepo.count() == 0) {
			List <Employee> EmployeeList = new ArrayList<Employee>() ;
						employeeRepo.saveAll(EmployeeList);
		}
		
		if (inventoryProductRepo.count() == 0) {
			List<InventoryProduct> productList = new ArrayList<InventoryProduct>();
			productList.add(new InventoryProduct("101","Printer","H","401101101","501101101","601101101"));
			productList.add(new InventoryProduct("102","Computer","H","401101101","501101101","601101101"));
			productList.add(new InventoryProduct("103","Mouse","H","401101101","501101101","601101101"));
			productList.add(new InventoryProduct("104","Keyboard","H","401101101","501101101","601101101"));
			productList.add(new InventoryProduct("105","Pendrive","H","401101101","501101101","601101101"));
			productList.add(new InventoryProduct("106","RAM","H","401101101","501101101","601101101"));
			productList.add(new InventoryProduct("107","ROM","H","401101101","501101101","601101101"));
			productList.add(new InventoryProduct("108","Portable Hard disk","H","401101101","501101101","601101101"));		
			inventoryProductRepo.saveAll(productList);
		}
		if (glcoderepository.count() == 0) {
			List<GLCode> glcodelist = new ArrayList<GLCode>();
			glcodelist.add(new GLCode("101000000","Non- Current Assets","A","P",""));
			glcodelist.add(new GLCode("101101000","Land And Land Development","A","M","101000000"));
			glcodelist.add(new GLCode("101101101","Land Dhaka","A","L","101101000"));
			glcodelist.add(new GLCode("101101102","Land Chittagong","A","L","101101000"));
			glcodelist.add(new GLCode("101102000","Building And Construction","A","M","101000000"));
			glcodelist.add(new GLCode("101102101","Building Dhaka","A","L","101102000"));
			glcodelist.add(new GLCode("101102102","Building Chittagong","A","L","101102000"));
			
			glcodelist.add(new GLCode("102000000","Long Term Investment","A","P",""));
			glcodelist.add(new GLCode("102101000","Investment","A","M","102000000"));
			glcodelist.add(new GLCode("102101101","Investment","A","L","102101000"));
			
			glcodelist.add(new GLCode("103000000","Advance,Deposit and Pre-Payment","A","P",""));
			glcodelist.add(new GLCode("103101000","Advance","A","M","103000000"));
			glcodelist.add(new GLCode("103102000","Deposit","A","M","103000000"));
			glcodelist.add(new GLCode("103103000","Pre-Payment","A","M","103000000"));
			
			glcoderepository.saveAll(glcodelist);
		}
		
		if (chargesRepo.count() == 0) {
   			List <Charges> ChargesList = new ArrayList<Charges>() ;
   			ChargesList.add(new Charges("101","Maintainance Fee","A","Y","Y","301302","401401"));	
			ChargesList.add(new Charges("102","SMS Fee","A","Y","Y","301303","401401"));	
			ChargesList.add(new Charges("103","Late Payment Fee","M","Y","Y","301304","401401"));
			ChargesList.add(new Charges("104","Application Fee","R","N","Y","301304",""));
			chargesRepo.saveAll(ChargesList);
   		}
		
		if (ProductParamRepo.count() == 0) {
   			List <ProductParam> productList = new ArrayList<ProductParam>() ;
			productList.add(new ProductParam("100","Savings","D","Y"));
			productList.add(new ProductParam("101","Current","D","Y"));
			productList.add(new ProductParam("103","SND","D","Y"));
			productList.add(new ProductParam("400","Deposit","D","Y"));
			productList.add(new ProductParam("200","Micro Credit","L","Y"));
			productList.add(new ProductParam("201","Shop Loan","L","Y"));
			productList.add(new ProductParam("203","Marrage Loan","L","Y"));
			ProductParamRepo.saveAll(productList);
   		}
		
		if (RequisitionRepo.count() == 0) {
   			List <Requisition> Requisition = new ArrayList<Requisition>() ;
   			//Requisition.add(new Requisition("00018",LocalDate.parse("2022-09-20"),1,"102",3,"Test Narration"));	
   			//Requisition.add(new Requisition("00018",LocalDate.parse("2022-09-20"),1,"103",4,"Test Narration"));	
   			//Requisition.add(new Requisition("00018",LocalDate.parse("2022-09-20"),1,"105",2,"Test Narration"));
   			//Requisition.add(new Requisition("00018",LocalDate.parse("2022-09-20"),2,"102",3,"Test Narration"));	
   			//Requisition.add(new Requisition("00018",LocalDate.parse("2022-09-20"),2,"106",2,"Test Narration"));
   			RequisitionRepo.saveAll(Requisition);
   		}
   		
   		if (RequisitionListRepo.count() == 0) {
   			List <RequisitionList> RequisitionList = new ArrayList<RequisitionList>() ;
   			//RequisitionList.add(new RequisitionList("00018","2022-09-20",1,"Test Remarks"));	
   		//	RequisitionList.add(new RequisitionList("00018","2022-09-20",2,"Test Remarks"));
   			RequisitionListRepo.saveAll(RequisitionList);
   		}
		
		return "index";
	}
	
	
    
   
    @Autowired
    DesignationRepo DesignationRepo;
    @Autowired
    BloodGroupRepo ArmyTradeRepo;
    @Autowired
	
    LeaveDescriptionRepo LeaveDescriptionRepo;
    @Autowired
    RequisitionRepo RequisitionRepo;
    @Autowired
    RequisitionListRepo RequisitionListRepo;
    @Autowired
    BloodGroupRepo BloodGroupRepo;

    
    @GetMapping("/DefaultLeaveParameterCreation")
   	public String DefaultParameterCreation() {
   		
   		if (DesignationRepo.count() == 0) {
   			List <Designation> DesignationList = new ArrayList<Designation>() ;
   			DesignationList.add(new Designation("101","OFFR","Asssistant Officer"));	
   			DesignationList.add(new Designation("102","OFFR","Officer"));	
   			DesignationList.add(new Designation("103","OFFR","Assistant Manager"));	
   			DesignationList.add(new Designation("104","OFFR","Deputy Manager"));	
   			DesignationList.add(new Designation("105","OFFR","Joint Manager"));	
   			DesignationList.add(new Designation("106","OFFR","Senior Manager"));
   			
   			
   			DesignationRepo.saveAll(DesignationList);
   		}
   		
	   	if (LeaveDescriptionRepo.count() == 0) {
   			List <LeaveDescription> LeavList = new ArrayList<LeaveDescription>() ;
   			LeavList.add(new LeaveDescription("C","Casual leave"));	
   			LeavList.add(new LeaveDescription("R","Recreation leave"));	
   			LeavList.add(new LeaveDescription("P","Privilege leave"));	
   			LeavList.add(new LeaveDescription("F","Festival leave"));	
   			LeavList.add(new LeaveDescription("E","Emergency leave"));	
   			LeavList.add(new LeaveDescription("W","Weekend"));
   			LeaveDescriptionRepo.saveAll(LeavList);
   		}
	   	 if(BloodGroupRepo.count()==0) {
	   		List<BloodGroup> BloodgroupList = new ArrayList<BloodGroup>();
			BloodgroupList.add(new BloodGroup("AP", "A+"));
			BloodgroupList.add(new BloodGroup("AN", "A-"));
			BloodgroupList.add(new BloodGroup("BP", "B+"));
			BloodgroupList.add(new BloodGroup("BN", "B-"));
			BloodgroupList.add(new BloodGroup("ABP", "AB+"));
			BloodgroupList.add(new BloodGroup("ABN", "AB-"));
			BloodgroupList.add(new BloodGroup("OP", "O+"));
			BloodgroupList.add(new BloodGroup("ON", "O-"));
			BloodGroupRepo.saveAll(BloodgroupList);
	   	 }
	   	
   		return "index";
   	}   
   
    
    
}
