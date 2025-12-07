Feature: Login Feature

Scenario Outline: Validate user login successfully
Given User navigates to the url
When Screen Loads
And User enters "<email>" in email field
And User enters "<password>" in password Field
And User clicks on Login button
#Then Verify user landed to Homepage

Examples:

|email|password|
|test3588@gmail.com|Test@2025|


