package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.pageclasses.MessagesPage;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyCreateSellerRootCompany extends BrowserApp {
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

	@Test(description = "Verify that user can create Child Company (Invoice as reseller = Checked) within Root Company", groups = { "globalRegressionPack" })
	public void tc_0364_addSellerCompany() throws Exception {

		VerifyCreateSellerRootCompany.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCreateSellerRootCompany.logger.debug("Click on Configuration page");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Company);
		VerifyCreateSellerRootCompany.logger.debug("Navigate to Company Page");

		this.confPage.CreateSellerCompany("sellerCompany", "seller");
		VerifyCreateSellerRootCompany.logger.debug("Creting Seller company");

		MessagesPage.isIntermediateSuccessMessageAppeared();
		VerifyCreateSellerRootCompany.logger.debug("Verify Message Creting Seller company");

		Reporter.log("<br> Test Passed");
		VerifyCreateSellerRootCompany.logger.exitMethod();
	}
}