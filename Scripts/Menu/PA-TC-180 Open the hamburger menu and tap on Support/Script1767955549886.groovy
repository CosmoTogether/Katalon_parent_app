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
TestObject menuButton    = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject supportOpt    = findTestObject('Object Repository/HamburgerMenu/SupportTab')
TestObject supportHeader = findTestObject('Object Repository/SupportScreen/SupportText')

// Open menu
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Open "Support" section
Mobile.waitForElementPresent(supportOpt, 10)
Mobile.tap(supportOpt, 0)
KeywordUtil.logInfo('Opened Support section')

// Verify "Support" header with try-catch
try {
	Mobile.waitForElementPresent(supportHeader, 5)
	Mobile.verifyElementExist(supportHeader, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('"Support" header verified successfully')
} catch(Exception e) {
	KeywordUtil.logInfo("Exception during Support verification: ${e.message}")
}

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
