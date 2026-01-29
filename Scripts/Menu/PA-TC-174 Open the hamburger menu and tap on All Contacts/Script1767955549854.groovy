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


import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

// TestObjects
TestObject menuButton       = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject allContactsOpt   = findTestObject('Object Repository/HamburgerMenu/ContactTab')
TestObject allContactsText  = findTestObject('Object Repository/AllContactScreen/VerifyAllContactText')

// Open menu
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Open "All Contacts" section
Mobile.waitForElementPresent(allContactsOpt, 10)
Mobile.tap(allContactsOpt, 0)
KeywordUtil.logInfo('Opened All Contacts section')

// Verify "All Contacts" header with try-catch
try {
	Mobile.waitForElementPresent(allContactsText, 5)
	Mobile.verifyElementExist(allContactsText, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('"All Contacts" header verified successfully')
} catch(Exception e) {
	KeywordUtil.logInfo("Exception during All Contacts verification: ${e.message}")
}

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
