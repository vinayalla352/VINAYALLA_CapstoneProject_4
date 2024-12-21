@tag
Feature: Test the functionalities of the-internet.herokuapp.com

  @tag1
  Scenario: Verify the title,navigate back to home page ,drop down and frame links
    Given Launch the given URL "http://the-internet.herokuapp.com/"
    Then Verify the title of the page "The Internet"
    When clicking on the "A/B Testing" link
    Then verify the text on the page as "A/B Test Variation 1"
    When Navigate back to Home page
    And clicking on the "Dropdown" link
    Then Select "Option 1" value form drop down
    And verify "Option 1" is selected
    When Navigate back to Home page
    And clicking on the "Frames" link
    Then Verify the below hyperlinks are presented on the Frames Page
      | Nested Frames |
      | iFrame        |
