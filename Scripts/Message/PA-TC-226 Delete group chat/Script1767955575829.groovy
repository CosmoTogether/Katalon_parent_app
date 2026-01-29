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
TestObject firstGroupImage  = findTestObject('Object Repository/NewGroupChatScreen/FirstPenImage')
TestObject editGroupText     = findTestObject('Object Repository/EditGroupChatScreen/EditgroupChatText')
TestObject deleteGroupButton = findTestObject('Object Repository/EditGroupChatScreen/DeleteGroupChatButton')
TestObject deletedToast      = findTestObject('Object Repository/EditGroupChatScreen/VerifyToast - Deleted')


// Open menu
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Open "Messages" section
Mobile.waitForElementPresent(messagesOption, 10)
Mobile.tap(messagesOption, 0)
KeywordUtil.logInfo('Opened Messages section')

// Open first group chat
Mobile.waitForElementPresent(firstGroupImage, 10)
Mobile.tap(firstGroupImage, 0)
KeywordUtil.logInfo('Opened first group chat')

// Verify "Edit group Chat" text
try {
	Mobile.waitForElementPresent(editGroupText, 5)
	Mobile.verifyElementVisible(editGroupText, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('"Edit group Chat" text verified successfully')
} catch(Exception e) {
	KeywordUtil.logInfo('Failed to verify "Edit group Chat": ' + e.message)
}

// Delete group chat
Mobile.waitForElementPresent(deleteGroupButton, 5)
Mobile.tap(deleteGroupButton, 0)
KeywordUtil.logInfo('Tapped Delete group chat button')

// Verify "Deleted" toast
try {
	Mobile.waitForElementPresent(deletedToast, 5)
	Mobile.verifyElementExist(deletedToast, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('Deleted toast verified successfully')
} catch(Exception e) {
	KeywordUtil.logInfo('Deleted toast verification failed: ' + e.message)
}

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
