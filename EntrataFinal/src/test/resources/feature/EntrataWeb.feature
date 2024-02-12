Feature: Sample Feature


	@test1
	Scenario: Check product and Marketing page
		Given User is on Entrata application
	    When User clicks on product
		Then User is navigated to Marketing and Leasing page successfully



	@test2
	Scenario Outline: Watch demo form
		Given User is on Entrata application
		When I enter "<first_name>", "<last_name>", "<email>", "<phone_number>", "<companyName>", "<uid>", and "<jobTitle>"
		Then User fills the watch demo form successfully

		Examples:
			| first_name | last_name | email             | phone_number | companyName | uid    | jobTitle     |
			| Pooja      | Rasal     | pooja.rasal@gmail.com | 1234567890   | Infosys Ltd | 1 - 10 | Test Analyst |

     @test3
      Scenario Outline: Navigate Between pages
        Given User is on Entrata application
	    Then User able to navigate "<Entrata_navigation_snap>"
	     Examples:
		| Entrata_navigation_snap |
		| screenshot              |

@test4
	Scenario: Navigate to a new window and return to the main window
		Given User is on Entrata application
		When User navigated to login window
		Then User returns to the main window

	@test5
	Scenario Outline: Resident Login window
		Given User is on Entrata application
		When User navigated to  residentPortal LoginButton
		And user fills contact information "<Name>", "<Email>", "<PropertyName>", "<PropertyURL>", "<Category>", and "<Message>"
		Then Cpture Title of the residentPortal

		Examples:
			| Name    | Email             | PropertyName | PropertyURL          | Category | Message |
			| Roshani | roshani@gmail.com | College      | www.apna.college.com | Payments | Hello   |
