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

//Mobile.startExistingApplication(GlobalVariable.link)
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType

// TestObjects
TestObject menuButton           = findTestObject('Object Repository/DashboardScreen/SettingEnginButton')
TestObject presetMessagesOpt    = findTestObject('Object Repository/DataAndSettingScreen/PresetMessagesTab')
TestObject presetMessagesText   = findTestObject('Object Repository/PresentMessagesScreen/PresentMessagesText')
TestObject PlusButton           = findTestObject('Object Repository/PresentMessagesScreen/PlusButton')
TestObject messageInputField    = findTestObject('Object Repository/PresentMessagesScreen/Enter your preset message')
TestObject saveButton           = findTestObject('Object Repository/PresentMessagesScreen/SaveButton')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(presetMessagesOpt, 10)
Mobile.tap(presetMessagesOpt, 0)
KeywordUtil.logInfo('Opened Preset Messages section')

Mobile.verifyElementVisible(presetMessagesText, 5, FailureHandling.STOP_ON_FAILURE)
KeywordUtil.logInfo('Preset Messages list verified')

Mobile.waitForElementPresent(PlusButton, 10)
Mobile.tap(PlusButton, 0)
KeywordUtil.logInfo('Tapped PLus button to add new preset message')

// Generate random 4-digit number and set message
int random4Digit = 1000 + new Random().nextInt(9000)
String finalMessage = message + random4Digit

Mobile.hideKeyboard()

Mobile.waitForElementPresent(messageInputField, 10)
Mobile.setText(messageInputField, finalMessage, 0)
KeywordUtil.logInfo("Entered preset message: '${finalMessage}'")

// Tap Save
Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

// Small wait to allow list to refresh
Mobile.delay(2)

Mobile.scrollToText(finalMessage, FailureHandling.OPTIONAL)

// Create dynamic TestObject to verify saved message
TestObject savedMessageObj = new TestObject('dynamicSavedMessage')
savedMessageObj.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//*[@text='${finalMessage}']"
)

// Verify the newly added preset message is visible
if (Mobile.waitForElementPresent(savedMessageObj, 10, FailureHandling.OPTIONAL)) {
	Mobile.verifyElementVisible(savedMessageObj, 0, FailureHandling.OPTIONAL)
	KeywordUtil.logInfo("Verified preset message is visible: '${finalMessage}'")
} else {
	KeywordUtil.markFailed("Preset message NOT visible after save: '${finalMessage}'")
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
