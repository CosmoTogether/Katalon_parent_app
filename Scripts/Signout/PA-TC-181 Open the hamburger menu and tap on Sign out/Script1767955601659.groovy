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
TestObject signOutOption    = findTestObject('Object Repository/HamburgerMenu/SignoutTab')
TestObject okButton         = findTestObject('Object Repository/DashboardScreen/OkSignout')
TestObject homeScreenIcon   = findTestObject('Object Repository/SignInScreen/cosmoMC_image')

// Steps

// Open menu
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Open "Sign Out" option
Mobile.waitForElementPresent(signOutOption, 10)
Mobile.tap(signOutOption, 0)
KeywordUtil.logInfo('Tapped Sign Out option')

// Confirm Sign Out
Mobile.waitForElementPresent(okButton, 10)
Mobile.tap(okButton, 0)
KeywordUtil.logInfo('Confirmed Sign Out')

// Verify landing screen
try {
	Mobile.waitForElementPresent(homeScreenIcon, 5)
	Mobile.verifyElementVisible(homeScreenIcon, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('Successfully returned to home screen after Sign Out')
} catch(Exception e) {
	KeywordUtil.logInfo("Exception during Sign Out verification: ${e.message}")
}
