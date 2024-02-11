Feature: Sample Feature


	@test1
	Scenario: Checlk product and Marketing page
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
      Scenario Outline: Navigatebetween pages
        Given User is on Entrata application
	    Then User able to navigate "<Entrata_navigation_snap>"
	     Examples:
		| Entrata_navigation_snap |
		| screenshot              |