package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyCreateOrderDifferentCurrency extends BrowserApp {
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

	@Test(description = "TC_361  :  Verify correct currency conversion is made while creating order with plan.")
	public void tc_0361_createOrder() throws Exception {

		VerifyCreateOrderDifferentCurrency.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909926");

		String customername = this.propReader.readPropertyFromFile("TC_356_CustomerName", "testData");
		String planname = this.propReader.readPropertyFromFile("TC_360_planDescription", "testData");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyCreateOrderDifferentCurrency.logger.debug("Navigate to Customers Page");

		this.customerPage = this.customerPage.selectCustomerRecent(customername);
		VerifyCreateOrderDifferentCurrency.logger.debug("Select Customer");

		this.customerPage.clickCreateOrder();
		VerifyCreateOrderDifferentCurrency.logger.debug("Click Create Order button");

		this.customerPage.createOrderWithDifferentCurrency(planname, "OrderWithDifferentPeriodsCurr", "curr4");
		VerifyCreateOrderDifferentCurrency.logger.debug("Add Plan");

		this.msgsPage.verifyDisplayedMessageText("Created new order", "successfully", TextComparators.contains);
		VerifyCreateOrderDifferentCurrency.logger.debug("Verify message");

		Reporter.log("<br> Test Passed");
		VerifyCreateOrderDifferentCurrency.logger.exitMethod();
	}
}