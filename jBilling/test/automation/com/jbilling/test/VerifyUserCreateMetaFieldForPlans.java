package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserCreateMetaFieldForPlans extends BrowserApp {
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
	@Test(description = "TC 86: Verify user can create meta-fields for plans.", groups = { "globalRegressionPack" })
	public void tc_144_verifyUserCreateMetaFieldForPlans() throws Exception {
		VerifyUserCreateMetaFieldForPlans.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCreateMetaFieldForPlans.logger.debug("Login Into Application And Navigate to Product Page");

		String AddedCategory = this.productsPage.addCategorywithGlobal("addCategory1CustomerMetaFields", "acopc", true);
		VerifyUserCreateMetaFieldForPlans.logger.debug("Add a Category");

		String AddedCategory2 = this.productsPage.addCategoryWithOneItemPerOrder("addCategory2CustomerMetaFields", "acopc", true);
		VerifyUserCreateMetaFieldForPlans.logger.debug("Add a Category");

		String productCategory1 = this.productsPage.addProductwithGlobal("addProductWithGlobalMeta", "ap", true);
		VerifyUserCreateMetaFieldForPlans.logger.debug("Add a Product with Description");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserCreateMetaFieldForPlans.logger.debug(" Navigate to Product Page");

		String PlanName = this.plansPage.addPlanwithMetaFields(AddedCategory, AddedCategory2, productCategory1,
				"addPlanWithProductMetaField", "ap", true);
		VerifyUserCreateMetaFieldForPlans.logger.debug("Add a Plan for mulitple prouct");

		this.plansPage = this.plansPage.editPlanForMetaField("addPlanWithProductUpdateMetaField", "ap");
		VerifyUserCreateMetaFieldForPlans.logger.debug("Add a Plan with Updated Meta Fields");

		Reporter.log("<br> Test Passed");
		VerifyUserCreateMetaFieldForPlans.logger.exitMethod();

	}
}
