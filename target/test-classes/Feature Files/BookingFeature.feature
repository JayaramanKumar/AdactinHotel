@VerifingBookingFeatures
Feature: Verifying Adactin hotel booking confirmation

  @VerifyingBookingWithDetails
  Scenario Outline: Verifying adactin hotel booking page
    Given User is on the Adactin login page
    When User should enter "<userName>", "<password>" and click login button	
    And User should search hotel with "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>" and search hotel
    And User should select one of the hotel and click continue
    And User should enter "<firstName>", "<lastName>" and "<billingAddress>"
    And User should make payment
      | creditCardNo     | creditCardType   | expMonth | expYear | cvvNo |
      | 1234567890123456 | VISA             | January  |    2021 |   123 |
      | 1234567890123456 | American Express | October  |    2020 |   767 |
      | 1234567890123456 | Master Card      | August   |    2022 |   121 |      
    Then User should verify the booking confirmed page "Booking Confirmation" and order ID;
    

    Examples: 
      | userName  | password    | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Jayaraman | Jairam@2021 | London   | Hotel Creek | Standard | 1 - One   | 21/12/2021  | 22/12/2021   | 1 - One       | 0 - None        | Jayaraman | Kumar    | Chennai        |

  @VerifyingBookingWithoutDetails
  Scenario Outline: Verifying adactin hotel booking page without enntering data
    Given User is on the Adactin login page
    When User should enter "<userName>", "<password>" and click login button	
    And User should search hotel with "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>" and search hotel
    And User should select one of the hotel and click continue
    And User should book hotel without entering any fields
    Then User should verify getting the error messages for every fields as "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName  | password    | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Jayaraman | Jairam@2021 | London   | Hotel Creek | Standard | 1 - One   | 21/12/2021  | 22/12/2021   | 1 - One       | 0 - None        |
