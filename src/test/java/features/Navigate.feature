Feature: Navigate
  Scenario: Navigate1
    * Navigate to https://demoqa.com/ and set window size to width of 1920 and height of 1080
    * Click card named Elements from the LandingPage
    * Click box named Text Box from the ElementPage
    * Close all advertisement boxes
    * Write Mehmet Galioglu to username box
    * Write testpractice@gmail.com to email box
    * Write x mah. 100. sok 5/8 Ayranci Ankara to current address box
    * Write who knows his permanent address but I hope it's not my parents' house :D to permanent address box
    * Wait for 3 seconds
    * Click submit button on the elements page
    * Wait for 3 seconds
    * Show all the submitted info
    * Return the landing page by clicking ToolQA image

  Scenario: Navigate2
    * Click card named widgets from the LandingPage
