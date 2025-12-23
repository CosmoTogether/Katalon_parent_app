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
import com.kms.katalon.core.exception.StepFailedException as StepFailedException

//Mobile.startApplication('D:\\app_releaseCosmo_3.1.2.680.apk', true)
try {
    Mobile.startExistingApplication('com.cosmo.missioncontrol')

    Mobile.tap(findTestObject('Object Repository/PA-TC-115/android.widget.Button - Create an account'), 0)

    Mobile.setText(findTestObject('Object Repository/PA-TC-115/android.widget.EditText - First name'), 'test', 0)

    Mobile.setText(findTestObject('Object Repository/PA-TC-115/android.widget.EditText - Last name'), 'test', 0)

    Mobile.setText(findTestObject('PA-TC-115/android.widget.EditText - Email'), email, 0)

    Mobile.setText(findTestObject('Object Repository/PA-TC-115/android.widget.EditText - Password (8 or more characters)'), 
        'Abcd$1234', 0)

    Mobile.setText(findTestObject('Object Repository/PA-TC-115/android.widget.EditText - Confirm Password'), 'Abcd$1234', 
        0)

    Mobile.hideKeyboard( // hide keyboard after confirming password
        )

    Mobile.tap(findTestObject('Object Repository/PA-TC-115/android.widget.CheckBox'), 0)

    Mobile.tap(findTestObject('Object Repository/PA-TC-115/android.widget.Button - Next'), 0)

    Mobile.setText(findTestObject('Object Repository/PA-TC-115/android.widget.EditText - Parent Phone Number'), '3434343434', 
        0)

    Mobile.hideKeyboard( // hide keyboard after entering phone number
        )

    Mobile.tap(findTestObject('Object Repository/PA-TC-115/android.widget.Button - Btn_Next_2'), 0)

	// Verify that either the email confirmation toast is shown OR the "Resend Email" button is present.
	boolean ok =
    	Mobile.verifyElementExist(findTestObject("Object Repository/PA-TC-115/Toast_UserEmailConfirmation"), 5, 
			FailureHandling.OPTIONAL) || 
		Mobile.verifyElementExist(findTestObject('Object Repository/Create Parent Account - Confirmation Screen/ResendEmailButton'), 
			5, FailureHandling.OPTIONAL)
		
	if (!ok) {
		throw new StepFailedException("No toast, No Resend Email")
	}
}
finally { 
    try {
        Mobile.closeApplication()
    }
    catch (Exception e) {
        println('[PA-TC-115] Failed to close app in teardown: ' + e.getMessage())
    } 
}

