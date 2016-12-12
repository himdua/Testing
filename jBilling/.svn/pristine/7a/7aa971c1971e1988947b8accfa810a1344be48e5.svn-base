package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.SetEnumValues;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyUserCanAddUserCodes extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
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
	 * @author Shanky
	 * @since 1.0
	 * @version 1.0
	 */

	@Test(description = "TC 102 : Verify that orders with mandatory and optional dependency gets created. ")
	public void TC_67_VerifyUserCanAddUserCodes() throws Exception {

		VerifyUserCanAddUserCodes.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserCanAddUserCodes.logger.debug("Click on Configuration Menu");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Users);
		VerifyUserCanAddUserCodes.logger.debug("Click on Users option");

		String userName = this.confPage.createUser("CreateUser", "cu");
		VerifyUserCanAddUserCodes.logger.debug("Create users");

		this.confPage = this.confPage.setPermission("UserPermissions", "up", userName);
		VerifyUserCanAddUserCodes.logger.debug("Set User code permissions");

		String userNameCode = this.confPage.enterUserCode("UserData", "ud", userName);
		VerifyUserCanAddUserCodes.logger.debug("Enter user code");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserCanAddUserCodes.logger.debug("Click on Configuration Menu");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Enumerations);
		VerifyUserCanAddUserCodes.logger.debug("Click on Enumerations option");

		String enumerationName = this.confPage.addEnumerations(SetEnumValues.ONE, "addEnumerations", "ae");
		VerifyUserCanAddUserCodes.logger.debug("Add Enumerations");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserCanAddUserCodes.logger.debug("Click on Configuration Menu");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Users);
		VerifyUserCanAddUserCodes.logger.debug("Click on Users option");

		String editedUserCode = this.confPage.editUserCode("editUserCode", "euc", userName, userNameCode);
		VerifyUserCanAddUserCodes.logger.debug("Edit User Code");

		this.confPage = this.confPage.verifyUserCode(editedUserCode);
		VerifyUserCanAddUserCodes.logger.debug("Verify USer Code after editing");

		VerifyUserCanAddUserCodes.logger.exitMethod();
		Reporter.log("<br> Test Passed");

	}
}
