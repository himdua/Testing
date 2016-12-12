package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyAccountTypeNotification extends BrowserApp {

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
	@Test(description = "TC 346: Verify that when user check Use In Notification checkbox at AIT metafield page then it is automatically selected at account type", groups = { "globalRegressionPack" })
	public void tc_0346_addAITMetafieldToAccountType() throws Exception {

		VerifyAccountTypeNotification.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyAccountTypeNotification.logger.debug("Click on Configuration page");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyAccountTypeNotification.logger.debug("Click on Payment Method link");

		this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyAccountTypeNotification.logger.debug("Add Payment Method");

		String accountTypeName = this.confPage.addAccountType("SingleaddAccountInformationType", "aait");
		VerifyAccountTypeNotification.logger.debug("Add an Account informationType");

		this.confPage = this.confPage.validateAccountTypeSavedTestData(accountTypeName);
		VerifyAccountTypeNotification.logger.debug("Validate Added Account type Data");

		String accountName = this.confPage.addAITMetaFieldToAccountType("addAccountInformationType", "aait", accountTypeName);
		this.propReader.updatePropertyInFile("metafield", accountName, "testData");
		VerifyAccountTypeNotification.logger.debug("Add Metafield to an Account Type");

		this.confPage = this.confPage.validateAccountInformationTypeSavedTestData(accountName);
		VerifyAccountTypeNotification.logger.debug("VAlidate metaield in an account information type");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyAccountTypeNotification.logger.debug("Naviagate To account Type Page");

		this.confPage.clickRecentlyCreatedAccountType();
		VerifyAccountTypeNotification.logger.debug("Clicking Recently Customer ");

		this.confPage.clickOnMetafieldID();
		VerifyAccountTypeNotification.logger.debug("Clicking Recently Customer ");

		this.confPage.clickEditAIT();
		VerifyAccountTypeNotification.logger.debug("Clicking Edit Account button ");

		this.confPage.clickUserNotification(true);
		VerifyAccountTypeNotification.logger.debug("Click in Uer Notification ");

		this.confPage.popupYesAit();
		VerifyAccountTypeNotification.logger.debug("Click Yes in AIT Meta field");

		this.confPage.clickSaveChangesButton();
		VerifyAccountTypeNotification.logger.debug("Saving MetaField");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyAccountTypeNotification.logger.debug("Naviagate To account Type Page");

		this.confPage.clickRecentlyCreatedAccountType();
		VerifyAccountTypeNotification.logger.debug("Clicking Recently Account Type  ");

		this.confPage.clickEditAccountTypeButton();
		VerifyAccountTypeNotification.logger.debug("Clicking Edit Account Type Button ");

		this.confPage.verifyDropdownIncludeinNotifications(accountName);
		VerifyAccountTypeNotification.logger.debug("Verify dropdown value");

		Reporter.log("<br> Test Passed");
		VerifyAccountTypeNotification.logger.exitMethod();
	}
}