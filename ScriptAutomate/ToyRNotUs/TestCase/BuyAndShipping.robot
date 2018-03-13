*** Settings ***
Test Setup        Open Browser    ${URL}
Test Teardown     Close Browser
Resource          ../Resource/ExpectedVariables_TestCase_01.txt
Resource          ../Resource/GlobalVariables.txt
Resource          ../Resource/UserKeywords.txt

*** Test Cases ***
01_BuyItem_By_Female_3to5
    Comment    SearchItemyByAgeAndGender    ${Age3to5}    ${GenderFemale}    &{ExpectedItemData}
    Comment    SelectItem    &{ExpectedItemData}
    ViewDetailItem    &{ExpectedItemData}
    SelectQuality    ${text3}
    VerifyPrice    &{ExpectedItemData['Price']}    ${text3}
    InputAddress    &{ShippingAddress}
    SubmitAddress
    VerifyForm    &{ExpectedItemData}    &{ShippingAddress}
