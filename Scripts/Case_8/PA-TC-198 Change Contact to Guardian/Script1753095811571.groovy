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
import com.kms.katalon.core.testobject.ConditionType


Mobile.startExistingApplication('com.cosmo.missioncontrol')

Mobile.tap(findTestObject('Object Repository/Test_8/android.widget.ImageButton (2)'), 0)

Mobile.tap(findTestObject('Object Repository/Test_8/android.widget.LinearLayout'), 0)

Mobile.tap(findTestObject('Object Repository/Test_8/android.widget.TextView - test test'), 0)

Mobile.tap(findTestObject('Object Repository/Test_8/android.widget.RadioButton - Guardian'), 0)

int randomNum = (1000..9999).toList().get(new Random().nextInt(9000))
String randomEmail = "test" + randomNum + "@gmail.com"

Mobile.setText(findTestObject('Object Repository/Test_8/android.widget.EditText - Email'), randomEmail, 0)

Mobile.tap(findTestObject('Object Repository/Test_8/android.widget.Button - Save'), 0)

Mobile.tap(findTestObject('Object Repository/Test_8/android.widget.Button - CONFIRM'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Test_8/android.widget.TextView - All contacts'), 'All contacts')

Mobile.closeApplication()
