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

public class VerifyEditNotificationPayment extends BrowserApp {

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

	@Test(description = "TC_168 Verify that email medium type option is displayed on Edit notification page", groups = { "globalRegressionPack" })
	public void tc_0168_editNotification() throws Exception {

		VerifyEditNotificationPayment.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyEditNotificationPayment.logger.debug("Click on Configuration page");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Notification);
		VerifyEditNotificationPayment.logger.debug("Click on Notification Method link");

		this.confPage.clickPaymentnotification("Payments");
		VerifyEditNotificationPayment.logger.debug("Click on Payment in Notification List Item");

		this.confPage.createPaymentNotification("NotificationPayment", "notpay");
		VerifyEditNotificationPayment.logger.debug("Save Notofication");

		this.msgsPage.verifyDisplayedMessageText("Notification Saved", "Successfully", TextComparators.contains);
		VerifyEditNotificationPayment.logger.debug("Notification Saved Successfully");

		this.confPage.setEditAndVerifyValuePresent("NotificationEditPayment", "notf");
		VerifyEditNotificationPayment.logger.debug("Edit and Verify Email in list box");

		Reporter.log("<br> Test Passed");
		VerifyEditNotificationPayment.logger.exitMethod();
	}
}