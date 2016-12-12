package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
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
	 * @author Shanky
	 * @since 1.0
	 * @version 1.0
	 */

	@Test(description = "TC 102 : Verify that orders with mandatory and optional dependency gets created. ")
	public void VerifyOrdersWithMandatoryAndOptionalDependencyCreated() throws Exception {
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Login Into Application And Navigate to Products Tab");

		String category1 = this.productsPage.addCategory("productCategory", "pcat");
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Create A Product Category");

		this.confPage = this.confPage.validateCategoriesSavedTestData(VerifyUserIsAbleToAddlDependenciesOnProduct.category);
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Validate Saved New Product successfully");

		String description1 = this.productsPage.addProduct(AddProductField.FLAT, "addProductOneWithDependencies", "ap");
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Add The Product");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Login Into Application And Navigate to Products Tab");

		String productDescriptionWithID = this.productsPage.productDescriptionWithID(category1, description1);

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Login Into Application And Navigate to Products Tab");

		String category2 = this.productsPage.addCategory("productCategory", "pcat");
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Create A Product Category");

		this.confPage = this.confPage.validateCategoriesSavedTestData(VerifyUserIsAbleToAddlDependenciesOnProduct.category);
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Validate Saved New Product successfully");

		String description2 = this.productsPage.addProduct(AddProductField.FLAT, "addProductTwoWithDependencies", "ap");
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Add The Product");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Login Into Application And Navigate to Products Tab");

		String productDescription2WithID = this.productsPage.productDescriptionWithID(category2, description2);

		String description3 = this.productsPage.createProductWithDependencies("addProductThreeWithDependencies", "ap",
				productDescriptionWithID, category1, productDescription2WithID, category2);
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Add The Product");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Click on Confioguration tab");

		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Click on Payment Method link");

		String paymentMethodName = this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Add Payment MEthod");

		this.confPage = this.confPage.clickOnAccountTypeLink();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Click on Account type Link");

		String accountType = this.confPage.createAccountTypeWithCreditDetails("accountTypeWithCreditLimit", "atcl", paymentMethodName);
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Add account type");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Click on Customer Tab");

		String customerName = this.customerPage.createCustomerWithPaymentType("AddCustomerWithPaymentCardNew", "acwpc", accountType,
				paymentMethodName);
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Click on Customer Tab");

		this.customerPage = this.customerPage.createOrderWithDependencies("createOrderWithDepencies", "cowd", description2, description3);
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Create Order with Dependencies");

		this.ordersPage = this.ordersPage.verifyParentOrder();
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Verify Parent Icon on Order");

		this.ordersPage = this.ordersPage.editDependenciesOrder(customerName, "One time", description1, "One time");
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.debug("Edit Dependency Order");

		Reporter.log("<br> Test Passed");
		VerifyOrdersWithMandatoryAndOptionalDependencyGetsCreated.logger.exitMethod();

	}
}
