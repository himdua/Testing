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
public class VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly extends BrowserApp {

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

	@Test(description = "TC 106 : Verify user is able to set minimum period for order and the cancellation fee is applicable accordingly.")
	public void tc_0106_verifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly() throws Exception {

		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Click on Product tab");

		String categoryName = this.productsPage.createCategoryWithOneCustomer("addCategoryForMinimumTimePeriod", "ac");
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Add category");

		String productDescription = this.productsPage.addProductInOnePerCustomerCategory("addProductForMinimumTime", "ap", categoryName);
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger
		.debug("Add product in category with one per order");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Click on Confioguration tab");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger
		.debug("Click on Payment Method option");

		String paymentMethodName = this.confPage.addPaymentMethod("testPaymentTypeWithCheque", "ptwc");
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Add Payment MEthod");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Click on Account type Link");

		String accountType = this.confPage.addAccount("addNewAccount", "aa", paymentMethodName);
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Add account type");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Click on Customer menu");

		String customerName = this.customerPage.addCustomerWithChequePaymentOption("addCustomerWithCheque", "acwc", paymentMethodName,
				accountType);
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Click on Customer Tab");

		this.customerPage = this.customerPage.createOrderWithChequeType("CreateOrderWithCheque", "cowc", productDescription);
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger
		.debug("Create an Order with Payment Card");

		this.customerPage = this.customerPage.editCreatedOrder("CreateOrderWithCheque", "cowc");
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Edit Created Order");

		this.customerPage = this.customerPage.verifyInvoiceGenerated();
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Verify invoice is generated");

		this.ordersPage = this.navPage.navigateToOrdersPage();
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.debug("Click on Order menu");

		this.ordersPage = this.customerPage.verifyOrderStatus("CreatedOrderValues", "cov", customerName);
		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger
		.debug("Verify Order successfully generated.");

		VerifyUserIsAbleToSetMinimumPeriodForOrderAndTheCancellationFeeIsApplicableAccordingly.logger.exitMethod();
		Reporter.log("<br> Test Passed");
	}
}