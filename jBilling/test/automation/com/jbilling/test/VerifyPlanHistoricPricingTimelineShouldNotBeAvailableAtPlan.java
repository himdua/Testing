package com.jbilling.test;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddPlanField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan extends BrowserApp {

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

	@Test(description = "TC 185 : Verify that plan historic pricing timeline should not be available at plan creation page")
	public void tc_0185_VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan() throws Exception {

		VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan.logger.debug("Click on Product Menu");

		String categoryName = this.productsPage.addCategory("", "");
		VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan.logger.debug("Add new category");

		String productDescription1 = this.productsPage.addProduct(AddProductField.FLAT, "addProductFlat", "apf");
		VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan.logger.debug("Add new product");

		String productDescription2 = this.productsPage.addProduct(AddProductField.GRADUATED, "addProductGraduated", "apg");
		VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan.logger.debug("Add new product");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan.logger.debug("Click on Plan Menu");

		this.plansPage = this.plansPage
				.addPlan(AddPlanField.HISTORICPLAN, categoryName, productDescription2, "AddPlanwithHistoric", "apwh");
		VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan.logger.debug("Add new plan with historic plan");

		Reporter.log("<br> Test Passed");
		VerifyPlanHistoricPricingTimelineShouldNotBeAvailableAtPlan.logger.exitMethod();
	}
}