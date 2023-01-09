#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Verify the table
Background:
Given user hit the url
Scenario: Verify only details of black bears are displayed on the Bear Table
When the only details of black bears are displayed on the Bear Table
Then Assert that all the rows have the value black for color column

Scenario: Verify the cats weight
When get the details from weight column of cat table
Then Assert that all the rows have the value less than 15 lbs for weight column

Scenario: Verify starwar table
When get the description details from starwar table
Then the values in the Description column has less than 350 characters  