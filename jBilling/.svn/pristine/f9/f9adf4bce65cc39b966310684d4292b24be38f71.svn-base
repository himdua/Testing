package com.jbilling.test;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddPlanField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PaymentMethodField;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyUserIsAbleToAddlDependenciesOnProduct extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";
	static String description2 = "";
	static String paymentMethodName = "";
	static String accountName = "";
	static String customerName = "";
	static String description1 = "";
	static String secondCategory = "";
	static String orderPeriod1 = "";

	@Test(description = "TC 43 : Verify user is able to add mandatory and optional dependencies on product.", priority = 1)
	public void tc_43_verifyUserAbleToAddDependencies() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Products Tab");

		VerifyUserIsAbleToAddlDependenciesOnProduct.category = this.productsPage.addCategory("productCategory", "pcat");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Create A Product Category");

		this.confPage = this.confPage.validateCategoriesSavedTestData(VerifyUserIsAbleToAddlDependenciesOnProduct.category);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Validate Saved New Product successfully");

		String description = this.productsPage.addProduct(AddProductField.GRADUATED, "addProductOneToAddDependencies", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Add The Product");

		String id = this.productsPage.getIDOfAddedProduct();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Get Product ID");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Products Page");

		VerifyUserIsAbleToAddlDependenciesOnProduct.secondCategory = this.productsPage.addCategory("NewProductCategoryData", "pcd");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Create Second Product Category");

		this.confPage = this.confPage.validateCategoriesSavedTestData(VerifyUserIsAbleToAddlDependenciesOnProduct.secondCategory);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Validate Saved New Product successfully");

		VerifyUserIsAbleToAddlDependenciesOnProduct.description1 = this.productsPage.addProduct(AddProductField.FLAT,
				"addProductTwoToAddDependencies", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Add Different Product From Existing");

		String id1 = this.productsPage.getIDOfAddedProduct();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Get Product ID");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Products Page");

		VerifyUserIsAbleToAddlDependenciesOnProduct.description2 = this.productsPage.addProduct(AddProductField.FLAT,
				"addProductThreeToAddDependencies", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Add Different Product From Existing");

		this.productsPage.getIDOfAddedProduct();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Get Product ID");

		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Products Page");

		String productToSelect1 = id1 + " : " + VerifyUserIsAbleToAddlDependenciesOnProduct.description1;
		String productToSelect = id + " : " + description;

		this.productsPage = this.productsPage.editDependencyInProduct("editFirstDependency", "efd",
				VerifyUserIsAbleToAddlDependenciesOnProduct.secondCategory, VerifyUserIsAbleToAddlDependenciesOnProduct.description2,
				VerifyUserIsAbleToAddlDependenciesOnProduct.secondCategory, productToSelect1,
				VerifyUserIsAbleToAddlDependenciesOnProduct.category, productToSelect);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Edit Created Product And Add Dependency");

		this.productsPage.validateDependencySavedTestData(VerifyUserIsAbleToAddlDependenciesOnProduct.description1);
		this.productsPage.validateDependencySavedTestData(description);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verified that dependencies are added in the product");

		// The Product from second category on which dependency is applied
		// should not appear in drop down.
		if (this.productsPage.isProductPresentInTheDropdownForDependency(VerifyUserIsAbleToAddlDependenciesOnProduct.secondCategory,
				productToSelect1) == true) {
			throw new Exception("Test 43 failed as Product on which dependency is applied is still Present ");
		}
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger
				.debug("Verified that Product on which Dependency applied is not present anymore");

		// The Product from first category on which dependency is applied should
		// not appear in drop down.
		if (this.productsPage.isProductPresentInTheDropdownForDependency(VerifyUserIsAbleToAddlDependenciesOnProduct.category,
				productToSelect) == true) {
			throw new Exception("Test 43 failed as Product on which dependency is applied is still Present ");
		}
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger
				.debug("Verified that Product on which Dependency applied is not present anymore");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}

	@Test(description = "TC 62.1 : Create/Edit Plans in System", priority = 2)
	public void tc_62_1_addOrderPeriods() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Configuration Page");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.OrderPeriods);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Select Configuration");

		VerifyUserIsAbleToAddlDependenciesOnProduct.orderPeriod1 = this.confPage.createNewOrderPeriod("yearlyOrderPeriod", "op");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Configuring First Order period");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Period", "created successfully", TextComparators.contains);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verify Text:Order Period Is Created Successfully");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}

	@Test(description = "TC 62.2 : Create/Edit Plans in System", dependsOnMethods = { "tc_43_verifyUserAbleToAddDependencies",
			"tc_62_1_addOrderPeriods" }, priority = 3)
	public void tc_62_2_addPlans() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Plans Page");

		this.plansPage = this.plansPage.addPlan(AddPlanField.ALL, VerifyUserIsAbleToAddlDependenciesOnProduct.category,
				VerifyUserIsAbleToAddlDependenciesOnProduct.description2, "addplan62.2", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Processing To Add Plans");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new plan", "successfully", TextComparators.contains);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verify Text:Saved new plan Successfully");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}

	@Test(description = "TC 62.3 : Create/Edit Plans in System", dependsOnMethods = { "tc_43_verifyUserAbleToAddDependencies",
			"tc_62_1_addOrderPeriods" }, priority = 4)
	public void tc_62_3_addPlans() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Plans Page");

		this.plansPage = this.plansPage.addPlan(AddPlanField.PRODUCT, VerifyUserIsAbleToAddlDependenciesOnProduct.category,
				VerifyUserIsAbleToAddlDependenciesOnProduct.description2, "addplan62.3", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Processing To Add Plans");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new plan", "successfully", TextComparators.contains);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verify Text:Saved new plan Successfully");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}

	@Test(description = "TC 62.3.i : Create/Edit Plans in System", dependsOnMethods = { "tc_43_verifyUserAbleToAddDependencies",
			"tc_62_1_addOrderPeriods" }, priority = 5)
	public void tc_62_3_1_addPlans() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Plans Page");

		this.plansPage = this.plansPage.addPlan(AddPlanField.BUNDLEDPERIOD, VerifyUserIsAbleToAddlDependenciesOnProduct.category,
				VerifyUserIsAbleToAddlDependenciesOnProduct.description2, "addplan62.3.1", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Processing To Add Plans");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new plan", "successfully", TextComparators.contains);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verify Text:Saved new plan Successfully");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}

	@Test(description = "TC 62.4 : Create/Edit Plans in System", dependsOnMethods = { "tc_43_verifyUserAbleToAddDependencies",
			"tc_62_1_addOrderPeriods" }, priority = 6)
	public void tc_62_4_addPlans() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Plans Page");

		String planName = this.plansPage.addPlan(AddPlanField.PLANPERIOD, VerifyUserIsAbleToAddlDependenciesOnProduct.category,
				VerifyUserIsAbleToAddlDependenciesOnProduct.description2, VerifyUserIsAbleToAddlDependenciesOnProduct.orderPeriod1,
				"TC_62.4_addplan", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Processing To Add Plans");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new plan", "successfully", TextComparators.contains);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verify Text:Saved new plan Successfully");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}

	@Test(description = "TC 62.5 : Create/Edit Plans in System", dependsOnMethods = { "tc_43_verifyUserAbleToAddDependencies",
			"tc_62_1_addOrderPeriods" }, priority = 7)
	public void tc_62_5_addPlans() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Plans Page");

		String planName = this.plansPage.addPlan(AddPlanField.MULTIPLEPLAN, VerifyUserIsAbleToAddlDependenciesOnProduct.category,
				VerifyUserIsAbleToAddlDependenciesOnProduct.description2, VerifyUserIsAbleToAddlDependenciesOnProduct.orderPeriod1,
				"TC_62.5_addplan", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Processing To Add Plans");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new plan", "successfully", TextComparators.contains);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verify Text:Saved new plan Successfully");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}

	@Test(description = "TC 62.6 : Create/Edit Plans in System", dependsOnMethods = { "tc_43_verifyUserAbleToAddDependencies",
			"tc_62_1_addOrderPeriods" }, priority = 8)
	public void tc_62_6_addPlans() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Login Into Application And Navigate to Plans Page");

		String planName = this.plansPage.addPlan(AddPlanField.WITHNOTE, VerifyUserIsAbleToAddlDependenciesOnProduct.category,
				VerifyUserIsAbleToAddlDependenciesOnProduct.description2, VerifyUserIsAbleToAddlDependenciesOnProduct.orderPeriod1,
				"TC_62.6_addplan_a", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Processing To Add Plans");

		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Plans Page");

		this.plansPage = this.plansPage.addPlan(AddPlanField.WITHNOTE, VerifyUserIsAbleToAddlDependenciesOnProduct.category,
				VerifyUserIsAbleToAddlDependenciesOnProduct.description2, "TC_62.6_addplan_b", "ap");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Processing To Add Plans");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new plan", "successfully", TextComparators.contains);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verify Text:Saved new plan Successfully");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}

	@Test(description = "TC 102 : Verify that orders with mandatory and optional dependency gets created.", dependsOnMethods = { "tc_43_verifyUserAbleToAddDependencies" }, priority = 6)
	public void tc_102_verifyOrderesWithMandatoryAndOptionalDependency() throws Exception {

		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate to Configuration Page");

		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.PaymentMethod);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Select Configuration Payment Method Type");

		VerifyUserIsAbleToAddlDependenciesOnProduct.paymentMethodName = this.paymentsPage.addPaymentMethodWithoutMetaFields(
				PaymentMethodField.ALL, "TC102_addPaymentMethod", "apm");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Add Payment Method for Card");

		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type ", "created successfully", TextComparators.contains);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Verify Message For Created Account Type");

		this.confPage = this.confPage.validatePeriodsSavedTestData(VerifyUserIsAbleToAddlDependenciesOnProduct.paymentMethodName);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Validate Saved Account Type Test Data");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Select Configuration");

		// Add First Account Type
		VerifyUserIsAbleToAddlDependenciesOnProduct.accountName = this.accountTypePage.createAccountTypeWithCreditDetails(
				"TC102_AddAccountType", "aat", VerifyUserIsAbleToAddlDependenciesOnProduct.paymentMethodName);

		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Navigate To Customers Page");

		VerifyUserIsAbleToAddlDependenciesOnProduct.customerName = this.customerPage.addCustomer(
				VerifyUserIsAbleToAddlDependenciesOnProduct.accountName, VerifyUserIsAbleToAddlDependenciesOnProduct.paymentMethodName,
				"TC_102_NewCustomer", "nc");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Add a New Customer");

		this.ordersPage = this.customerPage.selectCustomerToAddOrder(VerifyUserIsAbleToAddlDependenciesOnProduct.customerName);
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Select Customer And Click Create Order");

		// Complete The Process To Create The Order For The Customer
		this.ordersPage = this.ordersPage.addOrder(VerifyUserIsAbleToAddlDependenciesOnProduct.description2,
				VerifyUserIsAbleToAddlDependenciesOnProduct.description1, "TC_102_AddOrder", "ao");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.debug("Create The Order For The Customer");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToAddlDependenciesOnProduct.logger.exitMethod();
	}
}
