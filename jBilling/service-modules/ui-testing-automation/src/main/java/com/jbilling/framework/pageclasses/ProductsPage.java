package com.jbilling.framework.pageclasses;

import org.testng.Assert;

import com.jbilling.framework.globals.GlobalConsts;
import com.jbilling.framework.globals.GlobalController;
import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.interfaces.ElementField;
import com.jbilling.framework.interfaces.LocateBy;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.setProductCategoryWithAssetMgmt;
import com.jbilling.framework.utilities.textutilities.TextUtilities;
import com.jbilling.framework.utilities.xmlutils.TestData;

public class ProductsPage {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@LocateBy(xpath = "//table[@id='categories']/tbody//strong[contains(text(),'New Test category')]/parent::a")
	private ElementField LT_PRODUCTCATEGORY;

	@LocateBy(xpath = "//table[@id='categories']/tbody//strong[contains(text(),'Asset Category 1')]/parent::a")
	private ElementField LT_ASSET_CATEGORY_1;

	@LocateBy(xpath = "//span[text()='Add Product']")
	private ElementField LT_AddProduct;

	@LocateBy(xpath = "//select[@id='newDescriptionLanguage']")
	private ElementField DD_ADDDESCRIPTION;

	@LocateBy(xpath = "//a[@onclick='addNewProductDescription()']")
	private ElementField LT_ADDDESCRIPTION;

	@LocateBy(xpath = "//label[contains(text(),'English Description')]/../div/input[1]")
	private ElementField TB_ENGLISHDESCRIPTION;

	@LocateBy(xpath = "//input[@id='product.number']")
	private ElementField TB_PRODUCTCODE;

	@LocateBy(xpath = "//input[@id='product.standardAvailability']")
	private ElementField CB_STANDARDAVAILABILITY;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//select[@id='product.accountTypes']")
	private ElementField DD_ACCOUNTTYPE;

	@LocateBy(id = "model.0.type")
	private ElementField DD_PRICINGMODEL;

	@LocateBy(xpath = "//input[@id='model.0.rateAsDecimal']")
	private ElementField TB_RATE;

	@LocateBy(xpath = "//select[@id='model.0.currencyId']")
	private ElementField DD_CURRENCY;

	@LocateBy(xpath = "//a[@class='submit save']//span[contains(text(),'Save Changes')]")
	private ElementField BT_SAVECHANGES;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Cancel']")
	private ElementField BT_CANCEL;

	@LocateBy(xpath = "//table[@id='products']/tbody//strong[contains(text(),'Flat 1 Priced Product')]")
	private ElementField LT_PRODUCT;

	@LocateBy(xpath = "//a[@class='submit edit']")
	private ElementField LT_EDITPRODUCT;

	@LocateBy(xpath = "//input[@id='product.standardPartnerPercentageAsDecimal']")
	private ElementField TB_AGENT;

	@LocateBy(xpath = "//input[@id='product.masterPartnerPercentageAsDecimal']")
	private ElementField TB_MASTER;

	@LocateBy(xpath = "//input[@id='plg-parm-provisionable_order_change_status_id']")
	private ElementField TB_PROVISIONABLE;

	@LocateBy(xpath = "//select[@id='company-select']")
	private ElementField DD_COMPANY;

	@LocateBy(xpath = "//ul[@class='top-nav']/li[1]")
	private ElementField TXT_COMPANY_NAME;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//div[@class='heading']//strong[contains(text(),'Add Product Category')]")
	private ElementField PageHeader_AddProductCategory;

	@LocateBy(xpath = "//span[text()='Add Category']")
	private ElementField LT_AddProductCategory;

	@LocateBy(xpath = "//select[@id='orderLineTypeId']//option")
	private ElementField Dropdown_AddProductCategory;

	@LocateBy(xpath = "//input[@id='description']")
	private ElementField TB_ProductCategoryName;

	@LocateBy(xpath = "//span[text()='Edit']")
	private ElementField LT_Edit;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Asset Statuses']")
	private ElementField Header_AssetStatusSection;

	@LocateBy(xpath = "//input[@id='lastStatusName']")
	private ElementField TB_AssetStatusName;

	@LocateBy(xpath = "//th[contains(text(),'Available')]/following::tbody/tr[1]/td[2]/input[@type='checkbox']")
	private ElementField CHK_Available;

	@LocateBy(xpath = "//th[contains(text(),'Available')]/following::tbody/tr[1]/td[3]/input[@type='checkbox']")
	private ElementField CHK_Default;

	@LocateBy(xpath = "//th[contains(text(),'Available')]/following::tbody/tr[2]/td[4]/input[@type='checkbox']")
	private ElementField CHK_OrderSave;

	@LocateBy(xpath = "//tr[@id='lastStatus']/td[5]/a/img")
	private ElementField BT_HiddenAssetStatus;

	@LocateBy(xpath = "//div[@id='assetMetaFields']//a[contains(@onclick, 'addMetaField')]")
	private ElementField BT_MetaField;

	@LocateBy(xpath = "//div[@id='assetMetaFields']//a[contains(@onclick, 'mfId')]")
	private ElementField BT_ImportMetaField;

	@LocateBy(xpath = "//div[@id='assetMetaFields']//a[contains(@onclick, 'groupId')]")
	private ElementField BT_ImportMetaFieldGroup;

	@LocateBy(xpath = "//input[@id='metaField2.name']")
	private ElementField TB_MetaFieldName;

	@LocateBy(xpath = "//table[@id='categories']/tbody/tr[1]/td/a/strong")
	private ElementField LT_CreatedProductCategory;

	@LocateBy(xpath = "//ul[@class='top-nav']/li[1]")
	private ElementField COMPANY;

	@LocateBy(xpath = "//select[@id = 'parentItemTypeId']")
	private ElementField DD_PARENT;

	@LocateBy(xpath = "//div[@class='menu-items']/ul/li-->>{TXT}Plug-ins{TXT}")
	private ElementField LT_PLUGINS;

	@LocateBy(xpath = "//strong[contains(text(),'Generic internal events listener')]")
	private ElementField LT_PLUGINGENERIC;

	@LocateBy(xpath = "//span[text()='Add New']")
	private ElementField LT_ADDNEW;

	@LocateBy(xpath = "//select[@id='typeId']")
	private ElementField DD_PLUGINTYPE;

	@LocateBy(xpath = "//input[@id='processingOrder']")
	private ElementField TB_ORDER;

	@LocateBy(xpath = "//span[text()='Save Plug-in']")
	private ElementField LT_SAVEPLUGIN;

	@LocateBy(xpath = "//div[@id='assetManagementEnabledDiv']/div/input[2]")
	private ElementField CB_ALLOWASSETMGMT;

	@LocateBy(xpath = "//span[text()='Add Asset']")
	private ElementField LT_ADDASSET;

	@LocateBy(xpath = "//span[text()='Add New']")
	private ElementField LT_ADDNEWASSET;

	@LocateBy(xpath = "//input[@id='identifier']")
	private ElementField TB_IDENTIFIER;

	@LocateBy(xpath = "//span[text()='Save Changes']")
	private ElementField LT_SAVECHANGES;

	@LocateBy(xpath = "//strong[contains(text(),'Agent Commission Calculation Process.')]")
	private ElementField LT_PLUGINAGENT;

	@LocateBy(xpath = "//input[@id='description']")
	private ElementField TB_NAME;

	@LocateBy(xpath = "//label[text()='Included Quantity']/../div/input[2]")
	private ElementField TB_INCLUDED_QUANTITY;

	@LocateBy(xpath = "//span[text()='Dependencies']")
	private ElementField LT_DEPENDENCIES;

	@LocateBy(xpath = "//select[@id='product.dependencyItemTypes']")
	private ElementField DD_PRODUCT_CATEGORY;

	@LocateBy(xpath = "//select[@id='product.dependencyItems']")
	private ElementField DD_PRODUCT;

	@LocateBy(xpath = "//img[@alt='Add']")
	private ElementField LT_ADD_PLUS_BUTTON;

	@LocateBy(xpath = "//table[@id='users']/tbody/tr/td/a/strong")
	private ElementField USERS_TABLE_CELL;

	@LocateBy(xpath = "//table[@id='categories']")
	private ElementField TBL_CATEGORIES_TABLE;

	@LocateBy(xpath = "//table[@id='products']")
	private ElementField TBL_PRODUCT_TABLE;

	@LocateBy(xpath = "//table[@id='categories']/tbody/tr/td/a/strong")
	private ElementField TAB_PRODUCT_CATEGORY;

	@LocateBy(xpath = "//table[@id='products']/tbody/tr/td/a/strong")
	private ElementField TAB_PRODUCT_NAME;

	@LocateBy(xpath = "")
	private ElementField TAB_PRODUCTS_ONE;

	@LocateBy(xpath = "")
	private ElementField TAB_PRODUCTS_TWO;

	@LocateBy(xpath = "//span[text()='Delete']")
	private ElementField LT_DELETE;

	@LocateBy(xpath = "//button/span[text()='Yes']")
	private ElementField LT_CONFIRM_YES;

	@LocateBy(xpath = "//span[contains(text(),'Add Category')]")
	private ElementField LT_ADD_CATEGORY;

	@LocateBy(xpath = "")
	private ElementField LT_FIRST_CATEGORY;

	@LocateBy(xpath = "")
	private ElementField BT_SHOW_ASSETS;

	@LocateBy(xpath = "")
	private ElementField TAB_ASSET;

	@LocateBy(xpath = "")
	private ElementField TXT_ASSET_NAME;

	@LocateBy(xpath = "//div[@id='breadcrumbs']")
	private ElementField BREADCRUMBS;

	@LocateBy(id = "global-checkbox")
	private ElementField CB_GLOBLE;

	@LocateBy(id = "assetManagementEnabled")
	private ElementField CB_ASSET_MANAGEMENT_ENABLED;

	@LocateBy(id = "allowAssetManagement")
	private ElementField CB_ALLOW_ASSET_MANAGEMENT;

	@LocateBy(id = "lastStatusAvailable")
	private ElementField CB_AVAILABLE;

	@LocateBy(xpath = "//*[@id='lastStatus']/td[5]/a/img")
	private ElementField PLUS_IMG_ICON;

	@LocateBy(id = "lastStatusOrderSaved")
	private ElementField CB_ORDER_SAVED;

	@LocateBy(id = "description")
	private ElementField TF_NAME;

	@LocateBy(xpath = "//span[contains(text(), 'Save Changes')]")
	private ElementField BT_SAVE_CHANGE;

	@LocateBy(id = "lastStatusDefault")
	private ElementField CB_DEFAULT;

	@LocateBy(xpath = "//span[contains(text(),'Add Product')]")
	private ElementField BT_ADD_PRODUCT;

	@LocateBy(xpath = "//*[@id='addDescription']/div/a/img")
	private ElementField ADD_DESCRIPTION_ICON;

	@LocateBy(id = "product.descriptions[1].content")
	private ElementField TF_PRODUCT_DESCRIPTION;

	@LocateBy(id = "product.number")
	private ElementField TF_PRODUCT_CODE;

	@LocateBy(id = "newDescriptionLanguage")
	private ElementField DD_ADD_DESCRIPTION;

	@LocateBy(xpath = "//input[@id='assetManagement']")
	private ElementField ALLOW_ASSET_MANAGEMENT_CHECKBOX;

	@LocateBy(id = "model.0.type")
	private ElementField DD_Price;

	@LocateBy(id = "model.0.rateAsDecimal")
	private ElementField TF_RATE;

	@LocateBy(id = "product.priceModelCompanyId")
	private ElementField DD_COMPANY_NAME;

	@LocateBy(xpath = "//span[contains(text(),'Add Asset')]")
	private ElementField BT_ADD_ASSET;

	@LocateBy(xpath = "//span[contains(text(),'Add New')]")
	private ElementField BT_ADD_NEW_ASSET;

	@LocateBy(xpath = "//th[text()='Name']/following::tbody/tr[1]/td/input[@type='text']")
	private ElementField TF_ASSET_NAME1;

	@LocateBy(xpath = "//th[text()='Name']/following::tbody/tr[contains(@id,'lastStatus')]//td//input[@type='text']")
	private ElementField TF_ASSET_NAME2;

	@LocateBy(xpath = "//table[@id='categories']//tbody//tr//td")
	private ElementField TABLE_CATEGORY_FIRST_CELL;

	@LocateBy(xpath = "//table[@id='categories']")
	private ElementField TABLE_CATEGORY;

	@LocateBy(xpath = "//table[@id='products']")
	private ElementField TABLE_PRODUCT;

	// N.B. fix in jbilling. table id should be changed to 'assets'
	@LocateBy(xpath = "//table[@id='users']")
	private ElementField TABLE_ASSET;

	@LocateBy(id = "product.dependencyMin")
	private ElementField MINIMUM;

	@LocateBy(id = "product.dependencyMax")
	private ElementField MAXIMUM;

	@LocateBy(xpath = "//table[@id='categories']/tbody//td/a/strong")
	private ElementField PRODUCT_CATEGORY_LIST;

	@LocateBy(xpath = "//table[@id='products']/tbody//td/a/strong")
	private ElementField PRODUCT_NAME_LIST;

	@LocateBy(xpath = "//div[@class='form-columns']/div/div/span")
	private ElementField PRODUCT_ID;

	@LocateBy(xpath = "//div[@class='form-columns']/div/div/span")
	private ElementField CATEGORY_NAME;

	@LocateBy(xpath = "//div[@class = 'buttons']//span[text()='Save Changes']")
	private ElementField BT_EDIT_SAVECHANGES;

	@LocateBy(xpath = "//span[text()='Dependencies']/parent::div[@class = 'box-cards-title']/following-sibling::div[@class = 'box-card-hold']/div/table[@class = 'dataTable']")
	private ElementField ADDED_DEPENDENCY_LIST;
	@LocateBy(xpath = "//input[contains(@data-customtooltip,'The cap on the maximum amount on the total')]")
	private ElementField Maximum;

	@LocateBy(id = "assetIdentifierLabel")
	private ElementField ASSET_IDE_LABEL;

	@LocateBy(xpath = "//div[@class='field-name']//label//span/following::div")
	private ElementField TB_MD_NAME;

	@LocateBy(id = "mandatoryCheck")
	private ElementField CB_NEW_MANDATORY;

	@LocateBy(xpath = "//label[text()='Import Meta Field']/following::select/option")
	private ElementField ASSET_META_DATA;

	@LocateBy(xpath = "//label[text()='Default value']/following::div/input")
	private ElementField META_DATA_DEFAULT_VALUE;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'If mediation is used this field is required.')]")
	private ElementField Date;

	@LocateBy(id = "model.0.attribute.2.value")
	private ElementField TimeSet;

	@LocateBy(xpath = "//input[@id='model.0.attribute.1.value']")
	private ElementField Range;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'This represents the range starting value')]")
	private ElementField From;

	@LocateBy(xpath = "//input[@data-customtooltip='This is the rate for the range starting from this value(inclusive)']")
	private ElementField Rate1;

	@LocateBy(xpath = "//a[@onclick ='addModelAttribute(this, 0, 2)']")
	private ElementField NewAttribute;

	@LocateBy(xpath = " //input[@name='model.0.attribute.3.name']")
	private ElementField From1;

	@LocateBy(xpath = "//input[contains(@name,'model.0.attribute.3.value')]")
	private ElementField Rate2;

	@LocateBy(xpath = "//a[@onclick ='addModelAttribute(this, 0, 3)']")
	private ElementField NewAttribute1;

	@LocateBy(xpath = " //input[@name='model.0.attribute.4.name']")
	private ElementField From2;

	@LocateBy(xpath = "//input[contains(@name,'model.0.attribute.4.value')]")
	private ElementField Rate3;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'Number of pulled products to be purchased, to be able to get this product as a bonus')]")
	private ElementField Multiplier;

	@LocateBy(xpath = "//select[contains(@name,'model.0.attribute.1.value')]")
	private ElementField SelectCategory;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'The calculation to determine the percentage is Selection Category/Category Percent x 100')]")
	private ElementField CategoryPercantage;

	@LocateBy(xpath = "//input[@data-customtooltip='Pair range between percentage calculated and the ID the product added, starting from 0 percent']")
	private ElementField ZeroField;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'Pair range between quantity of products in selected category and the ID the product added, starting from 1')]")
	private ElementField OneField;

	@LocateBy(xpath = "//input[@name='model.0.attribute.1.name']")
	private ElementField ProductID;

	@LocateBy(xpath = "//input[@name='model.0.attribute.1.value']")
	private ElementField Quantity;

	@LocateBy(xpath = "//span[contains(.,'Add Chain')]")
	private ElementField BT_AddChain;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'The rate of the product after the included quantity')]")
	private ElementField TB_GraduateRate;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'Number of included products for free')]")
	private ElementField TB_GraduateIncludedQuantity;

	@LocateBy(xpath = "//table[@id='categories']/tbody//strong[contains(text(),'Test category')]")
	private ElementField LT_CATEGORY;

	@LocateBy(xpath = "//strong[text()='Lemonade']")
	private ElementField TEXT_LEMONADE;

	@LocateBy(xpath = "	//strong[text()='Coffee']")
	private ElementField TEXT_COFFEE;

	@LocateBy(xpath = "//*[@id='product.dependencyItems']/option[2]")
	private ElementField SELECT_SECOND_AS_DEFAULT;

	@LocateBy(xpath = "//*[@id='save-product-form']/fieldset/div[7]/ul/li[1]/a")
	private ElementField CLICK_SAVE_BUTTON;

	@LocateBy(xpath = "//table[@id='categories']/tbody/tr/td/a/strong")
	private ElementField LT_Created_Category;

	@LocateBy(xpath = "//div[id='column2']//table[@class='innerTable']")
	private ElementField ASSET_HISTORY;

	@LocateBy(xpath = "//div[id='column2']//table[@class='dataTable']")
	private ElementField PRODUCT_DETAIL;

	@LocateBy(xpath = "//input[@id='onePerOrder']")
	private ElementField CHK_ONE_ITEM_PER_ORDER;

	@LocateBy(xpath = "//input[@id='onePerCustomer']")
	private ElementField CHK_ONE_ITEM_PER_CUSTOMER;

	@LocateBy(xpath = "//input[@id='product.activeSince']")
	private ElementField TB_START_DATE;

	@LocateBy(xpath = "//input[@id='product.activeUntil']")
	private ElementField TB_END_DATE;

	@LocateBy(xpath = "//input[@id='product.dependencyMax']")
	private ElementField MAXIMUMVALUE;

	@LocateBy(xpath = "//td[text()='Product Id']/following-sibling::td")
	private ElementField PRODUCT_ID_RUNTIME;

	@LocateBy(xpath = "//span[text()='Order meta fields']")
	private ElementField OTHER_META_FIELD;

	@LocateBy(xpath = "//span[text()='Add new metafield']")
	private ElementField BT_ADDMETAFIELD;

	@LocateBy(xpath = "(//*[@id='metaField2.name'])[1]")
	private ElementField TB_NAME_METAFIELD;

	@LocateBy(xpath = "//*[@id='metaField2.dataType']")
	private ElementField DD_DATATYPE_METAFIELD;

	@LocateBy(xpath = "//*[@id='metaField2.displayOrder']")
	private ElementField TB_DISPLAY_ORDER;

	@LocateBy(xpath = "(//*[@id='metaField3.name'])[1]")
	private ElementField TB_NAME_METAFIELD_SECOND;

	@LocateBy(xpath = "//*[@id='metaField3.dataType']")
	private ElementField DD_DATATYPE_METAFIELD_SECOND;

	@LocateBy(xpath = "(//span[text()='Update'])[1]")
	private ElementField BT_UPDATE_FIRST;

	@LocateBy(xpath = "(//span[text()='Update'])[2]")
	private ElementField BT_UPDATE_SECOND;

	@LocateBy(xpath = "(//*[@id='mandatoryCheck'])[1]")
	private ElementField CB_MANDATORY;

	@LocateBy(xpath = "(//*[@id='mandatoryCheck'])[2]")
	private ElementField CB_MANDATORY_SECOND;

	@LocateBy(xpath = "//input[@name='model.0.attribute.1.value']")
	private ElementField TB_CategoryID;

	@LocateBy(xpath = "//input[contains(@data-customtooltip,'Applied percentage')]")
	private ElementField TB_Percantage;

	@LocateBy(xpath = "//select[@id='model.1.type']")
	private ElementField DD_PRICING;

	@LocateBy(xpath = "//label[text()='Category ID']/following-sibling::span")
	private ElementField CATEGORY_ID;

	@LocateBy(xpath = "//input[@id='global-checkbox']")
	private ElementField CB_GLOBALCHECKBOX;

	@LocateBy(xpath = "//input[@id='onePerCustomer']")
	private ElementField CB_ONEITEMPERCUSTOMER;

	@LocateBy(xpath = "//a[@class='submit save']//span[contains(text(),'Save Changes')]")
	private ElementField LT_SaveProductCategory;

	@LocateBy(xpath = "//input[@id='product.activeSince']")
	private ElementField TB_STARTDATE;

	@LocateBy(xpath = "//input[@id='product.activeUntil']")
	private ElementField TB_ENDDATE;

	@LocateBy(xpath = "//select[@id='metaFieldTemplate-id']")
	private ElementField DD_METAFIELDVALUE;

	@LocateBy(xpath = "//div[@class='type-metafield-header']/span[2]/a/img")
	private ElementField IMG_ADDICON;

	@LocateBy(xpath = "//input[@id='assetManagementEnabled']")
	private ElementField CB_ALLOWASSETMANAGEMENT;

	@LocateBy(xpath = "//select[@id='assetStatusId']")
	private ElementField DD_ASSETSTATUS;

	@LocateBy(xpath = "//input[@id='asset-isGroup']")
	private ElementField CB_ISALLOWGROUP;

	@LocateBy(xpath = "//input[@class='field text ']")
	private ElementField TB_ASSETSVALUE;

	@LocateBy(xpath = "//input[@name='assetStatus.1.isAvailable']")
	private ElementField CHK_ASSETAVAILABLE;

	@LocateBy(xpath = "//input[@name='assetStatus.1.isOrderSaved']")
	private ElementField CHK_ORDERSAVED;

	@LocateBy(xpath = "//input[@name='assetStatus.1.isDefault']")
	private ElementField CHK_DEFAULT_1;

	/**
	 * This method will select Successful Product Category
	 */
	ProductsPage selectSuccessfulProductCategory() throws Exception {
		GlobalController.brw.clickLinkText(this.TAB_PRODUCT_CATEGORY);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will select Successful Product Category
	 */
	ProductsPage selectSuccessfulProduct() throws Exception {
		GlobalController.brw.clickLinkText(this.TAB_PRODUCT_NAME);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will select Product
	 *
	 * @throws Exception
	 */
	ProductsPage clickProductOne() throws Exception {
		GlobalController.brw.clickLinkText(this.TAB_PRODUCTS_ONE);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will select Asset Status
	 *
	 * @param currency
	 * @throws Exception
	 */
	ProductsPage selectAssetStatus(String AssetStatus) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_ASSETSTATUS, AssetStatus);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will add a asset with String data type
	 */

	public String addAssetForProductWithStringDataType(String testDataSetName, String category, boolean allowAsset) throws Exception {
		String identifier = TestData.read("PageProducts.xml", testDataSetName, "identifier", category);
		String AssetStatus = TestData.read("PageProducts.xml", testDataSetName, "AssetStatus", category);
		String value = TestData.read("PageProducts.xml", testDataSetName, "value", category);
		this.clickAddNew();
		this.assetDetails(identifier);
		this.selectAssetStatus(AssetStatus);
		this.checkIsAllowGroupChkBox(allowAsset);
		this.setAssets(value);
		this.clickSaveChanges();
		return identifier;
	}

	/**
	 * @author Syed
	 * @Description This method will set asset
	 */
	ProductsPage setAssets(String value) throws Exception {
		GlobalController.brw.setText(this.TB_ASSETSVALUE, value);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will check allow group
	 */
	ProductsPage checkIsAllowGroupChkBox(boolean allowAsset) throws Exception {
		if (allowAsset) {
			GlobalController.brw.check(this.CB_ISALLOWGROUP);
		} else {
			GlobalController.brw.uncheck(this.CB_ISALLOWGROUP);
		}
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select Product
	 *
	 * @throws Exception
	 */
	ProductsPage clickProductTwo() throws Exception {
		ProductsPage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.TAB_PRODUCTS_TWO);
		ProductsPage.logger.exitMethod();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click on Delete Button
	 *
	 * @throws Exception
	 */
	ProductsPage clickDelete() throws Exception {
		ProductsPage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.LT_DELETE);
		ProductsPage.logger.exitMethod();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click on confirm Yes
	 *
	 * @throws Exception
	 */
	ProductsPage clickConfirmYes() throws Exception {
		ProductsPage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.LT_CONFIRM_YES);
		ProductsPage.logger.exitMethod();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click on category
	 *
	 * @throws Exception
	 */
	public ProductsPage selectCategory(String category) throws Exception {
		GlobalController.brw.selectListItem(this.LT_Created_Category, category);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will click on Product
	 *
	 * @throws Exception
	 */
	public ProductsPage selectAddedProduct(String productName) throws Exception {
		GlobalController.brw.selectListItem(this.TAB_PRODUCT_NAME, productName);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will click on Asset
	 *
	 * @throws Exception
	 */
	public ProductsPage selectAddedAsset(String assetName) throws Exception {
		GlobalController.brw.selectListItem(this.USERS_TABLE_CELL, assetName);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will click on Add Category Button
	 *
	 * @throws Exception
	 */
	public ProductsPage clickAddCategory() throws Exception {
		ProductsPage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.LT_ADD_CATEGORY);
		ProductsPage.logger.exitMethod();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage selectCategory() throws Exception {
		ProductsPage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.LT_PRODUCTCATEGORY);
		ProductsPage.logger.exitMethod();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage selectRecentCategory() throws Exception {

		ProductsPage.logger.enterMethod();
		String Category = GlobalController.brw.getText(this.LT_FIRST_CATEGORY);

		GlobalController.brw.selectTableRowItem(this.LT_FIRST_CATEGORY, Category);
		ProductsPage.logger.exitMethod();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage clickShowAssets() throws Exception {
		ProductsPage.logger.enterMethod();

		GlobalController.brw.clickLinkText(this.BT_SHOW_ASSETS);
		ProductsPage.logger.exitMethod();

		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage verifyAssetPresent(String assetName) throws Exception {
		ProductsPage.logger.enterMethod();

		GlobalController.brw.clickTableCellWithText(this.TAB_ASSET, assetName);
		String asset = GlobalController.brw.getText(this.TXT_ASSET_NAME);
		if (TextUtilities.contains(asset, assetName)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		ProductsPage.logger.exitMethod();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author syed
	 * @Description This method will check the global checkbox
	 *
	 */
	protected ProductsPage checkGlobal(Boolean Global) throws Exception {
		if (Global) {
			GlobalController.brw.check(this.CB_GLOBALCHECKBOX);
		} else {
			GlobalController.brw.uncheck(this.CB_GLOBALCHECKBOX);
		}
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * @author syed
	 * @description This method will create the Global category
	 * @param testDataSetName
	 * @param category
	 * @param OneItem
	 * @return
	 * @throws Exception
	 */
	public String addCategorywithGlobal(String testDataSetName, String category, boolean OneItem) throws Exception {
		String name = TestData.read("PageProducts.xml", testDataSetName, "categoryName", category);
		System.out.println("name" + name);
		this.clickAddCategory();
		this.setCategoryName(name);
		this.checkGlobal(OneItem);
		this.checkOneItemPerCustomer(OneItem);
		// this.selectCurrentCompany();
		this.clickSaveCategory();
		return name;

	}

	/**
	 * @author syed
	 * @Description This method will check One Item Per Order checkbox
	 */
	protected ProductsPage checkOneItemPerOrder(Boolean OneItem) throws Exception {
		if (OneItem) {
			GlobalController.brw.check(this.CHK_ONE_ITEM_PER_ORDER);
		} else {
			GlobalController.brw.uncheck(this.CHK_ONE_ITEM_PER_ORDER);
		}
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * @author syed
	 * @Description This method will create a category with One Item Per order
	 */

	public String addCategoryWithOneItemPerOrder(String testDataSetName, String category, boolean OneItem) throws Exception {
		String name = TestData.read("PageProducts.xml", testDataSetName, "categoryName", category);

		this.clickAddCategory();
		this.setCategoryName(name);
		this.checkGlobal(OneItem);
		this.checkOneItemPerOrder(OneItem);
		// this.selectCurrentCompany();
		this.clickSaveCategory();
		return name;

	}

	/**
	 * @author syed
	 * @Description This method will Add a Global product
	 */
	public String addProductwithGlobal(String testDataSetName, String category, boolean global) throws Exception {
		String description = TestData.read("PageProducts.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		this.clickAddProduct();
		this.selectAddDescription(description);
		this.clickAddDescription();

		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.checkGlobal(global);
		this.clickSaveChanges();
		return englishDescription;

	}

	/**
	 * @author syed
	 * @Description This method will click on save category Button
	 */
	ProductsPage clickSaveCategory() throws Exception {
		GlobalController.brw.click(this.LT_SaveProductCategory);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author syed
	 * @param OneItem
	 * @Description This method will check the One Item per Customer checkbox
	 * @return
	 * @throws Exception
	 */
	protected ProductsPage checkOneItemPerCustomer(Boolean OneItem) throws Exception {
		if (OneItem) {
			GlobalController.brw.check(this.CB_ONEITEMPERCUSTOMER);
		} else {
			GlobalController.brw.uncheck(this.CB_ONEITEMPERCUSTOMER);
		}
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * Add Product Form
	 *
	 * @param paptcd
	 * @throws Exception
	 */

	ProductsPage addProductCategory() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PRODUCTCATEGORY);
		GlobalController.brw.waitForAjaxElement(this.LT_AddProduct);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public void selectAssetCategory1() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ASSET_CATEGORY_1);
	}

	ProductsPage checkStandardAvailability(boolean standardAvailability) throws Exception {
		if (standardAvailability) {
			GlobalController.brw.check(this.CB_STANDARDAVAILABILITY);
		} else {
			GlobalController.brw.uncheck(this.CB_STANDARDAVAILABILITY);
		}
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	// Disabled field
	// GlobalController.brw.selectDropDown(ElementFieldsReader.GetElement(this.loadFields(),
	// "DD_ACCOUNTTYPE"),
	// paptcd.);
	ProductsPage selectPricingModel(String pricingModel) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRICINGMODEL, pricingModel);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage clickProductToEdit() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PRODUCT);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage ClickEditProduct() throws Exception {
		GlobalController.brw.waitForAjaxElement(this.LT_EDITPRODUCT);
		GlobalController.brw.waitUntilElementStopMoving(this.LT_EDITPRODUCT);
		GlobalController.brw.clickLinkText(this.LT_EDITPRODUCT);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage setAgentCommission(String agent) throws Exception {
		GlobalController.brw.setText(this.TB_AGENT, agent);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage setMasterCommission(String master) throws Exception {
		GlobalController.brw.setText(this.TB_MASTER, master);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage verifySavedProduct() throws Exception {
		MessagesPage.isIntermediateSuccessMessageAppeared();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Category Name
	 *
	 * @param productCategoryName
	 * @throws Exception
	 */
	ProductsPage setCategoryName(String productCategoryName) throws Exception {
		GlobalController.brw.setText(this.TB_ProductCategoryName, productCategoryName);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select recent Category
	 *
	 * @throws Exception
	 */
	ProductsPage clickRecentCreatedcategory() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_CreatedProductCategory);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click on Edit button
	 *
	 * @throws Exception
	 */
	ProductsPage clickEdit() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_Edit);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select current company
	 *
	 *
	 * @throws Exception
	 */
	ProductsPage selectCurrentCompany() throws Exception {
		String company = GlobalController.brw.getText(this.COMPANY);
		GlobalController.brw.selectDropDown(this.DD_COMPANY, company);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select second option from Product Dropdown
	 *
	 *
	 * @throws Exception
	 */
	ProductsPage selectsecondoption() throws Exception {
		String company = GlobalController.brw.getText(this.SELECT_SECOND_AS_DEFAULT);
		GlobalController.brw.selectDropDown(this.DD_PRODUCT, company);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select parent category
	 *
	 *
	 * @throws Exception
	 */
	ProductsPage selectParentCategory(String parent) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PARENT, parent);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will Select Plugin value
	 *
	 *
	 * @throws Exception
	 */
	ProductsPage selectPluginsInConfiguration() throws Exception {
		GlobalController.brw.selectListItem(this.LT_PLUGINS, GlobalConsts.USE_EXTENDED_TEXT_TO_XPATH);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage clickPluginGeneric() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PLUGINGENERIC);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage clickAddNew() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDNEW);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will select product value
	 *
	 *
	 * @throws Exception
	 */
	ProductsPage selectPluginTypeDropdown(String pluginType) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PLUGINTYPE, pluginType);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will Set order in plugin value
	 *
	 *
	 * @throws Exception
	 */
	ProductsPage setOrder(String order) throws Exception {
		GlobalController.brw.setText(this.TB_ORDER, order);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage setProvisionableField(String provision_ID) throws Exception {
		GlobalController.brw.setText(this.TB_PROVISIONABLE, provision_ID);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will Save Value in plugin
	 *
	 *
	 * @throws Exception
	 */
	ProductsPage clickSavePluginButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_SAVEPLUGIN);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage SelectProductCategory() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PRODUCTCATEGORY);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage clickAddProduct() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_AddProduct);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage setEnglishDescription(String englishDescription) throws Exception {
		GlobalController.brw.setText(this.TB_ENGLISHDESCRIPTION, englishDescription);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage checkAssetManagement(Boolean assetManage) throws Exception {
		if (assetManage) {
			GlobalController.brw.check(this.CB_ASSET_MANAGEMENT_ENABLED);
		} else {
			GlobalController.brw.uncheck(this.CB_ASSET_MANAGEMENT_ENABLED);
		}
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage selectDropdownCurrency(String currency) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_CURRENCY, currency);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage addAsset() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDASSET);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage addChildAsset() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_ADD_NEW_ASSET);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage assetDetails(String identifier) throws Exception {
		GlobalController.brw.setText(this.TB_IDENTIFIER, identifier);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage addNewAsset() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDNEWASSET);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage clickPluginAgentCommision() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PLUGINAGENT);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage verifySavedPlugin() throws Exception {
		MessagesPage.isIntermediateSuccessMessageAppeared();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage clickAddProductCategory() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_AddProductCategory);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage setProductCategoryName(String assetCategory) throws Exception {
		GlobalController.brw.setText(this.TB_ProductCategoryName, assetCategory);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage checkAllowAssetManagement() throws Exception {
		GlobalController.brw.check(this.CB_ALLOW_ASSET_MANAGEMENT);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage setAssetStatusName(String assetStatusName) throws Exception {
		GlobalController.brw.setText(this.TB_AssetStatusName, assetStatusName);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage checkAvailable() throws Exception {
		GlobalController.brw.check(this.CHK_Available);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage checkDefault() throws Exception {
		GlobalController.brw.check(this.CHK_Default);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage clickHiddenStatus() throws Exception {
		GlobalController.brw.click(this.BT_HiddenAssetStatus);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author Syed
	 * @description This method will check available under asset option
	 * @return
	 * @throws Exception
	 */
	ProductsPage checkAssetAvailable() throws Exception {
		GlobalController.brw.check(this.CHK_ASSETAVAILABLE);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author Syed
	 * @description This method will check order saved under asset option
	 * @return
	 * @throws Exception
	 */
	ProductsPage checkAssetOrderSaved() throws Exception {
		GlobalController.brw.check(this.CHK_ORDERSAVED);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author Syed
	 * @description This method will check order saved under asset option
	 * @return
	 * @throws Exception
	 */
	ProductsPage checkAssetDefaultSaved() throws Exception {
		GlobalController.brw.check(this.CHK_DEFAULT_1);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage checkOrderSave() throws Exception {
		GlobalController.brw.check(this.CHK_OrderSave);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage clickMetaField() throws Exception {
		GlobalController.brw.isElementPresent(this.BT_MetaField);
		GlobalController.brw.click(this.BT_MetaField);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	ProductsPage clickImportMetaField() throws Exception {
		GlobalController.brw.isElementPresent(this.BT_ImportMetaField);
		GlobalController.brw.click(this.BT_ImportMetaField);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	ProductsPage clickImportMetaFieldGroup() throws Exception {
		GlobalController.brw.isElementPresent(this.BT_ImportMetaFieldGroup);
		GlobalController.brw.click(this.BT_ImportMetaFieldGroup);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	ProductsPage setMetafieldName(String assetStatusName) throws Exception {
		GlobalController.brw.setText(this.TB_MetaFieldName, assetStatusName);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Name
	 */
	ProductsPage setName(String name) throws Exception {
		GlobalController.brw.setText(this.TB_NAME, name);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will Add description
	 *
	 * @param description
	 * @throws Exception
	 */
	ProductsPage selectAddDescription(String description) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_ADDDESCRIPTION, description);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click image + button
	 *
	 * @throws Exception
	 */
	ProductsPage clickAddDescription() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDDESCRIPTION);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Rate in Graduate
	 *
	 * @param Graduate
	 *            Rate
	 * @throws Exception
	 */
	ProductsPage setGraduateRate(String GraduateRate) throws Exception {
		GlobalController.brw.setText(this.TB_GraduateRate, GraduateRate);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set description
	 *
	 * @param englishDescription
	 * @throws Exception
	 */
	ProductsPage setDescription(String englishDescription) throws Exception {
		GlobalController.brw.setText(this.TB_ENGLISHDESCRIPTION, englishDescription);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Included quantity in Graduate
	 *
	 * @param Graduate
	 *            quantity
	 * @throws Exception
	 */
	ProductsPage setGraduateIncludedQuantity(String GraduateQuantity) throws Exception {
		GlobalController.brw.setText(this.TB_GraduateIncludedQuantity, GraduateQuantity);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Product Code
	 *
	 * @param productCode
	 * @throws Exception
	 */
	ProductsPage setProductCode(String productCode) throws Exception {
		GlobalController.brw.setText(this.TB_PRODUCTCODE, productCode);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select company from company dropdown
	 *
	 * @param company
	 * @throws Exception
	 */
	ProductsPage selectCompany() throws Exception {
		String text = GlobalController.brw.getText(this.TXT_COMPANY_NAME);

		GlobalController.brw.selectDropDown(this.DD_COMPANY, text);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set IncludedQuantity
	 *
	 * @param rate
	 * @throws Exception
	 */
	ProductsPage setIncludedQuantity(String includedQuantity) throws Exception {
		GlobalController.brw.setText(this.TB_INCLUDED_QUANTITY, includedQuantity);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select Currency
	 *
	 * @param currency
	 * @throws Exception
	 */
	ProductsPage selectCurrency(String currency) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_CURRENCY, currency);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select product category
	 *
	 * @param currency
	 * @throws Exception
	 */
	ProductsPage selectProductCategory(String Category) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRODUCT_CATEGORY, Category);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Maximum
	 *
	 * @param Maximum
	 * @throws Exception
	 */
	ProductsPage setMaximum(String maximum) throws Exception {
		GlobalController.brw.setText(this.Maximum, maximum);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Maximum
	 *
	 * @param Maximum
	 * @throws Exception
	 */
	ProductsPage selectCategoryID(String CategoryID) throws Exception {
		GlobalController.brw.selectDropDown(this.SelectCategory, CategoryID);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Date
	 *
	 * @param Date
	 * @throws Exception
	 */
	ProductsPage setDate(String date) throws Exception {
		GlobalController.brw.setText(this.Date, date);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set TimeSet
	 *
	 * @param TimeSet
	 * @throws Exception
	 */
	ProductsPage setTimeField(String TimeValue) throws Exception {
		GlobalController.brw.setText(this.TimeSet, TimeValue);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Range
	 *
	 * @param Range
	 * @throws Exception
	 */
	ProductsPage setRange(String Range) throws Exception {
		GlobalController.brw.setText(this.Range, Range);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set From
	 *
	 * @param From
	 * @throws Exception
	 */
	ProductsPage setFrom(String From) throws Exception {
		GlobalController.brw.setText(this.From, From);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Rate1
	 *
	 * @param Rate1
	 * @throws Exception
	 */
	ProductsPage setToRate(String Rate1) throws Exception {
		GlobalController.brw.setText(this.Rate1, Rate1);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set From1
	 *
	 * @param From1
	 * @throws Exception
	 */
	ProductsPage setFrom1(String From1) throws Exception {
		GlobalController.brw.setText(this.From1, From1);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Rate1
	 *
	 * @param Rate1
	 * @throws Exception
	 */
	ProductsPage setToRate2(String Rate2) throws Exception {
		GlobalController.brw.setText(this.Rate2, Rate2);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set From1
	 *
	 * @param From1
	 * @throws Exception
	 */
	ProductsPage setFrom2(String From2) throws Exception {
		GlobalController.brw.setText(this.From2, From2);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Rate1
	 *
	 * @param Rate1
	 * @throws Exception
	 */
	ProductsPage setToRate3(String Rate3) throws Exception {
		GlobalController.brw.setText(this.Rate3, Rate3);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Multiplier
	 *
	 * @param Multiplier
	 * @throws Exception
	 */
	ProductsPage setMultiplier(String Multiplier) throws Exception {
		GlobalController.brw.setText(this.Multiplier, Multiplier);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click image + button
	 *
	 * @throws Exception
	 */
	ProductsPage clickAddNewAttribute() throws Exception {
		GlobalController.brw.clickLinkText(this.NewAttribute);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click image + button
	 *
	 * @throws Exception
	 */
	ProductsPage clickAddNewAttribute1() throws Exception {
		GlobalController.brw.clickLinkText(this.NewAttribute1);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Rate
	 *
	 * @param rate
	 * @throws Exception
	 */
	ProductsPage setRate(String rate) throws Exception {
		GlobalController.brw.setText(this.TB_RATE, rate);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select Currency
	 *
	 * @param currency
	 *            ======= This method will set ProductID
	 *
	 * @param ProductID
	 *            >>>>>>> .r110
	 * @throws Exception
	 */
	ProductsPage setProductID(String ProductID) throws Exception {
		GlobalController.brw.setText(this.ProductID, ProductID);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select product category
	 *
	 * @param currency
	 *            ======= This method will set Quantity
	 *
	 * @param Quantity
	 *            >>>>>>> .r110
	 * @throws Exception
	 */
	ProductsPage setQuantity(String Quantity) throws Exception {
		GlobalController.brw.setText(this.Quantity, Quantity);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click Add Chain button
	 *
	 * @throws Exception
	 */
	ProductsPage clickAddChain() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_AddChain);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will set Category Percentage
	 *
	 * @param Category
	 *            Percentage
	 *
	 * @throws Exception
	 */
	ProductsPage setPercentageCategory(String Percentage) throws Exception {
		GlobalController.brw.setText(this.CategoryPercantage, Percentage);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set OField
	 *
	 * @param rate
	 * @throws Exception
	 */
	ProductsPage setZero(String Zero) throws Exception {
		GlobalController.brw.setText(this.ZeroField, Zero);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set OField
	 *
	 * @param rate
	 * @throws Exception
	 */
	ProductsPage setOne(String One) throws Exception {
		GlobalController.brw.setText(this.OneField, One);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select product
	 *
	 * @param currency
	 * @throws Exception
	 */
	ProductsPage selectProduct(String product) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRODUCT, product);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click + button button
	 *
	 * @throws Exception
	 */
	ProductsPage clickImagePlusButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADD_PLUS_BUTTON);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click Dependencies
	 *
	 * @throws Exception
	 */
	ProductsPage clickDependencies() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_DEPENDENCIES);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click Save Changes button
	 *
	 * @throws Exception
	 */
	ProductsPage clickSaveChanges() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_SAVECHANGES);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This will enter minimum value in dependencies
	 *
	 * @param master
	 * @return
	 * @throws Exception
	 */
	ProductsPage setMimimumValue(String minimum) throws Exception {
		GlobalController.brw.setText(this.MINIMUM, minimum);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This will enter maximim value in dependencies
	 *
	 * @param master
	 * @return
	 * @throws Exception
	 */
	ProductsPage setMaximimValue(String maximum) throws Exception {
		GlobalController.brw.setText(this.MAXIMUM, maximum);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * Click on specified Category
	 *
	 * @throws Exception
	 */
	public ConfigurationPage clickSpecifiedCategoryInTheTable(String categoryName) throws Exception {
		GlobalController.brw.selectListItem(this.PRODUCT_CATEGORY_LIST, categoryName);
		return GlobalController.brw.initElements(ConfigurationPage.class);
	}

	/**
	 * Click on specified Product
	 *
	 * @throws Exception
	 */
	public ConfigurationPage clickSpecifiedProductInTheTable(String product) throws Exception {
		GlobalController.brw.selectListItem(this.PRODUCT_NAME_LIST, product);
		return GlobalController.brw.initElements(ConfigurationPage.class);
	}

	/**
	 * This method will select company from company dropdown
	 *
	 * @param company
	 * @throws Exception
	 */
	public String getProductID() throws Exception {
		String text = GlobalController.brw.getText(this.PRODUCT_ID);
		return text;

	}

	/**
	 * This method will get Text from textbox
	 *
	 * @param company
	 * @throws Exception
	 */
	public String getCategoryName() throws Exception {
		String text = GlobalController.brw.getText(this.CATEGORY_NAME);
		return text;

	}

	/**
	 * Check if the Product is present in the Dropdown
	 *
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public boolean isProductPresent(String productName) throws Exception {
		return GlobalController.brw.isValuePresentInDropDown(this.DD_PRODUCT, productName);
	}

	/**
	 * This method will click Save Changes button After Editing Any Product
	 *
	 * @throws Exception
	 */
	ProductsPage clickEditSaveChanges() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_EDIT_SAVECHANGES);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public String addProduct(AddProductField addProductField, String testDataSetName, String category) throws Exception {
		String description = TestData.read("PageProducts.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		String pricingModel = TestData.read("PageProducts.xml", testDataSetName, "pricingModel", category);
		String rate = TestData.read("PageProducts.xml", testDataSetName, "rate", category);
		String currency = TestData.read("PageProducts.xml", testDataSetName, "currency", category);
		String includedQuantity = TestData.read("PageProducts.xml", testDataSetName, "includedQuantity", category);
		String Maximum = TestData.read("PageProducts.xml", testDataSetName, "maximum", category);
		String Date = TestData.read("PageProducts.xml", testDataSetName, "Date", category);
		String TimeFormat = TestData.read("PageProducts.xml", testDataSetName, "Time", category);
		String Range = TestData.read("PageProducts.xml", testDataSetName, "Range", category);
		String From = TestData.read("PageProducts.xml", testDataSetName, "From", category);
		String Rate1 = TestData.read("PageProducts.xml", testDataSetName, "Rate", category);
		String From1 = TestData.read("PageProducts.xml", testDataSetName, "From1", category);
		String Rate2 = TestData.read("PageProducts.xml", testDataSetName, "Rate2", category);
		String From2 = TestData.read("PageProducts.xml", testDataSetName, "From2", category);
		String Rate3 = TestData.read("PageProducts.xml", testDataSetName, "Rate3", category);
		String Multiplier = TestData.read("PageProducts.xml", testDataSetName, "Multiplier", category);
		String CategoryID = TestData.read("PageProducts.xml", testDataSetName, "categoryID", category);
		String Percentage = TestData.read("PageProducts.xml", testDataSetName, "CategoryPercentage", category);
		String Zero = TestData.read("PageProducts.xml", testDataSetName, "Zero", category);
		String One = TestData.read("PageProducts.xml", testDataSetName, "One", category);
		String ProductID = TestData.read("PageProducts.xml", testDataSetName, "ProductID", category);
		String Quantity = TestData.read("PageProducts.xml", testDataSetName, "Quantity", category);
		String GraduateRate = TestData.read("PageProducts.xml", testDataSetName, "GraduateRate", category);
		String GraduateQuantity = TestData.read("PageProducts.xml", testDataSetName, "GraduateQuantity", category);
		String PooledCategoryID = TestData.read("PageProducts.xml", testDataSetName, "PoolingCategoryID", category);
		String PercentageValue = TestData.read("PageProducts.xml", testDataSetName, "PercentageValue", category);
		String pricing = TestData.read("PageProducts.xml", testDataSetName, "pricing", category);
		String StartDate = TestData.read("PageProducts.xml", testDataSetName, "StartDate", category);
		String EndDate = TestData.read("PageProducts.xml", testDataSetName, "EndDate", category);
		boolean standardAvailability = TextUtilities.compareValue(
				TestData.read("PageProducts.xml", testDataSetName, "standardAvailability", category), "true", true, TextComparators.equals);
		boolean assetManage = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "assetManage", category),
				"true", true, TextComparators.equals);
		boolean global = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "global", category), "true", true,
				TextComparators.equals);
		boolean globle = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "globle", category), "true", true,
				TextComparators.equals);

		switch (addProductField) {
		case FLAT:
			this.clickRecentCreatedcategory();
			this.clickAddProduct();
			this.selectAddDescription(description);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.setProductCode(productCode);
			this.selectCurrentCompany();
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			this.selectCurrency(currency);

			break;
		case LINEPERCENTAGE:
			this.addProductCategory();
			this.clickAddProduct();
			this.selectAddDescription(description);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.setProductCode(productCode);
			this.checkStandardAvailability(standardAvailability);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			break;

		case ASSETMANAGEMENT: // "product.tc-3.4", "ap"
			this.clickAddProduct();
			this.selectAddDescription(description);
			this.clickAddDescription();

			this.setDescription(englishDescription);
			this.setProductCode(productCode);
			this.checkAssetManagement(assetManage);
			if (global) {
				this.enableGlobleCheckBox(true);
			}
			this.checkStandardAvailability(standardAvailability);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			this.selectCurrency(currency);
			break;
		case DESCRIPTION:
			// this.addProductCategory();
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			break;
		case FLATPRICE:
			// this.addProductCategory();
			// this.selectRecentCategory();
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			break;
		case GRADUATEDPRICE:
			// this.addProductCategory();
			// this.selectProductCategory(category);
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			this.setIncludedQuantity(includedQuantity);
			break;

		case GRADUATECAPPRICE:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			this.setIncludedQuantity(includedQuantity);
			this.setMaximum(Maximum);
			break;

		case TIMEOFDAY:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setDate(Date);
			this.setTimeField(TimeFormat);
			break;

		case TIERED:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setRange(Range);
			this.setFrom(From);
			this.setToRate(Rate1);
			this.clickAddNewAttribute();
			this.setFrom1(From1);
			this.setToRate2(Rate2);
			break;

		case VOLUME:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setRange(Range);
			this.setFrom(From);
			this.setToRate(Rate1);
			this.clickAddNewAttribute();
			this.setFrom1(From1);
			this.setToRate2(Rate2);
			this.clickAddNewAttribute1();
			this.setFrom2(From2);
			this.setToRate3(Rate3);
			break;

		case POOLED:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			this.setMultiplier(Multiplier);
			break;
		case ITEMPAGESELECTOR:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			// this.selectCategoryID(CategoryID);
			this.setPercentageCategory(Percentage);
			this.setZero(Zero);
			break;

		case ITEMSELECTOR:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setOne(One);
			break;

		case QUANTITYADON:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setProductID(ProductID);
			this.setQuantity(Quantity);
			this.clickAddChain();
			this.setGraduateRate(GraduateRate);
			this.setGraduateIncludedQuantity(GraduateQuantity);
			break;
		case GRADUATED:
			this.clickRecentCreatedcategory();
			this.clickAddProduct();
			this.selectAddDescription(description);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.setProductCode(productCode);
			this.selectPricingModel(pricingModel);
			this.setIncludedQuantity(includedQuantity);
			this.setRate(rate);
			break;
		case COMPANYPOOLED:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			System.out.println("Pricing Model is selected");
			this.setPoolingCategoryID(PooledCategoryID);
			System.out.println("Pooled category ID is working");
			this.setIncludedQuantity(includedQuantity);
			this.setRate(rate);
			break;

		case FLAT_PERCENTAGE:
			this.clickRecentCreatedcategory();
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			this.clickAddChain();
			this.selectPricingModelinAddChain(pricing);
			this.setPercentage(PercentageValue);
			break;

		case FLAT_DATE:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectCurrentCompany();
			this.checkGlobal(globle);
			this.availabilityStartDate(StartDate);
			this.availabilityEndDate(EndDate);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			break;

		case FLATPRICEWITHCURRENTCOMPANY:
			// this.addProductCategory();
			// this.clickRecentCreatedcategory();
			// this.selectRecentCategory();
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectCurrentCompany();
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			// this.selectCurrency("United States Dollar");
			break;

		case LINEPERCENTAGEWITHCOMPANY:
			// this.addProductCategory();
			this.clickAddProduct();
			this.selectAddDescription(description);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.setProductCode(productCode);
			// this.checkAssetManagement(assetManage);

			this.selectCurrentCompany();
			this.selectPricingModel(pricingModel);
			// this.setIncludedQuantity(includedQuantity);
			this.setRate(rate);
			// this.selectCurrency("United States Dollar");
			break;

		case FLATPRICEWITHGLOBAL:
			// this.addProductCategory();
			// this.clickRecentCreatedcategory();
			// this.selectRecentCategory();
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.selectCurrentCompany();
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			this.checkGlobal(globle);
			// this.selectCurrency("United States Dollar");
			break;
		case ADDPRODUCTWITHASSETMANAGEMENT:
			this.clickAddProduct();
			this.setProductCode(productCode);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.checkAllowAssetManagementChkBox(assetManage);
			break;
		default:
			throw new Exception("Invalid Step Provided. Not defined in enumeration");
		}
		this.clickSaveChanges();

		return englishDescription;

	}

	/**
	 * @author Syed
	 * @Description This method will add the asset
	 *
	 */
	public String addAssetForProduct(String testDataSetName, String category, boolean allowAsset) throws Exception {
		String identifier = TestData.read("PageProducts.xml", testDataSetName, "identifier", category);
		String AssetStatus = TestData.read("PageProducts.xml", testDataSetName, "AssetStatus", category);
		this.addAsset();
		this.assetDetails(identifier);
		this.selectAssetStatus(AssetStatus);
		this.checkIsAllowGroupChkBox(allowAsset);
		this.clickSaveChanges();
		return identifier;
	}

	/**
	 * @author Syed
	 * @Description This method will add the asset
	 *
	 */
	public String addAssetForMultipleProduct(String testDataSetName, String category, boolean allowAsset) throws Exception {
		String identifier = TestData.read("PageProducts.xml", testDataSetName, "identifier", category);
		String AssetStatus = TestData.read("PageProducts.xml", testDataSetName, "AssetStatus", category);
		this.clickAddNew();
		this.assetDetails(identifier);
		this.selectAssetStatus(AssetStatus);
		this.checkIsAllowGroupChkBox(allowAsset);
		this.clickSaveChanges();
		return identifier;
	}

	/**
	 * @author Syed
	 * @Description This method will check the Allow asset management checkbox
	 */
	ProductsPage checkAllowAssetManagementChkBox(boolean allowAsset) throws Exception {
		if (allowAsset) {
			GlobalController.brw.check(this.CB_ALLOWASSETMANAGEMENT);
		} else {
			GlobalController.brw.uncheck(this.CB_ALLOWASSETMANAGEMENT);
		}
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This will enter End Availability Date
	 *
	 * @author syed
	 * @param EndDate
	 * @return
	 * @throws Exception
	 */
	ProductsPage availabilityEndDate(String EndDate) throws Exception {
		GlobalController.brw.setText(this.TB_ENDDATE, EndDate);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 *
	 * This will enter Start Availability Date
	 *
	 * @param StartDate
	 * @return
	 * @throws Exception
	 */
	ProductsPage availabilityStartDate(String StartDate) throws Exception {
		GlobalController.brw.setText(this.TB_STARTDATE, StartDate);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author syed Description This method will seclect pricing Model in Add
	 *         chain section
	 */
	ProductsPage selectPricingModelinAddChain(String pricing) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_PRICING, pricing);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will set Percentage
	 *
	 * @param Percentage
	 *
	 * @throws Exception
	 */
	ProductsPage setPercentage(String PercentageValue) throws Exception {
		GlobalController.brw.setText(this.TB_Percantage, PercentageValue);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This will enter minimum value in dependencies
	 *
	 * @param master
	 * @return
	 * @throws Exception
	 */
	protected ProductsPage setPoolingCategoryID(String PooledCategoryID) throws Exception {
		GlobalController.brw.setText(this.TB_CategoryID, PooledCategoryID);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage editProduct(String testDataSetName, String category) throws Exception {
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		String rate = TestData.read("PageProducts.xml", testDataSetName, "rate", category);

		this.clickProductToEdit();
		this.ClickEditProduct();

		this.setDescription(englishDescription);
		this.setProductCode(productCode);

		this.setRate(rate);
		this.clickSaveChanges();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This will add Category
	 *
	 * @param master
	 * @return
	 * @throws Exception
	 */
	public String addCategory(String testDataSetName, String category) throws Exception {
		String name = TestData.read("PageProducts.xml", testDataSetName, "name", category);
		this.clickAddCategory();
		this.setCategoryName(name);
		this.selectCurrentCompany();
		this.clickSaveChanges();
		return name;

	}

	public String addCategoryNationalMobileCalls(String testDataSetName, String category) throws Exception {
		String name = TestData.read("PageProducts.xml", testDataSetName, "name", category);
		this.clickAddCategory();
		this.setCategoryName(name);
		this.selectCurrentCompany();
		this.clickSaveChanges();
		return name;

	}

	/**
	 * This will add plugin
	 *
	 * @param master
	 * @return
	 * @throws Exception
	 */
	public ProductsPage addPlugin(String testDataSetName, String category) throws Exception {
		String pluginType = TestData.read("PageProducts.xml", testDataSetName, "pluginType", category);
		String order4 = TestData.read("PageProducts.xml", testDataSetName, "order", category);

		this.selectPluginsInConfiguration();
		this.clickPluginGeneric();
		this.clickAddNew();
		this.selectPluginTypeDropdown(pluginType);

		this.setOrder(order4);
		this.clickSavePluginButton();
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public String addAsset(String testDataSetName, String category) throws Exception {
		String identifier = TestData.read("PageProducts.xml", testDataSetName, "identifier", category);
		String taxID = TestData.read("PageProducts.xml", testDataSetName, "taxID", category);
		this.assetDetails(identifier);
		this.clickSaveChanges();
		return identifier;

	}

	public ProductsPage addProductCategoryWithAssetMgmt(String parentCategory, String importedMetaFieldName,
			setProductCategoryWithAssetMgmt addProductCategory, String testDataSetName, String category) throws Exception {
		String assetCategory = TestData.read("PageProducts.xml", testDataSetName, "assetCategory", category);
		String assetCategory2 = TestData.read("PageProducts.xml", testDataSetName, "assetCategory2", category);
		String metaFieldName = TestData.read("PageProducts.xml", testDataSetName, "metaFieldName", category);
		String assetStatusName = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName", category);
		String assetStatusName2 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName2", category);
		String assetStatusName3 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName3", category);
		String assetStatusName4 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName4", category);
		String assetStatusName5 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName5", category);
		String addAssetIdentifier = TestData.read("PageProducts.xml", testDataSetName, "addAssetIdentifier", category);
		String addAssetIdentifier2 = TestData.read("PageProducts.xml", testDataSetName, "addAssetIdentifier2", category);
		String addAssetIdentifier3 = TestData.read("PageProducts.xml", testDataSetName, "addAssetIdentifier3", category);
		String metaFieldName2 = TestData.read("PageProducts.xml", testDataSetName, "metaFieldName2", category);
		String Value = TestData.read("PageProducts.xml", testDataSetName, "Value", category);
		String productCategoryType = TestData.read("PageProducts.xml", testDataSetName, "productCategoryType", category);
		String productCategoryType2 = TestData.read("PageProducts.xml", testDataSetName, "productCategoryType2", category);
		String taxCategory = TestData.read("PageProducts.xml", testDataSetName, "taxCategory", category);

		switch (addProductCategory) {
		case PCWAMG1:
			this.clickAddProductCategory();
			this.setProductCategoryName(assetCategory);
			this.selectCurrentCompany();
			this.checkAllowAssetManagement();
			this.setAssetStatusName(assetStatusName);
			this.checkAvailable();
			this.checkDefault();
			this.clickHiddenStatus();
			this.setAssetStatusName(assetStatusName2);
			this.checkOrderSave();
			this.clickMetaField();
			this.setMetafieldName(metaFieldName);
			this.clickSaveChanges();
			break;

		case PCWAMG2:
			this.clickAddProductCategory();
			this.setProductCategoryName(assetCategory);
			this.selectParentCategory(parentCategory);
			this.selectCurrentCompany();
			this.checkAllowAssetManagement();
			this.addAssetIdentifier(addAssetIdentifier);
			this.setAssetStatusName(assetStatusName);
			this.checkAvailable();
			this.checkDefault();
			this.clickHiddenStatus();
			this.setAssetStatusName(assetStatusName3);
			this.checkOrderSave();
			this.clickHiddenStatus();
			this.setAssetStatusName(assetStatusName4);
			this.selectImportMetaField(importedMetaFieldName);
			this.clickMetaField();
			this.setMetafieldName(metaFieldName2);
			this.changeUserPermissionForMandatory(true);
			this.enterNewMetaDataDefaultValue(Value);
			this.clickSaveChanges();
			break;

		case PCWAMG3:
			this.clickAddProductCategory();
			this.setProductCategoryName(taxCategory);
			this.selectProductCategoryType(productCategoryType);
			this.selectCurrentCompany();
			this.checkAllowAssetManagement();
			this.addAssetIdentifier(addAssetIdentifier2);
			this.setAssetStatusName(assetStatusName5);
			this.checkDefault();
			this.clickHiddenStatus();
			this.setAssetStatusName(assetStatusName3);
			this.checkOrderSave();
			this.selectImportMetaField(importedMetaFieldName);
			this.clickImportMetaField();
			this.clickSaveChanges();
			break;

		case PCWAMG4:
			this.clickAddProductCategory();
			this.setProductCategoryName(assetCategory2);
			this.selectProductCategoryType(productCategoryType2);
			this.selectCurrentCompany();
			this.checkAllowAssetManagement();
			this.addAssetIdentifier(addAssetIdentifier3);
			this.setAssetStatusName(assetStatusName5);
			this.checkDefault();
			this.clickHiddenStatus();
			this.setAssetStatusName(assetStatusName3);
			this.checkOrderSave();
			this.clickHiddenStatus();
			this.setAssetStatusName(assetStatusName4);
			this.selectImportMetaField(importedMetaFieldName);
			this.clickImportMetaField();
			this.clickSaveChanges();
			break;

		default:
			throw new Exception("Bad enum value: " + addProductCategory);
		}
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public String Createanotherproduct(AddProductField addProductField, String testDataSetName, String category) throws Exception {
		String description = TestData.read("PageProducts.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		String pricingModel = TestData.read("PageProducts.xml", testDataSetName, "pricingModel", category);
		String rate = TestData.read("PageProducts.xml", testDataSetName, "rate", category);
		String currency = TestData.read("PageProducts.xml", testDataSetName, "currency", category);

		boolean standardAvailability = TextUtilities.compareValue(
				TestData.read("PageProducts.xml", testDataSetName, "standardAvailability", category), "true", true, TextComparators.equals);

		this.clickAddProduct();
		this.selectAddDescription(description);
		this.clickAddDescription();

		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.checkStandardAvailability(standardAvailability);
		this.selectPricingModel(pricingModel);
		this.setRate(rate);
		this.selectCurrency(currency);
		this.clickSaveChanges();
		return englishDescription;

	}

	public String editCategory(String testDataSetName, String category) throws Exception {
		String productCategoryName = TestData.read("PageProducts.xml", testDataSetName, "name", category);

		this.clickRecentCreatedcategory();
		this.clickEdit();
		this.setCategoryName(productCategoryName);
		this.clickSaveChanges();
		return productCategoryName;

	}

	public ProductsPage assetExists(String testDataSetName, String category) throws Exception {
		String productCategory = TestData.read("PageProducts.xml", testDataSetName, "productCategory", category);
		String productName = TestData.read("PageProducts.xml", testDataSetName, "productName", category);
		String assetName = TestData.read("PageProducts.xml", testDataSetName, "assetName", category);

		this.selectProductCategory(productCategory);
		this.selectProduct(productName);
		this.clickShowAssets();
		this.verifyAssetPresent(assetName);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage addProductOnDependency(String testDataSetName, String category, String Category) throws Exception {
		String description = TestData.read("PageProducts.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		String pricingModel = TestData.read("PageProducts.xml", testDataSetName, "pricingModel", category);

		boolean standardAvailability = TextUtilities.compareValue(
				TestData.read("PageProducts.xml", testDataSetName, "standardAvailability", category), "true", true, TextComparators.equals);

		this.addProductCategory();
		this.clickAddProduct();
		this.selectAddDescription(description);
		this.clickAddDescription();

		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.checkStandardAvailability(standardAvailability);

		this.selectPricingModel(pricingModel);
		this.clickDependencies();
		this.selectProductCategory(Category);
		this.clickSaveChanges();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage addProductWithCommission(String testDataSetName, String category) throws Exception {
		String description = TestData.read("PageProducts.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		String pricingModel = TestData.read("PageProducts.xml", testDataSetName, "pricingModel", category);
		String rate = TestData.read("PageProducts.xml", testDataSetName, "rate", category);
		String agent = TestData.read("PageProducts.xml", testDataSetName, "agent", category);
		String master = TestData.read("PageProducts.xml", testDataSetName, "master", category);

		this.addProductCategory();
		this.clickAddProduct();
		this.selectAddDescription(description);
		this.clickAddDescription();

		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.setAgentCommission(agent);
		this.setMasterCommission(master);
		this.selectPricingModel(pricingModel);
		this.setRate(rate);
		this.clickSaveChanges();
		this.verifySavedProduct();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage deleteProductCategory() throws Exception {
		this.selectSuccessfulProductCategory();
		this.selectSuccessfulProduct();
		this.clickDelete();
		// this.clickConfirmYes();
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will validate users table saved test data
	 *
	 * @throws Exception
	 */
	public ProductsPage validateUserTableSavedTestData(String data) throws Exception {
		GlobalController.brw.validateSavedTestData(this.USERS_TABLE_CELL, data);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will validate users table saved test data
	 *
	 * @throws Exception
	 */
	public ProductsPage validateAssetSavedTestData(String date, String status) throws Exception {
		GlobalController.brw.validateSavedTestData(this.ASSET_HISTORY, date);
		GlobalController.brw.validateSavedTestData(this.PRODUCT_DETAIL, status);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will verify breadcrumbs ui component
	 *
	 * @throws Exception
	 */
	public ProductsPage verifyUIComponent() throws Exception {
		GlobalController.brw.verifyUIComponent(this.BREADCRUMBS);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will Enable global checkbox
	 *
	 * @return
	 * @throws Exception
	 */
	ProductsPage enableGlobleCheckBox(boolean global) throws Exception {
		if (global) {
			GlobalController.brw.check(this.CB_GLOBLE);
		} else {
			GlobalController.brw.uncheck(this.CB_GLOBLE);
		}
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will Enable Allow Asset Management checkbox
	 *
	 * @return
	 * @throws Exception
	 */
	ProductsPage enableAllowAssetMgmtCheckBox(boolean assetValue) throws Exception {
		if (assetValue) {
			GlobalController.brw.check(this.ALLOW_ASSET_MANAGEMENT_CHECKBOX);
		} else {
			GlobalController.brw.uncheck(this.ALLOW_ASSET_MANAGEMENT_CHECKBOX);
		}
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will click + button button
	 *
	 * @throws Exception
	 */
	ProductsPage clickPlusImageButton() throws Exception {
		GlobalController.brw.clickLinkText(this.PLUS_IMG_ICON);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage clickonOrderSavedCheckbox() throws Exception {
		GlobalController.brw.click(this.CB_ORDER_SAVED);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	ProductsPage enterAssetName(String assetName) throws Exception {
		GlobalController.brw.setText(this.TF_ASSET_NAME1, assetName);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	ProductsPage enterAssetName1(String assetName) throws Exception {
		GlobalController.brw.setText(this.TF_ASSET_NAME2, assetName);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	ProductsPage clickonDescriptionPlusIcon() throws Exception {
		GlobalController.brw.click(this.ADD_DESCRIPTION_ICON);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	ProductsPage enterDescription(String testDataSetName, String category) throws Exception {
		String description = TestData.read("PageConfiguration.xml", testDataSetName, "description", category);
		GlobalController.brw.setText(this.TF_PRODUCT_DESCRIPTION, description);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	ProductsPage verifyDescriptionSelectValue(String assetName) throws Exception {
		ProductsPage.logger.enterMethod();

		GlobalController.brw.clickTableCellWithText(this.TAB_ASSET, assetName);
		String asset = GlobalController.brw.getText(this.DD_ADD_DESCRIPTION);
		if (TextUtilities.contains(asset, assetName)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		ProductsPage.logger.exitMethod();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public String addNewCategory(String testDataSetName, String category) throws Exception {
		String assetName1 = TestData.read("PageProducts.xml", testDataSetName, "asserName1", category);
		String assetName2 = TestData.read("PageProducts.xml", testDataSetName, "asserName2", category);
		String categoryName = TestData.read("PageProducts.xml", testDataSetName, "categoryName", category);
		boolean assetCheckBox = TextUtilities.compareValue(
				TestData.read("PageProducts.xml", testDataSetName, "checkAssetManagement", category), "true", true, TextComparators.equals);
		boolean global = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "global", category), "true", true,
				TextComparators.equals);

		this.clickAddCategory();
		this.setCategoryName(categoryName);
		this.checkAllowAssetManagement();
		this.enableGlobleCheckBox(global);
		this.checkAvailable();
		this.checkDefault();
		this.enterAssetName(assetName1);
		this.clickPlusImageButton();
		this.enterAssetName1(assetName2);
		this.clickonOrderSavedCheckbox();
		this.clickSaveChanges();
		this.verifySavedProduct();
		this.validateAddedCategory(categoryName);

		return categoryName;
	}

	public String addAssetinProduct(String testDataSetName, String category) throws Exception {
		String identifier = TestData.read("PageProducts.xml", testDataSetName, "identifier1", category);
		boolean global = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "global", category), "true", true,
				TextComparators.equals);

		this.addAsset();
		this.assetDetails(identifier);
		this.enableGlobleCheckBox(global);
		this.clickSaveChanges();
		return identifier;
	}

	public String addChildAsset(String testDataSetName, String category) throws Exception {
		String identifier = TestData.read("PageProducts.xml", testDataSetName, "identifier2", category);
		boolean global = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "global", category), "true", true,
				TextComparators.equals);
		this.addChildAsset();
		this.assetDetails(identifier);
		this.enableGlobleCheckBox(global);
		this.selectCurrentCompany();
		this.clickSaveChanges();
		return identifier;
	}

	public ProductsPage ClickOnAddedCategory() throws Exception {
		GlobalController.brw.clickLinkText(this.TABLE_CATEGORY_FIRST_CELL);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will validate Added category
	 *
	 * @throws Exception
	 */
	public ProductsPage validateAddedCategory(String data) throws Exception {
		GlobalController.brw.validateSavedTestData(this.TABLE_CATEGORY, data);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will validate Added Product
	 *
	 * @throws Exception
	 */
	public ProductsPage validateAddedProduct(String data) throws Exception {
		GlobalController.brw.validateSavedTestData(this.TABLE_PRODUCT, data);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will validate Added Asset
	 *
	 * @throws Exception
	 */
	public ProductsPage validateAddedAsset(String data) throws Exception {
		GlobalController.brw.validateSavedTestData(this.TABLE_ASSET, data);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public ProductsPage editDependencyInProduct(String testDataSetName, String category, String categoryName, String product,
			String productCategory, String productName, String productCategory2, String productName2) throws Exception {
		String min1 = TestData.read("PageProducts.xml", testDataSetName, "Min1", category);
		String min0 = TestData.read("PageProducts.xml", testDataSetName, "Min0", category);

		this.clickSpecifiedCategoryInTheTable(categoryName);
		this.clickSpecifiedProductInTheTable(product);
		this.ClickEditProduct();

		this.clickDependencies();
		this.selectProductCategory(productCategory);
		this.selectProduct(productName);
		this.setMimimumValue(min1);
		this.setMaximimValue(min1);
		this.clickImagePlusButton();

		this.selectProductCategory(productCategory2);
		this.selectProduct(productName2);
		this.setMimimumValue(min0);
		this.setMaximimValue(min1);
		this.clickImagePlusButton();

		this.clickEditSaveChanges();
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public String addProductCategoryWithAssetManagement(String testDataSetName, String category, String MetaField1, String MetaField2,
			String MetaField3) throws Exception {
		String assetCategory = TestData.read("PageProducts.xml", testDataSetName, "assetCategory", category);
		String assetStatusName = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName", category);
		String assetStatusName2 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName2", category);
		String assetStatusName3 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName3", category);
		this.clickAddProductCategory();
		this.setProductCategoryName(assetCategory);
		this.selectCurrentCompany();
		this.checkAllowAssetManagement();
		this.setAssetStatusName(assetStatusName);
		this.checkAssetAvailable();
		this.checkAssetDefaultSaved();
		this.clickHiddenStatus();
		this.setAssetStatusName(assetStatusName2);
		this.clickHiddenStatus();
		this.setAssetStatusName(assetStatusName3);
		this.checkAssetOrderSaved();

		this.setMetafieldValue(MetaField1);

		this.clickAddFieldIcon();
		this.setMetafieldValue(MetaField2);
		this.clickAddFieldIcon();
		this.setMetafieldValue(MetaField3);
		this.clickAddFieldIcon();

		this.clickSaveCategory();
		return assetCategory;
	}

	/**
	 * @author Syed
	 * @Description This method will create category with asset Management
	 */
	public String addCategoryWithAssetManagement(String testDataSetName, String category) throws Exception {
		String assetCategory = TestData.read("PageProducts.xml", testDataSetName, "assetCategory", category);
		String assetStatusName = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName", category);
		String assetStatusName2 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName2", category);
		String assetStatusName3 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName3", category);
		String assetStatusName4 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName4", category);

		this.clickAddProductCategory();
		this.setProductCategoryName(assetCategory);
		this.selectCurrentCompany();
		this.checkAllowAssetManagement();
		this.setAssetStatusName(assetStatusName);
		this.checkAssetAvailable();
		// this.checkAvailable();
		// this.checkDefault();
		// this.checkOrderSave();

		this.clickHiddenStatus();
		this.setAssetStatusName(assetStatusName2);
		this.checkAssetOrderSaved();
		this.checkAssetDefaultSaved();
		/*
		 * this.checkAvailable(); this.clickHiddenStatus();
		 * this.setAssetStatusName(assetStatusName3); this.checkAvailable();
		 * this.setAssetStatusName(assetStatusName4); this.checkAvailable();
		 */

		this.clickSaveCategory();
		return assetCategory;
	}

	/**
	 * @author Syed
	 * @Description This method will click on Add icon
	 */
	ProductsPage clickAddFieldIcon() throws Exception {
		GlobalController.brw.click(this.IMG_ADDICON);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * @author Syed
	 * @Description This method will set metaField name
	 * @param productCategory
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	ProductsPage setMetafieldValue(String metaFieldValue) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_METAFIELDVALUE, metaFieldValue);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public boolean isProductPresentInTheDropdownForDependency(String productCategory, String productName) throws Exception {

		this.ClickEditProduct();
		this.clickDependencies();
		this.selectProductCategory(productCategory);
		boolean result = this.isProductPresent(productName);
		this.clickEditSaveChanges();
		return result;

	}

	public String getIDOfAddedProduct() throws Exception {
		this.ClickEditProduct();
		String id = this.getProductID();
		return id;

	}

	public String getProductCategoryName() throws Exception {
		this.ClickEditProduct();
		String Name = this.getCategoryName();
		return Name;

	}

	/**
	 * This method will validate categories table saved test data
	 *
	 * @throws Exception
	 */
	public ProductsPage validateDependencySavedTestData(String data) throws Exception {
		GlobalController.brw.validateSavedTestData(this.ADDED_DEPENDENCY_LIST, data);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public String addProductNationalRomingcall(String testDataSetName, String category) throws Exception {

		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		String pricingModel = TestData.read("PageProducts.xml", testDataSetName, "pricingModel", category);
		String rate = TestData.read("PageProducts.xml", testDataSetName, "rate", category);

		this.clickAddProduct();
		this.setProductCode(productCode);
		this.clickAddDescription();
		this.setDescription(englishDescription);
		this.selectPricingModel(pricingModel);
		this.setRate(rate);
		this.clickSaveChanges();
		return englishDescription;

	}

	/**
	 * This method will validate categories table saved test data
	 *
	 * @throws Exception
	 */
	public ProductsPage validateCategoriesSavedTestData(String data) throws Exception {
		GlobalController.brw.validateSavedTestData(this.TBL_CATEGORIES_TABLE, data);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will validate categories table saved test data
	 *
	 * @throws Exception
	 */
	public ProductsPage validateProductSavedTestData(String data) throws Exception {
		GlobalController.brw.validateSavedTestData(this.TBL_PRODUCT_TABLE, data);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public ProductsPage addAndvarifyAddedAsset(String testDataSetName, String category, String categoryname, String productName,
			String assetName) throws Exception {
		String status = TestData.read("PageCustomers.xml", testDataSetName, "Status", category);
		String date = TestData.read("PageCustomers.xml", testDataSetName, "EffectiveDate", category);
		this.selectCategory(categoryname);
		this.selectAddedProduct(productName);
		this.clickShowAssets();
		this.selectAddedAsset(assetName);
		this.validateAssetSavedTestData(date, status);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 *
	 * This method will edit product
	 *
	 */

	public ProductsPage EditProducts(String product_category, String testDataSetName1, String category, String product_category2)
			throws Exception {

		String Minimum = TestData.read("PageProducts.xml", testDataSetName1, "Minimum", category);
		String Maximum = TestData.read("PageProducts.xml", testDataSetName1, "Maximum", category);
		String Minimumboxes = TestData.read("PageProducts.xml", testDataSetName1, "Minimumboxes", category);
		String Maximumboxes = TestData.read("PageProducts.xml", testDataSetName1, "Maximumboxes", category);

		boolean flag = false;
		flag = GlobalController.brw.isElementPresent(this.TEXT_LEMONADE);
		if (flag == true) {
			GlobalController.brw.click(this.TEXT_LEMONADE);
			this.ClickEditProduct();
			this.clickDependencies();
			this.selectCategoryLemonade(product_category);
			this.selectsecondoption();
			GlobalController.brw.clearTextBox(this.MINIMUM);
			this.setMimimumValue(Minimum);
			this.setMaximimValue(Maximum);
			this.clickImagePlusButton();
			GlobalController.brw.click(this.CLICK_SAVE_BUTTON);

		} else {
			throw new Exception("Test Case failed: ");
		}

		// This will edit COFFEE
		flag = GlobalController.brw.isElementPresent(this.TEXT_COFFEE);
		if (flag == true) {
			GlobalController.brw.click(this.TEXT_COFFEE);
			this.ClickEditProduct();
			this.clickDependencies();
			this.selectCategorCoffee(product_category2);
			this.selectsecondoption();
			this.setMimimumValue(Minimumboxes);
			this.setMaximimValue(Maximumboxes);
			this.clickImagePlusButton();
			GlobalController.brw.click(this.CLICK_SAVE_BUTTON);

		} else {
			throw new Exception("Test Case failed: ");
		}
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * @author syed
	 * @Description This method will add the category with global checkbox
	 *
	 * @param testdataset
	 * @return
	 * @throws Exception
	 */
	public String addCategorywithGlobalCheckbox(String testDataSetName, String category) throws Exception {
		String name = TestData.read("PageProducts.xml", testDataSetName, "categoryName", category);

		this.clickAddCategory();
		this.setCategoryName(name);
		System.out.println("name" + name);
		this.checkGlobal(true);

		// this.selectCurrentCompany();
		this.clickSaveCategory();
		return name;

	}

	public ProductsPage selectCategorCoffee(String testdataset) throws Exception {

		// select Dropdown for Product Category
		String dropDownValueToBeSelected = testdataset;
		System.out.println(dropDownValueToBeSelected);
		GlobalController.brw.selectDropDown(this.DD_PRODUCT_CATEGORY, dropDownValueToBeSelected);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public ProductsPage selectCategoryLemonade(String testdataset) throws Exception {

		// select Dropdown for Product Category
		String dropDownValueToBeSelected = testdataset;
		System.out.println(dropDownValueToBeSelected);
		GlobalController.brw.selectDropDown(this.DD_PRODUCT_CATEGORY, dropDownValueToBeSelected);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public ProductsPage selectcategorycoffoe(String testdataset) throws Exception {

		// select Dropdown for Product Category
		String dropDownValueToBeSelected = testdataset;
		System.out.println(dropDownValueToBeSelected);
		GlobalController.brw.selectDropDown(this.DD_PRODUCT_CATEGORY, dropDownValueToBeSelected);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	protected ProductsPage addAssetIdentifier(String assetIdentifierValue) throws Exception {
		GlobalController.brw.setText(this.ASSET_IDE_LABEL, assetIdentifierValue);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method provide new name in "New Meta Data" page
	 *
	 * @param Name
	 * @return
	 * @throws Exception
	 */
	protected ConfigurationPage enterNewMetaDataName(String Name) throws Exception {
		GlobalController.brw.setText(this.TB_MD_NAME, Name);
		return GlobalController.brw.initElements(ConfigurationPage.class);
	}

	/**
	 * Check/Uncheck <b>Manadatory</b> permission
	 *
	 * @param editPlugin
	 * @throws Exception
	 */
	protected ConfigurationPage changeUserPermissionForMandatory(boolean editManadatory) throws Exception {
		if (editManadatory) {
			GlobalController.brw.check(this.CB_NEW_MANDATORY);
		} else {
			GlobalController.brw.uncheck(this.CB_NEW_MANDATORY);
		}
		return GlobalController.brw.initElements(ConfigurationPage.class);
	}

	protected ProductsPage selectImportMetaField(String ImportMetaFieldValue) throws Exception {
		GlobalController.brw.selectListItem(this.ASSET_META_DATA, ImportMetaFieldValue);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method provide new value in "Default" field
	 *
	 * @param Name
	 * @return
	 * @throws Exception
	 */
	protected ProductsPage enterNewMetaDataDefaultValue(String Value) throws Exception {
		GlobalController.brw.setText(this.META_DATA_DEFAULT_VALUE, Value);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will select Parent company
	 *
	 *
	 * @throws Exception
	 */
	protected ProductsPage selectProductCategoryType(String productCategoryType) throws Exception {
		GlobalController.brw.selectListItem(this.Dropdown_AddProductCategory, productCategoryType);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public ProductsPage addPluginWithProvisionID(String testDataSetName, String category) throws Exception {
		String pluginType = TestData.read("PageProducts.xml", testDataSetName, "pluginType", category);
		String order = TestData.read("PageProducts.xml", testDataSetName, "order", category);

		this.clickAddNew();
		this.selectPluginTypeDropdown(pluginType);

		this.setOrder(order);
		this.setProvisionableField("5");
		this.clickSavePluginButton();
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public ProductsPage addPluginInsidePlugin(String testDataSetName, String category) throws Exception {
		String pluginType = TestData.read("PageProducts.xml", testDataSetName, "pluginType", category);
		String order = TestData.read("PageProducts.xml", testDataSetName, "order", category);

		this.clickAddNew();
		this.selectPluginTypeDropdown(pluginType);

		this.setOrder(order);
		this.clickSavePluginButton();
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public String addProductCategoryWithAssetMgmt(String testDataSetName, String category) throws Exception {
		String assetCategory = TestData.read("PageProducts.xml", testDataSetName, "assetCategory", category);
		String metaFieldName = TestData.read("PageProducts.xml", testDataSetName, "metaFieldName", category);
		String assetStatusName = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName", category);
		String assetStatusName2 = TestData.read("PageProducts.xml", testDataSetName, "assetStatusName2", category);

		this.clickAddProductCategory();
		this.setProductCategoryName(assetCategory);
		this.selectCurrentCompany();
		this.checkAllowAssetManagement();
		this.setAssetStatusName(assetStatusName);
		this.checkAvailable();
		this.checkDefault();
		this.clickHiddenStatus();
		this.setAssetStatusName(assetStatusName2);
		this.checkOrderSave();
		this.clickMetaField();
		this.setMetafieldName(metaFieldName);
		this.clickSaveChanges();
		return assetCategory;

	}

	/**
	 * Add Product Form
	 *
	 * @param paptcd
	 * @throws Exception
	 */

	ProductsPage addCategory() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_CATEGORY);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click on One item per Order check box
	 *
	 * @throws Exception
	 */
	ProductsPage clickOneItemPerOrderChkBox(boolean value) throws Exception {
		GlobalController.brw.clickLinkText(this.CHK_ONE_ITEM_PER_ORDER);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click on One item per Customer check box
	 *
	 * @throws Exception
	 */
	ProductsPage clickOneItemPerCustomerChkBox(boolean value) throws Exception {
		GlobalController.brw.clickLinkText(this.CHK_ONE_ITEM_PER_CUSTOMER);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will verify One item per Customer check box is disabled
	 *
	 * @throws Exception
	 */
	ProductsPage verifyOneItemPerCustomerChkBoxIsDisabled() throws Exception {
		String actualStatus = GlobalController.brw.getAttribute(this.CHK_ONE_ITEM_PER_CUSTOMER, "disabled");
		Assert.assertTrue("true".equalsIgnoreCase(actualStatus));
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will Set Start Date
	 *
	 * @throws Exception
	 */
	ProductsPage setStartDate(String startDate) throws Exception {
		GlobalController.brw.setText(this.TB_START_DATE, startDate);

		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will Set End Date
	 *
	 * @throws Exception
	 */
	ProductsPage setEndDate(String startDate) throws Exception {
		GlobalController.brw.setText(this.TB_END_DATE, startDate);

		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will verify One item per Order check box is disabled
	 *
	 * @throws Exception
	 */
	ProductsPage verifyOneItemPerOrderChkBoxIsDisabled() throws Exception {
		String actualStatus = GlobalController.brw.getAttribute(this.CHK_ONE_ITEM_PER_ORDER, "disabled");
		Assert.assertTrue("true".equalsIgnoreCase(actualStatus));
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	public String createCategoryWithOneOrder(String testDataSetName, String category) throws Exception {
		String categoryName = TestData.read("PageProducts.xml", testDataSetName, "categoryName", category);
		boolean global = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "global", category), "true", true,
				TextComparators.equals);
		boolean customerCheckBox = TextUtilities.compareValue(
				TestData.read("PageProducts.xml", testDataSetName, "customerCheckBox", category), "true", true, TextComparators.equals);
		boolean orderCheckBox = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "orderCheckBox", category),
				"true", true, TextComparators.equals);
		this.clickAddCategory();
		this.clickOneItemPerOrderChkBox(orderCheckBox);
		this.verifyOneItemPerCustomerChkBoxIsDisabled();
		this.clickOneItemPerOrderChkBox(orderCheckBox);
		this.clickOneItemPerCustomerChkBox(customerCheckBox);
		this.verifyOneItemPerOrderChkBoxIsDisabled();
		this.setCategoryName(categoryName);
		this.enableGlobleCheckBox(global);
		this.clickOneItemPerCustomerChkBox(customerCheckBox);
		this.clickOneItemPerOrderChkBox(orderCheckBox);
		this.clickSaveChanges();
		this.validateAddedCategory(categoryName);
		return categoryName;
	}

	public String addProductInOnePerOrderCategory(String testDataSetName, String category, String categoryName) throws Exception {
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String startDate = TestData.read("PageProducts.xml", testDataSetName, "startDate", category);
		String endDate = TestData.read("PageProducts.xml", testDataSetName, "endDate", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		boolean global = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "global", category), "true", true,
				TextComparators.equals);
		this.selectCategory(categoryName);
		this.clickAddProduct();
		this.clickAddDescription();
		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.selectCurrentCompany();
		this.enableGlobleCheckBox(global);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.clickSaveChanges();
		return englishDescription;
	}

	public String addProducts(AddProductField addProductField, String testDataSetName, String category) throws Exception {
		String description = TestData.read("PageProducts.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		String pricingModel = TestData.read("PageProducts.xml", testDataSetName, "pricingModel", category);
		String rate = TestData.read("PageProducts.xml", testDataSetName, "rate", category);

		switch (addProductField) {
		case FLAT:
			this.clickRecentCreatedcategory();
			this.clickAddProduct();
			this.selectAddDescription(description);
			this.clickAddDescription();
			this.setDescription(englishDescription);
			this.setProductCode(productCode);
			this.selectPricingModel(pricingModel);
			this.setRate(rate);
			break;

		default:
			throw new Exception("Invalid Step Provided. Not defined in enumeration");
		}
		this.clickSaveChanges();
		return englishDescription;

	}

	public String createCategoryWithOneCustomer(String testDataSetName, String category) throws Exception {
		String categoryName = TestData.read("PageProducts.xml", testDataSetName, "categoryName", category);
		boolean global = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "global", category), "true", true,
				TextComparators.equals);
		boolean customerCheckBox = TextUtilities.compareValue(
				TestData.read("PageProducts.xml", testDataSetName, "customerCheckBox", category), "true", true, TextComparators.equals);
		this.clickAddCategory();
		this.setCategoryName(categoryName);
		this.clickOneItemPerCustomerChkBox(customerCheckBox);
		this.enableGlobleCheckBox(global);
		this.clickSaveChanges();
		this.validateAddedCategory(categoryName);
		return categoryName;
	}

	public String addProductInOnePerCustomerCategory(String testDataSetName, String category, String categoryName) throws Exception {
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String startDate = TestData.read("PageProducts.xml", testDataSetName, "startDate", category);
		String pricingModel = TestData.read("PageProducts.xml", testDataSetName, "pricingModel", category);
		String rate = TestData.read("PageProducts.xml", testDataSetName, "rate", category);
		String currency = TestData.read("PageProducts.xml", testDataSetName, "currency", category);
		String endDate = TestData.read("PageProducts.xml", testDataSetName, "endDate", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		boolean global = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "global", category), "true", true,
				TextComparators.equals);
		this.selectCategory(categoryName);
		this.clickAddProduct();
		this.clickAddDescription();
		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.enableGlobleCheckBox(global);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.selectPricingModel(pricingModel);
		this.setRate(rate);
		this.selectCurrency(currency);
		this.clickSaveChanges();
		return englishDescription;
	}

	public String getIDAddedCategory(String categoryName) throws Exception {
		this.clickEdit();
		String id = this.getCategoryID();

		this.clickEditSaveChanges();
		System.out.println("id>>>>>>" + id);
		System.out.println("text::::::" + categoryName);
		String product = categoryName.concat(" (Id: ");
		String productName1 = product.concat(id);
		String category = productName1.concat(")");
		System.out.println("productName" + category);
		return category;

	}

	public String getCategoryID() throws Exception {
		String text = GlobalController.brw.getText(this.PRODUCT_ID);
		return text;

	}

	public String getIDAddedProduct(String productName) throws Exception {
		this.ClickEditProduct();
		String id = this.getProductID();

		this.clickEditSaveChanges();
		System.out.println("id>>>>>>" + id);
		System.out.println("text::::::" + productName);
		String product = id.concat(" : ");
		String productName1 = product.concat(productName);
		System.out.println("productName" + productName1);
		return productName1;

	}

	/**
	 * Edit Product With Dependencies
	 *
	 * @author shanky
	 * @param testDataSetName
	 * @param category
	 * @param productCategory
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public ProductsPage editProductWithDependency(String testDataSetName, String category, String productCategory, String productName)
			throws Exception {
		String minimum = TestData.read("PageProducts.xml", testDataSetName, "minimum", category);
		String maximum = TestData.read("PageProducts.xml", testDataSetName, "maximum", category);

		this.ClickEditProduct();

		this.clickDependencies();
		this.selectProductCategory(productCategory);
		this.selectProduct(productName);
		this.setMimimumValue(minimum);
		this.setMaximumValue(maximum);
		this.clickImagePlusButton();
		this.clickEditSaveChanges();
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This will enter maximum value in dependencies
	 *
	 * @author shanky
	 * @param master
	 * @return
	 * @throws Exception
	 */
	ProductsPage setMaximumValue(String maximum) throws Exception {
		GlobalController.brw.setText(this.MAXIMUMVALUE, maximum);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will get Product ID
	 *
	 * @author shanky
	 * @param productDescription
	 * @return
	 * @throws Exception
	 */
	public String getRunTimeProductID(String productDescription) throws Exception {
		String productID = GlobalController.brw.getText(this.PRODUCT_ID_RUNTIME);
		return productID + " : " + productDescription;

	}

	/**
	 * This method will return Product Name with It's Product ID
	 *
	 * @author shanky
	 * @param categoryName
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public String productDescriptionWithID(String categoryName, String productName) throws Exception {
		this.selectCategory(categoryName);
		this.selectAddedProduct(productName);
		String productNameWithID = this.getRunTimeProductID(productName);
		System.out.println(productNameWithID);
		return productNameWithID;
	}

	/**
	 * @author shanky This method will create Product with Dependencies
	 * @param testDataSetName
	 * @param category
	 * @param prodcutDescription1
	 * @param categoryName1
	 * @param prodcutDescription2
	 * @param categoryName2
	 * @return
	 * @throws Exception
	 */
	public String createProductWithDependencies(String testDataSetName, String category, String prodcutDescription1, String categoryName1,
			String prodcutDescription2, String categoryName2) throws Exception {
		String minimum1 = TestData.read("PageProducts.xml", testDataSetName, "minimum1", category);
		String minimum2 = TestData.read("PageProducts.xml", testDataSetName, "minimum2", category);
		String description = TestData.read("PageProducts.xml", testDataSetName, "description", category);
		String rate = TestData.read("PageProducts.xml", testDataSetName, "rate", category);
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		String pricingModel = TestData.read("PageProducts.xml", testDataSetName, "pricingModel", category);

		this.clickAddProduct();
		this.selectAddDescription(description);
		this.clickAddDescription();
		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.selectCurrentCompany();
		this.selectPricingModel(pricingModel);
		this.setRate(rate);
		this.clickDependencies();
		this.selectProductCategory(categoryName2);
		this.selectProduct(prodcutDescription2);
		this.setMimimumValue(minimum1);
		this.clickImagePlusButton();
		this.selectProductCategory(categoryName1);
		this.selectProduct(prodcutDescription1);
		this.setMimimumValue(minimum2);
		this.clickImagePlusButton();
		this.clickSaveChanges();
		return englishDescription;

	}

	/**
	 * This method will click on Other Meta field bar
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	ProductsPage clickOnOtherMetaField() throws Exception {
		GlobalController.brw.clickLinkText(this.OTHER_META_FIELD);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will enter name in metafield
	 *
	 * @author shanky
	 * @param name
	 * @return
	 * @throws Exception
	 */
	ProductsPage enterNameInOtherMEtaField(String name) throws Exception {
		GlobalController.brw.setText(this.TB_NAME_METAFIELD, name);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will enter name in metafield
	 *
	 * @author shanky
	 * @param name
	 * @return
	 * @throws Exception
	 */
	ProductsPage enterNameInOtherMetaFieldSecond(String name) throws Exception {
		GlobalController.brw.setText(this.TB_NAME_METAFIELD_SECOND, name);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will select value from dropdown
	 *
	 * @author shanky
	 * @param value
	 * @return
	 * @throws Exception
	 */
	ProductsPage selectDataType(String value) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_DATATYPE_METAFIELD, value);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will select value from dropdown
	 *
	 * @author shanky
	 * @param value
	 * @return
	 * @throws Exception
	 */
	ProductsPage selectDataTypeSecond(String value) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_DATATYPE_METAFIELD_SECOND, value);
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will Enable mandatory checkbox
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	ProductsPage enableMandatoryCheckBox(boolean mandatory) throws Exception {
		if (mandatory) {
			GlobalController.brw.check(this.CB_MANDATORY);
		} else {
			GlobalController.brw.uncheck(this.CB_MANDATORY);
		}
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will Enable mandatory checkbox
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	ProductsPage enableMandatoryCheckBoxSecond(boolean mandatory) throws Exception {
		if (mandatory) {
			GlobalController.brw.check(this.CB_MANDATORY_SECOND);
		} else {
			GlobalController.brw.uncheck(this.CB_MANDATORY_SECOND);
		}
		return GlobalController.brw.initElements(ProductsPage.class);
	}

	/**
	 * This method will click on Add Meta field
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	ProductsPage clickOnAddMetaField() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_ADDMETAFIELD);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click on update button
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	ProductsPage clickOnUpdateBtnSecond() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_UPDATE_SECOND);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * This method will click on update button
	 *
	 * @author shanky
	 * @return
	 * @throws Exception
	 */
	ProductsPage clickOnUpdateBtnFirst() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_UPDATE_FIRST);
		return GlobalController.brw.initElements(ProductsPage.class);

	}

	/**
	 * Add Product with other Meta Field
	 *
	 * @author shanky
	 * @param testDataSetName
	 * @param category
	 * @param categoryName
	 * @return
	 * @throws Exception
	 */
	public String addProductwithOtherMetaField(String testDataSetName, String category, String categoryName) throws Exception {
		String description = TestData.read("PageProducts.xml", testDataSetName, "description", category);
		String englishDescription = TestData.read("PageProducts.xml", testDataSetName, "englishDescription", category);
		String name = TestData.read("PageProducts.xml", testDataSetName, "name", category);
		String name2 = TestData.read("PageProducts.xml", testDataSetName, "name2", category);
		String value = TestData.read("PageProducts.xml", testDataSetName, "value", category);
		String productCode = TestData.read("PageProducts.xml", testDataSetName, "productCode", category);
		boolean mandatory = TextUtilities.compareValue(TestData.read("PageProducts.xml", testDataSetName, "mandatory", category), "true",
				true, TextComparators.equals);
		this.clickAddProduct();
		this.selectAddDescription(description);
		this.clickAddDescription();
		this.setDescription(englishDescription);
		this.setProductCode(productCode);
		this.clickOnOtherMetaField();
		this.clickOnAddMetaField();
		this.enterNameInOtherMEtaField(name);
		this.selectDataType(value);
		this.enableMandatoryCheckBox(mandatory);
		this.clickOnUpdateBtnFirst();
		this.clickOnAddMetaField();
		this.enterNameInOtherMetaFieldSecond(name2);
		this.selectDataTypeSecond(value);
		this.enableMandatoryCheckBoxSecond(mandatory);
		this.clickOnUpdateBtnSecond();
		this.selectCurrentCompany();
		// this.selectProductCategory(categoryName);
		this.clickSaveChanges();
		return englishDescription;

	}

	/**
	 * This method will get Category ID
	 *
	 * @author Shanky
	 * @param categoryDescription
	 * @return
	 * @throws Exception
	 */
	public String getRunTimecategoryID(String categoryDescription) throws Exception {
		String categoryID = GlobalController.brw.getText(this.CATEGORY_ID);
		return categoryDescription + " (Id: " + categoryID + ")";

	}

	/**
	 * This method will return category description with ID
	 *
	 * @author Shanky
	 * @param categoryName
	 * @return
	 * @throws Exception
	 */
	public String categoryDescriptionWithID(String categoryName) throws Exception {
		this.selectCategory(categoryName);
		this.clickEdit();
		String categoryNameWithID = this.getRunTimecategoryID(categoryName);
		return categoryNameWithID;

	}

	/**
	 * This order will edit added product
	 *
	 * @author Shanky
	 * @param testDataSetName
	 * @param category
	 * @param prodcutDescription1
	 * @param prodcutDescription2
	 * @param categoryName
	 * @return
	 * @throws Exception
	 */
	public ProductsPage editProduct(String testDataSetName, String category, String prodcutDescription1, String prodcutDescription2,
			String categoryName) throws Exception {
		String minimum = TestData.read("PageProducts.xml", testDataSetName, "minimum", category);
		String maximum = TestData.read("PageProducts.xml", testDataSetName, "maximum", category);

		this.selectCategory(categoryName);
		this.selectAddedProduct(prodcutDescription1);
		this.clickEdit();
		this.clickDependencies();
		this.selectProductCategory(categoryName);
		this.selectProduct(prodcutDescription2);
		this.setMimimumValue(minimum);
		this.setMaximimValue(maximum);
		this.clickImagePlusButton();
		this.clickSaveChanges();

		return GlobalController.brw.initElements(ProductsPage.class);

	}

}