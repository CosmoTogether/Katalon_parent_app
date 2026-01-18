import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import groovy.json.JsonOutput
import internal.GlobalVariable
import java.net.URL
import java.net.HttpURLConnection

class SlackSuiteNotifier {

	@AfterTestSuite
	def sendSlackNotification(TestSuiteContext context) {

		println ">>> AfterTestSuite STARTED"

		try {
			String suiteName = context.getTestSuiteId()

			String passed  = GlobalVariable.PASSED_TESTS?.trim() ? GlobalVariable.PASSED_TESTS : "None"
			String failed  = GlobalVariable.FAILED_TESTS?.trim() ? GlobalVariable.FAILED_TESTS : "None"
			String skipped = GlobalVariable.SKIPPED_TESTS?.trim() ? GlobalVariable.SKIPPED_TESTS : "None"

			def payload = JsonOutput.toJson([
				text: """ *Katalon Test Suite Report*
*Suite:* ${suiteName}
*Summary*
• Total Test Cases: ${GlobalVariable.TOTAL_TESTS}
• Passed: ${GlobalVariable.PASSED_COUNT}
• Failed: ${GlobalVariable.FAILED_COUNT}
• Skipped: ${GlobalVariable.SKIPPED_COUNT}

✔ Passed:
${passed}

❌ Failed:
${failed}

⚠️ Skipped:
${skipped}
"""
			])

			HttpURLConnection connection =
				(HttpURLConnection) new URL(GlobalVariable.SLACK_WEBHOOK_URL).openConnection()

			connection.setRequestMethod("POST")
			connection.setRequestProperty("Content-Type", "application/json")
			connection.setDoOutput(true)

			connection.outputStream.withWriter("UTF-8") {
				it.write(payload)
			}

			println "Slack HTTP response: ${connection.responseCode}"
			connection.inputStream.text

			println "✅ Slack message sent"

		} catch (Exception e) {
			println "❌ Slack failed"
			e.printStackTrace()
		}
	}
}
