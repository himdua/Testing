package com.jbilling.framework.pageclasses;

import org.testng.Assert;

import com.jbilling.framework.globals.GlobalController;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.interfaces.ElementField;
import com.jbilling.framework.interfaces.LocateBy;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddPlanField;
import com.jbilling.framework.utilities.xmlutils.TestData;

public class PlansPage {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//table[@id='plans']/thead/tr/th/a")
	private ElementField PageHeader_Plan;

	@LocateBy(xpath = "//span[text()='Add New']")
	private ElementField LT_AddNew;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//div[@class='download']/a")
	private ElementField LT_DownloadCSVFile;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='product.number']")
	private ElementField PlanDetails_ProductCode;

	@LocateBy(xpath = "//select[@id='plan.periodId']")
	private ElementField Details_Period;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='product.activeSince']")
	private ElementField Details_StartDate;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='product.activeUntil']")
	private ElementField Details_EndDate;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "select[@id='price.currencyId']")
	private ElementField Details_Currency;

	@LocateBy(xpath = "//table[@id='products']/tbody//td/a/strong")
	private ElementField LT_PRODUCT;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//select[@id='product.types']")
	private ElementField Details_Categories;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//label[@id='price.rateAsDecimal']")
	private ElementField Details_Rate;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//select[@id='plan.usagePoolIds']")
	private ElementField Details_FreeUsagePools;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//textarea[@id='plan.description']")
	private ElementField TB_Note;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Add New Metafield']")
	private ElementField LT_AddNewMeta;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='metaField0.name']")
	private ElementField TB_MetaField;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//select[@id='metaField0.dataType']")
	private ElementField Dropdown_MetaFieldDataType;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='metaField0.filename']")
	private ElementField TB_MetaFieldFileName;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='mandatoryCheck']")
	private ElementField CHB_MetaFieldMandatory;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='disableCheck']")
	private ElementField CHB_MetaFieldDisable;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='metaField0.displayOrder']")
	private ElementField TB_MetaFieldDisplayOrder;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='defaultValue0']")
	private ElementField TB_MetaFieldDefaultValue;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//label[text()='Dependency']/preceding-sibling::input")
	private ElementField CHB_MetaFieldDependency;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//label[text()='Help']/preceding-sibling::input")
	private ElementField CHB_MetaFieldHelp;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//select[@id='metaField0.validationRule.ruleType']")
	private ElementField Dropdown_MetaFieldValidation;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Update']")
	private ElementField LT_MetaFieldUpdate;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Remove']")
	private ElementField TB_MetaFieldRemove;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='filterBy']")
	private ElementField Products_FilterBy;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='typeId']")
	private ElementField Products_ProductCategory;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='plansFilterBy']")
	private ElementField Plans_FilterBy;

	@LocateBy(xpath = "//table[@id='plans']/tbody/tr/td/a")
	private ElementField LT_PLANLIST;

	@LocateBy(xpath = "//span[text()='Edit']")
	private ElementField LT_EDIT;

	@LocateBy(xpath = "//input[@id='product.number']")
	private ElementField TB_PRODUCTCODE;

	@LocateBy(xpath = "//select[@id='newDescriptionLanguage']")
	private ElementField DD_ADDDESCRIPTION;

	@LocateBy(xpath = "//a[@onclick='addNewProductDescription()']/img")
	private ElementField IBT_ADDNEWDESCRIPTION;

	@LocateBy(xpath = "//div[@id='descriptions']/div/div/input")
	private ElementField TB_DESCRIPTION;

	@LocateBy(xpath = "//input[@id='product.activeSince']/../img")
	private ElementField BT_STARTDATE;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='product.activeUntil']")
	private ElementField BT_ENDDATE;

	@LocateBy(xpath = "//input[@id='price.rateAsDecimal']")
	private ElementField TB_RATE;

	@LocateBy(xpath = "//a[text()='Details']")
	private ElementField LT_DETAILS;

	@LocateBy(xpath = "//a[text()='Products']")
	private ElementField LT_PRODUCTS;

	@LocateBy(xpath = "//table[@id='products']/tbody//td/a/strong")
	private ElementField LT_PRODUCTCODE;

	@LocateBy(xpath = "//select[@id='product.types']")
	private ElementField DD_CATEGORY;

	@LocateBy(xpath = "//input[@id='bundle.quantityAsDecimal']")
	private ElementField TB_BUNDLEQUANTITY;

	@LocateBy(xpath = "//label[text()='Rate']/../div/input")
	private ElementField TB_RATEPRODUCT;

	@LocateBy(xpath = "//span[text()='Update']")
	private ElementField LT_UPDATE;

	@LocateBy(xpath = "//span[text()='Save Changes']")
	private ElementField LT_SAVECHANGES;

	@LocateBy(xpath = "//select[@id = 'model.0.type']")
	private ElementField DD_PRICING;

	@LocateBy(xpath = "//select[@id = 'company-select']")
	private ElementField DD_COMPANY;

	@LocateBy(xpath = "//select[@id = 'product.types']")
	private ElementField DD_PRODUCT_CATEGORY;

	@LocateBy(xpath = "//select[@id = 'plan.usagePoolIds']")
	private ElementField DD_FREE_USAGE_POOL;

	@LocateBy(xpath = "//select[@id = 'typeId']")
	private ElementField DD_PRODUCT;

	@LocateBy(xpath = "//ul[@class = 'top-nav']/li")
	private ElementField CURRENT_COMPANY;

	@LocateBy(xpath = "//input[@id='model.0.rateAsDecimal']")
	private ElementField TB_RATE2;

	@LocateBy(xpath = "//span[text()='Add New']")
	private ElementField LT_ADDNEW;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//div[@id='addDescription']//div/a/img")
	private ElementField IBT5_ADDDESCRIPTION;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//div[@id='descriptions']/div/div/input[1]")
	private ElementField TB_ADDDESCRIPTION;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//label[text()='Availability Start Date']/../div/img")
	private ElementField IBT_STARTDATE;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//label[text()='Availability End Date']/../div/img")
	private ElementField IBT_ENDDATE;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//select[@id='product.types']//option[contains(text(),'New Test category')]")
	private ElementField TXT_CATEGORIES;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//a[text()='Products']")
	private ElementField LT_PRODUCTSTAB;

	@LocateBy(xpath = "//select[@id='bundle.periodId']")
	private ElementField DD_BUNDELEDPERIOD;

	@LocateBy(xpath = "//input[@id = 'price.precedence']")
	private ElementField TXT_PRECEDENCE;

	@LocateBy(xpath = "//span[contains(text(),'-')]/parent::li")
	private ElementField LI_METAFIELDTAB_ACTIVATOR;

	@LocateBy(xpath = "//span[contains(text(),'-')]")
	private ElementField SPAN_NEW_METAFIELDTAB;

	@LocateBy(xpath = "//span[text()='Save Plug-in']")
	private ElementField LT_SAVEPLUGINS;

	@LocateBy(xpath = "//span[text()='Add Product']")
	private ElementField LT_AddProduct;

	@LocateBy(xpath = "//a[@onclick='addNewProductDescription()']")
	private ElementField LT_ADDDESCRIPTION;

	@LocateBy(xpath = "//label[contains(text(),'English Description')]/../div/input[1]")
	private ElementField TB_ENGLISHDESCRIPTION;

	@LocateBy(id = "global-checkbox")
	private ElementField CB_GLOBLE;

	@LocateBy(xpath = "//input[@id='product.activeSince']")
	private ElementField TB_START_DATE;

	@LocateBy(xpath = "//input[@id='product.activeUntil']")
	private ElementField TB_END_DATE;

	@LocateBy(xpath = "//a[text()='Products']")
	private ElementField PRODUCT_TAB;

	@LocateBy(xpath = "//table[@id='products']/tbody/tr/td/a/strong")
	private ElementField TAB_PRODUCT;

	@LocateBy(xpath = "//table[@id='products']/tbody/tr/td/a/strong")
	private ElementField TAB_PRODUCT_NAME;

	@LocateBy(xpath = "//table[@id='plans']/tbody/tr/td/a/strong")
	private ElementField TAB_PLAN_NAME;

	@LocateBy(id = "plans")
	private ElementField TBL_PLANS;

	@LocateBy(xpath = "//div[@class='box-card-hold']/div/ul/li[1]")
	private ElementField CATEGORY_NAME1;

	@LocateBy(xpath = "//div[@class='box-card-hold']/div/ul/li[2]")
	private ElementField CATEGORY_NAME2;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'When configuring products to use this pricing model, this field is always zero (0). When you create the plan that includes a free quantity (minutes for example), this is when you enter a value.')]")
	private ElementField TB_INCLUDEDQUANTITY;

	@LocateBy(id = "price.currencyId")
	private ElementField DD_Currency;

	@LocateBy(xpath = "//span[contains(text(), 'Not Mandatory')]")
	private ElementField FIELD_META;

	@LocateBy(xpath = "//input[@id='metaField0.name']")
	private ElementField TB_NewNameMetaField;

	@LocateBy(xpath = "//li[@id='mf-0-editor']//div[@class='btn-box']/a/span[contains(text(), 'Update')]")
	private ElementField UpdateMeta;

	@LocateBy(xpath = "//a[contains(text(), 'Review')]")
	private ElementField BT_REVIEWTAB;

	@LocateBy(xpath = "//form[2]//span[contains(text(), 'Not Mandatory')]")
	private ElementField FIELD_META2;

	@LocateBy(xpath = "//td[contains(text(), 'New Meta1')]")
	private ElementField TF_METAFIELD1;

	@LocateBy(xpath = "//input[@id='metaField1.name']")
	private ElementField TB_NewNameMetaField2;

	@LocateBy(xpath = "//form[2]//li//a/span[contains(text(), 'Update')]")
	private ElementField UpdateMeta2;

	@LocateBy(xpath = "////td[contains(text(), 'Extra New Update Meta')]")
	private ElementField TF_METAFIELD2;

	@LocateBy(xpath = "//li[@id='line-0-editor']//div[@class='btn-box']/a/span[contains(text(), 'Update')]")
	private ElementField BTN_PLANUPDATE_1;

	@LocateBy(xpath = "//li[@id='line-1-editor']//div[@class='btn-box']/a/span[contains(text(), 'Update')]")
	private ElementField BTN_PLANUPDATE_2;

	@LocateBy(xpath = "//li[@id='line-2-editor']//div[@class='btn-box']/a/span[contains(text(), 'Update')]")
	private ElementField BTN_PLANUPDATE_3;
	@LocateBy(xpath = "//li[@id='line-3-editor']//div[@class='btn-box']/a/span[contains(text(), 'Update')]")
	private ElementField BTN_PLANUPDATE_4;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[2]//input[@id = 'price.precedence']")
	private ElementField TXT_PRECEDENCE2;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[2]//input[@id='bundle.quantityAsDecimal']")
	private ElementField TB_BUNDLEQUANTITY_1;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[2]//select[@id='bundle.periodId']")
	private ElementField DD_BUNDELEDPERIOD_2;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[2]//select[@id = 'model.0.type']")
	private ElementField DD_PRICING_2;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[2]//label[text()='Rate']/../div/input")
	private ElementField TB_RATEPRODUCT_2;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[2]//span[text()='Update']")
	private ElementField LT_UPDATE_2;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[3]//input[@id = 'price.precedence']")
	private ElementField TXT_PRECEDENCE3;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[3]//input[@id='bundle.quantityAsDecimal']")
	private ElementField TB_BUNDLEQUANTITY_2;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[3]//select[@id='bundle.periodId']")
	private ElementField DD_BUNDELEDPERIOD_3;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[3]//select[@id = 'model.0.type']")
	private ElementField DD_PRICING_3;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[4]//label[text()='Rate']/../div/input")
	private ElementField TB_RATEPRODUCT_3;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[3]//span[text()='Update']")
	private ElementField LT_UPDATE_3;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[4]//input[@id = 'price.precedence']")
	private ElementField TXT_PRECEDENCE4;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[4]//input[@id='bundle.quantityAsDecimal']")
	private ElementField TB_BUNDLEQUANTITY_3;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[4]//select[@id='bundle.periodId']")
	private ElementField DD_BUNDELEDPERIOD_4;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[4]//select[@id = 'model.0.type']")
	private ElementField DD_PRICING_4;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[4]//span[text()='Update']")
	private ElementField LT_UPDATE_4;

	@LocateBy(xpath = "//ul[@id='review-lines']/li[2]//div[@class='inp-bg ']/input[@id='model.0.rateAsDecimal']")
	private ElementField TB_RATE3;
	@LocateBy(xpath = "//ul[@id='review-lines']/li[4]//div[@class='inp-bg ']/input[@id='model.0.rateAsDecimal']")
	private ElementField TB_RATE4;

	public PlansPage clickAddNewButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_AddNew);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select first plan in Plans list
	 * 
	 * @throws Exception
	 */
	public PlansPage selectFirstPlanInPlanList() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PLANLIST);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author syed
	 * @Description This method Add meta Fields
	 */
	public String addPlanwithMetaFields(String userCategory1, String userCategory2, String productCategory, String testDataSetName,
			String category, boolean globle) throws Exception {
		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String rate = TestData.read("PagePlans.xml", testDataSetName, "rate", category);
		String bundleQuantity = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity", category);
		String rateProduct = TestData.read("PagePlans.xml", testDataSetName, "rateProduct", category);
		String pricing = TestData.read("PagePlans.xml", testDataSetName, "pricing", category);
		String metaFieldName = TestData.read("PagePlans.xml", testDataSetName, "metaFieldName", category);
		this.clickAddNewButton();
		this.setProductCode(productCode);
		// this.selectAddDesctiption(description);
		this.clickAddNewDescription();
		this.setNewDescription(englishDescription);
		this.enableGlobleCheckBox(globle);
		this.selectCategory(userCategory2);
		GlobalController.brw.pressControlKey();

		this.selectCategory(userCategory1);
		GlobalController.brw.releaseControlKey();
		this.selectInsideProductsTab();
		this.selectProductCode(productCategory);
		this.clickUpdate();
		this.clickAddNewMetaFieldButton();

		this.clickAddedMetaField();
		this.setNewNameMetaField(metaFieldName);
		this.clickUpdateMetaFieldButton();
		this.clickOnReviewTab();
		this.clickSaveChanges();

		return englishDescription;
	}

	/**
	 * @author syed
	 * @Description This method will edit the meta fields
	 * 
	 */
	public PlansPage editPlanForMetaField(String testDataSetName, String category) throws Exception {
		String metaFieldName = TestData.read("PagePlans.xml", testDataSetName, "metaFieldName", category);

		this.selectFirstPlanInPlanList();
		this.clickEdit();
		this.clickAddNewMetaFieldButton();

		this.clickAddedMetaField2();
		this.setNewNameMetaField2(metaFieldName);
		this.clickUpdateMetaFieldButton2();
		this.clickOnReviewTab();
		this.clickSaveChanges();
		this.verifyMetaField1();
		this.verifyMetaField2();
		return GlobalController.brw.initElements(PlansPage.class);
	}

	/**
	 * @author syed
	 * @Description This method will verify the Meta Feild
	 */
	public DiscountsPage verifyMetaField2() throws Exception {
		GlobalController.brw.isElementPresent(this.TF_METAFIELD2);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * @author syed
	 * @Description This method will click on update button
	 */
	public PlansPage clickUpdateMetaFieldButton2() throws Exception {
		GlobalController.brw.clickLinkText(this.UpdateMeta2);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @Description This method will set new name metafield
	 * @author syed
	 * @param englishDescription
	 * @throws Exception
	 */
	public PlansPage setNewNameMetaField2(String metaFieldName) throws Exception {

		GlobalController.brw.setText(this.TB_NewNameMetaField2, metaFieldName);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author syed
	 * @Description This method will verify the Second Meta field
	 * 
	 */
	public DiscountsPage verifyMetaField1() throws Exception {
		GlobalController.brw.isElementPresent(this.TF_METAFIELD1);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * @author syed
	 * @Description This method will Add Second product for metafield
	 */
	public PlansPage clickAddedMetaField2() throws Exception {
		GlobalController.brw.clickLinkText(this.FIELD_META2);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author syed This method will click on Add new description + image button
	 * 
	 * @throws Exception
	 */
	public PlansPage clickOnReviewTab() throws Exception {
		GlobalController.brw.click(this.BT_REVIEWTAB);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author syed
	 * @Description This method will Click on Update Meta Field Button
	 */
	public PlansPage clickUpdateMetaFieldButton() throws Exception {
		GlobalController.brw.clickLinkText(this.UpdateMeta);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author syed This method will set new name metafield
	 * 
	 * @param englishDescription
	 * @throws Exception
	 */
	public PlansPage setNewNameMetaField(String metaFieldName) throws Exception {
		GlobalController.brw.setText(this.TB_NewNameMetaField, metaFieldName);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author syed
	 * @Description This method will click on Add new Meta Field
	 */
	public PlansPage clickAddedMetaField() throws Exception {
		GlobalController.brw.clickLinkText(this.FIELD_META);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author syed
	 * @Description This method will Click on New Meta Field Button
	 */
	public PlansPage clickAddNewMetaFieldButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_AddNewMeta);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will click on Edit button
	 * 
	 * @throws Exception
	 */
	public PlansPage clickEdit() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_EDIT);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	public PlansPage addPlan() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDNEW);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will set Product Code
	 * 
	 * @param productCode
	 * @throws Exception
	 */
	public PlansPage setProductCode(String productCode) throws Exception {
		GlobalController.brw.setText(this.TB_PRODUCTCODE, productCode);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select Add description dropdown option
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectAddDesctiption(String description) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_ADDDESCRIPTION, description);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will click on Add new description + image button
	 * 
	 * @throws Exception
	 */
	public PlansPage clickAddNewDescription() throws Exception {
		GlobalController.brw.click(this.IBT_ADDNEWDESCRIPTION);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will set new English Description
	 * 
	 * @param englishDescription
	 * @throws Exception
	 */
	public PlansPage setNewDescription(String englishDescription) throws Exception {
		GlobalController.brw.setText(this.TB_DESCRIPTION, englishDescription);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select current date
	 * 
	 * @throws Exception
	 */
	public PlansPage setCurrentDate() throws Exception {
		GlobalController.brw.click(this.BT_STARTDATE);
		GlobalController.brw.pressEnter(this.BT_STARTDATE);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select current date
	 * 
	 * @throws Exception
	 */
	public PlansPage setEndtDate() throws Exception {
		// GlobalController.brw.click(this.BT_STARTDATE);
		// GlobalController.brw.pressEnter(this.BT_STARTDATE);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will set Rate
	 * 
	 * @param rate
	 * @throws Exception
	 */
	public PlansPage setRate(String rate) throws Exception {
		GlobalController.brw.setText(this.TB_RATE, rate);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will set Model Rate
	 * 
	 * @param rate
	 * @throws Exception
	 */
	public PlansPage setModelRate(String rate) throws Exception {
		GlobalController.brw.setText(this.TB_RATE2, rate);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select Category from dropdown
	 * 
	 * @param category
	 * @throws Exception
	 */
	public PlansPage selectCategory(String category) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_CATEGORY, category);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select Products tab within plans
	 * 
	 * @throws Exception
	 */
	public PlansPage selectInsideProductsTab() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PRODUCTS);
		GlobalController.brw.waitForAjaxElement(this.Products_FilterBy);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select product code1 description code
	 * 
	 * @throws Exception
	 */
	public PlansPage selectProductCode(String product) throws Exception {
		GlobalController.brw.selectListItem(this.LT_PRODUCTCODE, product);
		// GlobalController.brw.waitForAjaxElement(this.TB_BUNDLEQUANTITY);
		return GlobalController.brw.initElements(PlansPage.class);
	}

	/**
	 * This method will set bundled quantity
	 * 
	 * @param quantity
	 * @throws Exception
	 */
	public PlansPage setBundleQuantity(String quantity) throws Exception {
		GlobalController.brw.setText(this.TB_BUNDLEQUANTITY, quantity);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method set product rate
	 * 
	 * @param rate
	 * @throws Exception
	 */
	public PlansPage setRateProduct(String rate) throws Exception {
		GlobalController.brw.setText(this.TB_RATEPRODUCT, rate);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will click Update button
	 * 
	 * @throws Exception
	 */
	public PlansPage clickUpdate() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_UPDATE);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will click Update button
	 * 
	 * @throws Exception
	 */
	public PlansPage clickUpdate1() throws Exception {
		GlobalController.brw.clickLinkText(this.BTN_PLANUPDATE_2);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will click Update button
	 * 
	 * @throws Exception
	 */
	public PlansPage clickUpdate2() throws Exception {
		GlobalController.brw.clickLinkText(this.BTN_PLANUPDATE_3);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will click Update button
	 * 
	 * @throws Exception
	 */
	public PlansPage clickUpdate3() throws Exception {
		GlobalController.brw.clickLinkText(this.BTN_PLANUPDATE_4);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will click save changes button
	 * 
	 * @throws Exception
	 */
	public PlansPage clickSaveChanges() throws Exception {
		GlobalController.brw.waitForAjaxElement(this.LT_SAVECHANGES);
		GlobalController.brw.waitUntilElementStopMoving(this.LT_SAVECHANGES);
		GlobalController.brw.clickLinkText(this.LT_SAVECHANGES);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	public PlansPage selectPricicngDropdown(String pricing) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRICING, pricing);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select current company
	 * 
	 * @throws Exception
	 */
	public PlansPage selectCurrentCompany() throws Exception {
		String currentCompany = GlobalController.brw.getText(this.CURRENT_COMPANY);
		GlobalController.brw.selectDropDown(this.DD_COMPANY, currentCompany);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select selectProductCategory dropdown option
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectProductCategory(String category) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRODUCT_CATEGORY, category);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select selectProductCategory dropdown option
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectFreeUsagePool(String freeUsagePoolName) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_FREE_USAGE_POOL, freeUsagePoolName);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select selectProduct dropdown option
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectProduct(String products) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRODUCT, products);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will click on selected product from product section
	 * 
	 * @return
	 * @throws Exception
	 * @author
	 */
	protected ConfigurationPage clickSelectedProduct() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PRODUCT);
		return GlobalController.brw.initElements(ConfigurationPage.class);
	}

	/**
	 * This method will select Bundled Period dropdown option
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectBundeledPeriod(String period) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_BUNDELEDPERIOD, period);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will select Plan Period dropdown option
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectPlanPeriod(String period) throws Exception {
		GlobalController.brw.selectDropDown(this.Details_Period, period);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will enter Note
	 * 
	 * @param note
	 * @throws Exception
	 */
	public PlansPage enterNotes(String note) throws Exception {
		GlobalController.brw.setText(this.TB_Note, note);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will enter Precedence
	 * 
	 * @param precedence
	 * @return
	 * @throws Exception
	 */
	public PlansPage enterPrecedence(String precedence) throws Exception {
		GlobalController.brw.setText(this.TXT_PRECEDENCE, precedence);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This Method will add Metafield
	 * 
	 * @param paitad
	 * @throws Exception
	 */
	protected ConfigurationPage verifyMetaField() throws Exception {
		String AttributeValue = GlobalController.brw.getAttribute(this.LI_METAFIELDTAB_ACTIVATOR, "class");
		if (AttributeValue.contains("active") == false) {
			GlobalController.brw.clickLinkText(this.SPAN_NEW_METAFIELDTAB);
		}
		return GlobalController.brw.initElements(ConfigurationPage.class);
	}

	public PlansPage addPlan(AddPlanField addPlanField, String userCategory, String productCategory, String testDataSetName, String category)
			throws Exception {
		PlansPage.logger.enterMethod();

		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String rate = TestData.read("PagePlans.xml", testDataSetName, "rate", category);
		String bundleQuantity = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity", category);
		String rateProduct = TestData.read("PagePlans.xml", testDataSetName, "rateProduct", category);
		String pricing = TestData.read("PagePlans.xml", testDataSetName, "pricing", category);
		String bundledPeriod = TestData.read("PagePlans.xml", testDataSetName, "bundledPeriod", category);
		String note = TestData.read("PagePlans.xml", testDataSetName, "note", category);
		String precedence = TestData.read("PagePlans.xml", testDataSetName, "precedence", category);
		String includedQuantity = TestData.read("PagePlans.xml", testDataSetName, "IncludedQuantity", category);
		String productCategory2 = TestData.read("PagePlans.xml", testDataSetName, "productCategory2", category);
		String precedence2 = TestData.read("PagePlans.xml", testDataSetName, "precedence2", category);
		String quantity1 = TestData.read("PagePlans.xml", testDataSetName, "quantity1", category);
		String period2 = TestData.read("PagePlans.xml", testDataSetName, "period2", category);
		String pricing2 = TestData.read("PagePlans.xml", testDataSetName, "pricing2", category);
		String rate2 = TestData.read("PagePlans.xml", testDataSetName, "rate2", category);
		String rate1 = TestData.read("PagePlans.xml", testDataSetName, "rate1", category);
		String productCategory3 = TestData.read("PagePlans.xml", testDataSetName, "productCategory3", category);
		String precedence3 = TestData.read("PagePlans.xml", testDataSetName, "precedence3", category);
		String quantity2 = TestData.read("PagePlans.xml", testDataSetName, "quantity2", category);
		String period3 = TestData.read("PagePlans.xml", testDataSetName, "period3", category);
		String pricing3 = TestData.read("PagePlans.xml", testDataSetName, "pricing3", category);
		String productCategory4 = TestData.read("PagePlans.xml", testDataSetName, "productCategory4", category);
		String precedence4 = TestData.read("PagePlans.xml", testDataSetName, "precedence4", category);
		String quantity3 = TestData.read("PagePlans.xml", testDataSetName, "quantity3", category);
		String period4 = TestData.read("PagePlans.xml", testDataSetName, "period4", category);
		String pricing4 = TestData.read("PagePlans.xml", testDataSetName, "pricing4", category);
		String startDate = TestData.read("PagePlans.xml", testDataSetName, "startDate", category);
		String endDate = TestData.read("PagePlans.xml", testDataSetName, "endDate", category);
		String rate4 = TestData.read("PagePlans.xml", testDataSetName, "rate4", category);

		switch (addPlanField) {
		case ALL:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			// this.selectPricicngDropdown(pricing);
			this.setBundleQuantity(bundleQuantity);
			this.setModelRate(rateProduct);
			this.clickUpdate();
			break;
		case PRODUCT:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.setBundleQuantity(bundleQuantity);
			this.clickUpdate();
			break;
		case BUNDLEDPERIOD:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			// this.selectPricicngDropdown(pricing);
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.selectBundeledPeriod(bundledPeriod);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();
			break;
		case WITHNOTE:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.enterNotes(note);
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.verifyMetaField();
			this.enterPrecedence(precedence);
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.selectBundeledPeriod(bundledPeriod);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();
			break;
		case INCLUDEQUANTITY:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.setBundleQuantity(bundleQuantity);
			this.setIncludedQuantity(includedQuantity);
			break;

		case FLATPRICE:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.selectCurrentCompany();
			this.selectCategory(userCategory);
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.enterPrecedence(precedence);
			this.setBundleQuantity(bundleQuantity);
			this.selectBundeledPeriod(bundledPeriod);
			this.selectPricicngDropdown(pricing);
			// this.setRateProduct(rate);
			this.clickUpdate();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory2);

			this.enterPrecedence2(precedence2);
			this.setBundleQuantity2(quantity1);
			this.selectBundeledPeriod2(period2);
			this.selectPricicngDropdown2(pricing2);
			this.setRateProduct2(rate2);
			this.clickUpdate1();

			break;

		case ONEPRODUCT:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.enterPrecedence(precedence);
			this.setBundleQuantity(bundleQuantity);
			// this.selectBundeledPeriod(bundledPeriod);
			this.selectPricicngDropdown(pricing);
			// this.setRateProduct(rateProduct);
			this.setModelRate(rate2);
			this.clickUpdate();
			break;

		case FLATPRICEWITHRATE:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCurrentCompany();
			this.selectCategory(userCategory);
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.enterPrecedence(precedence);
			this.setBundleQuantity(bundleQuantity);
			this.selectBundeledPeriod(bundledPeriod);
			this.selectPricicngDropdown(pricing);
			// this.setRateProduct(rateProduct);
			this.setModelRate(rate1);
			this.clickUpdate();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory2);

			this.enterPrecedence2(precedence2);
			this.setBundleQuantity2(quantity1);
			this.selectBundeledPeriod2(period2);
			this.selectPricicngDropdown2(pricing2);
			this.setModelRate1(rate2);
			this.clickUpdate1();
			break;

		case FLATPRICEWITHFOURPRODUCT:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.enterPrecedence(precedence);
			this.setBundleQuantity(bundleQuantity);
			this.selectBundeledPeriod(bundledPeriod);
			this.selectPricicngDropdown(pricing);
			// this.setRateProduct(rateProduct);
			this.setModelRate(rateProduct);
			this.clickUpdate();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory2);

			this.enterPrecedence2(precedence2);
			this.setBundleQuantity2(quantity1);
			this.selectBundeledPeriod2(period2);
			this.selectPricicngDropdown2(pricing2);
			// this.setRateProduct2(rate2);
			this.setModelRate1(rate1);
			this.clickUpdate1();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory3);
			// GlobalController.brw.clearCookies();
			// GlobalController.brw.click(this.LT_PRODUCTCODE);

			// GlobalController.brw.waitForElement(element, timeout);
			this.enterPrecedence3(precedence3);
			this.setBundleQuantity3(quantity2);
			this.selectBundeledPeriod3(period3);
			this.selectPricicngDropdown3(pricing3);
			// this.setRateProduct3(rate3);
			this.clickUpdate2();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory4);

			this.enterPrecedence4(precedence4);
			this.setBundleQuantity4(quantity3);
			this.selectBundeledPeriod4(period4);
			this.selectPricicngDropdown4(pricing4);
			this.setModelRate4(rate4);
			this.clickUpdate3();

			break;

		case NEWPLANWITHDATE:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCurrentCompany();
			this.setCurrentDate();
			this.setEndtDate();
			// this.setAvailabilityEndDate(endDate);
			this.selectCategory(userCategory);
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.selectBundeledPeriod(bundledPeriod);

			this.clickUpdate();
			break;

		case HISTORICPLAN:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCurrentCompany();
			this.setCurrentDate();
			this.selectCategory(userCategory);
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.clickUpdate();
			break;

		default:
			throw new Exception("Invalid Step Provided. Not defined in enumeration");
		}

		this.clickSaveChanges();

		PlansPage.logger.exitMethod();
		return GlobalController.brw.initElements(PlansPage.class);
	}

	/**
	 * @author Syed
	 * @Description This method will set Model Rate
	 * 
	 * @param rate
	 * @throws Exception
	 */
	public PlansPage setModelRate4(String rate) throws Exception {
		GlobalController.brw.setText(this.TB_RATE4, rate);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will select Bundled Period dropdown option for
	 *              fourth Product
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectBundeledPeriod4(String period4) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_BUNDELEDPERIOD_4, period4);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	public PlansPage selectPricicngDropdown4(String pricing4) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRICING_4, pricing4);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will click Update button for Fourth product
	 * 
	 * @throws Exception
	 */
	public PlansPage clickUpdate4() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_UPDATE_4);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will set bundled quantity for Fourth Product
	 * 
	 * @param quantity
	 * @throws Exception
	 */
	public PlansPage setBundleQuantity4(String quantity3) throws Exception {

		GlobalController.brw.setText(this.TB_BUNDLEQUANTITY_3, quantity3);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	public PlansPage selectPricicngDropdown3(String pricing3) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRICING_3, pricing3);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will enter Precedence in Fourth Product
	 * 
	 * @param precedence
	 * @return
	 * @throws Exception
	 */
	public PlansPage enterPrecedence4(String precedence4) throws Exception {

		GlobalController.brw.setText(this.TXT_PRECEDENCE4, precedence4);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will enter Precedence in Third Product
	 * 
	 * @param precedence
	 * @return
	 * @throws Exception
	 */
	public PlansPage enterPrecedence3(String precedence3) throws Exception {

		GlobalController.brw.setText(this.TXT_PRECEDENCE3, precedence3);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will select Bundled Period dropdown option for
	 *              Third Product
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectBundeledPeriod3(String period3) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_BUNDELEDPERIOD_3, period3);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will set bundled quantity for Third Product
	 * 
	 * @param quantity
	 * @throws Exception
	 */
	public PlansPage setBundleQuantity3(String quantity2) throws Exception {

		GlobalController.brw.setText(this.TB_BUNDLEQUANTITY_2, quantity2);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method set product rate for Product2
	 * 
	 * @param rate
	 * @throws Exception
	 */
	public PlansPage setRateProduct2(String rate2) throws Exception {
		GlobalController.brw.setText(this.TB_RATEPRODUCT_2, rate2);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	public PlansPage selectPricicngDropdown2(String pricing2) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRICING_2, pricing2);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will set Model Rate
	 * 
	 * @param rate
	 * @throws Exception
	 */
	public PlansPage setModelRate1(String rate) throws Exception {
		GlobalController.brw.setText(this.TB_RATE3, rate);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will select Bundled Period dropdown option for
	 *              Second Product
	 * 
	 * @param description
	 * @throws Exception
	 */
	public PlansPage selectBundeledPeriod2(String period2) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_BUNDELEDPERIOD_2, period2);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will set bundled quantity
	 * 
	 * @param quantity
	 * @throws Exception
	 */
	public PlansPage setBundleQuantity2(String quantity1) throws Exception {

		GlobalController.brw.setText(this.TB_BUNDLEQUANTITY_1, quantity1);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	private PlansPage filterProducts(String textForProductFiltering) throws Exception {
		ElementField efTbForFiltering = this.Products_FilterBy;
		GlobalController.brw.setText(efTbForFiltering, textForProductFiltering.replace(" ", "_"));
		GlobalController.brw.pressTab(efTbForFiltering);
		return GlobalController.brw.initElements(PlansPage.class);
	}

	/**
	 * @author Syed
	 * @Description This method will enter Precedence in Second Product
	 * 
	 * @param precedence
	 * @return
	 * @throws Exception
	 */
	public PlansPage enterPrecedence2(String precedence2) throws Exception {

		GlobalController.brw.setText(this.TXT_PRECEDENCE2, precedence2);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will set Included quantity
	 * 
	 * @param IncludedQuantity
	 * @return
	 * @throws Exception
	 */
	public PlansPage setIncludedQuantity(String includedQuantity) throws Exception {

		GlobalController.brw.setText(this.TB_INCLUDEDQUANTITY, includedQuantity);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	public PlansPage addPlan(String userCategory, String productCategory, String testDataSetName, String category) throws Exception {
		PlansPage.logger.enterMethod();

		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String rate = TestData.read("PagePlans.xml", testDataSetName, "rate", category);
		String bundleQuantity = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity", category);
		String rateProduct = TestData.read("PagePlans.xml", testDataSetName, "rateProduct", category);
		String pricing = TestData.read("PagePlans.xml", testDataSetName, "pricing", category);

		this.clickAddNewButton();
		this.setProductCode(productCode);
		this.selectAddDesctiption(description);
		this.clickAddNewDescription();
		this.setNewDescription(englishDescription);
		this.selectCategory(userCategory);
		this.setRate(rate);
		this.selectCurrentCompany();
		this.selectInsideProductsTab();
		this.filterProducts(productCategory);
		this.selectProductCode(productCategory);
		this.verifyMetaField();
		// this.selectPricicngDropdown(pricing);
		this.setBundleQuantity(bundleQuantity);
		this.verifyMetaField();
		this.setModelRate(rateProduct);
		this.clickUpdate();
		this.clickSaveChanges();

		PlansPage.logger.exitMethod();
		return GlobalController.brw.initElements(PlansPage.class);
	}

	public PlansPage editPlan(String productCategory, String testDataSetName, String category) throws Exception {
		String pricing = TestData.read("PagePlans.xml", testDataSetName, "pricing", category);
		String bundleQuantity = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity", category);
		String rateProduct = TestData.read("PagePlans.xml", testDataSetName, "rateProduct", category);
		this.selectFirstPlanInPlanList();
		this.clickEdit();
		this.selectInsideProductsTab();
		this.selectProductCode(productCategory);
		// this.selectPricicngDropdown(pricing);
		this.setBundleQuantity(bundleQuantity);
		this.setModelRate(rateProduct);
		this.clickUpdate();
		this.clickSaveChanges();
		return GlobalController.brw.initElements(PlansPage.class);
	}

	public String addPlan(AddPlanField addPlanField, String userCategory, String productCategory, String planPeriod,
			String testDataSetName, String category) throws Exception {
		PlansPage.logger.enterMethod();

		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String rate = TestData.read("PagePlans.xml", testDataSetName, "rate", category);
		String bundleQuantity = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity", category);
		String rateProduct = TestData.read("PagePlans.xml", testDataSetName, "rateProduct", category);
		String pricing = TestData.read("PagePlans.xml", testDataSetName, "pricing", category);
		String bundledPeriod = TestData.read("PagePlans.xml", testDataSetName, "bundledPeriod", category);
		String bundleQuantity2 = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity2", category);
		String rateProduct2 = TestData.read("PagePlans.xml", testDataSetName, "rateProduct2", category);
		String note = TestData.read("PagePlans.xml", testDataSetName, "note", category);

		switch (addPlanField) {

		case PLANPERIOD:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.selectPlanPeriod(planPeriod);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.verifyMetaField();
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();
			this.clickSaveChanges();
			break;
		case MULTIPLEPLAN:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.selectPlanPeriod(planPeriod);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.verifyMetaField();
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.verifyMetaField();
			this.setBundleQuantity(bundleQuantity2);
			this.verifyMetaField();
			this.setModelRate(rateProduct2);
			this.clickUpdate();
			this.clickSaveChanges();
			break;
		case WITHNOTE:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.selectPlanPeriod(planPeriod);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.enterNotes(note);
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.verifyMetaField();
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();
			this.clickSaveChanges();
			break;

		case WITHOUTPRODUCTRATE:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.selectPlanPeriod(planPeriod);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.setBundleQuantity(bundleQuantity);
			this.clickUpdate();
			this.clickSaveChanges();
			break;
		default:
			throw new Exception("Invalid Step Provided. Not defined in enumeration");
		}

		PlansPage.logger.exitMethod();
		return englishDescription;
	}

	/**
	 * This method will click on Add product button
	 * 
	 * @return
	 * @throws Exception
	 */

	PlansPage clickAddProduct() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_AddProduct);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * @author Syed
	 * @Descrption This method will add a new plan with mulitple category
	 */
	public String addPlanWithMulitpleCategory(String userCategory1, String testDataSetName, String category) throws Exception {

		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String productcode1 = TestData.read("PagePlans.xml", testDataSetName, "productcode1", category);
		String productcode2 = TestData.read("PagePlans.xml", testDataSetName, "productcode2", category);
		String productcode3 = TestData.read("PagePlans.xml", testDataSetName, "productcode3", category);
		String productcode4 = TestData.read("PagePlans.xml", testDataSetName, "productcode4", category);
		this.clickAddNewButton();
		this.setProductCode(productCode);
		// this.selectAddDesctiption(description);
		this.clickAddNewDescription();
		this.setNewDescription(englishDescription);

		this.selectCategory(userCategory1);
		this.selectCurrentCompany();
		// this.selectCategory(userCategory2);
		/*
		 * GlobalController.brw.pressControlKey();
		 * 
		 * this.selectCategory(userCategory1);
		 * this.selectCategory(userCategory3);
		 * GlobalController.brw.releaseControlKey();
		 */

		// this.clickSaveChanges();
		this.selectInsideProductsTab();
		this.selectProductCode(productcode1);
		this.clickUpdate();
		this.selectProductCode(productcode2);
		this.clickUpdate1();
		this.selectProductCode(productcode3);
		this.clickUpdate2();
		this.selectProductCode(productcode4);
		this.clickUpdate3();
		this.clickSaveChanges();
		return englishDescription;
	}

	/**
	 * This method will click image + button
	 * 
	 * @throws Exception
	 */
	PlansPage clickAddDescription() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDDESCRIPTION);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will Product Tab
	 * 
	 * @throws Exception
	 */
	PlansPage clickProductTab() throws Exception {
		GlobalController.brw.clickLinkText(this.PRODUCT_TAB);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will set description
	 * 
	 * @param englishDescription
	 * @throws Exception
	 */
	PlansPage setDescription(String englishDescription) throws Exception {
		GlobalController.brw.setText(this.TB_ENGLISHDESCRIPTION, englishDescription);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will Enable globle checkbox
	 * 
	 * @return
	 * @throws Exception
	 */
	PlansPage enableGlobleCheckBox(boolean globle) throws Exception {
		if (globle) {
			GlobalController.brw.check(this.CB_GLOBLE);
		} else {
			GlobalController.brw.uncheck(this.CB_GLOBLE);
		}
		return GlobalController.brw.initElements(PlansPage.class);
	}

	/**
	 * This method will Set Start Date
	 * 
	 * @throws Exception
	 */
	PlansPage setStartDate(String startDate) throws Exception {
		GlobalController.brw.setText(this.TB_START_DATE, startDate);

		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * This method will Set End Date
	 * 
	 * @throws Exception
	 */
	PlansPage setEndDate(String startDate) throws Exception {
		GlobalController.brw.setText(this.TB_END_DATE, startDate);

		return GlobalController.brw.initElements(PlansPage.class);

	}

	PlansPage clickSaveButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_SAVEPLUGINS);
		return GlobalController.brw.initElements(PlansPage.class);

	}

	/**
	 * <<<<<<< .mine This method will click on Product
	 * 
	 * @throws Exception
	 */
	public PlansPage selectAddedProduct(String productName) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_PRODUCT_NAME, productName);
		return GlobalController.brw.initElements(PlansPage.class);
	}

	public String addPlanForMobileCalls(String freeUsagePoolName, String productCategory, String products, String testDataSetName,
			String category) throws Exception {

		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);

		this.clickAddNewButton();
		this.setProductCode(productCode);
		this.selectAddDesctiption(description);
		this.clickAddNewDescription();
		this.setNewDescription(englishDescription);
		this.selectProductCategory(productCategory);
		this.selectFreeUsagePool(freeUsagePoolName);

		this.selectCurrentCompany();
		this.selectInsideProductsTab();
		this.selectProduct(productCategory);
		this.clickSelectedProduct();

		this.clickUpdate();
		this.clickSaveChanges();
		return englishDescription;

	}

	public String addProductInPlan(String testDataSetName, String category, String categoryName, String productName) throws Exception {
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);

		this.setProductCode(productCode);
		this.clickAddNewDescription();
		this.setNewDescription(englishDescription);
		this.selectCategory(categoryName);
		this.selectCurrentCompany();
		this.clickProductTab();
		this.selectAddedProduct(productName);
		this.clickSaveChanges();

		return englishDescription;
	}

	public String addProductInMultipleCategoryInPlan(String testDataSetName, String category, String categoryName1, String categoryName2,
			String productName) throws Exception {
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		this.clickAddNewButton();
		this.clickAddDescription();
		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.selectCategory(categoryName2);

		// GlobalController.brw.pressControlKey();
		this.selectCategory(categoryName1);
		// GlobalController.brw.releaseControlKey();
		this.selectCurrentCompany();
		this.clickProductTab();
		this.selectAddedProduct(productName);
		this.clickSaveChanges();
		this.validatePlanSavedTestData(englishDescription);
		return englishDescription;
	}

	/**
	 * This method will validate Added Plan
	 * 
	 * @throws Exception
	 */
	public PlansPage validatePlanSavedTestData(String data) throws Exception {
		GlobalController.brw.validateSavedTestData(this.TBL_PLANS, data);
		return GlobalController.brw.initElements(PlansPage.class);
	}

	public PlansPage verifyCategoryName(String planDescription, String categoryName1, String categoryName2) throws Exception {
		this.selectAddedPlan(planDescription);
		this.validateCategoryLable(categoryName1, categoryName2);
		return GlobalController.brw.initElements(PlansPage.class);
	}

	/**
	 * This method will click on Plan
	 * 
	 * @throws Exception
	 */
	public PlansPage selectAddedPlan(String planDescription) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_PLAN_NAME, planDescription);
		return GlobalController.brw.initElements(PlansPage.class);
	}

	/**
	 * This method will click on Plan
	 * 
	 * @throws Exception
	 */
	public PlansPage validateCategoryLable(String CategoryName1, String CategoryName2) throws Exception {
		String category1 = GlobalController.brw.getText(this.CATEGORY_NAME1);
		Assert.assertEquals(category1, CategoryName1);
		String category2 = GlobalController.brw.getText(this.CATEGORY_NAME2);
		Assert.assertEquals(category2, CategoryName2);
		return GlobalController.brw.initElements(PlansPage.class);
	}

	public String addPlanYearly(AddPlanField addPlanField, String userCategory, String productCategory, String testDataSetName,
			String category, String planPeriod) throws Exception {
		PlansPage.logger.enterMethod();

		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String rate = TestData.read("PagePlans.xml", testDataSetName, "rate", category);
		String bundleQuantity = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity", category);
		String rateProduct = TestData.read("PagePlans.xml", testDataSetName, "rateProduct", category);
		String pricing = TestData.read("PagePlans.xml", testDataSetName, "pricing", category);
		String bundledPeriod = TestData.read("PagePlans.xml", testDataSetName, "bundledPeriodOneTime", category);
		String note = TestData.read("PagePlans.xml", testDataSetName, "note", category);
		String precedence = TestData.read("PagePlans.xml", testDataSetName, "precedence", category);
		String bundleQuantity2 = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity2", category);
		String rateProduct2 = TestData.read("PagePlans.xml", testDataSetName, "rateProduct2", category);
		String bundledPeriodOneTime = TestData.read("PagePlans.xml", testDataSetName, "bundledPeriodOneTime", category);
		String type = TestData.read("PagePlans.xml", testDataSetName, "type", category);

		switch (addPlanField) {
		case ALL:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			// this.selectPricicngDropdown(pricing);
			this.setBundleQuantity(bundleQuantity);
			this.setModelRate(rateProduct);
			this.clickUpdate();
			break;
		case PRODUCT:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.setBundleQuantity(bundleQuantity);
			this.clickUpdate();
			break;
		case BUNDLEDPERIOD:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.selectPlanPeriod(planPeriod);
			// this.selectOrderType(type);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			// this.selectPricicngDropdown(pricing);
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.selectBundeledPeriod(bundledPeriodOneTime);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();
			break;
		case WITHNOTE:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.enterNotes(note);
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.verifyMetaField();
			this.enterPrecedence(precedence);
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.selectBundeledPeriod(bundledPeriod);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();

			break;

		default:
			throw new Exception("Invalid Step Provided. Not defined in enumeration");
		}

		this.clickSaveChanges();

		PlansPage.logger.exitMethod();
		return englishDescription;
	}

	/**
	 * this order will add monthly plan
	 * 
	 * @author shanky
	 * @param addPlanField
	 * @param userCategory
	 * @param productCategory
	 * @param testDataSetName
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public String addPlanMonthly(AddPlanField addPlanField, String userCategory, String productCategory, String testDataSetName,
			String category) throws Exception {
		PlansPage.logger.enterMethod();

		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String rate = TestData.read("PagePlans.xml", testDataSetName, "rate", category);
		String bundleQuantity = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity", category);
		String rateProduct = TestData.read("PagePlans.xml", testDataSetName, "rateProduct", category);
		String pricing = TestData.read("PagePlans.xml", testDataSetName, "pricing", category);
		String bundledPeriod = TestData.read("PagePlans.xml", testDataSetName, "bundledPeriodOneTime", category);
		String note = TestData.read("PagePlans.xml", testDataSetName, "note", category);
		String precedence = TestData.read("PagePlans.xml", testDataSetName, "precedence", category);
		String bundleQuantity2 = TestData.read("PagePlans.xml", testDataSetName, "bundleQuantity2", category);
		String rateProduct2 = TestData.read("PagePlans.xml", testDataSetName, "rateProduct2", category);

		switch (addPlanField) {
		case ALL:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			// this.selectPricicngDropdown(pricing);
			this.setBundleQuantity(bundleQuantity);
			this.setModelRate(rateProduct);
			this.clickUpdate();
			break;
		case PRODUCT:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.setBundleQuantity(bundleQuantity);
			this.clickUpdate();
			break;
		case BUNDLEDPERIOD:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			// this.selectPricicngDropdown(pricing);
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.selectBundeledPeriod(bundledPeriod);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();
			break;
		case WITHNOTE:
			this.clickAddNewButton();
			this.setProductCode(productCode);
			this.selectAddDesctiption(description);
			this.clickAddNewDescription();
			this.setNewDescription(englishDescription);
			this.setRate(rate);
			this.selectCategory(userCategory);
			this.selectCurrentCompany();
			this.enterNotes(note);
			this.selectInsideProductsTab();
			this.selectProductCode(productCategory);
			this.verifyMetaField();
			this.enterPrecedence(precedence);
			this.setBundleQuantity(bundleQuantity);
			this.verifyMetaField();
			this.selectBundeledPeriod(bundledPeriod);
			this.verifyMetaField();
			this.setModelRate(rateProduct);
			this.clickUpdate();

			break;

		default:
			throw new Exception("Invalid Step Provided. Not defined in enumeration");
		}

		this.clickSaveChanges();

		PlansPage.logger.exitMethod();
		return englishDescription;
	}

	/**
	 * This wrapper method will add plan with selecting currency in it
	 * 
	 * @throws Exception
	 */
	public String addPlanWithDifferentCurrency(String userCategory, String productCategory, String testDataSetName, String category)
			throws Exception {

		String productCode = TestData.read("PagePlans.xml", testDataSetName, "productCode", category);
		String description = TestData.read("PagePlans.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PagePlans.xml", testDataSetName, "englishDescription", category);
		String differentcurrency = TestData.read("PagePlans.xml", testDataSetName, "currencydiffer", category);
		String rate = TestData.read("PagePlans.xml", testDataSetName, "rate", category);

		this.clickAddNewButton();
		this.setProductCode(productCode);
		this.selectAddDesctiption(description);
		this.clickAddNewDescription();
		this.setNewDescription(englishDescription);
		this.setRate(rate);
		this.selectCategory(userCategory);
		this.selectCurrentCompany();
		this.setDifferentCurrency(differentcurrency);
		this.selectInsideProductsTab();
		this.selectProductCode(productCategory);
		this.clickSaveChanges();
		PlansPage.logger.exitMethod();
		return englishDescription;
	}

	/**
	 * This method will set currency value
	 * 
	 * @throws Exception
	 */
	public PlansPage setDifferentCurrency(String currency) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_Currency, currency);
		return GlobalController.brw.initElements(PlansPage.class);
	}
}
