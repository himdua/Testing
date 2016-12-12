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
public class VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput extends BrowserApp {

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

	@Test(description = "TC 110 : Verify that correct validation is displayed for invalid meta-field values input")
	public void tc_110_VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput() throws Exception {

		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger
				.debug("Login Into Application And Navigate to Products Tab");

		String categoryName = this.productsPage.addCategory("productCategory", "pcat");
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Create A Product Category");

		this.confPage = this.confPage.validateCategoriesSavedTestData(VerifyUserIsAbleToAddlDependenciesOnProduct.category);
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Validate Saved New Product successfully");

		String description = this.productsPage.addProductwithOtherMetaField("addProductWithOtherMetaField", "apomf", categoryName);
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Add new Product");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Click on Confioguration tab");

		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Click on Payment Method link");

		String methodName = this.confPage.addPaymentMethod("paymentTypeWithPaymentCard", "pt");
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Add Payment Method");

		this.confPage = this.confPage.clickOnAccountTypeLink();
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Click on Account type Link");

		String accountType = this.confPage.accounttype("AccountTypeName", "oii", methodName);
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Add account type");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Click on Customer Tab");

		this.customerPage = this.customerPage.addNewCustomer(accountType, methodName, "NewCustomerInfo", "ldr");
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Click on Customer Tab");

		this.customerPage = this.customerPage.editCreatedOrderWithOthermetaField("editOrderWithOtherMetaFiedl", "eowmf", description);
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.debug("Edit other meta fields in order");

		Reporter.log("<br> Test Passed");
		VerifyCorrectValidationIsDisplayedForInvalidMetaFieldValuesInput.logger.exitMethod();
	}
}
