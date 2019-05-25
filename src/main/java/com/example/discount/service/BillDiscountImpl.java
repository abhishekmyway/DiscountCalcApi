package com.example.discount.service;

import com.example.discount.pojo.Bill;

public class BillDiscountImpl implements BillDiscount{
	
	public Bill getEmployeeDiscount(Bill bill) {
		Double discountedBill = bill.getAmount() - ((bill.getAmount()*30)/100);
		bill.setAmount(discountedBill);
		return bill;
	}
	
	public Bill getReferalDiscount(Bill bill) {
		Double discountedBill = bill.getAmount() - ((bill.getAmount()*10)/100);
		bill.setAmount(discountedBill);
		return bill;
	}

	@Override
	public Bill getCustomerDiscount(Bill bill) {
		if(bill.getCountOfyear()>2) {
			Double discountedBill = bill.getAmount() - ((bill.getAmount()*10)/100);
			
			bill.setAmount(discountedBill);
			return bill;
		}
		else return bill;
		
	}
	
	public Bill getAdditionalDiscount(Bill bill) {
		Integer n = Integer.valueOf(bill.getAmount().intValue()/100);
		Integer NetDiscount = n*5;
		
		Double discountedBill = bill.getAmount() - NetDiscount;
		bill.setAmount(discountedBill);
		return bill;
	}
}
