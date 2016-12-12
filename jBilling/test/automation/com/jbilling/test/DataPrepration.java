package com.jbilling.test;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

/**
 * Current Application Page Stack || LoginPage--> loginPage; NavigatorPage-->
 * navPage; HomePage--> homePage; ConfigurationPage--> confPage; AgentsPage-->
 * agentsPage; CustomersPage--> customerPage; ProductsPage--> productsPage;
 * PlansPage--> plansPage; OrdersPage--> ordersPage; InvoicePage--> invoicePage;
 * ReportsPage--> reportsPage; DiscountsPage--> discountsPage; FiltersPage-->
 * filtersPage; PaymentsPage--> paymentsPage; MessagesPage--> msgsPage;
 *
 * @author Shanky
 * @since 1.0
 * @version 1.0
 */
@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class DataPrepration extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 145 : Data Prepration (Nested Plan)")
	public void dataPrepration() throws Exception {

		DataPrepration.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.plansPage = this.navPage.navigateToPlanPage();
		DataPrepration.logger.debug("Click on Plan Menu");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String categoryName1 = this.productsPage.addCategory("addCategory1", "ac");
		DataPrepration.logger.debug("Add Category");

		String productDescription1 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct1", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String productDescription2 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct2", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String categoryName2 = this.productsPage.addCategory("addCategory2", "ac");
		DataPrepration.logger.debug("Add Category");

		String productDescription3 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct3", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String productDescription4 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct4", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String categoryName3 = this.productsPage.addCategory("addCategory3", "ac");
		DataPrepration.logger.debug("Add Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String categoryName4 = this.productsPage.addCategory("addCategory4", "ac");
		DataPrepration.logger.debug("Add Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String categoryName5 = this.productsPage.addCategory("addCategory5", "ac");
		DataPrepration.logger.debug("Add Category");

		String productDescription5 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct5", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String productDescription6 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct6", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String productDescription7 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct7", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String productDescription8 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct8", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String productDescription9 = this.productsPage.addProduct(AddProductField.FLAT, "addProduct9", "ap");
		DataPrepration.logger.debug("Add Product in Category");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String productDescriptionWithID = this.productsPage.productDescriptionWithID(categoryName5, productDescription8);

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String categoryDescriptionWithID1 = this.productsPage.categoryDescriptionWithID(categoryName2);
		DataPrepration.logger.debug("Get category name with ID");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		String categoryDescriptionWithID2 = this.productsPage.categoryDescriptionWithID(categoryName3);
		DataPrepration.logger.debug("Get category name with ID");

		this.productsPage = this.navPage.navigateToProductsPage();
		DataPrepration.logger.debug("Click on Configuration Menu");

		this.productsPage = this.productsPage
				.editProduct("editProduct", "ep", productDescription9, productDescriptionWithID, categoryName5);
		DataPrepration.logger.debug("Edit Product");

		this.confPage = this.navPage.navigateToConfigurationPage();
		DataPrepration.logger.debug("Click on Configuration");

		this.confPage = this.confPage.ClickOnOrderChangeTypeLink();
		DataPrepration.logger.debug("click on order status type link");

		this.confPage = this.confPage
				.addOrderStatusType("orderStatusType_1", "ost", categoryDescriptionWithID1, categoryDescriptionWithID2);
		DataPrepration.logger.debug("Add order status type");

		this.confPage = this.confPage
				.addOrderStatusType("orderStatusType_2", "ost", categoryDescriptionWithID1, categoryDescriptionWithID2);
		DataPrepration.logger.debug("Add order status type");

		Reporter.log("<br> Test Passed");
		DataPrepration.logger.exitMethod();

	}
}
