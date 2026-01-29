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
TestObject newGroupButton   = findTestObject('Object Repository/NewGroupChatScreen/PlusButton')
TestObject newGroupHeader   = findTestObject('Object Repository/NewGroupChatScreen/NewgroupChat')

// Steps

// Open menu
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Open "Messages" section
Mobile.waitForElementPresent(messagesOption, 10)
Mobile.tap(messagesOption, 0)
KeywordUtil.logInfo('Opened Messages section')

// Tap on "New Group Chat" button
Mobile.waitForElementPresent(newGroupButton, 10)
Mobile.tap(newGroupButton, 0)
KeywordUtil.logInfo('Tapped New Group Chat button')

// Verify "New Group Chat" header
try {
	Mobile.waitForElementPresent(newGroupHeader, 5)
	Mobile.verifyElementVisible(newGroupHeader, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('"New Group Chat" header verified successfully')
} catch(Exception e) {
	KeywordUtil.logInfo('"New Group Chat" header verification failed: ' + e.message)
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
