package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyDeleteAITType extends BrowserApp {

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
	@Test(description = "TC 347 : Verify that when user check Use In Notification checkbox at AIT metafield page then it is automatically selected at account type", groups = { "globalRegressionPack" })
	public void tc_0347_deleteAIT() throws Exception {
		VerifyDeleteAITType.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyDeleteAITType.logger.debug("Click on Configuration page");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.PaymentMethod);
		VerifyDeleteAITType.logger.debug("Click on Payment Method link");

		this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyDeleteAITType.logger.debug("Add Payment Method");

		String accountTypeName = this.confPage.addAccountType("SingleaddAccountInformationType", "aait");
		VerifyDeleteAITType.logger.debug("Add an Account informationType");

		this.confPage = this.confPage.validateAccountTypeSavedTestData(accountTypeName);
		VerifyDeleteAITType.logger.debug("Validate Added Account type Data");

		String accountName = this.confPage.addAITMetaFieldToAccountType("addAccountInformationType", "aait", accountTypeName);
		this.propReader.updatePropertyInFile("metafield", accountName, "testData");
		VerifyDeleteAITType.logger.debug("Add Metafield to an Account Type");

		this.confPage = this.confPage.validateAccountInformationTypeSavedTestData(accountName);
		VerifyDeleteAITType.logger.debug("VAlidate metaield in an account information type");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.AccountType);
		VerifyDeleteAITType.logger.debug("Naviagate To account Type Page");

		this.confPage.clickRecentlyCreatedAccountType();
		VerifyDeleteAITType.logger.debug("Clicking Recently Customer ");

		this.confPage.clickOnMetafieldID();
		VerifyDeleteAITType.logger.debug("Clicking Recently Customer ");

		this.confPage.clickEditAIT();
		VerifyDeleteAITType.logger.debug("Clicking Edit Account button ");

		this.confPage.clickUserNotification(true);
		VerifyDeleteAITType.logger.debug("Click in Uer Notification ");

		this.confPage.popupYesAit();
		VerifyDeleteAITType.logger.debug("Click Yes in AIT Meta field");

		this.confPage.clickSaveChangesButton();
		VerifyDeleteAITType.logger.debug("Saving MetaField");

		this.confPage.clickDeleteAit();
		VerifyDeleteAITType.logger.debug("Click Delete button");

		this.confPage.clickPopupYes();
		VerifyDeleteAITType.logger.debug("Click  Yes in pop up");

		this.confPage.verifyErrorMessage();
		VerifyDeleteAITType.logger.debug("Verify error message appeared");

		Reporter.log("<br> Test Passed");
		VerifyDeleteAITType.logger.exitMethod();
	}
}