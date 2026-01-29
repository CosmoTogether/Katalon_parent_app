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
TestObject messagesOption   = findTestObject('Object Repository/HamburgerMenu/MessagesTab')
TestObject firstImageView   = findTestObject('Object Repository/MessagesScreen/FirstChat')
TestObject editTextField    = findTestObject('Object Repository/MessageService/TextField')
TestObject imageView1       = findTestObject('Object Repository/MessageService/img3')
TestObject imageView2       = findTestObject('Object Repository/MessageService/img1')
TestObject imageView3       = findTestObject('Object Repository/MessageService/img2')

// Steps

// Open menu
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Open "Messages" section
Mobile.waitForElementPresent(messagesOption, 10)
Mobile.tap(messagesOption, 0)
KeywordUtil.logInfo('Opened Messages section')

// Open first message/image
Mobile.waitForElementPresent(firstImageView, 10)
Mobile.tap(firstImageView, 0)
KeywordUtil.logInfo('Opened first message/image')

// Verify Edit Text field
try {
	Mobile.waitForElementPresent(editTextField, 5)
	Mobile.verifyElementVisible(editTextField, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('Edit text field verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo("Edit text field NOT found: ${e.message}")
}

// Verify ImageView 1
try {
	Mobile.waitForElementPresent(imageView1, 5)
	Mobile.verifyElementVisible(imageView1, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('ImageView 1 verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo("ImageView 1 NOT found: ${e.message}")
}

// Verify ImageView 2
try {
	Mobile.waitForElementPresent(imageView2, 5)
	Mobile.verifyElementVisible(imageView2, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('ImageView 2 verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo("ImageView 2 NOT found: ${e.message}")
}

// Verify ImageView 3
try {
	Mobile.waitForElementPresent(imageView3, 5)
	Mobile.verifyElementVisible(imageView3, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('ImageView 3 verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo("ImageView 3 NOT found: ${e.message}")
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
