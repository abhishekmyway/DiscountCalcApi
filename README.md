# DiscountCalcApi
TechnicalAssement

Document for Technical Assement:

Here i created a spring boot based rest  api for discount on the final bill. 
1. For each requirement mentioned in the question paper i created separate REST service. 
2. I also can create single service for all the requirement and use authorization to check for employee and customer roles. 
3. Percentage based discount are not applied on groceries. 
4. Added test cases, I need to recheck..    
5. Tools used to develop this api: 
	Eclipse with STS plugin
	Spring boot with web artifact
	Postman for testing



1. For Employee service api 
Api url: http://localhost:8080/discounts/employee
Input : 
{     "amount": 1000,     "customerType": "emplolyee",     "countOfyear": 2,     "itemType": "Reatil",     "isDiscounted": "N" }    


2. For customer service api: 
Api Url: http://localhost:8080/discounts/customer
Input:  
{     "amount": 1000,     "customerType": "customer",     "countOfyear": 2,     "itemType": "retail",     "isDiscounted": "N" }  
      

3. For referral service api. 
Api Url: http://localhost:8080/discounts/referal
Input: 
{     "amount": 1000,     "customerType": "referal",     "countOfyear": 2,     "itemType": "Grocery",     "isDiscounted": "N" }  
