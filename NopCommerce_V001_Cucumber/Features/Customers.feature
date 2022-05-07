Feature: Customers 

Background: Below are the common steps for each scenario 
      
   	Given user launch Chrome broswer 
	When user opens URL "https://admin-demo.nopcommerce.com/Login" 
	And users enters Email as "admin@yourstore.com" and Password as "admin" 
	And click on Login 
	Then user can view Dashboard 
	When user click on customers menu 
	And click on customers menu item 
	
@Sanity
Scenario: Add a new Customer 

	And click on add new button 
	Then user can view add new customer page 
	When user enter customer info 
	And click on save button 
	Then user can view confirmation message "The new customer has been added successfully." 
	And close the browser 

@Regression	
Scenario: Search Customer by using Email id 
	And user enter customer Email 
	When user click on search button 
	Then user should found Email in the search table 
	And close the browser 
	
@Regression		
Scenario: Search Customer by using FirstName 

	And user enter customer FirstName 
	When user click on search button 
	Then user should found firstname in the search table 
	And close the browser
	
