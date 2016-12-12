package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyCurrencyChangeRate extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	ITestResult result;
	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Current Application Page Stack || LoginPage--> loginPage;
	 * NavigatorPage--> navPage; HomePage--> homePage; ConfigurationPage-->
	 * confPage; AgentsPage--> agentsPage; CustomersPage--> customerPage;
	 * ProductsPage--> productsPage; PlansPage--> plansPage; OrdersPage-->
	 * ordersPage; InvoicePage--> invoicePage; ReportsPage--> reportsPage;
	 * DiscountsPage--> discountsPage; FiltersPage--> filtersPage;
	 * PaymentsPage--> paymentsPage; MessagesPage--> msgsPage;
	 * 
	 * @since 1.0
	 * @version 1.0
	 */

	@Test(description = "TC_363 Verify,user is able to change the default currency", groups = { "globalRegressionPack" }, priority = 0)
	public void tc_0363_verifyChangeDefaultCurrency() throws Exception {
		VerifyCurrencyChangeRate.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCurrencyChangeRate.logger.debug("Login Into Application And Navigate to Configuration");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Currencies);
		VerifyCurrencyChangeRate.logger.debug("Navigate to Currency Page");

		String defaultvalue = this.confPage.defaultCurrencySetup("DefaultCurrency", "default_curr_rate");
		this.propReader.updatePropertyInFile("TC_363_DefaultCurrency", defaultvalue, "testData");
		VerifyCurrencyChangeRate.logger.debug("This method to call currency methods");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Currencies updated successfully.", "successfully",
				TextComparators.contains);
		VerifyCurrencyChangeRate.logger.debug("Verify Message appears properly ");

		Reporter.log("<br> Test Passed");
		VerifyCurrencyChangeRate.logger.exitMethod();

	}

	@Test(description = "TC_364 Verify, changed default currency is displayed on 'Currency' field at Customer/ Agents creation page", groups = { "globalRegressionPack" }, priority = 1)
	public void tc_0364_verifyAgentCustomerCurrency() throws Exception {
		VerifyCurrencyChangeRate.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyCurrencyChangeRate.logger.debug("Navigate to Customer Page");

		this.customerPage.clickAddNewButton();
		VerifyCurrencyChangeRate.logger.debug("Click Add New Button");

		this.customerPage.clickSelectButton();
		VerifyCurrencyChangeRate.logger.debug("Click Add New Button");

		this.customerPage.verifyDropdownCurrency(this.pr.readTestData("TC_363_DefaultCurrency"));
		VerifyCurrencyChangeRate.logger.debug("Verify Default Currency");

		this.agentsPage = this.navPage.navigateToAgentsPage();
		VerifyCurrencyChangeRate.logger.debug("Navigate to Agent tab");

		this.agentsPage.clickAddNewButton();
		VerifyCurrencyChangeRate.logger.debug("Click add new agent tab");

		this.agentsPage.defaultCurrency("TC_363_DefaultCurrency");
		VerifyCurrencyChangeRate.logger.debug("Click add new agent tab");

		Reporter.log("<br> Test Passed");
		VerifyCurrencyChangeRate.logger.exitMethod();
	}
}