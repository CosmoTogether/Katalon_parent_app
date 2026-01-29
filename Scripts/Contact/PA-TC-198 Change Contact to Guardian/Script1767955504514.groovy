import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject

// TestObjects
TestObject menuButton         = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject allContactsItem    = findTestObject('Object Repository/HamburgerMenu/ContactTab')
TestObject contactItem         = findTestObject('Object Repository/AllContactScreen/FirstContact')
TestObject guardianRadioButton = findTestObject('Object Repository/AddContactScreen/GuardianAcount')
TestObject emailField          = findTestObject('Object Repository/AddContactScreen/EmailField')
TestObject saveButton          = findTestObject('Object Repository/AddContactScreen/SaveButton')
TestObject confirmButton       = findTestObject('Object Repository/EditContactScreen/ConfirmButton')
TestObject allContactsText     = findTestObject('Object Repository/AllContactScreen/VerifyAllContactText')
TestObject VerifySaveMessage   = findTestObject('Object Repository/AllContactScreen/SaveCompleteToast')

Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
println 'Tapped Menu button'

Mobile.waitForElementPresent(allContactsItem, 10)
Mobile.tap(allContactsItem, 0)
println 'Opened All contacts'

Mobile.waitForElementPresent(contactItem, 10)
Mobile.tap(contactItem, 0)
println 'Selected contact item'

Mobile.waitForElementPresent(guardianRadioButton, 10)
Mobile.tap(guardianRadioButton, 0)
println 'Selected Guardian radio button'

int randomNum = (1000..9999).toList().get(new Random().nextInt(9000))
String randomEmail = 'test' + randomNum + '@gmail.com'

Mobile.waitForElementPresent(emailField, 10)
Mobile.setText(emailField, randomEmail, 0)
println 'Entered Email'

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
println 'Tapped Save button'

Mobile.waitForElementPresent(confirmButton, 10)
Mobile.tap(confirmButton, 0)
println 'Tapped CONFIRM button'


if (Mobile.waitForElementPresent(VerifySaveMessage, 0)) {
	Mobile.verifyElementExist(VerifySaveMessage, 0)
	KeywordUtil.logInfo('Toast message verified successfully')
} else {
	KeywordUtil.logInfo('message not displayed')
}


try {
	Mobile.waitForElementPresent(allContactsText, 10)
	Mobile.verifyElementText(allContactsText, verify_contact_text)
	println '"All contacts" text verified'
} catch (Exception e) {
	println 'Verification failed: "All contacts" text not found or mismatched - ' + e.getMessage()
}

Mobile.pressBack()
