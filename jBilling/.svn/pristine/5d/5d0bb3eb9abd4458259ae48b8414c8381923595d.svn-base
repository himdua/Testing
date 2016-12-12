package com.jbilling.test;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyPaymentMethodIsAvailableForAllTheCustomers extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();

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
	 * @author Shanky
	 * @since 1.0
	 * @version 1.0
	 */

	@Test(description = "TC_0083 : Verify the payment method (card/cheque) with 'All account type' checkbox checked,is available for all the customers, associated with any account type")
	public void tc_0083_verifyPaymentMethodIsAvailableForAllTheCustomers() throws Exception {

		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.debug("Click on configuration menu");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.debug("Click on Payment Method option");

		String paymentMethodName = this.confPage.addPaymentMethod("testPaymentTypeWithCheque", "ptwc");
		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.debug("Add Payment MEthod");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.debug("Click on Account type Link");

		String accountType = this.confPage.addAccount("addNewAccount", "aa", paymentMethodName);
		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.debug("Add account type");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.debug("Click on Customer menu");

		String customerName = this.customerPage.addCustomerWithChequePaymentOption("addCustomerWithCheque", "acwc", paymentMethodName,
				accountType);
		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.debug("Create customer with Cheque payment type");

		VerifyPaymentMethodIsAvailableForAllTheCustomers.logger.exitMethod();
		Reporter.log("<br> Test Passed");
	}
}
