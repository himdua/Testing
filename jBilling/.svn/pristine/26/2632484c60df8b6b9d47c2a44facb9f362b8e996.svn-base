package com.jbilling.framework.pageclasses;

import java.math.BigDecimal;

import org.testng.Assert;

import com.jbilling.framework.globals.GlobalController;
import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.interfaces.ElementField;
import com.jbilling.framework.interfaces.LocateBy;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.EditOrder;
import com.jbilling.framework.utilities.textutilities.TextUtilities;
import com.jbilling.framework.utilities.xmlutils.TestData;

public class OrdersPage {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@LocateBy(xpath = "//table[@id='orders']//strong[contains(text(),'customera')]")
	private ElementField TAB_ORDER;

	@LocateBy(xpath = "//span[text()='Delete']")
	private ElementField LT_DELETE;

	@LocateBy(xpath = "//span[text()='Yes']")
	private ElementField LT_CONFIRM_YES;

	@LocateBy(xpath = "//table[@id='orders']/tbody/tr")
	private ElementField TAB_ORDERS_ROWS;

	@LocateBy(xpath = "//a[@class='submit order']/span[text()='Generate Invoice']")
	private ElementField BTN_GENERATE_INVOICE;

	@LocateBy(xpath = "//label[text()='Active Since']/../div/input")
	private ElementField TB_ACTIVEDATE;

	@LocateBy(xpath = "//div[@class = 'btn-box']/div/a/span")
	private ElementField BT_PAYINVOICE;

	@LocateBy(xpath = "//label[text()='Effective Date']/../div/input")
	private ElementField TB_EFFECTIVE_DATE;

	@LocateBy(xpath = "//select[@id='orderPeriod']")
	private ElementField DD_PERIOD;

	@LocateBy(xpath = "//select[@id='billingTypeId']")
	private ElementField DD_TYPE;

	@LocateBy(xpath = "//li[@aria-controls='ui-tabs-products']/a")
	private ElementField LT_PRODUCTS;

	@LocateBy(xpath = "//input[@id='filterBy']")
	private ElementField TB_FILTER_PRODUCTS_BY;

	@LocateBy(xpath = "//table[@id='products']")
	private ElementField TAB_PRODUCTS;

	@LocateBy(xpath = "//table[@id='products']/tbody//td/a/strong")
	private ElementField TAB_LIST_PRODUCT;

	@LocateBy(xpath = "//table[@id='orders']/tbody//td/a/strong")
	private ElementField TAB_LIST_ORDER;

	@LocateBy(xpath = "//strong[text()='Billing Graduated']")
	private ElementField TAB_PRODUCTS_GRADUATED;

	@LocateBy(xpath = "//strong[text()='Billing Flat']")
	private ElementField TAB_PRODUCTS_FLAT;

	@LocateBy(xpath = "//label[text()='Quantity']/../div/input")
	private ElementField TB_QUANTITY;

	@LocateBy(xpath = "//div[@id='messages']/div/ul/li")
	private ElementField TXT_VALIDATION_MESSAGE;

	@LocateBy(xpath = "//span[text()='Dependency']")
	private ElementField LT_DEPENDENCY_BUTTON;

	@LocateBy(xpath = "//div[@id='breadcrumbs']")
	private ElementField BREADCRUMBS;

	@LocateBy(xpath = "//strong[text()='Installation Fee']")
	private ElementField TAB_DEPENDENT_PRODUCT;

	@LocateBy(xpath = "//span[text()='Current order']")
	private ElementField LT_CURRENT_ORDER;

	@LocateBy(xpath = "//span[contains(text(),'Update')]")
	private ElementField LT_UPDATE;

	@LocateBy(xpath = "(//span[contains(text(),'Update')])[2]")
	private ElementField LT_UPDATE_;

	@LocateBy(xpath = "//li[@aria-controls='ui-tabs-discounts']/a")
	private ElementField LT_DISCOUNTS;

	@LocateBy(xpath = "//select[@id='discount.0.id']")
	private ElementField DD_DISCOUNTS;

	@LocateBy(xpath = "//select[@id='discountableItem.0.lineLevelDetails']")
	private ElementField DD_DISCOUNTABLEITEM;

	@LocateBy(xpath = "//a[text()='Review']")
	private ElementField LT_REVIEW;

	@LocateBy(xpath = "//span[text()='Save Changes']")
	private ElementField LT_SAVECHANGES;

	@LocateBy(xpath = "//select[@id = 'billingTypeId']")
	private ElementField DD_ORDER;

	@LocateBy(name = "asset.select.0")
	private ElementField CHK_SIM;

	@LocateBy(xpath = "//a[text()='Add Selected']")
	private ElementField LT_ADDSELECTED;

	@LocateBy(xpath = "//a[text()='Add to Order']")
	private ElementField LT_ADDORDER;

	@LocateBy(xpath = "//li[@aria-controls='ui-tabs-Provisioning']/a")
	private ElementField LT_PROVISIONTAB;

	@LocateBy(xpath = "//a[text()='Provisioning']")
	private ElementField LT_PROVISION;

	@LocateBy(xpath = "//span[text()='Generate Invoice']")
	private ElementField BT_INVOICE;

	@LocateBy(xpath = "//table[@id='orders']/tbody/tr//td[2]/a/strong")
	private ElementField TAB_ORDERS;

	@LocateBy(xpath = "//div[@class='row']/a[contains(@href,'downloadPdf')]")
	private ElementField LT_DOWNLOADPDF;

	@LocateBy(xpath = "//table[@id='orders']/tbody/tr/td/a/strong")
	private ElementField TAB_LIST_CUSTOMER_NAME;

	@LocateBy(xpath = "//span[text()='Edit this Order']")
	private ElementField BT_EDIT_ORDER;

	@LocateBy(xpath = "//ul[@id='review-lines']/form")
	private ElementField INLINE_ORDER;

	@LocateBy(xpath = "//span[text()='Change']")
	private ElementField BT_CHANGE;

	@LocateBy(xpath = "//span[text()='Add Asset']")
	private ElementField LT_ADDASSET;

	@LocateBy(xpath = "//input[@id='identifier']")
	private ElementField TB_IDENTIFIER;

	@LocateBy(xpath = "//span[text()='Create Asset']")
	private ElementField BT_CREATE_ASSET;

	@LocateBy(xpath = "//ul[@class='top-nav']/li[1]")
	private ElementField COMPANY;

	@LocateBy(xpath = "//select[@id='company-select']")
	private ElementField DD_COMPANY;

	@LocateBy(xpath = "//form[@id='save-asset-form']/fieldset//div[@class='buttons']/ul/li//a[@class='submit save']")
	private ElementField SAVE_CHANGE_ON_ASSET;

	@LocateBy(name = "//span[text()='Add to Order']")
	private ElementField BT_ADDORDER;

	@LocateBy(xpath = "//div[@id = 'review-messages']/div/ul/li")
	private ElementField MSG_REVIEW_ERRRO;

	@LocateBy(xpath = "//a[text()='Line Changes']")
	private ElementField LT_LINE_CHANGES;

	@LocateBy(xpath = "//table[contains(@id,'dependencies-products-change')]/tbody//td/a/strong")
	private ElementField TAB_LIST_DEPENDENCY_PRODUCT;

	@LocateBy(xpath = "//button/span[text()='New SubOrder']")
	private ElementField BT_NEW_SUB_ORDER;

	@LocateBy(xpath = "//label[text()='Apply Now']/preceding-sibling::input[@class='cb check']")
	private ElementField CB_APPLY_NOW;

	@LocateBy(xpath = "//td[text()='Active Since:']/following::td[1]")
	private ElementField ACTIVE_SINCE_VALUE;

	@LocateBy(xpath = "(//table[@class='innerTable'])[2]/tbody/tr/td[3]")
	private ElementField ORDER_QUANTITY_VALUE;

	@LocateBy(xpath = "(//table[@class='innerTable'])[2]/tbody/tr/td[4]")
	private ElementField ORDER_PRICE_VALUE;

	@LocateBy(xpath = "(//table[@class='innerTable'])[2]/tbody/tr/td[5]")
	private ElementField ORDER_TOTAL_VALUE;

	@LocateBy(xpath = "(//table[@class='innerTable'])/tbody/tr/td[3]")
	private ElementField ORDER_QUANTITY;

	@LocateBy(xpath = "(//table[@class='innerTable'])/tbody/tr/td[4]")
	private ElementField ORDER_PRICE;

	@LocateBy(xpath = "(//table[@class='innerTable'])/tbody/tr/td[5]")
	private ElementField ORDER_TOTAL;

	@LocateBy(xpath = "(//td[text()='Type:']/following-sibling::td")
	private ElementField TYPE_ON_ORDER_SLIP;

	@LocateBy(xpath = "(//*[@id='column2']/div/div[2]/div/table[2]/tbody/tr[6]/td[2]")
	private ElementField PERIOD_ON_ORDER_SLIP;

	@LocateBy(xpath = "//a[contains(text(),'Show all orders')]")
	private ElementField SHOW_ALL_ORDER_LINK;

	@LocateBy(xpath = "(//table[@id='orders']/tbody/tr/td/a/strong")
	private ElementField TAB_ORDER1;

	@LocateBy(xpath = "((//div[@class='column-hold']//div[@class='heading']/strong)[1]")
	private ElementField ORDER_FORM;

	@LocateBy(xpath = "(//thead/tr/th/a")
	private ElementField ORDER_HEARDER;

	@LocateBy(xpath = "(//img[@alt='parent'])[1]")
	private ElementField PARENT_IMAGE;

	@LocateBy(xpath = "(//img[@alt='parent'])[1]/following-sibling::span")
	private ElementField CHILD_COUNT;

	@LocateBy(xpath = "(//img[@alt='child'])[1]")
	private ElementField CHILD_IMAGE;

	@LocateBy(xpath = "(//span[text()='Edit this Order'])[1]")
	private ElementField BT_PARENT_EDIT_TO_ORDER;

	@LocateBy(xpath = "//a[contains(text(),'Suborders')]")
	private ElementField SUBORDER_TAB;

	@LocateBy(xpath = "//table[@id='suborders']/tbody/tr/td/a/strong")
	private ElementField TAB_SUBORDER;

	@LocateBy(xpath = "//span[text()='Show']")
	private ElementField BT_SHOW;

	@LocateBy(xpath = "//label[text()='Parent order']/following-sibling::span")
	private ElementField LT_PARENT_ID;

	@LocateBy(xpath = "//span[text()='Current order']")
	private ElementField BT_CURRENT_ORDER;

	@LocateBy(xpath = "//table[@class='innerTable']/tbody/tr[2]")
	private ElementField TAB_PARENT_ORDER_ROW;

	@LocateBy(xpath = "//table[starts-with(@id,'dependencies-products')]/tbody/tr/td/a/strong")
	private ElementField TAB_DEPENDENCY_PRODUCT;

	@LocateBy(xpath = "//table[@id='orders']/tbody/tr[2]/td/a/strong")
	private ElementField PARENT_ICON_ORDER;

	@LocateBy(xpath = "//a[contains(text(),'Products')]")
	private ElementField PRODUCT_TAB;

	@LocateBy(xpath = "//table[starts-with(@id,'dependencies-child-orders')]/tbody/tr/td/a/strong")
	private ElementField TAB_DEPENDENCY_SUBORDER;

	@LocateBy(xpath = "//ul[@id='review-lines']/form/li[1]")
	private ElementField REVIEW_TAB_PRODUCT;

	@LocateBy(xpath = "//a[contains(text(),'Change Log')]")
	private ElementField CHANGE_LOG_TAB;

	@LocateBy(xpath = "//table[@id='orderChanges']/tbody/tr/td/strong")
	private ElementField TAB_ORDER_CHANGE;

	@LocateBy(xpath = "(//label[text()='Status']/../select)[2]")
	private ElementField DD_STATUS;

	@LocateBy(xpath = "//div[@class='total']")
	private ElementField TOTAL_PRICE;

	@LocateBy(xpath = "//a[contains(text(),'Status')]/following::td[4]")
	private ElementField PRODUCT_STATUS;

	@LocateBy(xpath = "//label[contains(text(),'Use default product price & description')]/../input[2]")
	private ElementField CB_USE_DEFAULT_PRODUCT_PRICE;

	@LocateBy(xpath = "(//label[text()='Description']/../div/input)[2]")
	private ElementField TB_DESCTIPTON;

	@LocateBy(xpath = "//span[@class='description']")
	private ElementField ORDER_LINE_DESCRIPTION;

	@LocateBy(xpath = "//label[text()='Price']/../div/input")
	private ElementField TB_PRICE;

	@LocateBy(xpath = "(//span[text()='Change'])[3]")
	private ElementField BT_CHANGE_REVIEW_TAB;

	/**
	 * This method will select Successful payment
	 */
	OrdersPage selectSuccessfulOrders() throws Exception {
		GlobalController.brw.clickLinkText(this.TAB_LIST_CUSTOMER_NAME);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Delete Button
	 *
	 * @throws Exception
	 */
	OrdersPage clickDelete() throws Exception {
		OrdersPage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.LT_DELETE);

		OrdersPage.logger.exitMethod();
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Delete Button
	 *
	 * @throws Exception
	 */
	OrdersPage clickConfirmYes() throws Exception {
		OrdersPage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.LT_CONFIRM_YES);

		OrdersPage.logger.exitMethod();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	OrdersPage clickFirstRowOnOrdersTable() throws Exception {
		OrdersPage.logger.enterMethod();
		GlobalController.brw.clickTableCellWithText(this.TAB_ORDERS, "Ashish");
		OrdersPage.logger.exitMethod();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	OrdersPage clickTextOnOrdersTable(String text) throws Exception {
		OrdersPage.logger.enterMethod();
		GlobalController.brw.selectListItem(this.TAB_ORDERS, text);
		OrdersPage.logger.exitMethod();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	public OrdersPage clickGenerateInvoice() throws Exception {
		GlobalController.brw.clickLinkText(this.BTN_GENERATE_INVOICE);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	// /////////////////////
	/**
	 * This method will click Add New button
	 */
	OrdersPage setCurrentActiveSinceDate() throws Exception {
		GlobalController.brw.setcurrentDate(this.TB_ACTIVEDATE);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will select period
	 *
	 * @throws Exception
	 */
	OrdersPage selectPeriod(String period) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PERIOD, period);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click products tab within orders form
	 *
	 * @throws Exception
	 */
	OrdersPage clickProductsTabinOrdersForm() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PRODUCTS);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	OrdersPage filterProducts(String textForProductFiltering) throws Exception {
		ElementField efTbForFiltering = this.TB_FILTER_PRODUCTS_BY;
		GlobalController.brw.setText(efTbForFiltering, textForProductFiltering.replace(" ", "_"));
		GlobalController.brw.pressTab(efTbForFiltering);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on product
	 *
	 * @throws Exception
	 */
	OrdersPage selectProduct(String product) throws Exception {
		this.filterProducts(product);
		GlobalController.brw.selectListItem(this.TAB_LIST_PRODUCT, product);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on order
	 *
	 * @throws Exception
	 */
	OrdersPage selectOrder(String order) throws Exception {
		this.filterProducts(order);
		GlobalController.brw.selectListItem(this.TAB_LIST_ORDER, order);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Update Button
	 *
	 * @throws Exception
	 */
	OrdersPage clickUpdate() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_UPDATE);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Update Button
	 *
	 * @throws Exception
	 */
	OrdersPage click_Update() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_UPDATE_);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Discounts Tab
	 *
	 * @throws Exception
	 */
	OrdersPage clickDiscountsTabinOrdersForm() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_DISCOUNTS);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will select Discount
	 *
	 * @throws Exception
	 */
	OrdersPage selectDiscount(String discount) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_DISCOUNTS, discount);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will select Discountable Item
	 *
	 * @throws Exception
	 */
	OrdersPage selectDiscountableItem(String discountItem) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_DISCOUNTABLEITEM, discountItem);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Review Tab
	 *
	 * @throws Exception
	 */
	OrdersPage clickReviewTab() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_REVIEW);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Save Changes Button
	 *
	 * @throws Exception
	 */
	OrdersPage clickSaveChanges() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_SAVECHANGES);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will select period
	 *
	 * @throws Exception
	 */
	OrdersPage selectOrderType(String order) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_ORDER, order);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will set quantity
	 *
	 * @param rate
	 * @throws Exception
	 */
	OrdersPage setQuantity(String quantity) throws Exception {
		GlobalController.brw.setText(this.TB_QUANTITY, quantity);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will check SIM checkbox
	 *
	 * @param rememberMe
	 * @throws Exception
	 */
	OrdersPage checkSIM(Boolean SIM) throws Exception {
		if (SIM) {
			GlobalController.brw.check(this.CHK_SIM);
		} else {
			GlobalController.brw.uncheck(this.CHK_SIM);
		}
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Add Selected button
	 *
	 * @throws Exception
	 */
	OrdersPage clickAddSelectedButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDSELECTED);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Add to order button
	 *
	 * @throws Exception
	 */
	OrdersPage clickAddToOrderButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDORDER);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Provisioning Button
	 *
	 * @throws Exception
	 */
	public OrdersPage clickProvisioningButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PROVISION);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on Provisioning Tab
	 *
	 * @throws Exception
	 */
	public OrdersPage clickProvisioningTab() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PROVISIONTAB);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will generate invoice
	 *
	 * @throws Exception
	 */

	OrdersPage generateInvoice() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_INVOICE);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will verify generated invoice
	 *
	 * @throws Exception
	 */
	OrdersPage verifyGeneratedInvoice() throws Exception {
		MessagesPage.isIntermediateSuccessMessageAppeared();
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will set Default Date
	 *
	 * @throws Exception
	 */
	OrdersPage setActiveSinceDateDefault(String activeDate) throws Exception {
		GlobalController.brw.setText(this.TB_ACTIVEDATE, activeDate);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method clicks on pay invoice button
	 *
	 * @throws Exception
	 */
	InvoicePage clickPayInvoice() throws Exception {
		GlobalController.brw.click(this.BT_PAYINVOICE);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method will click on product
	 *
	 * @throws Exception
	 */
	OrdersPage selectProductGraduated() throws Exception {
		GlobalController.brw.clickLinkText(this.TAB_PRODUCTS_GRADUATED);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	InvoicePage downloadPdf() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_DOWNLOADPDF);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method will click on product
	 *
	 * @throws Exception
	 */
	OrdersPage selectProductFlat() throws Exception {
		GlobalController.brw.clickLinkText(this.TAB_PRODUCTS_FLAT);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	protected String isInvoiceGenerationSuccessful() throws Exception {
		String msgToVerify = "successfully generated invoice for order";
		return MessagesPage.isOperationSuccessfulOnMessage(msgToVerify, TextComparators.contains);
	}

	/**
	 * This method will select type
	 *
	 * @throws Exception
	 */
	OrdersPage selectType(String type) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_TYPE, type);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	OrdersPage clickDependencyButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_DEPENDENCY_BUTTON);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will select dependent Product
	 *
	 * @param depandentProduct
	 * @throws Exception
	 */
	OrdersPage selectDependentProduct(String depandentProduct) throws Exception {
		GlobalController.brw.clickLinkText(this.TAB_DEPENDENT_PRODUCT);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on current Order button
	 *
	 * @throws Exception
	 */
	OrdersPage clickCurrentOrder() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_CURRENT_ORDER);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on Edit This Order button
	 *
	 * @throws Exception
	 */
	OrdersPage clickEditThisOrderBtn() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_EDIT_ORDER);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on In line Order
	 *
	 * @throws Exception
	 */
	OrdersPage clickInlineOrder() throws Exception {
		GlobalController.brw.clickLinkText(this.INLINE_ORDER);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Change button
	 *
	 * @throws Exception
	 */
	OrdersPage clickChangeBtn() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_CHANGE);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Add Asset button
	 *
	 * @throws Exception
	 */
	OrdersPage addAssetBtn() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDASSET);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage verifyErrorMessage(String message) throws Exception {
		String msg = GlobalController.brw.getText(this.MSG_REVIEW_ERRRO);
		if (TextUtilities.contains(msg, message)) {
			Assert.assertTrue(true);
		} else {
			throw new Exception("Test Case failed: ");
		}
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on Line Changes Tab
	 *
	 * @throws Exception
	 */
	OrdersPage clickLineChangesTab() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_LINE_CHANGES);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Dependency Product
	 *
	 * @throws Exception
	 */
	OrdersPage selectDependencyProduct(String product) throws Exception {
		GlobalController.brw.waitForElement(this.TAB_LIST_DEPENDENCY_PRODUCT, 2000);
		GlobalController.brw.selectListItem(this.TAB_LIST_DEPENDENCY_PRODUCT, product);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This Method will click on New Sub Order Button
	 *
	 * @return
	 * @throws Exception
	 */
	OrdersPage clickNewSubOrder() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_NEW_SUB_ORDER);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This Method will add Metafield
	 *
	 * @param paitad
	 * @throws Exception
	 */
	protected ConfigurationPage verifyApplyNowCheckBox() throws Exception {
		String attributeValue = GlobalController.brw.getAttribute(this.CB_APPLY_NOW, "type");
		if (attributeValue.equals("checkbox") == false) {
			throw new Exception("Apply Now is " + attributeValue + " It is not a check box");
		}
		return GlobalController.brw.initElements(ConfigurationPage.class);
	}

	public OrdersPage createOrder(String testDataSetName, String category, String discount) throws Exception {
		OrdersPage.logger.enterMethod();
		String period = TestData.read("PageOrders.xml", testDataSetName, "period", category);
		String discountItem = TestData.read("PageOrders.xml", testDataSetName, "discountItem", category);
		String product = TestData.read("PageOrders.xml", testDataSetName, "product", category);

		this.setCurrentActiveSinceDate();
		this.selectPeriod(period);
		this.clickProductsTabinOrdersForm();
		this.selectProduct(product);
		this.clickUpdate();
		this.clickDiscountsTabinOrdersForm();
		this.selectDiscount(discount);
		this.clickReviewTab();
		this.clickSaveChanges();
		OrdersPage.logger.exitMethod();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	public OrdersPage verifyInvoiceGenerationForChoosenCustomer(String customerName) throws Exception {
		System.out.println("SYSO Customer Name For Target:::::" + customerName);
		OrdersPage.logger.debug("Customer Name For Target:::::" + customerName);
		this.clickTextOnOrdersTable(customerName);
		this.clickGenerateInvoice();
		String msg = this.isInvoiceGenerationSuccessful();
		if (msg != null) {
			throw new Exception("Invoice has not been generated successfully. Message: " + msg);
		}
		// TODO. FIXIT: downloadPdf does not work, because the icon for test
		// company is absent
		// this.downloadPdf();

		return GlobalController.brw.initElements(OrdersPage.class);
	}

	public OrdersPage deleteOrders() throws Exception {
		this.selectSuccessfulOrders();
		// this.clickDelete();
		// this.clickConfirmYes();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will verify breadcrumbs ui component
	 *
	 * @throws Exception
	 */
	public OrdersPage verifyUIComponent() throws Exception {
		GlobalController.brw.verifyUIComponent(this.BREADCRUMBS);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on Create Asset Button
	 *
	 * @param depandentProduct
	 * @throws Exception
	 */
	protected OrdersPage clickOnCreateAssetButton() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_CREATE_ASSET);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	protected OrdersPage assetDetails(String identifier) throws Exception {
		GlobalController.brw.setText(this.TB_IDENTIFIER, identifier);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	protected OrdersPage selectCurrentCompany() throws Exception {
		String company = GlobalController.brw.getText(this.COMPANY);
		GlobalController.brw.selectDropDown(this.DD_COMPANY, company);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Add to order button on add Asset pop-up
	 *
	 * @throws Exception
	 */
	protected OrdersPage clickOnAddToOrderButton() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_ADDORDER);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will set Default Date
	 *
	 * @throws Exception
	 */
	protected OrdersPage setEffectiveDatDefault(String effectiveDate) throws Exception {
		GlobalController.brw.setText(this.TB_EFFECTIVE_DATE, effectiveDate);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will set current Default Date
	 *
	 * @author shanky
	 * @throws Exception
	 */
	protected OrdersPage setCurrentEffectiveDatDefault() throws Exception {
		GlobalController.brw.setcurrentDate(this.TB_EFFECTIVE_DATE);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on Save Changes Button
	 *
	 * @throws Exception
	 */
	protected OrdersPage clickSaveChangesOnNewAssetPage() throws Exception {
		GlobalController.brw.clickLinkText(this.SAVE_CHANGE_ON_ASSET);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will verify updated order
	 *
	 * @throws Exception
	 */
	OrdersPage verifyUpdateOrder() throws Exception {
		MessagesPage.isIntermediateSuccessMessageAppeared();
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	public void addAssetInOrder(String testDataSetName, String category) throws Exception {
		String identifier = TestData.read("PageCustomers.xml", testDataSetName, "identifier1", category);
		String effectiveDate = TestData.read("PageCustomers.xml", testDataSetName, "order", category);
		this.addAssetBtn();
		this.clickOnCreateAssetButton();
		this.assetDetails(identifier);
		this.selectCurrentCompany();
		this.clickSaveChangesOnNewAssetPage();
		this.clickOnAddToOrderButton();
		this.setEffectiveDatDefault(effectiveDate);
		this.clickUpdate();
		this.clickReviewTab();
		this.clickSaveChanges();
		this.verifyUpdateOrder();

	}

	public void editOrder() throws Exception {
		this.selectCurrentCompany();
		this.clickEditThisOrderBtn();
		this.clickInlineOrder();
		this.clickChangeBtn();

	}

	public OrdersPage addOrder(String product, String dependencyProduct, String testDataSetName, String category) throws Exception {
		OrdersPage.logger.enterMethod();

		String message = TestData.read("PageOrders.xml", testDataSetName, "message", category);

		this.clickProductsTabinOrdersForm();
		this.selectProduct(product);
		this.clickUpdate();
		this.clickReviewTab();
		this.clickSaveChanges();
		this.verifyErrorMessage(message);
		this.clickLineChangesTab();
		this.clickDependencyButton();
		this.selectDependencyProduct(dependencyProduct);
		this.clickNewSubOrder();
		this.verifyApplyNowCheckBox();
		this.clickUpdate();
		this.clickSaveChanges();
		OrdersPage.logger.exitMethod();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	public OrdersPage verifySubOrderActiveSinceDate(String parentOrderActiveDate, String subOrderActiveDate) throws Exception {
		if (parentOrderActiveDate.equals(subOrderActiveDate)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		return GlobalController.brw.initElements(OrdersPage.class);

	}

	public OrdersPage verifySubOrderActiveSinceDate(String order) throws Exception {
		String parentOrderActiveDate = this.getActiveSinceValue();
		this.selectCreatedOrder(order);
		String childOrderActiveDate = this.getActiveSinceValue();
		this.verifySubOrderActiveSinceDate(parentOrderActiveDate, childOrderActiveDate);

		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on order
	 *
	 * @throws Exception
	 */
	OrdersPage selectCreatedOrder(String order) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_LIST_ORDER, order);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will get Active Since Date
	 *
	 * @throws Exception
	 */
	public String getActiveSinceValue() throws Exception {
		String acticeSince = GlobalController.brw.getText(this.ACTIVE_SINCE_VALUE);
		return acticeSince;
	}

	BigDecimal getDecimalValue(ElementField textElement) throws Exception {
		String strValue = GlobalController.brw.getText(textElement);
		return new BigDecimal(strValue.replaceAll("[^\\d.,]+", "")).setScale(3);
	}

	BigDecimal calcualteTotalPrice(BigDecimal quantity, BigDecimal price) {
		return quantity.multiply(price).setScale(3);
	}

	/**
	 * this method will verify applied total on the order
	 *
	 * @author shanky
	 * @throws Exception
	 */
	public void verifyAppliedTotalOnOrder() throws Exception {
		BigDecimal quantity = this.getDecimalValue(this.ORDER_QUANTITY_VALUE);
		BigDecimal price = this.getDecimalValue(this.ORDER_PRICE_VALUE);
		BigDecimal expectedTotal = this.getDecimalValue(this.ORDER_TOTAL_VALUE);
		BigDecimal actualTotal = this.calcualteTotalPrice(quantity, price);
		Assert.assertEquals(actualTotal, expectedTotal);
	}

	/**
	 * This methos will verify user is successfully direct on the order page
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	public OrdersPage verifyOrderPage() throws Exception {
		GlobalController.brw.isElementPresent(this.ORDER_HEARDER);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will verify Applied total on order first Line
	 *
	 * @author shanky
	 * @throws Exception
	 */
	public void verifyAppliedTotalOnOrderFirstLine() throws Exception {
		BigDecimal quantity = this.getDecimalValue(this.ORDER_QUANTITY);
		BigDecimal price = this.getDecimalValue(this.ORDER_PRICE);
		BigDecimal expectedTotal = this.getDecimalValue(this.ORDER_TOTAL);
		BigDecimal actualTotal = this.calcualteTotalPrice(quantity, price);
		Assert.assertEquals(actualTotal, expectedTotal);
	}

	/**
	 * This method will edit the created order
	 *
	 * @author shanky
	 * @param testDataSetName
	 * @param category
	 * @param customerName
	 * @return
	 * @throws Exception
	 */
	public OrdersPage editCreartedOrder(String testDataSetName, String category, String customerName) throws Exception {
		String period = TestData.read("PageOrders.xml", testDataSetName, "period", category);
		String type = TestData.read("PageOrders.xml", testDataSetName, "type", category);

		this.selectCreatedOrder(customerName);
		this.clickEditThisOrderBtn();
		this.selectPeriod(period);
		this.selectOrderType(type);
		this.clickSaveChanges();
		this.verifyUpdateOrder();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * this method will verify created Parent Image
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage verifyParentImage() throws Exception {
		GlobalController.brw.isElementPresent(this.PARENT_IMAGE);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will verify the child count value
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage verifyChildCount() throws Exception {
		GlobalController.brw.isElementPresent(this.CHILD_COUNT);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will verify the child Image
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage verifyChildImage() throws Exception {
		GlobalController.brw.isElementPresent(this.CHILD_IMAGE);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will verify the created Parent order
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	public OrdersPage verifyParentOrder() throws Exception {

		this.verifyParentImage();
		this.verifyChildCount();
		this.verifyChildImage();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on the parent Icon order
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	public OrdersPage clickOnParentIconOrder() throws Exception {
		GlobalController.brw.clickLinkText(this.PARENT_ICON_ORDER);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on the Edit this order for parent button
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	public OrdersPage clickOnEditThisOrderForParent() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_PARENT_EDIT_TO_ORDER);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * this method will click on the Suborder Tab
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	public OrdersPage clickOnSuborderTab() throws Exception {
		GlobalController.brw.clickLinkText(this.SUBORDER_TAB);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will select sub order
	 *
	 * @author shanky
	 * @param orderPeriod
	 * @return
	 * @throws Exception
	 */
	public OrdersPage SelectSubOrder(String orderPeriod) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_SUBORDER, orderPeriod);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on the Show button
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	public OrdersPage clickOnShowButton() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_SHOW);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on the parent ID Link
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	public OrdersPage clickOnParentIDLink() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PARENT_ID);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will select dependency Product
	 *
	 * @author shanky
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage selectDependecyProduct(String productName) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_DEPENDENCY_PRODUCT, productName);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will select dependency sub product
	 *
	 * @author shanky
	 * @param SubproductName
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage selectDependecySubProduct(String SubproductName) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_DEPENDENCY_SUBORDER, SubproductName);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on the current order Button
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	public OrdersPage clickOnCurrentOrderButon() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_CURRENT_ORDER);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on Product Tab
	 *
	 * @author shanky
	 * @param depandentProduct
	 * @throws Exception
	 */
	protected OrdersPage clickOnProductTab() throws Exception {
		GlobalController.brw.clickLinkText(this.PRODUCT_TAB);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on the product review tab
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage clickOnProductInReviewTab() throws Exception {
		GlobalController.brw.clickLinkText(this.REVIEW_TAB_PRODUCT);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will edir Order Dependencies
	 *
	 * @author shanky
	 * @param customerName
	 * @param period
	 * @param productName
	 * @param SubproductName
	 * @return
	 * @throws Exception
	 */
	public OrdersPage editDependenciesOrder(String customerName, String period, String productName, String SubproductName) throws Exception {
		this.clickOnParentIconOrder();
		this.clickOnEditThisOrderForParent();
		this.clickOnSuborderTab();
		this.SelectSubOrder(period);
		this.clickOnShowButton();
		this.clickOnParentIDLink();
		this.clickOnProductInReviewTab();
		this.clickDependencyButton();
		this.selectDependecyProduct(productName);
		this.selectDependecySubProduct(SubproductName);
		this.clickOnCurrentOrderButon();
		this.clickUpdate();
		this.clickSaveChanges();
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will click on the Change log Tab
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage clickOnChangeLogTab() throws Exception {
		GlobalController.brw.clickLinkText(this.CHANGE_LOG_TAB);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will verify product reflected in order change table
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected OrdersPage verifyOrderChangeProductInTable() throws Exception {
		GlobalController.brw.isElementPresent(this.TAB_ORDER_CHANGE);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will Select Value from Status dropdown
	 *
	 * @author Shanky
	 * @param statusName
	 * @return
	 * @throws Exception
	 */
	public OrdersPage selectStatus(String statusName) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_STATUS, statusName);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will get total Price of Product
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	public String getTotalPrice() throws Exception {
		String totalPrice[] = GlobalController.brw.getText(this.TOTAL_PRICE).split("€");
		return totalPrice[1];
	}

	/**
	 * This method will verify product price
	 *
	 * @author Shanky
	 * @param actualPrice
	 * @param expectedPrice
	 * @return
	 * @throws Exception
	 */
	public OrdersPage verifyProductPrice(String actualPrice, String expectedPrice) throws Exception {
		Assert.assertEquals(actualPrice, expectedPrice);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will get the product status
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	public String getProductStatus() throws Exception {
		String productStatus = GlobalController.brw.getText(this.PRODUCT_STATUS);
		return productStatus;
	}

	/**
	 * This method will verify the product Status
	 *
	 * @author Shanky
	 * @param actualStatus
	 * @param expectedStatus
	 * @return
	 * @throws Exception
	 */
	public OrdersPage verifyProductStatus(String actualStatus, String expectedStatus) throws Exception {
		Assert.assertEquals(actualStatus, expectedStatus);
		return GlobalController.brw.initElements(OrdersPage.class);
	}

	/**
	 * This method will check Use Default Product Price and Description checkbox
	 *
	 * @author Shanky
	 * @param rememberMe
	 * @throws Exception
	 */
	OrdersPage unCheckUseDefaultProductPrice(Boolean defaultProductPrice) throws Exception {
		if (defaultProductPrice) {
			GlobalController.brw.check(this.CB_USE_DEFAULT_PRODUCT_PRICE);
		} else {
			GlobalController.brw.uncheck(this.CB_USE_DEFAULT_PRODUCT_PRICE);
		}
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method is use to set Plan Description
	 *
	 * @author Shanky
	 * @param description
	 * @return
	 * @throws Exception
	 */
	OrdersPage setDescription(String description) throws Exception {
		GlobalController.brw.setText(this.TB_DESCTIPTON, description);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method is use to set Price
	 *
	 * @author Shanky
	 * @param price
	 * @return
	 * @throws Exception
	 */
	OrdersPage setPrice(String price) throws Exception {
		GlobalController.brw.setText(this.TB_PRICE, price);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will return description described on order line
	 *
	 * @return
	 * @throws Exception
	 */
	public String getDescriptionOnOrderLine() throws Exception {
		String description[] = GlobalController.brw.getText(this.ORDER_LINE_DESCRIPTION).trim().split("\\(");
		System.out.println(description[0]);
		return description[0];

	}

	/**
	 * This method will verify the order line Description
	 *
	 * @Shanky
	 * @param actualDescription
	 * @param expectedDescription
	 * @return
	 * @throws Exception
	 */
	OrdersPage verifyOrderLineDescription(String actualDescription, String expectedDescription) throws Exception {
		Assert.assertEquals(actualDescription, expectedDescription);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will verify total price
	 *
	 * @param actualprice
	 * @param expectedPrice
	 * @return
	 * @throws Exception
	 */
	OrdersPage verifyTotalPrice(String actualprice, String expectedPrice) throws Exception {
		Assert.assertEquals(actualprice, expectedPrice);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	/**
	 * This method will click on Change button on Review tab
	 *
	 * @return
	 * @throws Exception
	 */
	OrdersPage clickOnChnageBtnOnReviewTab() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_CHANGE_REVIEW_TAB);
		return GlobalController.brw.initElements(OrdersPage.class);

	}

	public OrdersPage editOrderChangeStatus(EditOrder editOrderStatus, String testDataSetName, String category, String statusName)
			throws Exception {
		String quantity1 = TestData.read("PageOrders.xml", testDataSetName, "quantity1", category);
		String quantity2 = TestData.read("PageOrders.xml", testDataSetName, "quantity2", category);
		String effectiveDate = TestData.read("PageOrders.xml", testDataSetName, "effectiveDate", category);
		String expectedPrice = TestData.read("PageOrders.xml", testDataSetName, "expectedPrice", category);
		String expectedStatus = TestData.read("PageOrders.xml", testDataSetName, "expectedStatus", category);
		String effectiveDate2 = TestData.read("PageOrders.xml", testDataSetName, "effectiveDate2", category);
		String description = TestData.read("PageOrders.xml", testDataSetName, "description", category);
		String price = TestData.read("PageOrders.xml", testDataSetName, "price", category);
		boolean defaultProductPrice = TextUtilities.compareValue(
				TestData.read("PageProducts.xml", testDataSetName, "defaultProductPrice", category), "true", true, TextComparators.equals);

		switch (editOrderStatus) {
		case CHANGEQUANTITY:
			this.clickEditThisOrderBtn();
			this.clickOnChangeLogTab();
			this.verifyOrderChangeProductInTable();
			this.clickOnProductInReviewTab();
			this.clickChangeBtn();
			this.selectStatus(statusName);
			this.setQuantity(quantity1);
			this.click_Update();
			String actualPrice = this.getTotalPrice();
			this.verifyProductPrice(actualPrice, expectedPrice);
			this.clickSaveChanges();
			break;

		case EFFECTIVEDATEANDQUANTITY:
			this.clickEditThisOrderBtn();
			this.clickReviewTab();
			this.clickOnProductInReviewTab();
			this.clickChangeBtn();
			this.setQuantity(quantity2);
			this.selectStatus(statusName);
			this.setEffectiveDatDefault(effectiveDate);
			this.click_Update();
			String actualPrice1 = this.getTotalPrice();
			this.verifyProductPrice(actualPrice1, expectedPrice);
			this.clickSaveChanges();
			break;
		case CHANGESTATUS:
			this.clickEditThisOrderBtn();
			this.clickOnChangeLogTab();
			String productStatus = this.getProductStatus();
			this.verifyProductStatus(productStatus, expectedStatus);
			this.clickReviewTab();
			this.clickOnProductInReviewTab();
			this.clickOnChnageBtnOnReviewTab();
			this.setCurrentEffectiveDatDefault();
			this.selectStatus(statusName);
			this.setQuantity(quantity1);
			this.click_Update();
			this.clickSaveChanges();
			break;
		case PLANEDIT:
			this.clickOnEditThisOrderForParent();
			this.clickOnProductInReviewTab();
			this.unCheckUseDefaultProductPrice(defaultProductPrice);
			this.clickUpdate();
			this.clickOnProductInReviewTab();
			this.clickChangeBtn();
			this.setDescription(description);
			this.setPrice(price);
			this.click_Update();
			String orderDescription = this.getDescriptionOnOrderLine();
			this.verifyOrderLineDescription(orderDescription, description);
			String orderPrice = this.getTotalPrice();
			this.verifyTotalPrice(orderPrice, price);
			this.clickSaveChanges();
			break;
		default:
			throw new Exception("Invalid Step Provided. Not defined in enumeration");
		}
		return GlobalController.brw.initElements(OrdersPage.class);
	}

}
