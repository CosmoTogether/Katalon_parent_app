import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

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

    // hide keyboard after confirming password
    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/PA-TC-115/android.widget.CheckBox'), 0)

    // ---- validations (collect results, don't stop execution) ----
    boolean allOk = true

    allOk &= Mobile.verifyElementExist(findTestObject('PA-TC-115/android.widget.EditText - Email - Invalid'), 5, FailureHandling.OPTIONAL)

    allOk &= Mobile.verifyElementExist(findTestObject('PA-TC-115/android.widget.EditText - Email - Error'), 5, FailureHandling.OPTIONAL)

    allOk &= Mobile.verifyElementAttributeValue(findTestObject('Object Repository/PA-TC-115/android.widget.Button - Next'), 
        'enabled', 'false', 0, FailureHandling.OPTIONAL)

    // ---- final verdict for the test case ----
    if (!(allOk)) {
        throw new StepFailedException('[PA-TC-115] One or more validations failed (see log above).')
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

