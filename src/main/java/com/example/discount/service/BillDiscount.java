package com.example.discount.service;

import com.example.discount.pojo.Bill;

public interface BillDiscount {
	public Bill getEmployeeDiscount(Bill bill);
	public Bill getReferalDiscount(Bill bill);
	public Bill getCustomerDiscount(Bill bill);
}
