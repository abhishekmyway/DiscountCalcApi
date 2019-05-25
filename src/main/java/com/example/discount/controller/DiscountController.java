package com.example.discount.controller;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.discount.pojo.Bill;
import com.example.discount.service.BillDiscountImpl;
 
//import com.example.rest.dao.billService;
//import com.example.rest.model.Discounts;

@RestController
@RequestMapping(path = "/discounts")
public class DiscountController {
	 
	    @Autowired
	    private BillDiscountImpl billService;
	    
	    @Autowired
	    private Bill discountedbill;
	    
	    @GetMapping(path="/default", produces = "application/json")
	    public Bill getDefault()
	    {
	        return discountedbill;
	    }
	    
	    @PostMapping(path="/employee", produces = "application/json", consumes = "application/json")
	    public Bill getEmployeeDiscount(@RequestBody Bill bill)
	    {
	    	try {
	    		if(bill.getIsDiscounted().equals("N")) {
		    		if(!bill.getItemType().equals("Grocery")) {
			    		discountedbill =  billService.getEmployeeDiscount(bill);
			    		discountedbill.setIsDiscounted("Y");
			    	}
			        discountedbill = billService.getAdditionalDiscount(bill);
		    	}
	    		else {
	    			discountedbill = (Bill)bill.clone();
	    		}
	    	}catch(Exception e) {
	    		
	    	}
	    	
	    	
	        return discountedbill;
	    }
	     
	    @PostMapping(path="/referal", produces = "application/json", consumes = "application/json")
	    public Bill getReferalDiscount(@RequestBody Bill bill)
	    {
	    	try {
	    		if(bill.getIsDiscounted().equals("N")) {
		    		if(!bill.getItemType().equals("referal")) {
			    		discountedbill =  billService.getReferalDiscount(bill);
			    	}
		    		discountedbill = billService.getAdditionalDiscount(discountedbill);
	    		}
	    		else {
	    			discountedbill = (Bill)bill.clone();
	    		}
	    	}catch(Exception e) {
	    		
	    	}
	    	return discountedbill;
	    }
	    
	    @PostMapping(path="/customer", produces = "application/json", consumes = "application/json")
	    public Bill getCustomerDiscount(@RequestBody Bill bill)
	    {
	    	try {
	    		if(bill.getIsDiscounted().equals("N")) {
		    		if(!bill.getItemType().equals("Grocery")) {
			    		discountedbill =  billService.getCustomerDiscount(bill);
			    	}
		    		else {
		    			discountedbill = (Bill)bill.clone();
		    		}
		    		discountedbill = billService.getAdditionalDiscount(discountedbill);
		    	}
			}catch(Exception e) {
				    		
			}
	    	return discountedbill;
	    }
	}
