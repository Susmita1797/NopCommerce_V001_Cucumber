Feature: Login

@Sanity
Scenario: Successful login with valid Credentials

Given user launch Chrome broswer
When user opens URL"https://admin-demo.nopcommerce.com/Login"
And users enters Email as "admin@yourstore.com" and Password as "admin"
And click on Login
Then Page Title should be"Dashboard / nopCommerce administration"
When user click on logout link
Then Page Title should be"Your store. Login"
And close the browser

@Regression
Scenario Outline: Login Data Driven

Given user launch Chrome broswer
When user opens URL "https://admin-demo.nopcommerce.com/Login"
And users enters Email as "<email>" and Password as "<password>"
And click on Login
Then Page Title should be"Dashboard / nopcommerce administration"
When user click on logout link
Then page Title should be"Your store. Login"
And close the browser

    Examples:

| email   | password    |
| admin@yourstore.com |   admin  |
| admin1@yourstore.com  |  admin123   |

