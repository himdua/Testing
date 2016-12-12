package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserCreateMultiplePlan extends BrowserApp {
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
	@Test(description = "TC 84: Verify user can create multiple plan", groups = { "globalRegressionPack" })
	public void tc_0142_verifyUserCreateMultiplePlan() throws Exception {
		VerifyUserCreateMultiplePlan.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCreateMultiplePlan.logger.debug("Login Into Application And Navigate to Product Page");

		String AddedCategory = this.productsPage.addCategorywithGlobal("CreateProductCategoryGlobal", "pcd", true);
		VerifyUserCreateMultiplePlan.logger.debug("Add a Category");

		String Product1 = this.productsPage.addProduct(AddProductField.FLAT_DATE, "addProductwithFlatDate1", "ap");
		VerifyUserCreateMultiplePlan.logger.debug("Create a product1 with global checkbox");

		String Product2 = this.productsPage.addProduct(AddProductField.FLAT_DATE, "addProductwithFlatDate2", "ap");
		VerifyUserCreateMultiplePlan.logger.debug("Create a product2 with global checkbox");

		String Product3 = this.productsPage.addProduct(AddProductField.FLAT_DATE, "addProductwithFlatDate3", "ap");
		VerifyUserCreateMultiplePlan.logger.debug("Create a product3 with global checkbox");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserCreateMultiplePlan.logger.debug("Add a Plan with Product Code");

		String CustomerName = this.customerPage.addCustomerWithMakePayment("CreateCustomer1", "vp", "Default");
		VerifyUserCreateMultiplePlan.logger.debug("Add a Parent Customer");

		this.customerPage = this.customerPage.createOrderwithActiveSince("CreateOrderwithActiveSinceDate", "vp", CustomerName, Product1);
		VerifyUserCreateMultiplePlan.logger.debug("Create a order with child Customer1");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Created new order", "successfully", TextComparators.contains);
		VerifyUserCreateMultiplePlan.logger.debug("Verify Message for Add product Successfully");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserCreateMultiplePlan.logger.debug("Add a Plan with Product Code");

		this.customerPage = this.customerPage.createOrderwithoutQuantity("CreateOrderwithoutQuantity", "vp", CustomerName, Product2);
		VerifyUserCreateMultiplePlan.logger.debug("Create a order with child Customer1");

		Reporter.log("<br> Test Passed");
		VerifyUserCreateMultiplePlan.logger.exitMethod();
	}
}
