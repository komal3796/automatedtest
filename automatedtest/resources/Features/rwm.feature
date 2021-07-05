@SIT
Feature: To test request water meter
@TC01
  Scenario: To complete Request water meter journey successfully
  
    Given Navigate To Home Page for chrome browser
    Then click on menu My account tab and sub menu Water meters
    And verify user navigated to Water meters page
    Then click on Request a water meter button
    And verify user navigated to Request a water meter page
    Then Fill Account no and First name Last name Postcode required field in user identification screen  
    |Account no  |900010088948|
    |First name  |Joshua  |
    |Last name   |Miller|
    |Postcode|OX4 4YT|
    Then click on next button
    And verify user navigated to security questions page
    Then select security question and answer
    | Question1 | Your date of birth|
    | date       | 01                 |	
    | month      | 01                 |	
    | year       | 1980                       |	
    | Question2  | Your usual payment method  |	
    | Answer2    | Direct Debit  |	
    Then click on next button
    Then enter contact details and select household information
    | email              | data67@mailinator.com  |	
    | phone              | 7134256456  |	
    | Type of property    | Flat|	
    | Number of occupants |  2 |	
    | Number of bedrooms  | 3 |	
    Then select checkboxes
    Then click on next button
    When on summary page
    Then select checkbox
    And click on submit button
    Then confirmation page is displayed
    
    
   
    
	  
    
    
    
    @TC02
  Scenario: To test roadblock page is displayed for already metered customer
  
     Given Navigate To Home Page for edge browser
    Then click on menu My account tab and sub menu Water meters
    And verify user navigated to Water meters page
    Then click on Request a water meter button
    And verify user navigated to Request a water meter page
    Then Fill Account no and First name Last name Postcode required field in user identification screen  
    |Account no  |900011549876|
    |First name  |Joshua|
    |Last name   |Johnson|
    |Postcode|GL7 6DS|
    Then click on next button
    And verify user navigated to security questions page
    Then select security question and answer
    | Question1 | Your date of birth|
    | date       | 01                 |	
    | month      | 01                 |	
    | year       | 1980                       |	
    | Question2  | Your usual payment method  |	
    | Answer2    | Direct Debit  |	
    Then click on next button
    Then roadblock for already metered is displayed
    
    
    
    
 @TC03
    Scenario: To test roadblock page is displayed for already processed request
  
    Given Navigate To Home Page for firefox browser
    Then click on menu My account tab and sub menu Water meters
    And verify user navigated to Water meters page
    Then click on Request a water meter button
    And verify user navigated to Request a water meter page
    Then Fill Account no and First name Last name Postcode required field in user identification screen
     |Account no  |900012558097|
    |First name  |Chris|
    |Last name   |Brown|
    |Postcode|OX5 1TA|
    Then click on next button
    And verify user navigated to security questions page
    Then select security question and answer
    | Question1 | Your date of birth|
    | date       | 01                 |	
    | month      | 01                 |	
    | year       | 1980                       |	
    | Question2  | Your usual payment method  |	
    | Answer2    | Direct Debit  |
    Then click on next button
    Then roadblock page is displayed
