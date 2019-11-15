Feature: Deposit money into account

Background:
	Given amount of money in account is 9000 Baht

Scenario: Deposit money
	When I deposit 900 Baht into account
	Then amount of money in account should be 9900 Baht