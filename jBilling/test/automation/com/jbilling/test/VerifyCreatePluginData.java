package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyCreatePluginData extends BrowserApp {
	// Initialize private logger object
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

	@Test(description = "Test Case 285 : Data preparation for provisioning", groups = { "globalRegressionPack" })
	public void tc_0285_creatingPluginData() throws Exception {
		VerifyCreatePluginData.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047241");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCreatePluginData.logger.debug("Navigate to Configuration Page");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		VerifyCreatePluginData.logger.debug("Click on Plugin  from Configuration List");

		this.productsPage.addPlugin("addPluginOPT", "apOPT");
		VerifyCreatePluginData.logger.debug("Adding Plugin in to list");

		this.msgsPage.verifyDisplayedMessageText("The new plug-in with", "has been saved", TextComparators.contains);
		VerifyCreatePluginData.logger.debug("Verify success message The new plug-in with has been saved ");

		Reporter.log("<br> Test Passed");
		VerifyCreatePluginData.logger.exitMethod();
	}
}