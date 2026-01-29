import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable

class MobileTestListener {

	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {

		def prevStatus = GlobalVariable.prevStatus
		def appPackage = GlobalVariable.link
		
		
		boolean isFirstTest =
			testCaseContext.getTestCaseIndex() == 0
	
		if (isFirstTest) {
			println("First / Individual test – launching app")
			Mobile.startExistingApplication(appPackage)
	
		} else if (prevStatus == 'FAILED') {
			println("Previous test failed – restarting app")
			Mobile.closeApplication()
			Mobile.startExistingApplication(appPackage)
			
		} else {
			println("Previous test passed – continuing app")
		}
		
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		GlobalVariable.prevStatus = testCaseContext.getTestCaseStatus()
		println("Saved prevStatus = ${GlobalVariable.prevStatus}")
	}
}
