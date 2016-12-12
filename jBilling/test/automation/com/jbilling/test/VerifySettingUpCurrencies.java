package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.pageclasses.MessagesPage;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifySettingUpCurrencies extends BrowserApp {
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

	@Test(description = "TC_348 Verify setting up currencies from Configuration/Currencies", groups = { "globalRegressionPack" }, priority = 0)
	public void tc_0348_currencySetup() throws Exception {
		VerifySettingUpCurrencies.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifySettingUpCurrencies.logger.debug("Login Into Application And Navigate to Configure Page");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Currencies);
		VerifySettingUpCurrencies.logger.debug("Switching to Currencies configuration item");

		this.confPage.activeCurrency();
		VerifySettingUpCurrencies.logger.debug("Click SaveChanes in Currencies");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Currencies updated successfully.", "successfully",
				TextComparators.contains);
		VerifySettingUpCurrencies.logger.debug("Verify Message appears properly ");

		Reporter.log("<br> Test Passed");
		VerifySettingUpCurrencies.logger.exitMethod();

	}

	@Test(description = "TC_357 Verify,Inactive currencies are unavailable at 'New Agent' page and creating an Agent with default currency (USD)", groups = { "globalRegressionPack" }, priority = 1)
	public void tc_0357_checkAgentCurrency() throws Exception {
		VerifySettingUpCurrencies.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifySettingUpCurrencies.logger.debug("Login Into Application And Navigate to Configuration Page");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Currencies);
		VerifySettingUpCurrencies.logger.debug("Navigate to Currencies");

		this.confPage.defaultCurrencySetup("setcurrency", "setcurr");
		VerifySettingUpCurrencies.logger.debug("Navigate to Currencies");

		this.agentsPage = this.navPage.navigateToAgentsPage();
		VerifySettingUpCurrencies.logger.debug("Login Into Application And Navigate to Agent Page");

		this.agentsPage.verifyCurrency("addAgentcurrency", "currrecnydata");
		VerifySettingUpCurrencies.logger.debug("verify currency");

		Reporter.log("<br> Test Passed");
		VerifySettingUpCurrencies.logger.exitMethod();

	}

	@Test(description = "TC_353 Verify user is not able to remove currencies which are in use", groups = { "globalRegressionPack" }, priority = 2)
	public void tc_0353_currencyCheckup() throws Exception {
		VerifySettingUpCurrencies.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifySettingUpCurrencies.logger.debug("Navigate to Customer Page");

		this.customerPage.addCustomerWithcurrency("addcuswithcurr", "cuswithcurr");
		VerifySettingUpCurrencies.logger.debug("Adding Customer");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifySettingUpCurrencies.logger.debug("Login Into Application And Navigate to Configure Page");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Currencies);
		VerifySettingUpCurrencies.logger.debug("Switching to Currencies configuration item");

		this.confPage = this.confPage.deactivateCurrencies();
		VerifySettingUpCurrencies.logger.debug("Verify Deactivate Currencies");

		MessagesPage.isErrorMessageAppeared();
		VerifySettingUpCurrencies.logger.debug("Verify Error message");

		Reporter.log("<br> Test Passed");
		VerifySettingUpCurrencies.logger.exitMethod();

	}

	@Test(description = "TC_354 Verify removing currencies from Configuration/Currencies (not in use)", groups = { "globalRegressionPack" }, priority = 3)
	public void tc_0354_currencyChekupNotInUse() throws Exception {
		VerifySettingUpCurrencies.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifySettingUpCurrencies.logger.debug("Login Into Application And Navigate to Configure Page");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Currencies);
		VerifySettingUpCurrencies.logger.debug("Switching to Currencies configuration item");

		this.confPage.unusedCurrency();
		VerifySettingUpCurrencies.logger.debug("uncheck used Currency");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Currencies updated successfully.", "successfully",
				TextComparators.contains);
		VerifySettingUpCurrencies.logger.debug("Switching to Currencies configuration item");

		Reporter.log("<br> Test Passed");
		VerifySettingUpCurrencies.logger.exitMethod();
	}
}
