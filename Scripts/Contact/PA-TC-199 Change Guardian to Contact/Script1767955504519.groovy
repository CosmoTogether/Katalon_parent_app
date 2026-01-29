import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.util.KeywordUtil
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

TestObject menuButton          = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject allContactsItem     = findTestObject('Object Repository/HamburgerMenu/ContactTab')
TestObject pendingTab          = findTestObject('Object Repository/AllContactScreen/PendingGuardian')
TestObject contactRadioButton  = findTestObject('Object Repository/AddContactScreen/ContactAccount')
TestObject saveButton          = findTestObject('Object Repository/AddContactScreen/SaveButton')
TestObject confirmButton       = findTestObject('Object Repository/EditContactScreen/ConfirmButton')
TestObject okButton            = findTestObject('Object Repository/AddContactScreen/OkButton')
TestObject VerifySaveMessage   = findTestObject('Object Repository/AllContactScreen/SaveCompleteToast')

Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
println 'Tapped Menu button'

Mobile.waitForElementPresent(allContactsItem, 10)
Mobile.tap(allContactsItem, 0)
println 'Opened All contacts'

Mobile.waitForElementPresent(pendingTab, 10)
Mobile.tap(pendingTab, 0)
println 'Opened Pending tab'

Mobile.waitForElementPresent(contactRadioButton, 10)
Mobile.verifyElementVisible(contactRadioButton, 0)
println 'Verified Contact radio button is visible'

Mobile.tap(contactRadioButton, 0)
println 'Selected Contact radio button'

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
println 'Tapped Save button'

Mobile.waitForElementPresent(confirmButton, 10)
Mobile.tap(confirmButton, 0)
println 'Tapped CONFIRM button'

Mobile.waitForElementPresent(okButton, 10)
Mobile.tap(okButton, 0)
println 'Tapped OK button'

if (Mobile.waitForElementPresent(VerifySaveMessage, 0)) {
	Mobile.verifyElementExist(VerifySaveMessage, 0)
	KeywordUtil.logInfo('Toast message verified successfully')
} else {
	KeywordUtil.logInfo('message not displayed')
}


Mobile.pressBack()
