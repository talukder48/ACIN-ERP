package com.panacea.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.panacea.model.acounting.Charges;
import com.panacea.model.acounting.GLCode;
import com.panacea.model.acounting.ProductParam;
import com.panacea.model.hrm.ArmyCompany;
import com.panacea.model.hrm.ArmyEmployee;
import com.panacea.model.hrm.ArmyRank;
import com.panacea.model.hrm.ArmyTrade;
import com.panacea.model.hrm.Employee;
import com.panacea.model.hrm.LeaveDescription;
import com.panacea.model.hrm.LeaveRegister;
import com.panacea.model.inventory.InventoryProduct;
import com.panacea.model.inventory.Requisition;
import com.panacea.model.inventory.RequisitionList;
import com.panacea.model.login.UserMaster;
import com.panacea.repository.Accounting.AccountsProductRepo;
import com.panacea.repository.Accounting.ChargesRepo;
import com.panacea.repository.Accounting.GLCodeRepo;
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
			UserList.add(new UserMaster("10000", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "SYSTEM","S"));
			UserList.add(new UserMaster("20001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "INVENTORY","E"));
			UserList.add(new UserMaster("20002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "INVENTORY","S"));
			UserList.add(new UserMaster("30001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com","ACCOUNTING", "E"));
			UserList.add(new UserMaster("30002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com","ACCOUNTING", "S"));
			UserList.add(new UserMaster("40001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "LEAVE","M"));
			UserList.add(new UserMaster("40002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "LEAVE","E"));
			UserList.add(new UserMaster("50001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "HRM","S"));
			UserList.add(new UserMaster("60001", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "TRACKER","S"));
			UserList.add(new UserMaster("60002", "Test", AESEncrypt.encrypt("admin"), "0018", "01", "01515240013","Test@gmail.com", "TRACKER","E"));
			
			UserMasterRepo.saveAll(UserList);
		}
		return "index";
	}

	
	@GetMapping("/DefaultEmployeeInsert")
	public String DefaultEmployeeInsert() {
		
		if (employeeRepo.count() == 0) {
			List <Employee> EmployeeList = new ArrayList<Employee>() ;
			EmployeeList.add(new Employee("ID2020080002","Abu Tayab","Abdur Rahim","Amena Begum","199210000001","1098234567","M","test@gmail.com","017120908902","Barisal","01-01-2009","20"));	
			EmployeeList.add(new Employee("ID2020080001","Abdur Rahim","Abdur Karim","Momena Begum","199210003001","1098231567","M","test@gmail.com","017120908902","Feni","01-01-2009","19"));	
			EmployeeList.add(new Employee("ID2020080003","Tanjila Akter","Abdur Rob","Jorina Begum","199210004001","1098232567","M","test@gmail.com","017120908902","Rangamati","01-01-2009","18"));	
			EmployeeList.add(new Employee("ID2020080005","Habibur Rahman","Aminur Rahmna","Maymuna Begum","199210080001","4098234567","M","test@gmail.com","017120908902","Dhaka","01-01-2009","17"));	
			employeeRepo.saveAll(EmployeeList);
		}
		return "index";
	}
	@GetMapping("/DefaultLeaveCreation")
	public String DefaultLeaveCreation() {
		if (leaveregisterRepo.count() == 0) {
			List <LeaveRegister> LeaveList = new ArrayList<LeaveRegister>() ;
			LeaveList.add(new LeaveRegister(10001L,"ID2020080002","","C","Dhaka","01-01-2022","03-01-2022","Personal","31-12-2021"));	
			LeaveList.add(new LeaveRegister(10002L,"ID2020080001","","C","Dhaka","01-01-2022","03-01-2022","Medical","31-12-2021"));	
			LeaveList.add(new LeaveRegister(10003L,"ID2020080003","","C","Dhaka","01-01-2022","03-01-2022","Maternity","31-12-2021"));	
			LeaveList.add(new LeaveRegister(10004L,"ID2020080005","","C","Dhaka","01-01-2022","03-01-2022","Peternity","31-12-2021"));	
			
			leaveregisterRepo.saveAll(LeaveList);
		}
		return "index";
	}

    
    @GetMapping("/DefaultInventoryProductCreation")
	public String DefaultInventoryProductCreation() {
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
		return "index";
	}   
    
    @GetMapping("/DefaultGLCodeCreation")
	public String DefaultGLCodeCreation() {
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
		return "index";
	} 
    
    
    @GetMapping("/DefaultAccountingProductCreation")
   	public String DefaultAccountingProductCreation() {
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
   		return "index";
   	}   
    @GetMapping("/DefaultChargesCreation")
   	public String DefaultChargesCreation() {
   		if (chargesRepo.count() == 0) {
   			List <Charges> ChargesList = new ArrayList<Charges>() ;
   			ChargesList.add(new Charges("101","Maintainance Fee","A","Y","Y","301302","401401"));	
			ChargesList.add(new Charges("102","SMS Fee","A","Y","Y","301303","401401"));	
			ChargesList.add(new Charges("103","Late Payment Fee","M","Y","Y","301304","401401"));
			ChargesList.add(new Charges("104","Application Fee","R","N","Y","301304",""));
			chargesRepo.saveAll(ChargesList);
   		}
   		return "index";
   	}   
    
    @Autowired
    ArmyCompayRepo ArmyCompayRepo;
    @Autowired
    ArmyRankRepo ArmyRankRepo;
    @Autowired
    ArmyTradeRepo ArmyTradeRepo;
    @Autowired
	ArmyEmployeeRepo ArmyEmployeeRepo;
    @Autowired
    LeaveDescriptionRepo LeaveDescriptionRepo;
    @Autowired
    RequisitionRepo RequisitionRepo;
    @Autowired
    RequisitionListRepo RequisitionListRepo;
    
    @GetMapping("/DefaultPurchaseCreation")
   	public String DefaultPurchaseCreation() {
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
    
    
    
    
    @GetMapping("/DefaultParameterCreation")
   	public String DefaultParameterCreation() {
   		if (ArmyCompayRepo.count() == 0) {
   			List <ArmyCompany> ArmyCompanyList = new ArrayList<ArmyCompany>() ;
   			ArmyCompanyList.add(new ArmyCompany("101","BHQ"));	
   			ArmyCompanyList.add(new ArmyCompany("102","HQ Company"));	
   			ArmyCompanyList.add(new ArmyCompany("103","OP Company"));	
   			ArmyCompanyList.add(new ArmyCompany("104","RR Company"));	
   			ArmyCompanyList.add(new ArmyCompany("105","Radio Company"));	
   			ArmyCompanyList.add(new ArmyCompany("106","BSC"));
   			ArmyCompanyList.add(new ArmyCompany("107","ABSC"));
   			ArmyCompayRepo.saveAll(ArmyCompanyList);
   		}
   		if (ArmyRankRepo.count() == 0) {
   			List <ArmyRank> ArmyRankList = new ArrayList<ArmyRank>() ;
   			ArmyRankList.add(new ArmyRank("101","Off","Second Lieutenant"));	
   			ArmyRankList.add(new ArmyRank("102","Off","Lieutenant"));	
   			ArmyRankList.add(new ArmyRank("103","Off","Captain"));	
   			ArmyRankList.add(new ArmyRank("104","Off","Major"));	
   			ArmyRankList.add(new ArmyRank("105","Off","Lieutenant Colonel"));	
   			ArmyRankList.add(new ArmyRank("106","JCO","Honorary captain"));
   			ArmyRankList.add(new ArmyRank("107","JCO","Second Lieutenant"));
   			ArmyRankList.add(new ArmyRank("108","JCO","Honorary Lieutenant"));
   			ArmyRankList.add(new ArmyRank("109","JCO","Master Warrant Officer"));
   			ArmyRankList.add(new ArmyRank("110","JCO","Senior Warrant officer"));
   			ArmyRankList.add(new ArmyRank("111","JCO","Warrant Officer"));
   			ArmyRankList.add(new ArmyRank("112","OTH","Corporal"));
   			ArmyRankList.add(new ArmyRank("113","OTH","Lance Corporal"));
   			ArmyRankList.add(new ArmyRank("114","OTH","Sainik"));
   			ArmyRankList.add(new ArmyRank("115","OTH","NC(E)"));
   			ArmyRankRepo.saveAll(ArmyRankList);
   		}
   		if (ArmyTradeRepo.count() == 0) {
   			List <ArmyTrade> ArmyTradeList = new ArrayList<ArmyTrade>() ;
   			ArmyTradeList.add(new ArmyTrade("101","Operator"));	
   			ArmyTradeList.add(new ArmyTrade("102","Technician"));	
   			ArmyTradeList.add(new ArmyTrade("103","W/S"));	
   			ArmyTradeList.add(new ArmyTrade("104","DTMN"));	
   			ArmyTradeList.add(new ArmyTrade("105","Driver"));	
   			ArmyTradeList.add(new ArmyTrade("106","Clerk"));
   			ArmyTradeList.add(new ArmyTrade("107","SMT"));
   			ArmyTradeRepo.saveAll(ArmyTradeList);
   		}
	   	 if (ArmyEmployeeRepo.count() == 0) {
	 		List <ArmyEmployee> ArmyEmployeeList = new ArrayList<ArmyEmployee>() ;
	 		ArmyEmployeeList.add(new ArmyEmployee("ID2020080002","Abu Tayab","Abdur Rahim","Amena Begum","101","101","101","O","A+","01-01-1991","M","test@gmail.com","017120908902","Barisal","10","Wirless Gate","M","01515222234","Abu Naser","01515222235"));	
	 		ArmyEmployeeRepo.saveAll(ArmyEmployeeList);
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
	   	 
	   	 
	   	 
   		return "index";
   	}   
   
    
    
}
