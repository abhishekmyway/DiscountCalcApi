package com.example.discount.pojo;

public class Bill implements Cloneable{
	
	private Double amount;
	private String customerType;
	private Integer countOfyear;
	private String itemType;
	private String isDiscounted;
	public Bill() {
		
	}
	public Bill(Double amount, String customerType, Integer countOfyear, String itemType, String isDiscounted) {
		super();
		this.amount = amount;
		this.customerType = customerType;
		this.countOfyear = countOfyear;
		this.setItemType(itemType);
		this.isDiscounted = "N";
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}
	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	/**
	 * @return the countOfyear
	 */
	public Integer getCountOfyear() {
		return countOfyear;
	}
	/**
	 * @param countOfyear the countOfyear to set
	 */
	public void setCountOfyear(Integer countOfyear) {
		this.countOfyear = countOfyear;
	}
	public String getIsDiscounted() {
		return isDiscounted;
	}
	public void setIsDiscounted(String isDiscounted) {
		this.isDiscounted = isDiscounted;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public Object clone()throws CloneNotSupportedException{  
	return super.clone();  
	}  
}
