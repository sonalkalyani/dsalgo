/*package com.dsportalapp.dsalgo.stepDefinition;




	import java.io.IOException;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import com.dsportalapp.dsalgo.POM.CommonMethodsObject;
	import com.dsportalapp.dsalgo.POM.PracticeQuestionObjects;
	import com.dsportalapp.dsalgo.utilities.TestSetup;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	//PracticeQuestions

	public class PracticeQuestionsStepDefinition {

		public static Logger LOG = LoggerFactory.getLogger(PracticeQuestionsStepDefinition.class);
		CommonMethodsObject commonobj;
		PracticeQuestionObjects practiceobj;
		TestSetup testsetup;

		public PracticeQuestionsStepDefinition(TestSetup testsetup) throws IOException {
			super();
			this.testsetup = testsetup;
			commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
			practiceobj = testsetup.pageobjectmanager.getPracticeQuestionObject();

		}

		@Given("User is on {string} Practice Question page")
		public void user_is_on_page(String string) {
			practiceobj.navigateToPracticeQuestionPage(string);
		}

		@Then("The user should be redirected the question page contains a question,an tryEditor with Run and Submit buttons")
		public void the_user_should_be_redirected_the_question_page_contains_a_question_an_try_editor_with_run_and_submit_buttons() {
			practiceobj.checkElementsinPracticeQuestionPage();
		}

		@When("The user is on Python Editor and write valid code in Editor and click the run button")
		public void the_user_is_on_python_editor_and_write_valid_code_in_editor_and_click_the_run_button() {
			
			practiceobj.clearAndInsertMessage("print('helo')");
		}

		@Then("The user should be able to see output in the console")
		public void the_user_should_be_able_to_see_output_in_the_console() {
			LOG.info("Result in the Practice Question :" + commonobj.printResultEditor());
		}

		@When("The user clicks the Run button without entring the code in the Editor")
		public void the_user_clicks_the_run_button_without_entring_the_code_in_the_editor() {
			practiceobj.clearMessage();
		}

		@Then("Nothing happens to the page and no error message is displayed")
		public void nothing_happens_to_the_page_and_no_error_message_is_displayed() {
			LOG.info("Null Result in the Practice Question :" + commonobj.printResultEditor());
		}

		@When("The user is on Python Editor and write invalid code in Editor and click the run button")
		public void the_user_is_on_python_editor_and_write_invalid_code_in_editor_and_click_the_run_button() {
			commonobj.clickRunButton();
		}

		@Then("The user should able to see an error message in alert window")
		public void the_user_should_able_to_see_an_error_message_in_alert_window() {
			String err_alert = commonobj.switchToAlert();
			LOG.info("Error Message in the Alert window :" + err_alert);
		}

		@When("The user is on Python Editor and write invalid code in Editor and click the submit button")
		public void the_user_is_on_python_editor_and_write_invalid_code_in_editor_and_click_the_submit_button() {
			practiceobj.clickSubmitButton();
		}

		@Then("The user see an error message {string}")
		public void the_user_see_an_error_message(String string) {
			practiceobj.getErrorMessage(string);

		}

	}
*/
