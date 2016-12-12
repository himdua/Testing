package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddPlanField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserCreateMultiplePlanwithDifferentPrecedence extends BrowserApp {
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
	@Test(description = "TC 146:Verify that user is able to create multiple plan with diffrerent precedences and dependency", groups = { "globalRegressionPack" })
	public void tc_0146_testUserCreateMultiplePlanwithDifferentPrecedence() throws Exception {
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Login Into Application And Navigate to Product Page");

		// Click Add Category button

		String AddedCategory = this.productsPage.addCategory("CreateProductCategoryServices", "pcd");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Category");

		// Click Add Product Button and Add a product
		String productCategory1 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithNameSMS", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Product with Description");

		String productCategory2 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithNameGPRS", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Product with Description");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Login Into Application And Navigate to Product Page");

		String AddedCategory1 = this.productsPage.addCategory("CreateProductCategoryMSISDN", "pcd");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Category");

		String productCategory3 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithNameMSISDN", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Product with Description");

		String productCategory4 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithNameMSISDN_2", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Product with Description");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Login Into Application And Navigate to Product Page");

		String AddedCategory2 = this.productsPage.addCategory("CreateProductCategoryTarrifPlans", "pcd");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Category");

		String productCategory5 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithNameSMS1", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Product with Description");

		String productCategory6 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithNameEU", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Product with Description");

		String productCategory7 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithNameSMS2", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Product with Description");

		String productCategory8 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithNameConnectionFee", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Product with Description");

		// Login Into Application And Navigate to Product Tab
		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Login Into Application And Navigate to Product Page");

		// Create a Plan for Multiple product
		this.plansPage = this.plansPage
				.addPlan(AddPlanField.FLATPRICE, AddedCategory, productCategory1, "addPlanWithMultipleProduct", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Plan for mulitple prouct");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Login Into Application And Navigate to Product Page");

		this.plansPage = this.plansPage.addPlan(AddPlanField.ONEPRODUCT, AddedCategory, productCategory6, "AddPlanwithSingleProduct", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Plan for mulitple prouct");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Login Into Application And Navigate to Product Page");

		this.plansPage = this.plansPage.addPlan(AddPlanField.FLATPRICEWITHRATE, AddedCategory, productCategory7,
				"addPlanWithRateMultipleProduct", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Plan for mulitple prouct");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Login Into Application And Navigate to Product Page");
		this.plansPage = this.plansPage.addPlan(AddPlanField.FLATPRICEWITHFOURPRODUCT, AddedCategory, productCategory3,
				"addPlanWithThreeProduct", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Plan for mulitple prouct");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Login Into Application And Navigate to Product Page");

		this.plansPage = this.plansPage.addPlan(AddPlanField.NEWPLANWITHDATE, AddedCategory, productCategory1, "AddPlanwithDate", "ap");
		VerifyUserCreateMultiplePlanwithDifferentPrecedence.logger.debug("Add a Plan for mulitple prouct");

		Reporter.log("<br> Test Ends Here");

	}
}
