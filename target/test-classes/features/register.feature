Feature: Regiter User

Background: New User Signup

Given User is on Sign Up Page
When Screen loads
And User Enters "<Name>" in Name field
And User enters "<email>" in email fields
And User clicks on SignUp button

|Name  |   email      |
|Test  | test@test.com|