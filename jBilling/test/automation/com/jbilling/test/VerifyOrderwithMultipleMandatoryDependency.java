package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyOrderwithMultipleMandatoryDependency extends BrowserApp {
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
	@Test(description = "TC 76.1: Verify, order with multiple mandatory dependency is successfully created", groups = { "globalRegressionPack" })
	public void tc_0133_testOrderwithMultipleMandatoryDependency() throws Exception {
		VerifyOrderwithMultipleMandatoryDependency.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Login Into Application And Navigate to Product Page");

		String AddedCategory = this.productsPage.addCategorywithGlobalCheckbox("CreateProductMobileCategoryGlobal", "pcd");
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Add a Category");

		String addedProduct1 = this.productsPage.addProduct(AddProductField.FLATPRICEWITHGLOBAL, "addProductNokiaFlatPricingGlobal", "ap");
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Add a New Product with Flat Price");

		String ID_addedProduct1 = this.productsPage.getIDAddedProduct(addedProduct1);
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Login Into Application And Navigate to Product Page");

		String AddedCategory1 = this.productsPage.addCategorywithGlobalCheckbox("CreateProductLaptopCategoryGlobal", "pcd");
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Add a Category");

		String addedProduct2 = this.productsPage.addProduct(AddProductField.FLATPRICEWITHGLOBAL, "addProductAccerFlatPricingGlobal", "ap");
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Add a New Product with Flat Price");
		String ID_addedProduct2 = this.productsPage.getIDAddedProduct(addedProduct2);
		String addedProduct3 = this.productsPage.addProduct(AddProductField.FLATPRICEWITHGLOBAL, "addProductDellFlatPricingGlobal", "ap");
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Add a New Product with Flat Price");
		String ID_addedProduct3 = this.productsPage.getIDAddedProduct(addedProduct3);
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Login Into Application And Navigate to Product Page");

		this.productsPage = this.productsPage.editDependencyInProduct("editDependencyInProduct", "efd", AddedCategory1, addedProduct3,
				AddedCategory, ID_addedProduct1, AddedCategory1, ID_addedProduct2);
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Edit a Product with dependency");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Add a Plan with Product Code");

		String addedCustomer = this.customerPage.addCustomerWithMakePayment("CreateCustomer_Dependent", "vp", "Default");
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Added a Customer");

		this.customerPage = this.customerPage.createOrderWithDependency(addedCustomer, addedProduct1, addedProduct3,
				"createOrderWithDependency", "vp", addedProduct2);
		VerifyOrderwithMultipleMandatoryDependency.logger.debug("Verify a Customer");

	}
}
