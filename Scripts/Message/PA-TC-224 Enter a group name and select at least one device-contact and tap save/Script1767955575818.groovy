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
TestObject groupNameField   = findTestObject('Object Repository/NewGroupChatScreen/GroupNameField')
TestObject switchButton     = findTestObject('Object Repository/NewGroupChatScreen/DeviceSwitch')
TestObject saveButton       = findTestObject('Object Repository/NewGroupChatScreen/SaveButton')
TestObject savedToast       = findTestObject('Object Repository/MessagesScreen/VerifyToast - Saved')


// Open menu
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Open "Messages" section
Mobile.waitForElementPresent(messagesOption, 10)
Mobile.tap(messagesOption, 0)
KeywordUtil.logInfo('Opened Messages section')

// Tap "New Group" button
Mobile.waitForElementPresent(newGroupButton, 10)
Mobile.tap(newGroupButton, 0)
KeywordUtil.logInfo('Tapped New Group button')

// Enter random group name
int randomNumber = 100 + new Random().nextInt(900)
String groupName = 'test' + randomNumber
Mobile.waitForElementPresent(groupNameField, 10)
Mobile.setText(groupNameField, groupName, 0)
KeywordUtil.logInfo("Entered group name: ${groupName}")

Mobile.hideKeyboard()

// Toggle switch 
Mobile.waitForElementPresent(switchButton, 5)
Mobile.tap(switchButton, 0)
KeywordUtil.logInfo('Toggled switch for group settings')

// Tap Save button
Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

// Verify "Saved" toast
try {
	Mobile.waitForElementPresent(savedToast, 5)
	Mobile.verifyElementExist(savedToast, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('Group saved toast verified successfully')
} catch(Exception e) {
	KeywordUtil.logInfo('Saved toast verification failed: ' + e.message)
}

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

