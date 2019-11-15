Feature: Keep track of inventory
	As a shopkeeper
	I want to keep track of inventory

Background:
	Given a product apple with quantity 50 in stock
	Given a product banana with quantity 10 in stock

Scenario: Customer buy one product
	When customer buy apple with quantity 20
	Then apple quantity in stock should be 30

Scenario: Customer buy multiple products
	When customer buy apple with quantity 10
	And customer buy banana with quantity 5
	Then apple quantity in stock should be 40
	And banana quantity in stock should be 5

Scenario: Re-order one product
	When I order apple with quantity 10
	Then apple quantity in stock should be 60

Scenario: Re-order multiple product
	When I order apple with quantity 5
	And I order banana with quantity 10
	Then apple quantity in stock should be 55
	Then banana quantity in stock should be 20

