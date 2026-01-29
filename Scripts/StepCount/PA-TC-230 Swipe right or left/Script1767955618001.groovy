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
TestObject activityCenter   = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject stepCounterOption = findTestObject('Object Repository/ActivityCenterScreen/StepCounterTab')
TestObject firstRank        = findTestObject('Object Repository/StepCounterScreen/1st rank')
TestObject secondRank       = findTestObject('Object Repository/StepCounterScreen/2nd rank')

// Step 1: Tap Menu button
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Step 2: Open Activity Center
Mobile.waitForElementPresent(activityCenter, 10)
Mobile.tap(activityCenter, 0)
KeywordUtil.logInfo('Opened Activity Center')

// Step 3: Select Step Counter
Mobile.waitForElementPresent(stepCounterOption, 10)
Mobile.tap(stepCounterOption, 0)
KeywordUtil.logInfo('Opened Step Counter section')

// Step 4: Verify first rank
try {
	Mobile.verifyElementText(firstRank, '1st rank', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('Verified first rank text successfully')
} catch (Exception e) {
	KeywordUtil.logInfo('Failed to verify first rank text: ' + e.getMessage())
}

// Step 5: Perform swipe to see next rank
try {
	int startX = Mobile.getElementLeftPosition(firstRank, 0)
	int startY = Mobile.getElementTopPosition(firstRank, 0)
	int width = Mobile.getElementWidth(firstRank, 0)
	int height = Mobile.getElementHeight(firstRank, 0)
	int endX = startX
	int rightSideX = (startX + width) - 1
	int centerY = startY + (height / 2)

	Mobile.swipe(rightSideX, centerY, endX, centerY)
	KeywordUtil.logInfo('Swipe performed from right to left on first rank')
} catch (Exception e) {
	KeywordUtil.logInfo('Swipe failed: ' + e.getMessage())
}

// Step 6: Verify second rank
try {
	Mobile.verifyElementText(secondRank, '2nd rank', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('Verified second rank text successfully')
} catch (Exception e) {
	KeywordUtil.logInfo('Failed to verify second rank text: ' + e.getMessage())
}

// Optional: Take screenshot
Mobile.takeScreenshot()
KeywordUtil.logInfo('Screenshot captured for Step Counter swipe')

// Step 7: Navigate back safely
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
