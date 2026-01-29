//import com.kms.katalon.core.annotation.AfterTestCase
//import com.kms.katalon.core.context.TestCaseContext
//import internal.GlobalVariable
//
//class TestCaseResultListener {
//
//	@AfterTestCase
//	def afterTestCase(TestCaseContext context) {
//
//		String tcName = context.getTestCaseId()
//		String status = context.getTestCaseStatus()
//
//		if (status == "PASSED") {
//			GlobalVariable.PASSED_TESTS += "• ${tcName}\n"
//		} else if (status == "FAILED") {
//			GlobalVariable.FAILED_TESTS += "• ${tcName}\n"
//		} else {
//			GlobalVariable.SKIPPED_TESTS += "• ${tcName}\n"
//		}
//	}
//}
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import internal.GlobalVariable

class TestCaseResultListener {

	@AfterTestCase
	def afterTestCase(TestCaseContext context) {

		// Safe initialization
		if (GlobalVariable.TOTAL_TESTS == null) GlobalVariable.TOTAL_TESTS = 0
		if (GlobalVariable.PASSED_COUNT == null) GlobalVariable.PASSED_COUNT = 0
		if (GlobalVariable.FAILED_COUNT == null) GlobalVariable.FAILED_COUNT = 0
		if (GlobalVariable.SKIPPED_COUNT == null) GlobalVariable.SKIPPED_COUNT = 0

		if (GlobalVariable.PASSED_TESTS == null) GlobalVariable.PASSED_TESTS = ""
		if (GlobalVariable.FAILED_TESTS == null) GlobalVariable.FAILED_TESTS = ""
		if (GlobalVariable.SKIPPED_TESTS == null) GlobalVariable.SKIPPED_TESTS = ""

		String tcName = context.getTestCaseId()
		String status = context.getTestCaseStatus()

		// Total always increments
		GlobalVariable.TOTAL_TESTS++

		if (status == "PASSED") {
			GlobalVariable.PASSED_COUNT++
			GlobalVariable.PASSED_TESTS += "• ${tcName}\n"

		} else if (status == "FAILED") {
			GlobalVariable.FAILED_COUNT++
			GlobalVariable.FAILED_TESTS += "• ${tcName}\n"

		} else {
			GlobalVariable.SKIPPED_COUNT++
			GlobalVariable.SKIPPED_TESTS += "• ${tcName}\n"
		}
	}
}
