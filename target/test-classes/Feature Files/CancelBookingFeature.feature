@VerifyingCancel
Feature: Verifying Adactin hotel cancel booking

  @VerifyingCancelHotelWithSameOrderID
  Scenario Outline: Verifying the cancellation of order Id
    Given User is on the Adactin login page
    When User should enter "<userName>", "<password>" and click login button
    And User should search hotel with "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>" and search hotel
    And User should select the hotel and click continue
    And User should enter "<firstName>", "<lastName>" and "<billingAddress>"
    And User should make payment
      | creditCardNo     | creditCardType   | expMonth | expYear | cvvNo |
      | 1234567890123456 | VISA             | January  |    2021 |   123 |
      | 1234567890123456 | American Express | October  |    2020 |   767 |
      | 1234567890123456 | Master Card      | August   |    2022 |   121 |
    And User should click Booked itenerary and cancel the same order Id
    Then User should verify the booking cancelled message as "The Booking has been cancelled"

    Examples: 
      | userName  | password    | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Jayaraman | Jairam@2021 | London   | Hotel Creek | Standard | 1 - One   | 21/12/2021  | 22/12/2021   | 1 - One       | 0 - None        | Jayaraman | Kumar    | Chennai        |

  @VerifyingCancelFeatureWithExistingOrderID
  Scenario Outline: Verifying the cancellation of existing order Id
    Given User is on the Adactin login page
    When User should enter "<userName>", "<password>" and click login button
    And User should click Booked itenerary and cancel the existing order Id "<orderID>".
    Then User should verify the booking cancelled message as "The Booking has been cancelled"

    Examples: 
      | userName  | password    | orderID    |
      | Jayaraman | Jairam@2021 | 18FZ8O955J |
