package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyCustomerCCNumberMasked extends BrowserApp {
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
	@Test(description = "TC 12.13: Verify a Customer CC number is masked on customer 'Details page' , 'Edit Customer' page and blacklist page.", groups = { "globalRegressionPack" })
	public void tc_0030_verifyCustomerCCNumberMasked() throws Exception {
		VerifyCustomerCCNumberMasked.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCustomerCCNumberMasked.logger.debug("Login Into Application And Navigate to Configuration Page");

		String paymentName = this.confPage.addPaymentMethod("NewPaymentTypeMethod", "ocs", true, true);
		VerifyCustomerCCNumberMasked.logger.debug("Create Payment Mehtod");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCustomerCCNumberMasked.logger.debug("Navigate to Configuration page");

		this.confPage = this.confPage.setConfigurationPreference("setPreferenceValue", "pc");
		VerifyCustomerCCNumberMasked.logger.debug("Set a preference value for ITG invoice Notification");

		String newAccountName = this.confPage.newAccountTypeMethod("CreateNewAccountType", "atcl", paymentName);
		VerifyCustomerCCNumberMasked.logger.debug("Create a New Account");

		this.propReader.updatePropertyInFile("TC_12.13_NewAccountName", newAccountName, "testData");
		VerifyCustomerCCNumberMasked.logger.debug("Add Customer From Existing");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyCustomerCCNumberMasked.logger.debug("Navigate to Customer Page");

		String CustomerName1 = this.customerPage.addCustomerWithMakePayment("CreateCustomer_C", "vp", newAccountName);
		VerifyCustomerCCNumberMasked.logger.debug("Create a new Customer");

		this.propReader.updatePropertyInFile("TC_12.13_NewCustomerName", CustomerName1, "testData");
		VerifyCustomerCCNumberMasked.logger.debug("Add Customer From Existing");

		this.customerPage = this.customerPage.EditCustomerWithPaymentMethod("EditCustomerWithPaymentMethod", "vp", CustomerName1,
				paymentName);
		VerifyCustomerCCNumberMasked.logger.debug("Edit a Customer Detail with payment Detail");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCustomerCCNumberMasked.logger.debug("Navigate to Configuration page");

		this.confPage = this.confPage.verifyBlackListedCustomerWithDetail(CustomerName1);
		VerifyCustomerCCNumberMasked.logger.debug("Verfying Blacklisted Customer");
		Reporter.log("<br> Test Passed");
		VerifyCustomerCCNumberMasked.logger.exitMethod();
	}

	@Test(description = " TC 33: Verify that Proper validation is displayed on deleting the Account type used in any customer.", groups = { "globalRegressionPack" })
	public void tc_0059_verifyValidationDisplayedOnDeletingAccountType() throws Exception {
		VerifyCustomerCCNumberMasked.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCustomerCCNumberMasked.logger.debug("Navigate to Configuration page");

		String newAccountName = this.pr.readTestData("TC_12.13_NewAccountName");
		System.out.println("addedProduct1" + newAccountName);

		this.confPage = this.confPage.deleteAccountTypeUsedMethod(newAccountName);
		VerifyCustomerCCNumberMasked.logger.debug("Verify");
	}

	@Test(description = " TC 28.1: Verify that user is able to import the meta field as AIT which is created under account type at meta field.", groups = { "globalRegressionPack" })
	public void tc_0073_testUserAbleToImportMetaFieldAsAITUnderAccountTypeMeta() throws Exception {
		VerifyCustomerCCNumberMasked.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCustomerCCNumberMasked.logger.debug("Navigate to Configuration page");

		String newAccountName = this.pr.readTestData("TC_12.13_NewAccountName");
		System.out.println("addedProduct1" + newAccountName);

		String accountType = this.confPage.addNewAccountTypeInMetaField("addNewAccountTypeInMetaField", "aitc");
		VerifyCustomerCCNumberMasked.logger.debug("Create New Account type under Metafields");

		this.confPage = this.confPage.importMetafieldsUsingAITWithACCTYPE(newAccountName, accountType);
		VerifyCustomerCCNumberMasked.logger.debug("Create New Account type under Metafields");
	}

	@Test(description = " TC 37: Verify Correct validation should be displayed if user uses invalid input.", groups = { "globalRegressionPack" })
	public void tc_0086_testCorrectValidationUserUsesInvalidInput() throws Exception {
		VerifyCustomerCCNumberMasked.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyCustomerCCNumberMasked.logger.debug("Navigate to Customer Page");

		String newCustomerName = this.pr.readTestData("TC_12.13_NewCustomerName");
		System.out.println("newCustomerName" + newCustomerName);

		String AddedCategory = this.productsPage.addCategorywithGlobal("CreateProductCategoryGlobal", "pcd", true);
		VerifyCustomerCCNumberMasked.logger.debug("Add a Category");

		String Product1 = this.productsPage.addProduct(AddProductField.LINEPERCENTAGEWITHCOMPANY, "addProductWithLinePercentage", "ap");
		VerifyCustomerCCNumberMasked.logger.debug("Create a product1 with global checkbox");

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyCustomerCCNumberMasked.logger.debug("Navigate to Customer Page");

		this.customerPage = this.customerPage.createOrderWithInvalidData(newCustomerName, Product1);
		VerifyCustomerCCNumberMasked.logger.debug("Verify");

	}
}
