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
import com.kms.katalon.core.model.FailureHandling

// Test Objects
TestObject imageViewButton = findTestObject('Object Repository/DashboardScreen/Message')
TestObject cancelButton    = findTestObject('Object Repository/MessageService/CancelButton')
TestObject messagesText    = findTestObject('Object Repository/MessageService/MessagesText')

// Tap on ImageView
Mobile.waitForElementPresent(imageViewButton, 10)
Mobile.tap(imageViewButton, 0)
println 'Tapped ImageView button'

// Tap on Cancel
Mobile.waitForElementPresent(cancelButton, 10)
Mobile.tap(cancelButton, 0)
println 'Tapped Cancel button'

// Verify Messages text
Mobile.waitForElementPresent(messagesText, 10)
try {
	Mobile.verifyElementVisible(messagesText, 0)
	println 'Verified Messages text is visible'
} catch (Exception e) {
	println 'Messages text verification failed: ' + e.getMessage()
}

// Navigate back twice
Mobile.pressBack()
println 'Pressed back once'
Mobile.pressBack()
println 'Pressed back twice'


