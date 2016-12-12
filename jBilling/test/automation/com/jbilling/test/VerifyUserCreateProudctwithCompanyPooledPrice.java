package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddPlanField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserCreateProudctwithCompanyPooledPrice extends BrowserApp {
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
	@Test(description = "TC 81: Verify that user is able to create product with Company Pooled Pricing", groups = { "globalRegressionPack" })
	public void tc_0137_verifyUserCreateProudctwithCompanyPooledPrice() throws Exception {
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Login Into Application And Navigate to Product Page");

		String AddedCategory = this.productsPage.addCategory("CreateProductCategoryPool", "pcd");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a Category");

		String productCategory1 = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithFlatPricingPool", "ap");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a Product with Description");

		String productCategory2 = this.productsPage.addProduct(AddProductField.COMPANYPOOLED, "addProductWithCompanyPooled", "ap");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a Product with Description");

		String productCategory3 = this.productsPage.addProduct(AddProductField.COMPANYPOOLED, "addProductWithCompanyPooled2", "ap");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a Product with Description");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Navigate to Plan Page");

		this.plansPage = this.plansPage.addPlan(AddPlanField.INCLUDEQUANTITY, AddedCategory, productCategory1, "addplanPooledPrice1", "ap");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Navigate to Customer Page");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a Plan with Product Code");

		String CustomerName = this.customerPage.addCustomerWithMakePayment("CreateCustomer", "vp", "Default");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a Parent Customer");

		System.out.println("CustomerName" + CustomerName);
		String ChildCustomer1 = this.customerPage.addSubCustomer("Default", "CreateChildCustomer1", "vp", CustomerName);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a child Customer1");

		String ChildCustomer2 = this.customerPage.addSubCustomer("Default", "CreateChildCustomer2", "vp", CustomerName);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a child Customer1");

		this.customerPage = this.customerPage.createOrderWithCustomer("CreateOrderWithChildCustomer1", "vp", ChildCustomer1);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Create a order with child Customer1");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Navigate to Customer Page");

		this.customerPage = this.customerPage.createOrderWithCustomer("CreateOrderWithChildCustomer2", "vp", ChildCustomer2);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Create a order with child Customer1");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Navigate to Customer Page");

		this.customerPage = this.customerPage.selectCustomerwithCreateOrder("SelectCustomerwithCreateOrder", "vp", ChildCustomer2);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Update the order for Customer2");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Navigate to Customer Page");

		this.customerPage = this.customerPage.selectCustomerwithCreateOrder("SelectCustomerwithCreateOrder1", "vp", ChildCustomer1);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Update the order for Customer2");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Created new order", "successfully", TextComparators.contains);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Verify Message for Add product Successfully");
		// return ChildCustomer2;
		Reporter.log("<br> Test Passed");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.exitMethod();
	}

	@Test(description = "TC 81.2: Verify that PercentageStrategy pricing functionality works correctly.", dependsOnMethods = "tc_137_verifyUserCreateProudctwithCompanyPooledPrice")
	public void tc_0139_verifyPercentageStrategyPricingFucntionality() throws Exception {
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Login Into Application And Navigate to Product Page");

		String productCategory1 = this.productsPage.addProduct(AddProductField.FLAT_PERCENTAGE, "addProductWithPercentagePricing", "ap");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a Product with Description");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Navigate to Customer Page");

		String CustomerName = this.customerPage.addCustomerWithMakePayment("CreateCustomer1", "vp", "Default");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Add a Parent Customer");

		this.customerPage = this.customerPage.selectCustomerwithCreateOrder("CreateOrderWithCustomer", "vp", CustomerName);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Create a order with child Customer1");

		this.ordersPage = this.customerPage.editOrderForCustomer("EdirOrderWithCustomer", "vp");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Create a order with child Customer1");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Updated order", "successfully", TextComparators.contains);
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.debug("Verify Message for Updated Successfully");

		Reporter.log("<br> Test Passed");
		VerifyUserCreateProudctwithCompanyPooledPrice.logger.exitMethod();
	}
}
