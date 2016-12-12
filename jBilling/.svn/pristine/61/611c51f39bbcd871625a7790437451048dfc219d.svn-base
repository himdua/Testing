package com.jbilling.test;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded extends BrowserApp {

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

	@Test(description = "TC 109 : Verify that the added meta-fields are displayed on order creation page, when the product is added")
	public void tc_109_VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded() throws Exception {

		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger
				.debug("Login Into Application And Navigate to Products Tab");

		String categoryName = this.productsPage.addCategory("productCategory", "pcat");
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Create A Product Category");

		this.confPage = this.confPage.validateCategoriesSavedTestData(VerifyUserIsAbleToAddlDependenciesOnProduct.category);
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Validate Saved New Product successfully");

		String description = this.productsPage.addProductwithOtherMetaField("addProductWithOtherMetaField", "apomf", categoryName);
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Add new Product");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Click on Confioguration tab");

		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Click on Payment Method link");

		String methodName = this.confPage.addPaymentMethod("paymentTypeWithPaymentCard", "pt");
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Add Payment Method");

		this.confPage = this.confPage.clickOnAccountTypeLink();
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Click on Account type Link");

		String accountType = this.confPage.accounttype("AccountTypeName", "oii", methodName);
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Add account type");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Click on Customer Tab");

		this.customerPage = this.customerPage.addNewCustomer(accountType, methodName, "NewCustomerInfo", "ldr");
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Click on Customer Tab");

		this.customerPage = this.customerPage.verifyOtherMetaFields(methodName, description);
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.debug("Verify other meta fields are added in order");

		Reporter.log("<br> Test Passed");
		VerifyAddedMetaFieldsAreDisplayedOnOrderCreationPageWhenProductIsAdded.logger.exitMethod();
	}

}
