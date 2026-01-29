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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

// TestObjects
TestObject menuButton         = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject allContactsItem    = findTestObject('Object Repository/HamburgerMenu/ContactTab')
TestObject contactItem        = findTestObject('Object Repository/AllContactScreen/FirstContact')
TestObject deleteButton       = findTestObject('Object Repository/EditContactScreen/DeleteContactButton')
TestObject okButton           = findTestObject('Object Repository/EditContactScreen/OkDeleteButton')
TestObject allContactsText    = findTestObject('Object Repository/AllContactScreen/VerifyAllContactText')
TestObject VerifyContactDeleted    = findTestObject('Object Repository/AllContactScreen/VerifyContactDeleted')

Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
println 'Tapped Menu button'

Mobile.waitForElementPresent(allContactsItem, 10)
Mobile.tap(allContactsItem, 0)
println 'Opened All contacts'

Mobile.waitForElementPresent(contactItem, 10)
Mobile.tap(contactItem, 0)
println 'Selected contact item'

Mobile.waitForElementPresent(deleteButton, 10)
Mobile.tap(deleteButton, 0)
println 'Tapped Delete contact button'

Mobile.waitForElementPresent(okButton, 10)
Mobile.tap(okButton, 0)
println 'Tapped OK button to confirm deletion'


if (Mobile.waitForElementPresent(VerifyContactDeleted, 0)) {
	Mobile.verifyElementExist(VerifyContactDeleted, 0)
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


