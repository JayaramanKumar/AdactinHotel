@SearchHotel
Feature: Verifying Adactin login detail

  @VerifyAcdainSearchHotel
  Scenario Outline: Verifying adactin search hotel page entering all fields
    Given User is on the Adactin login page
    When User should enter "<userName>", "<password>" and click login button
    And User should search hotel with "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>" and search hotel
    Then User should verify navigate to "Select Hotel" page

    Examples: 
      | userName  | password    | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Jayaraman | Jairam@2021 | London   | Hotel Creek | Standard | 1 - One   | 21/12/2021  | 22/12/2021   | 1 - One       | 0 - None        |

  @VerifySearchFeatureMandatoryFields
  Scenario Outline: Verifying adactin search hotel page entering mandatory fields
    Given User is on the Adactin login page
    When User should enter "<userName>", "<password>" and click login button
    And User should search hotel with mandatory fields only "<location>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>" and search hotel
    Then User should verify navigate to "Select Hotel" page

    Examples: 
      | userName  | password    | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Jayaraman | Jairam@2021 | London   | 1 - One   | 21/12/2021  | 22/12/2021   | 1 - One       |

  @VerifySearchFeatureWithoutMandatoryFields
  Scenario Outline: Verifying adactin search hotel page without entering mandatory fields
    Given User is on the Adactin login page
    When User should enter "<userName>", "<password>" and click login button
    And User should search hotel without entering data and search hotel
    Then User should verify getting the error message for without entering data as "Please Select a Location" under search hotel

    Examples: 
      | userName  | password    |
      | Jayaraman | Jairam@2021 |

  @VerifySearchFeatureWithInvalidDates
  Scenario Outline: Verifying adactin search hotel page entering invalid date format
    Given User is on the Adactin login page
    When User should enter "<userName>", "<password>" and click login button
    And User should search hotel with mandatory fields only "<location>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>" and search hotel
    Then User should verify the error message for entered invalid dates  as "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

   Examples: 
      | userName  | password    | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Jayaraman | Jairam@2021 | London   | 1 - One   | 30/12/2021  | 24/12/2021   | 1 - One       |
