package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddMetaDataFields;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserSearch_FilterforAssetMetaField extends BrowserApp {
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
	@Test(description = "TC 47: Verify that user is able to search/filter for created asset meta field", groups = { "globalRegressionPack" })
	public void tc_0047testUserSearch_FilterforAssetMetaField() throws Exception {
		VerifyUserSearch_FilterforAssetMetaField.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Login Into Application And Navigate to Configuration Page");

		this.confPage = this.confPage.clickOnAssetOption();
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Navigate to Metafields and Click on Asset");

		String MetaField1 = this.confPage.setNewMetaData(AddMetaDataFields.DATA_DEFAULT_VALUE, "AddAssetInMetaField", "MDN");
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Create a New Asset");

		String MetaField2 = this.confPage.setNewMetaData(AddMetaDataFields.NewAssetMetafield, "AddBooleanAssetInMetaField", "MDN");
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Create a New Asset");

		String MetaField3 = this.confPage.setNewMetaData(AddMetaDataFields.NewAssetMetafieldWITHOUTDEFAULT, "AddDateAssetInMetaField",
				"MDN");
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Create a New Asset");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Navigate to Product Page");

		String AddedCategory = this.productsPage.addProductCategoryWithAssetManagement("CreateCategoryWithAssetManagement", "ap",
				MetaField1, MetaField2, MetaField3);
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Create a Category with Asset Management");

		String AddedProduct = this.productsPage.addProduct(AddProductField.ADDPRODUCTWITHASSETMANAGEMENT, "addProductWithAssetManagement",
				"ap");
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Create a product with Asset Management");

		String productAsset1 = this.productsPage.addAssetForProduct("addAssetFor1Product", "ap", true);
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Create a Asset for Product");

		String productAsset2 = this.productsPage.addAssetForProductWithStringDataType("addStringAssetFor1Product", "ap", true);
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Create a String Type Asset for Product");
		/*
		 * String productAsset3 =
		 * this.productsPage.addAssetForProductWithDateDataType
		 * ("addStringAssetFor1Product", "ap", true);
		 * VerifyUserSearch_FilterforAssetMetaField
		 * .logger.debug("Create a Date Type Asset for Product");
		 */

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("Navigate to Customer Page");

		String addedCustomer = this.customerPage.addCustomerWithMakePayment("CreateAssetCustomer", "vp", "Default");
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("create a new customer");

		this.customerPage = this.customerPage.createOrderWithMetaField("CreateAOrderWithMetaField", "vp", addedCustomer, AddedProduct,
				MetaField1, MetaField2, MetaField3);
		VerifyUserSearch_FilterforAssetMetaField.logger.debug("create a Order with Meta Fields");

		Reporter.log("<br> Test Ends Here");

	}
}
