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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

//Mobile.startApplication('D:\\app_releaseCosmo_3.1.2.680.apk', true)
Mobile.startExistingApplication('com.cosmo.missioncontrol')

Mobile.tap(findTestObject('Object Repository/case_14/case-9/android.widget.ImageButton'), 0)

Mobile.tap(findTestObject('Object Repository/case_14/case-9/android.widget.TextView - Location settings'), 0)

Mobile.tap(findTestObject('Object Repository/case_14/case-9/android.widget.TextView - Daytime only updates'), 0)

long endTime = System.currentTimeMillis() + 3000  
Random rand = new Random()

while(System.currentTimeMillis() < endTime) {
	
	int startX = 251 + rand.nextInt(85)
	int startY = 478 + rand.nextInt(64)

	int endX = startX
	int endY = startY - (50 + rand.nextInt(50))  

	Mobile.swipe(startX, startY, endX, endY)
}

Mobile.tap(findTestObject('Object Repository/case_14/case-9/android.widget.Button - OK'), 5)

Mobile.tap(findTestObject('Object Repository/case_14/case-9/android.widget.Button - Save'), 0)

Mobile.closeApplication()

