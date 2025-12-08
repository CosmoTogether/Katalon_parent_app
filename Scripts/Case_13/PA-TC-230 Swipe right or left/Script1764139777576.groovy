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

//Mobile.startApplication('D:\\app_releaseCosmo_3.1.2.680.apk', true)
Mobile.startExistingApplication('com.cosmo.missioncontrol')

Mobile.tap(findTestObject('Object Repository/case_13/case-2/android.widget.ImageButton'), 0)

Mobile.tap(findTestObject('Object Repository/case_13/case-2/android.widget.CheckedTextView - Activity Center'), 0)

Mobile.tap(findTestObject('Object Repository/case_13/case-2/android.widget.TextView - Step counter'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/case_13/case-2/android.widget.TextView - 1st rank'), '1st rank')

TestObject element = findTestObject('Object Repository/case_13/case-2/android.widget.TextView - 1st rank')

int startX = Mobile.getElementLeftPosition(element, 0)
int startY = Mobile.getElementTopPosition(element, 0)
int width = Mobile.getElementWidth(element, 0)
int height = Mobile.getElementHeight(element, 0)

int endX = startX
int rightSideX = startX + width - 1
int centerY = startY + (height / 2)

Mobile.swipe(rightSideX, centerY, endX, centerY)

Mobile.verifyElementText(findTestObject('Object Repository/case_13/case-2/android.widget.TextView - 2nd rank'), '2nd rank')

Mobile.closeApplication()

