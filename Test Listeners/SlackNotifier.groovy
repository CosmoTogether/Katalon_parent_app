import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import groovy.json.JsonOutput


class SlackNotifier {

	private static final String WEBHOOK_URL = ""

	@AfterTestSuite
	def sendSlackNotification(TestSuiteContext testSuiteContext) {
		try {
			def suiteName = testSuiteContext.getTestSuiteId()
			def status = testSuiteContext.getStatus() // PASSED / FAILED / STOPPED

			def message = [
				text: "*[Katalon Report]*\n" +
					  "Suite: ${suiteName}\n" +
					  "Status: ${status}"
			]

			def payload = JsonOutput.toJson(message)
			def connection = new URL(WEBHOOK_URL).openConnection()
			connection.setRequestMethod("POST")
			connection.setRequestProperty("Content-Type", "application/json")
			connection.doOutput = true
			connection.outputStream.write(payload.getBytes("UTF-8"))

			// Read Slack response
			def response = connection.inputStream.text
			println("Slack response: ${response}")

		} catch (Exception e) {
			println("Failed to send Slack notification: ${e.message}")
			e.printStackTrace()
		}
	}
}
