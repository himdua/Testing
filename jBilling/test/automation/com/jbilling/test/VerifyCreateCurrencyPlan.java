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

public class VerifyCreateCurrencyPlan extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
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
	 * @since 1.0
	 * @version 1.0
	 */

	@Test(description = "TC_360 Verify, correct currency in UI is displayed while creating plan with 'Euro Currency'", groups = { "globalRegressionPack" })
	public void tc_0360_createCurrencyPlan() throws Exception {
		VerifyCreateCurrencyPlan.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyCreateCurrencyPlan.logger.debug("Clicking in Recent Order Button");

		String category = this.productsPage.addCategory("productCategory", "pcat");
		VerifyCreateCurrencyPlan.logger.debug("Adding Category");

		String product = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductFresh", "prod");
		VerifyCreateCurrencyPlan.logger.debug("Adding Product ");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyCreateCurrencyPlan.logger.debug("Adding Plan in to it");

		String PlanDesc = this.plansPage.addPlanWithDifferentCurrency(category, product, "addplanwithdiffer", "currplan");
		this.propReader.updatePropertyInFile("TC_360_planDescription", PlanDesc, "testData");
		VerifyCreateCurrencyPlan.logger.debug("Add Plan in to it");

		this.msgsPage.verifyDisplayedMessageText("Saved new plan ", "successfully", TextComparators.contains);
		VerifyCreateCurrencyPlan.logger.debug("Save Plan");

		Reporter.log("<br> Test Passed");
		VerifyCreateCurrencyPlan.logger.exitMethod();
	}
}
