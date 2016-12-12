package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyOrderConfigureAtAccountType extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	String ProductID = "null";
	String ChildCustomer2;
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
	 * @author Aishwarya Dwivedi
	 * @since 1.0
	 * @version 1.0
	 */
	@Test(description = "TC 20: Verify that while creating order,product rate must be displayed same in order line as configured at account type", groups = { "globalRegressionPack" })
	public void tc_0056_testOrderConfigureAtAccountType() throws Exception {
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.navPage.navigateToConfigurationPage();
		this.confPage.ClickOnCurrencyLink();
		String defaultCurrency = this.confPage.getDefaultCurrencyValue();
		this.confPage.setCurrency("Dollar_currencyName", "cn");

		// Login Into Application And Navigate to Product Page
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrderConfigureAtAccountType.logger.debug("Navigate to Product Page");

		String addedCategory = this.productsPage.addCategorywithGlobalCheckbox("CreateProductWithGlobalCheckbox", "pcd");
		VerifyOrderConfigureAtAccountType.logger.debug("Add a New Category");

		String addedProduct1 = this.productsPage
				.addProduct(AddProductField.FLATPRICEWITHCURRENTCOMPANY, "addProductWithFlatPricing1", "ap");
		VerifyOrderConfigureAtAccountType.logger.debug("Add a New Product with Flat Price");

		this.propReader.updatePropertyInFile("TC_56_AddedProduct", addedProduct1, "testData");
		VerifyOrderConfigureAtAccountType.logger.debug("Add Product From Existing");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyOrderConfigureAtAccountType.logger.debug("Navigate to configuration page");

		String addedAccount = this.confPage.addAccountType("TC20_NewAccountTypeName", "ea");
		VerifyOrderConfigureAtAccountType.logger.debug("Create a New Account Type");

		this.propReader.updatePropertyInFile("TC_56_AddedPaymentType", addedAccount, "testData");
		VerifyOrderConfigureAtAccountType.logger.debug("Add Customer From Existing");

		this.confPage = this.confPage.addAccountTypePriceToSelectedProductWithCategory(addedProduct1, addedCategory, addedAccount,
				"CreateAPriceInAccountType", "ea");
		VerifyOrderConfigureAtAccountType.logger.debug("Add a Price in Product and Category");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyOrderConfigureAtAccountType.logger.debug("Navigate to Customer Page");

		String addedCustomer = this.customerPage.addCustomerWithMakePayment("CreateCustomerConfiguredAtAccountType", "vp", addedAccount);
		VerifyOrderConfigureAtAccountType.logger.debug("Create a Customer");

		this.propReader.updatePropertyInFile("TC_56_AddedCustomer", addedCustomer, "testData");
		VerifyOrderConfigureAtAccountType.logger.debug("Add Customer From Existing");

		this.customerPage = this.customerPage.createOrderWithReviewTab("createOrderWithReviewTab", "vp", addedCustomer, addedProduct1);
		VerifyOrderConfigureAtAccountType.logger.debug("Create a order with flat price product");

	}

	@Test(description = "TC 57: Verify no special pricing for product is applied beyond expiry date.", groups = { "globalRegressionPack" })
	public void tc_0057_testSpecialPriceAppliedBeyondExpiryDate() throws Exception {
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyOrderConfigureAtAccountType.logger.debug("Navigate to Customer Page");
		String addedCustomer = this.pr.readTestData("TC_56_AddedCustomer");

		System.out.println(addedCustomer);
		String addedProduct1 = this.pr.readTestData("TC_56_AddedProduct");
		System.out.println("addedProduct1" + addedProduct1);

		this.customerPage = this.customerPage.createOrderWithReviewTab("createOrderBeyondExpiryDate", "vp", addedCustomer, addedProduct1);
		VerifyOrderConfigureAtAccountType.logger.debug("Create a order with flat price product");

		Reporter.log("<br> Test Passed");
		VerifyOrderConfigureAtAccountType.logger.exitMethod();
	}

	@Test(description = "TC 61: Verify that user is able to create order with line percentage product", groups = { "globalRegressionPack" })
	public void tc_0061_testUserCreateOrderWithLinePercentageProduct() throws Exception {

		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Product Page
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrderConfigureAtAccountType.logger.debug("Navigate to Product Page");

		String addedCategory = this.productsPage.addCategorywithGlobalCheckbox("CreateCatgeoryForLinePercentageProduct", "pcd");
		VerifyOrderConfigureAtAccountType.logger.debug("Add a New Category");

		String addedProduct1 = this.productsPage
				.addProduct(AddProductField.FLATPRICEWITHCURRENTCOMPANY, "addProductWithFlatPricing2", "ap");
		VerifyOrderConfigureAtAccountType.logger.debug("Add a New Product with Flat Price");

		String addedProduct2 = this.productsPage
				.addProduct(AddProductField.LINEPERCENTAGEWITHCOMPANY, "addProductWithLinePercentage", "ap");
		VerifyOrderConfigureAtAccountType.logger.debug("Add a New Product with Line Percantage");

		String addedCustomer = this.pr.readTestData("TC_56_AddedCustomer");
		System.out.println(addedCustomer);

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyOrderConfigureAtAccountType.logger.debug("Navigate to Customer Page");

		this.customerPage = this.customerPage.createOrderWithMulitpleProduct("createOrderWithMulitpleProduct", "vp", addedCustomer,
				addedProduct1, addedProduct2);
		VerifyOrderConfigureAtAccountType.logger.debug("Create a Order with Line Percantage product");

	}

	@Test(description = "TC 72: Verify that user can add information timeline with the created customer.", groups = { "globalRegressionPack" })
	public void tc_0072_testUserCanAddInformationTimelineWithCreatedCustomer() throws Exception {
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyOrderConfigureAtAccountType.logger.debug("Navigate to configuration page");

		String addedPaymentType = this.pr.readTestData("TC_56_AddedPaymentType");
		System.out.println("addedPaymentType" + addedPaymentType);

		String infoType = this.confPage.addAITInPaymemntType("AIT_AccountPaymentMethod", "aitc", addedPaymentType);
		VerifyOrderConfigureAtAccountType.logger.debug("Create a Add Information Type in AccountType");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyOrderConfigureAtAccountType.logger.debug("Navigate to Customer Page");

		String addedCustomer = this.pr.readTestData("TC_56_AddedCustomer");
		System.out.println(addedCustomer);

		this.customerPage = this.customerPage.addTimelineInformationWithCreatedCustomer("addTimelineInformationWithCreatedCustomer", "vp",
				addedCustomer);

		VerifyOrderConfigureAtAccountType.logger.debug("Create a Add Information Type in AccountType");
	}
}
