package com.jbilling.framework.pageclasses;

import org.testng.Assert;

import com.jbilling.framework.globals.GlobalController;
import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.interfaces.ElementField;
import com.jbilling.framework.interfaces.LocateBy;
import com.jbilling.framework.utilities.xmlutils.TestData;

public class InvoicePage {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@LocateBy(xpath = "//span[text()='Add Sub-Account']")
	private ElementField LT_DELETE;

	@LocateBy(xpath = "//span[text()='Yes']")
	private ElementField LT_CONFIRM_YES;

	@LocateBy(xpath = "//table[@id='invoices']/tbody/tr/td[2]/a/strong")
	private ElementField TAB_INVOICES;

	@LocateBy(xpath = "//div[@class = 'btn-box']/div/a/span")
	private ElementField BT_PAYINVOICE;

	@LocateBy(xpath = "//div[@id='payments']/div[2]/table/tbody//input[@class='paymentRadio']")
	private ElementField RB_INVOICE;

	@LocateBy(xpath = "//input[@id = 'payment_amountAsDecimal']")
	private ElementField TB_VALUE;

	@LocateBy(xpath = "//div[@id = 'payment-method-fields-0']/div/div/input")
	private ElementField TB_NAME;

	@LocateBy(xpath = "//div[@id = 'payment-method-fields-0']/div[2]/div/input")
	private ElementField TB_NUMBER;

	@LocateBy(xpath = "//div[@id = 'payment-method-fields-0']/div[3]/div/input")
	private ElementField TB_DATE;

	@LocateBy(xpath = "//strong[contains(text(), '17')]")
	private ElementField LT_INVOICE;

	@LocateBy(xpath = "//input[@id = 'paymentMethod_0.processingOrder']")
	private ElementField TB_ORDER;

	@LocateBy(xpath = "//div[@class = 'buttons']/ul/li/a/span")
	private ElementField BT_REVIEW;

	@LocateBy(xpath = "//div[@class = 'buttons']/ul/li/a/span")
	private ElementField BT_MAKE;

	@LocateBy(xpath = "//div[@class = 'msg-box info']")
	private ElementField SM_MESSAGE;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//table[@class = 'dataTable']/tbody/tr[3]/td[2]")
	private ElementField SM_NAME;

	@LocateBy(xpath = "//div[@class='row']/a[contains(@href,'downloadPdf')]")
	private ElementField LT_DOWNLOADPDF;

	@LocateBy(xpath = "//select[@id='paymentMethod_0.paymentMethodTypeId']")
	private ElementField DD_PAYMENTMETHOD;

	@LocateBy(xpath = "//input[@id='payment_amountAsDecimal']")
	private ElementField TB_AMT;

	@LocateBy(xpath = "(//table[@class='innerTable']/tbody/tr/td[4])[2]")
	private ElementField PAID_AMOUNT;

	@LocateBy(xpath = "//td[text()='Balance']/following-sibling::td")
	private ElementField AMOUNT_BALANCE;

	@LocateBy(xpath = "//td[text()='Status']/following-sibling::td")
	private ElementField PAY_STATUS;

	@LocateBy(xpath = "(//table[@class='innerTable']/tbody/tr/td[4])[1]")
	private ElementField INVOICE_TOTAL_AMOUNT;

	@LocateBy(xpath = "(//table[@class='innerTable']/tbody/tr/td[2])[1]")
	private ElementField INVOICE_QUANTITY;

	@LocateBy(xpath = "(//table[@class='innerTable']/tbody/tr/td[3])[1]")
	private ElementField INVOICE_PRODUCT_AMOUNT;

	@LocateBy(xpath = "//span[text()='Pay Invoice']")
	private ElementField BT_PAY_INVOICE;

	@LocateBy(xpath = "//table[@id='invoices']/tbody/tr/td/a/strong")
	private ElementField TAB_INVOICE;

	/**
	 * This method will click on Delete Button
	 *
	 * @throws Exception
	 */
	protected InvoicePage clickDelete() throws Exception {
		InvoicePage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.LT_DELETE);

		InvoicePage.logger.exitMethod();
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method will click on Delete Button
	 *
	 * @throws Exception
	 */
	protected InvoicePage clickConfirmYes() throws Exception {
		InvoicePage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.LT_CONFIRM_YES);

		InvoicePage.logger.exitMethod();
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method selects row item from the web table
	 *
	 * @throws Exception
	 */
	protected InvoicePage selectRowItem(String rowText) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_INVOICES, rowText);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method clicks on pay invoice button
	 *
	 * @throws Exception
	 */
	protected InvoicePage clickPayInvoice() throws Exception {
		GlobalController.brw.click(this.BT_PAYINVOICE);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	protected String isInvoiceGenerationSuccessful() throws Exception {
		String msgToVerify = "successfully generated invoice for order";
		return MessagesPage.isOperationSuccessfulOnMessage(msgToVerify, TextComparators.contains);
	}

	/**
	 * This method verifies invoice radio button is selected
	 *
	 * @throws Exception
	 */
	protected InvoicePage verifyRadioButtonSelection() throws Exception {
		GlobalController.brw.clickLinkText(this.RB_INVOICE);

		GlobalController.brw.isSelected(this.RB_INVOICE);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method verifies payment amount
	 *
	 * @throws Exception
	 */

	protected InvoicePage verifyPaymentAmount(String expectedValue) throws Exception {
		GlobalController.brw.isElementPresent(this.TB_VALUE);
		String actualValue = GlobalController.brw.getAttribute((this.TB_VALUE), "value");

		Assert.assertTrue(expectedValue.equals(actualValue));
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method enters card holder names
	 *
	 * @throws Exception
	 */
	protected InvoicePage enterCardholderName(String name) throws Exception {
		GlobalController.brw.setText(this.TB_NAME, name);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method enters card number
	 *
	 * @throws Exception
	 */
	protected InvoicePage enterCardNumber(String number) throws Exception {
		GlobalController.brw.setText(this.TB_NUMBER, number);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method enters expiry date
	 *
	 * @throws Exception
	 */
	protected InvoicePage enterExpiryDate(String date) throws Exception {
		GlobalController.brw.setText(this.TB_DATE, date);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method will click on Invoice ID
	 *
	 * @throws Exception
	 */

	protected InvoicePage clickInvoiceID() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_INVOICE);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method enters processing order
	 *
	 * @throws Exception
	 */
	protected InvoicePage enterProcessingOrder(String order) throws Exception {
		GlobalController.brw.setText(this.TB_ORDER, order);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method clicks on rebiew button
	 *
	 * @throws Exception
	 */
	protected InvoicePage clickReviewButton() throws Exception {
		GlobalController.brw.click(this.BT_REVIEW);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method verifies payment details
	 *
	 * @throws Exception
	 */

	protected InvoicePage verifyPaymentDetails(String expectedValue) throws Exception {
		GlobalController.brw.isElementPresent(this.TB_NAME);
		String actualValue = GlobalController.brw.getAttribute((this.TB_NAME), "value");

		Assert.assertTrue(expectedValue.equals(actualValue));
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method clicks on Make Payment
	 *
	 * @throws Exception
	 */
	protected InvoicePage clickMakePayment() throws Exception {
		GlobalController.brw.click(this.BT_MAKE);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	/**
	 * This method verifies payment details
	 *
	 * @throws Exception
	 */
	protected InvoicePage verifyPaymentInfo() throws Exception {
		GlobalController.brw.isElementPresent(this.SM_MESSAGE);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	protected InvoicePage downloadPdf() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_DOWNLOADPDF);
		return GlobalController.brw.initElements(InvoicePage.class);

	}

	public void payInvoice(String customerName, String testDataSetName, String category) throws Exception {

		this.selectRowItem(customerName);
		this.clickPayInvoice();
		this.makePayment(testDataSetName, category);
	}

	public InvoicePage makePayment(String testDataSetName, String category) throws Exception {
		InvoicePage.logger.enterMethod();
		String rowText = TestData.read("PageInvoice.xml", testDataSetName, "rowText", category);
		String amount = TestData.read("PageInvoice.xml", testDataSetName, "amount", category);
		String name = TestData.read("PageInvoice.xml", testDataSetName, "name", category);
		String number = TestData.read("PageInvoice.xml", testDataSetName, "number", category);
		String date = TestData.read("PageInvoice.xml", testDataSetName, "date", category);
		String order = TestData.read("PageInvoice.xml", testDataSetName, "order", category);

		// this.verifyRadioButtonSelection();
		this.enterPaymentAmount(amount);
		this.enterCardholderName(name);
		this.enterCardNumber(number);
		this.enterExpiryDate(date);
		this.enterProcessingOrder(order);
		this.clickReviewButton();
		this.verifyPaymentDetails(name);
		this.clickMakePayment();
		this.verifyPaymentInfo();

		InvoicePage.logger.exitMethod();
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will select Payment Type Dropdown
	 *
	 * @param paymentMethod
	 * @throws Exception
	 */
	protected InvoicePage selectPaymentType(String paymentMethod) throws Exception {
		InvoicePage.logger.enterMethod();

		GlobalController.brw.selectDropDown(this.DD_PAYMENTMETHOD, paymentMethod);
		InvoicePage.logger.exitMethod();
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method enters payment amount
	 *
	 * @throws Exception
	 */
	protected InvoicePage enterPaymentAmount(String amt) throws Exception {
		GlobalController.brw.setText(this.TB_AMT, amt);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will get amount displayed on invoice
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected double getInvoiceAmount() throws Exception {
		String amount[] = GlobalController.brw.getText(this.INVOICE_TOTAL_AMOUNT).split("\\$");
		double totalAmount = Double.parseDouble(amount[1]);
		return totalAmount;
	}

	/**
	 * This method will get Paid amount displayed on invoice
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected double getPaidAmount() throws Exception {
		String amount[] = GlobalController.brw.getText(this.PAID_AMOUNT).split("\\$");
		double paidAmount = Double.parseDouble(amount[1]);
		return paidAmount;
	}

	/**
	 * This method will get Balance amount displayed on invoice
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected double getBalanceAmount() throws Exception {
		String amount[] = GlobalController.brw.getText(this.AMOUNT_BALANCE).split("\\$");
		double balanceAmount = Double.parseDouble(amount[1]);
		return balanceAmount;
	}

	/**
	 * This method will verify paid amount displayed on invoice
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected InvoicePage verifyPaidAmount(double paidAmount, String expectedPaidAmount) throws Exception {
		double expectedAmount = Double.parseDouble(expectedPaidAmount);
		Assert.assertEquals(paidAmount, expectedAmount);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will verify balance amount displayed on invoice
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected InvoicePage verifyBalanceAmount(double balanceAmount, String expectedBalanceAmount) throws Exception {
		double expectedAmount = Double.parseDouble(expectedBalanceAmount);
		Assert.assertEquals(balanceAmount, expectedAmount);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will verify balance amount displayed on invoice
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected InvoicePage verifyInvoiceTotalAmount(double totalAmount, double expectedTotalAmount) throws Exception {
		Assert.assertEquals(totalAmount, expectedTotalAmount);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will verify Status displayed on invoice
	 *
	 * @author Shanky
	 * @return
	 * @throws Exception
	 */
	protected InvoicePage verifyStatus(String actualStatus, String expectedStatus) throws Exception {
		Assert.assertEquals(actualStatus, expectedStatus);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will get Invoice Status
	 *
	 * @return
	 * @throws Exception
	 */
	protected String getStatus() throws Exception {
		String actualStatus = GlobalController.brw.getText(this.PAY_STATUS);
		return actualStatus;
	}

	/**
	 * This method will get product quantity
	 *
	 * @return
	 * @throws Exception
	 */
	double getQuantityValue() throws Exception {
		String quantityValue1 = GlobalController.brw.getText(this.INVOICE_QUANTITY);
		double quantityValue = Double.parseDouble(quantityValue1);
		return quantityValue;
	}

	/**
	 * This method will get product amount
	 *
	 * @return
	 * @throws Exception
	 */
	double getProductAmount() throws Exception {
		String productAmount1[] = GlobalController.brw.getText(this.INVOICE_PRODUCT_AMOUNT).split("\\$");
		double productAmount = Double.parseDouble(productAmount1[1]);
		return productAmount;
	}

	/**
	 * This method will calculate total amount
	 *
	 * @param quantity
	 * @param price
	 * @return
	 */
	protected double calcualteTotalPrice() throws Exception {
		double quantity = this.getQuantityValue();
		double price = this.getProductAmount();
		return quantity * price;
	}

	/**
	 * This method will click on pay invoice button
	 *
	 * @return
	 * @throws Exception
	 */
	public InvoicePage clickOnPayInvoiceBtn() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_PAY_INVOICE);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will select recently generated invoice
	 * 
	 * @param customerName
	 * @return
	 * @throws Exception
	 */
	public InvoicePage clickOnGeneratedInvoce(String customerName) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_INVOICE, customerName);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will verify invoice details
	 *
	 * @param testDataSetName
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public InvoicePage verifyInvoiceDetails(String testDataSetName, String category) throws Exception {
		String expectedPaidAmount = TestData.read("PageInvoice.xml", testDataSetName, "expectedPaidAmount", category);
		String expectedBalanceAmount = TestData.read("PageInvoice.xml", testDataSetName, "expectedBalanceAmount", category);
		String expectedStatus = TestData.read("PageInvoice.xml", testDataSetName, "expectedStatus", category);

		String actualStatus = this.getStatus();
		double paidAmount = this.getPaidAmount();
		double balanceAmount = this.getBalanceAmount();
		double totalAmount = this.getInvoiceAmount();
		this.verifyStatus(actualStatus, expectedStatus);
		this.verifyPaidAmount(paidAmount, expectedPaidAmount);
		this.verifyBalanceAmount(balanceAmount, expectedBalanceAmount);
		double expectedInvoiceAmount = this.calcualteTotalPrice();
		this.verifyInvoiceTotalAmount(totalAmount, expectedInvoiceAmount);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

	/**
	 * This method will verify the final paid status
	 *
	 * @author Shanky
	 * @param testDataSetName
	 * @param category
	 * @param customerName
	 * @return
	 * @throws Exception
	 */
	public InvoicePage verifyFinalPaidStatus(String testDataSetName, String category, String customerName) throws Exception {
		String expectedFinalStatus = TestData.read("PageInvoice.xml", testDataSetName, "expectedFinalStatus", category);
		this.clickOnGeneratedInvoce(customerName);
		String actualStatus = this.getStatus();
		this.verifyStatus(actualStatus, expectedFinalStatus);
		return GlobalController.brw.initElements(InvoicePage.class);
	}

}
