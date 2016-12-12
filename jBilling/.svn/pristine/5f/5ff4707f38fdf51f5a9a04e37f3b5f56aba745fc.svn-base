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

public class VerifyDefaultCurrency extends BrowserApp {
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

	@Test(description = "TC_358 Verify that user is able to set exchange rate for currencies", groups = { "globalRegressionPack" })
	public void tc_0358_currencyCreation() throws Exception {
		VerifyDefaultCurrency.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyDefaultCurrency.logger.debug("Login Into Application And Navigate to Agent Page");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Currencies);
		VerifyDefaultCurrency.logger.debug("Switching to Currencies configuration item");

		this.confPage.defaultCurrencySetup("DefaultCurrency", "default_curr_rate");
		VerifyDefaultCurrency.logger.debug("This method to call currency methods");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Currencies updated successfully.", "successfully",
				TextComparators.contains);
		VerifyDefaultCurrency.logger.debug("Verify Message appears properly ");

		Reporter.log("<br> Test Passed");
		VerifyDefaultCurrency.logger.exitMethod();
	}
}
