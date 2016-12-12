package com.jbilling.test;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.CreateOrder;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.MakePayment;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyUserIsAbleToPayLessAmountThenInvoiceAmount extends BrowserApp {

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

	@Test(description = "TC 163 : Verify that user is able to pay less amount than the invoice amount through Cheque")
	public void tc_0163_VerifyUserIsAbleToPayLessAmountThenInvoiceAmount() throws Exception {

		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Product tab");

		String categoryName = this.productsPage.createCategoryWithOneCustomer("addCategoryOneTime", "ac");
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Add category");

		String productDescription = this.productsPage.addProductInOnePerCustomerCategory("oneTimeAddProduct", "ap", categoryName);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Add product in category with one per order");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Confioguration tab");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Payment Method option");

		String paymentMethodName = this.confPage.addPaymentMethod("testPaymentTypeWithCheque", "ptwc");
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Add Payment MEthod");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Account type Link");

		String accountType = this.confPage.addAccount("addNewAccount", "aa", paymentMethodName);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Add account type");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Customer menu");

		String customerName = this.customerPage.addCustomerWithChequePaymentOption("addCustomerWithCheque", "acwc", paymentMethodName,
				accountType);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Customer Tab");

		this.customerPage = this.customerPage.createOrder(CreateOrder.ONETIME, "oneTimeOrder", "oto", productDescription);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Create order");

		this.ordersPage = this.ordersPage.clickGenerateInvoice();
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Generate invoice button");

		this.invoicePage = this.invoicePage.clickOnPayInvoiceBtn();
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Pay Invoice button");

		this.paymentsPage = this.paymentsPage.MakePayment(MakePayment.MODIFYPAYMENT, "makePayment", "mp", paymentMethodName);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Make payment after change Payment");

		this.invoicePage = this.navPage.navigateToInvoicesPage();
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on the Invoice Page");

		this.invoicePage = this.invoicePage.clickOnGeneratedInvoce(customerName);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on generated invoice");

		this.invoicePage = this.invoicePage.verifyInvoiceDetails("verifyInvoiceDetails", "vid");
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Verifing Invoice Details after paying half payment");

		this.invoicePage = this.invoicePage.clickOnPayInvoiceBtn();
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on Pay Invoice button");

		this.paymentsPage = this.paymentsPage.MakePayment(MakePayment.UNCHANGEDPAYEMENT, "makePayment", "mp", paymentMethodName);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Make full payment");

		this.invoicePage = this.navPage.navigateToInvoicesPage();
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Click on the Invoice Page");

		this.invoicePage = this.invoicePage.verifyFinalPaidStatus("verifyInvoiceDetails", "vid", customerName);
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.debug("Verify final status after paid complete payment");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToPayLessAmountThenInvoiceAmount.logger.exitMethod();
	}
}
