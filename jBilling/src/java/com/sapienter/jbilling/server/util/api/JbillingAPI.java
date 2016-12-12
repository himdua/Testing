/*
 * JBILLING CONFIDENTIAL
 * _____________________
 *
 * [2003] - [2012] Enterprise jBilling Software Ltd.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Enterprise jBilling Software.
 * The intellectual and technical concepts contained
 * herein are proprietary to Enterprise jBilling Software
 * and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden.
 */

package com.sapienter.jbilling.server.util.api;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

import javax.jws.WebService;

import com.sapienter.jbilling.common.SessionInternalError;
import com.sapienter.jbilling.server.customerEnrollment.CustomerEnrollmentWS;
import com.sapienter.jbilling.server.diameter.DiameterResultWS;
import com.sapienter.jbilling.server.discount.DiscountWS;
import com.sapienter.jbilling.server.ediTransaction.*;
import com.sapienter.jbilling.server.invoice.InvoiceWS;
import com.sapienter.jbilling.server.item.*;
import com.sapienter.jbilling.server.mediation.*;
import com.sapienter.jbilling.server.metafields.MetaFieldGroupWS;
import com.sapienter.jbilling.server.metafields.MetaFieldWS;
import com.sapienter.jbilling.server.notification.MessageDTO;
import com.sapienter.jbilling.server.order.OrderChangeStatusWS;
import com.sapienter.jbilling.server.order.OrderChangeTypeWS;
import com.sapienter.jbilling.server.order.OrderChangeWS;
import com.sapienter.jbilling.server.order.OrderLineWS;
import com.sapienter.jbilling.server.order.OrderPeriodWS;
import com.sapienter.jbilling.server.order.OrderProcessWS;
import com.sapienter.jbilling.server.order.OrderStatusFlag;
import com.sapienter.jbilling.server.order.OrderStatusWS;
import com.sapienter.jbilling.server.order.OrderWS;
import com.sapienter.jbilling.server.order.SwapMethod;
import com.sapienter.jbilling.server.order.Usage;
import com.sapienter.jbilling.server.payment.*;
import com.sapienter.jbilling.server.pluggableTask.admin.PluggableTaskTypeCategoryWS;
import com.sapienter.jbilling.server.pluggableTask.admin.PluggableTaskTypeWS;
import com.sapienter.jbilling.server.pluggableTask.admin.PluggableTaskWS;
import com.sapienter.jbilling.server.pricing.DataTableQueryWS;
import com.sapienter.jbilling.server.pricing.RatingUnitWS;
import com.sapienter.jbilling.server.pricing.RouteRecordWS;
import com.sapienter.jbilling.server.process.AgeingWS;
import com.sapienter.jbilling.server.process.BillingProcessConfigurationWS;
import com.sapienter.jbilling.server.process.BillingProcessWS;
import com.sapienter.jbilling.server.process.ProcessStatusWS;
import com.sapienter.jbilling.server.provisioning.ProvisioningCommandType;
import com.sapienter.jbilling.server.provisioning.ProvisioningCommandWS;
import com.sapienter.jbilling.server.provisioning.ProvisioningRequestWS;
import com.sapienter.jbilling.server.usagePool.CustomerUsagePoolWS;
import com.sapienter.jbilling.server.usagePool.UsagePoolWS;
import com.sapienter.jbilling.server.user.AccountInformationTypeWS;
import com.sapienter.jbilling.server.user.AccountTypeWS;
import com.sapienter.jbilling.server.user.CompanyWS;
import com.sapienter.jbilling.server.user.ContactWS;
import com.sapienter.jbilling.server.user.CreateResponseWS;
import com.sapienter.jbilling.server.user.CustomerNoteWS;
import com.sapienter.jbilling.server.user.MatchingFieldWS;
import com.sapienter.jbilling.server.user.RouteRateCardWS;
import com.sapienter.jbilling.server.user.RouteWS;
import com.sapienter.jbilling.server.user.UserCodeWS;
import com.sapienter.jbilling.server.user.UserTransitionResponseWS;
import com.sapienter.jbilling.server.user.UserWS;
import com.sapienter.jbilling.server.user.ValidatePurchaseWS;
import com.sapienter.jbilling.server.user.partner.CommissionProcessConfigurationWS;
import com.sapienter.jbilling.server.user.partner.CommissionProcessRunWS;
import com.sapienter.jbilling.server.user.partner.CommissionWS;
import com.sapienter.jbilling.server.user.partner.PartnerWS;
import com.sapienter.jbilling.server.util.CurrencyWS;
import com.sapienter.jbilling.server.util.EnumerationWS;
import com.sapienter.jbilling.server.util.PreferenceWS;
import com.sapienter.jbilling.server.util.search.SearchCriteria;
import com.sapienter.jbilling.server.util.search.SearchResultString;


@WebService(targetNamespace = "http://jbilling/", name = "jBillingSalesforceService")
public interface JbillingAPI {

    public CompanyWS getCompany();
    public Integer getCallerCompanyId();
    public Integer getCallerId();
    public Integer getCallerLanguageId();
    public CompanyWS[] getCompanies();
    
    /*
        Users
     */

    public UserWS getUserWS(Integer userId);
    public Integer createUser(UserWS newUser);
    public void updateUser(UserWS user);
    public void deleteUser(Integer userId);
    public void initiateTermination(Integer userId, String reasonCode, Date terminationDate);

    public boolean userExistsWithName(String userName);
    public boolean userExistsWithId(Integer userId);

    public ContactWS[] getUserContactsWS(Integer userId);
    public void updateUserContact(Integer userId, ContactWS contact);

    //TODO: this is not an API method it is declared/implemented in CustomerDTO, must be removed from here
    //TODO: also there is a method named setAuthPaymentType declared in IWebServicesSessionBean, maybe what we have here is a typo
    public void setAutoPaymentType(Integer userId, Integer autoPaymentType, boolean use);
    //TODO: not an API method it is declared/implemented in CustomerDTO, must be removed from here
    //TODO: also there is a method named getAuthPaymentType declared in IWebServicesSessionBean, maybe what we have here is a typo
    public Integer getAutoPaymentType(Integer userId);

    public Integer[] getUsersByStatus(Integer statusId, boolean in);
    public Integer[] getUsersInStatus(Integer statusId);
    public Integer[] getUsersNotInStatus(Integer statusId);

    public Integer getUserId(String username);
    public Integer getUserIdByEmail(String email);

    public UserTransitionResponseWS[] getUserTransitions(Date from, Date to);
    public UserTransitionResponseWS[] getUserTransitionsAfterId(Integer id);

    public CreateResponseWS create(UserWS user, OrderWS order, OrderChangeWS[] orderChanges);

    public Integer createUserCode(UserCodeWS userCode);
    public UserCodeWS[] getUserCodesForUser(Integer userId);
    public void updateUserCode(UserCodeWS userCode);
    public Integer[] getCustomersByUserCode(String userCode);
    public Integer[] getOrdersByUserCode(String userCode);
    public Integer[] getOrdersLinkedToUser(Integer userId);
    public Integer[] getCustomersLinkedToUser(Integer userId);
    public void resetPassword(int userId);

    /*
        Partners
     */

    public PartnerWS getPartner(Integer partnerId);
    public Integer createPartner(UserWS newUser, PartnerWS partner);
    public void updatePartner(UserWS newUser, PartnerWS partner);
    public void deletePartner (Integer partnerId);


    /*
        Items
     */

    // categories parentness
    public ItemTypeWS[] getItemCategoriesByPartner(String partner, boolean parentCategoriesOnly);
    public ItemTypeWS[] getChildItemCategories(Integer itemTypeId);

    public ItemDTOEx getItem(Integer itemId, Integer userId, PricingField[] fields);
    public ItemDTOEx[] getAllItems();
    public Integer createItem(ItemDTOEx item);
    public void updateItem(ItemDTOEx item);
    public void deleteItem(Integer itemId);

    public ItemDTOEx[] getAddonItems(Integer itemId);

    public ItemDTOEx[] getItemByCategory(Integer itemTypeId);
    public Integer[] getUserItemsByCategory(Integer userId, Integer categoryId);

	public ItemTypeWS getItemCategoryById(Integer id);
    public ItemTypeWS[] getAllItemCategories();
    public Integer createItemCategory(ItemTypeWS itemType);
    public void updateItemCategory(ItemTypeWS itemType);
    public void deleteItemCategory(Integer itemCategoryId);
    public ItemTypeWS[] getAllItemCategoriesByEntityId(Integer entityId);
    public ItemDTOEx[] getAllItemsByEntityId(Integer entityId);

    public String isUserSubscribedTo(Integer userId, Integer itemId);

    public InvoiceWS getLatestInvoiceByItemType(Integer userId, Integer itemTypeId);
    public Integer[] getLastInvoicesByItemType(Integer userId, Integer itemTypeId, Integer number);

    public OrderWS getLatestOrderByItemType(Integer userId, Integer itemTypeId);
    public Integer[] getLastOrdersByItemType(Integer userId, Integer itemTypeId, Integer number);

    public ValidatePurchaseWS validatePurchase(Integer userId, Integer itemId, PricingField[] fields);
    public ValidatePurchaseWS validateMultiPurchase(Integer userId, Integer[] itemIds, PricingField[][] fields);
    public Integer getItemID(String productCode);



    /*
        Orders
     */

    public OrderWS getOrder(Integer orderId);
    public Integer createOrder(OrderWS order, OrderChangeWS[] orderChanges);
    public void updateOrder(OrderWS order, OrderChangeWS[] orderChanges);
    public Integer createUpdateOrder(OrderWS order, OrderChangeWS[] orderChanges);
    public String deleteOrder(Integer id);

    public Integer createOrderAndInvoice(OrderWS order, OrderChangeWS[] orderChanges);

    public OrderWS getCurrentOrder(Integer userId, Date date);
    public OrderWS updateCurrentOrder(Integer userId, OrderLineWS[] lines, PricingField[] fields, Date date, String eventDescription); 

    public OrderLineWS getOrderLine(Integer orderLineId);
    public void updateOrderLine(OrderLineWS line);

    public Integer[] getOrderByPeriod(Integer userId, Integer periodId);
    public OrderWS getLatestOrder(Integer userId);
    public Integer[] getLastOrders(Integer userId, Integer number);
    public OrderWS[] getUserOrdersPage(Integer user, Integer limit, Integer offset);

    public OrderWS rateOrder(OrderWS order, OrderChangeWS[] orderChanges);
    public OrderWS[] rateOrders(OrderWS orders[], OrderChangeWS[] orderChanges);

    public OrderChangeWS[] calculateSwapPlanChanges(OrderWS order, Integer existingPlanItemId, Integer swapPlanItemId, SwapMethod method, Date effectiveDate);

    public PaymentAuthorizationDTOEx createOrderPreAuthorize(OrderWS order, OrderChangeWS[] orderChanges);

    public void updateOrders(OrderWS[] orders, OrderChangeWS[] orderChanges);
    public Integer[] getLastOrdersPage(Integer userId, Integer limit, Integer offset);
    public Integer[] getOrdersByDate(Integer userId, Date since, Date until);
    public OrderWS[] getUserSubscriptions(Integer userId);
    public boolean deleteOrderPeriod(Integer periodId);
    public boolean updateOrderPeriods(OrderPeriodWS[] orderPeriods);
    public boolean updateOrCreateOrderPeriod(OrderPeriodWS orderPeriod);

    /*
        Account Type
     */
    public Integer createAccountType(AccountTypeWS accountType);
    public boolean updateAccountType(AccountTypeWS accountType);
    public boolean deleteAccountType(Integer accountTypeId);
    public AccountTypeWS getAccountType(Integer accountTypeId);
    public AccountTypeWS[] getAllAccountTypes();

    /*
        Account Information Type
     */
    public AccountInformationTypeWS[] getInformationTypesForAccountType(Integer accountTypeId);
    public Integer createAccountInformationType(AccountInformationTypeWS accountInformationType);
    public void updateAccountInformationType(AccountInformationTypeWS accountInformationType);
    public boolean deleteAccountInformationType(Integer accountInformationTypeId);
    public AccountInformationTypeWS getAccountInformationType(Integer accountInformationType);

    public OrderWS[] getLinkedOrders(Integer primaryOrderId);

    /*
        Invoices
     */

    public InvoiceWS getInvoiceWS(Integer invoiceId);
    public Integer[] createInvoice(Integer userId, boolean onlyRecurring);
    public Integer[] createInvoiceWithDate(Integer userId, Date billingDate, Integer dueDatePeriodId, Integer dueDatePeriodValue, boolean onlyRecurring);
    public Integer createInvoiceFromOrder(Integer orderId, Integer invoiceId);
    public Integer applyOrderToInvoice(Integer orderId, InvoiceWS invoiceWs);
    public void deleteInvoice(Integer invoiceId);
    public Integer saveLegacyInvoice(InvoiceWS invoiceWS);
    public Integer saveLegacyPayment(PaymentWS paymentWS);
    public Integer saveLegacyOrder(OrderWS orderWS);

    public Integer[] getAllInvoices(Integer userId);
    public InvoiceWS getLatestInvoice(Integer userId);
    public Integer[] getLastInvoices(Integer userId, Integer number);

    public Integer[] getInvoicesByDate(String since, String until);
    public Integer[] getUserInvoicesByDate(Integer userId, String since, String until);
    public InvoiceWS[] getUserInvoicesPage(Integer userId, Integer limit, Integer offset);

    public Integer[] getUnpaidInvoices(Integer userId);

    public byte[] getPaperInvoicePDF(Integer invoiceId);
    public boolean notifyInvoiceByEmail(Integer invoiceId);
    public boolean notifyPaymentByEmail(Integer paymentId);
    public InvoiceWS[] getAllInvoicesForUser(Integer userId);

    /*
        Payments
     */

    public PaymentWS getPayment(Integer paymentId);
    public PaymentWS getLatestPayment(Integer userId);
    public Integer[] getLastPayments(Integer userId, Integer number);

    public Integer[] getLastPaymentsPage(Integer userId, Integer limit, Integer offset);
    public Integer[] getPaymentsByDate(Integer userId, Date since, Date until);

    public PaymentWS getUserPaymentInstrument(Integer userId);
    public PaymentWS[] getUserPaymentsPage(Integer userId, Integer limit, Integer offset);

    public Integer createPayment(PaymentWS payment);
    public void updatePayment(PaymentWS payment);
    public void deletePayment(Integer paymentId);

    public void removePaymentLink(Integer invoiceId, Integer paymentId);
    public void createPaymentLink(Integer invoiceId, Integer paymentId);
    public void removeAllPaymentLinks(Integer paymentId);

    public PaymentAuthorizationDTOEx payInvoice(Integer invoiceId);
    public Integer applyPayment(PaymentWS payment, Integer invoiceId);
    public PaymentAuthorizationDTOEx processPayment(PaymentWS payment, Integer invoiceId);

    public PaymentAuthorizationDTOEx[] processPayments(PaymentWS[] payments, Integer invoiceId);

    public Integer[] createPayments(PaymentWS[] payments);
    public BigDecimal getTotalRevenueByUser (Integer userId);

    /*
        Billing process
     */

    public void triggerBillingAsync(final Date runDate);
    public boolean triggerBilling(Date runDate);

    public void triggerAgeing(Date runDate);
    public boolean isAgeingProcessRunning();
    public ProcessStatusWS getAgeingProcessStatus();

    public BillingProcessConfigurationWS getBillingProcessConfiguration();
    public Integer createUpdateBillingProcessConfiguration(BillingProcessConfigurationWS ws);

    public Integer createUpdateCommissionProcessConfiguration(CommissionProcessConfigurationWS ws);
    public void calculatePartnerCommissions();
    public void calculatePartnerCommissionsAsync();
    public boolean isPartnerCommissionRunning();
    public CommissionProcessRunWS[] getAllCommissionRuns();
    public CommissionWS[] getCommissionsByProcessRunId(Integer processRunId);

    public BillingProcessWS getBillingProcess(Integer processId);
    public Integer getLastBillingProcess();

    public OrderProcessWS[] getOrderProcesses(Integer orderId);
    public OrderProcessWS[] getOrderProcessesByInvoice(Integer invoiceId);

    public BillingProcessWS getReviewBillingProcess();
    public BillingProcessConfigurationWS setReviewApproval(Boolean flag);

    public Integer[] getBillingProcessGeneratedInvoices(Integer processId);

    public AgeingWS[] getAgeingConfiguration(Integer languageId) ;
    public void saveAgeingConfiguration(AgeingWS[] steps, Integer languageId);
    public boolean isBillingRunning(Integer entityId);
    public ProcessStatusWS getBillingProcessStatus();


    /*
        Mediation process
     */

    public void triggerMediation();
    public void undoMediation(UUID processId);
    public UUID triggerMediationByConfiguration(Integer cfgId);
    public UUID launchMediation(Integer mediationCfgId, String jobName, File file);
    public boolean isMediationProcessRunning();
    public ProcessStatusWS getMediationProcessStatus();

    public MediationProcess getMediationProcess(UUID mediationProcessId);
    public MediationProcess[] getAllMediationProcesses();
    public JbillingMediationRecord[] getMediationEventsForOrder(Integer orderId);
    public JbillingMediationRecord[] getMediationEventsForOrderDateRange(Integer orderId, Date startDate, Date endDate, int offset, int limit);
    public JbillingMediationRecord[] getMediationEventsForInvoice(Integer invoiceId);
    public JbillingMediationRecord[] getMediationRecordsByMediationProcess(UUID mediationProcessId, Integer page, Integer size, Date startDate, Date endDate);
    public RecordCountWS[] getNumberOfMediationRecordsByStatuses();
    public RecordCountWS[] getNumberOfMediationRecordsByStatusesByMediationProcess(UUID mediationProcess);


    public MediationConfigurationWS[] getAllMediationConfigurations();
    public Integer createMediationConfiguration(MediationConfigurationWS cfg);
    public Integer[] updateAllMediationConfigurations(List<MediationConfigurationWS> configurations);
    public void deleteMediationConfiguration(Integer cfgId);

    public OrderWS processJMRData(
            UUID processId, String recordKey, Integer userId,
            Integer currencyId, Date eventDate, String description,
            Integer productId, String quantity, String pricing);

    public OrderWS processJMRRecord(UUID processId, JbillingMediationRecord JMR);
    public JbillingMediationErrorRecord[] getMediationErrorRecordsByMediationProcess(UUID mediationProcessId, Integer mediationRecordStatusId);

    public UUID processCDR(Integer configId, List<String> callDataRecords);
    public UUID runRecycleForConfiguration(Integer configId);
    public UUID runRecycleForProcess(UUID processId);//this method does not exists in the IWebServicesMediationProcess, but there is a method
    // named Integer runRecycleForMediationProcess(Integer processId), so I guess what we have here is a typo.
    
    
    /*
        Provisioning process
     */

    public void triggerProvisioning();

    public void updateOrderAndLineProvisioningStatus(Integer inOrderId, Integer inLineId, String result);
    public void updateLineProvisioningStatus(Integer orderLineId, Integer provisioningStatus);

    public ProvisioningCommandWS[] getProvisioningCommands(ProvisioningCommandType typeId, Integer Id);
    public ProvisioningCommandWS getProvisioningCommandById(Integer provisioningCommandId);

    public ProvisioningRequestWS[] getProvisioningRequests(Integer provisioningCommandId);
    public ProvisioningRequestWS getProvisioningRequestById(Integer provisioningRequestId);


    /*
        Preferences
     */
    public void updatePreferences(PreferenceWS[] prefList);
    public void updatePreference(PreferenceWS preference);
    public PreferenceWS getPreference(Integer preferenceTypeId);


    /*
        Currencies
     */

    public CurrencyWS[] getCurrencies();
    public void updateCurrencies(CurrencyWS[] currencies);
    public void updateCurrency(CurrencyWS currency);
    public Integer createCurrency(CurrencyWS currency);
    public Integer getCallerCurrencyId();//CURRENCY
    public void updateCompany(CompanyWS companyWS);//CURRENCIES


    /*
        Plug-ins
     */

    public PluggableTaskWS getPluginWS(Integer pluginId);
    public PluggableTaskWS[] getPluginsWS(Integer entityId, String className);
    public Integer createPlugin(PluggableTaskWS plugin);
    public void updatePlugin(PluggableTaskWS plugin);
    public void deletePlugin(Integer plugin);

    /*                                                       
     * Quartz jobs                                           
     */                                                      
    public void rescheduleScheduledPlugin(Integer pluginId);
    public void triggerScheduledTask(Integer pluginId, Date date);


    /*
        Plans and special pricing
     */

    public PlanWS getPlanWS(Integer planId);
    public PlanWS[] getAllPlans();
    public Integer createPlan(PlanWS plan);
    public void updatePlan(PlanWS plan);
    public void deletePlan(Integer planId);
    public void addPlanPrice(Integer planId, PlanItemWS price);

    public boolean isCustomerSubscribed(Integer planId, Integer userId);
    public boolean isCustomerSubscribedForDate(Integer planId, Integer userId, Date eventDate);
    public Integer[] getSubscribedCustomers(Integer planId);
    public Integer[] getPlansBySubscriptionItem(Integer itemId);
    public Integer[] getPlansByAffectedItem(Integer itemId);

    public Usage getItemUsage(Integer excludedOrderId, Integer itemId, Integer owner, List<Integer> userIds , Date startDate, Date endDate);

    public PlanItemWS createCustomerPrice(Integer userId, PlanItemWS planItem, Date expiryDate);
    public void updateCustomerPrice(Integer userId, PlanItemWS planItem, Date expiryDate);
    public void deleteCustomerPrice(Integer userId, Integer planItemId);

    public PlanItemWS[] getCustomerPrices(Integer userId);
    public PlanItemWS getCustomerPrice(Integer userId, Integer itemId);
    public PlanItemWS getCustomerPriceForDate(Integer userId, Integer itemId, Date pricingDate, Boolean planPricingOnly);

    public void createCustomerNote(CustomerNoteWS note);

    /*
     * Assets
     */

    public Integer createAsset(AssetWS asset);
    public void updateAsset(AssetWS asset);
    public AssetWS getAsset(Integer assetId);
    public void deleteAsset(Integer assetId);
    public Integer[] getAssetsForCategory(Integer categoryId);
    public Integer[] getAssetsForItem(Integer itemId) ;
    public AssetTransitionDTOEx[] getAssetTransitions(Integer assetId);
    public Long startImportAssetJob(int itemId, String idColumnName, String notesColumnName, String globalColumnName,String entitiesColumnName,String sourceFilePath, String errorFilePath);
    public AssetSearchResult findAssets(int productId, SearchCriteria criteria) ;

	public AssetAssignmentWS[] getAssetAssignmentsForAsset(Integer assetId);
	public AssetAssignmentWS[] getAssetAssignmentsForOrder(Integer orderId);
	public Integer findOrderForAsset(Integer assetId, Date date);
	public Integer[] findOrdersForAssetAndDateRange(Integer assetId, Date startDate, Date endDate);

    public PlanItemWS createAccountTypePrice(Integer accountTypeId, PlanItemWS planItem, Date expiryDate);
    public void updateAccountTypePrice(Integer accountTypeId, PlanItemWS planItem, Date expiryDate);
    public void deleteAccountTypePrice(Integer accountTypeId, Integer planItemId);

    public PlanItemWS[] getAccountTypePrices(Integer accountTypeId);
    public PlanItemWS getAccountTypePrice(Integer accountTypeId, Integer itemId);
    public Integer reserveAsset(Integer assetId, Integer userId);
    public void releaseAsset(Integer assetId, Integer userId);

    /*
     *  Notifications
     */

    public void createUpdateNotification(Integer messageId, MessageDTO dto);


    /*
     *  MetaField Group
     */
    
    public Integer createMetaFieldGroup(MetaFieldGroupWS metafieldGroup);
	public void updateMetaFieldGroup(MetaFieldGroupWS metafieldGroupWs);
	public void deleteMetaFieldGroup(Integer metafieldGroupId);
	public MetaFieldGroupWS getMetaFieldGroup(Integer metafieldGroupId);
    public MetaFieldGroupWS[] getMetaFieldGroupsForEntity(String entityType);

	public Integer createMetaField(MetaFieldWS metafield);
	public void updateMetaField(MetaFieldWS metafieldWs);
	public void deleteMetaField(Integer metafieldId);
	public MetaFieldWS getMetaField(Integer metafieldId);
    public MetaFieldWS[] getMetaFieldsForEntity(String entityType);

    public Integer createOrUpdateDiscount(DiscountWS discount);
    public DiscountWS getDiscountWS(Integer discountId);
    public void deleteDiscount(Integer discountId); 

    /*
     * Picked up this API from master branch, required for SugarCRM integration.
    */
    public OrderPeriodWS[] getOrderPeriods();    
    /*
     * OrderChangeStatus
     */
    public OrderChangeStatusWS[] getOrderChangeStatusesForCompany();
    public Integer createOrderChangeStatus(OrderChangeStatusWS orderChangeStatusWS) throws SessionInternalError;
    public void updateOrderChangeStatus(OrderChangeStatusWS orderChangeStatusWS) throws SessionInternalError;
    public void deleteOrderChangeStatus(Integer id) throws SessionInternalError;
    public void saveOrderChangeStatuses(OrderChangeStatusWS[] orderChangeStatuses) throws SessionInternalError;

    /*
     * OrderChangeType
     */
    public OrderChangeTypeWS[] getOrderChangeTypesForCompany();
    public OrderChangeTypeWS getOrderChangeTypeByName(String name);
    public OrderChangeTypeWS getOrderChangeTypeById(Integer orderChangeTypeId);
    public Integer createUpdateOrderChangeType(OrderChangeTypeWS orderChangeTypeWS);
    public void deleteOrderChangeType(Integer orderChangeTypeId);

    /*
     * OrderChange
     */
    public OrderChangeWS[] getOrderChanges(Integer orderId);

    /*
        Diameter Protocol
     */

    DiameterResultWS createSession(String sessionId, Date timestamp, BigDecimal units,
    		PricingField[] data) throws SessionInternalError;
    DiameterResultWS reserveUnits(String sessionId, Date timestamp, int units, 
    		PricingField[] data) throws SessionInternalError;
    DiameterResultWS updateSession(String sessionId, Date timestamp, BigDecimal usedUnits, 
    		BigDecimal reqUnits, PricingField[] data) throws SessionInternalError;
    DiameterResultWS extendSession(String sessionId, Date timestamp, BigDecimal usedUnits, 
    		BigDecimal reqUnits) throws SessionInternalError;
    DiameterResultWS endSession(String sessionId, Date timestamp, BigDecimal usedUnits, 
    		int causeCode) throws SessionInternalError;
    DiameterResultWS consumeReservedUnits(String sessionId, Date timestamp, int usedUnits,
    		int causeCode) throws SessionInternalError;
    /*
      Route Based Rating
     */
    public Integer createRoute(RouteWS routeWS, File routeFile);
    public void deleteRoute(Integer routeId);
    public RouteWS getRoute(Integer routeId);
    public Integer createMatchingField(MatchingFieldWS matchingFieldWS );
    public void deleteMatchingField(Integer matchingFieldId);
    public MatchingFieldWS getMatchingField(Integer matchingFieldId);
    public boolean updateMatchingField(MatchingFieldWS matchingFieldWS);
    public Integer createRouteRateCard(RouteRateCardWS routeRateCardWS, File routeRateCardFile);
    public void deleteRouteRateCard(Integer routeId);
    public void updateRouteRateCard(RouteRateCardWS routeRateCardWS, File routeRateCardFile);
    public RouteRateCardWS getRouteRateCard(Integer routeRateCardId);
    public Integer createRouteRecord(RouteRecordWS record, Integer routeId);
    public void updateRouteRecord(RouteRecordWS record, Integer routeId) ;
    public void deleteRouteRecord(Integer routeId, Integer recordId) ;
    public SearchResultString searchDataTable(Integer routeId, SearchCriteria criteria);

    public Set<String> searchDataTableWithFilter(Integer routeId, String filters, String searchName);
    public String getRouteTable(Integer routeId) ;
    public Integer createDataTableQuery(DataTableQueryWS queryWS) ;
    public DataTableQueryWS getDataTableQuery(int id) ;
    public void deleteDataTableQuery(int id) ;
    public DataTableQueryWS[] findDataTableQueriesForTable(int routeId) ;

    /*
     Rating Unit
     */
    public Integer createRatingUnit(RatingUnitWS ratingUnitWS);
    public void updateRatingUnit(RatingUnitWS ratingUnitWS);
    public boolean deleteRatingUnit(Integer ratingUnitId);
    public RatingUnitWS getRatingUnit(Integer ratingUnitId);
    public RatingUnitWS[] getAllRatingUnits();
    
    /*
     * UsagePool 
     */
    public Integer createUsagePool(UsagePoolWS usagePool);
    public void updateUsagePool(UsagePoolWS usagePool);
    public UsagePoolWS getUsagePoolWS(Integer usagePoolId);
    public boolean deleteUsagePool(Integer usagePoolId);
    public UsagePoolWS[] getAllUsagePools();
    public UsagePoolWS[] getUsagePoolsByPlanId(Integer planId);
    public CustomerUsagePoolWS getCustomerUsagePoolById(Integer customerUsagePoolId);
    public CustomerUsagePoolWS[] getCustomerUsagePoolsByCustomerId(Integer customerId);
    
    /*
     *Payment Method 
     */
    public PaymentMethodTemplateWS getPaymentMethodTemplate(Integer templateId);
    
    public Integer createPaymentMethodType(PaymentMethodTypeWS paymentMethod);
    public void updatePaymentMethodType(PaymentMethodTypeWS paymentMethod);
    public boolean deletePaymentMethodType(Integer paymentMethodTypeId);
    public PaymentMethodTypeWS getPaymentMethodType(Integer paymentMethodTypeId);
    
    public boolean removePaymentInstrument(Integer instrumentId);
    
    /* Customizable order status 7375 */
	public void deleteOrderStatus(OrderStatusWS orderStatus) ;
	public Integer createUpdateOrderStatus(OrderStatusWS orderStatusWS);
	public OrderStatusWS findOrderStatusById(Integer orderStatusId);
	public int getDefaultOrderStatusId(OrderStatusFlag flag, Integer entityId);
    
    /*
     * Plugin Type
     */
    
    public PluggableTaskTypeWS getPluginTypeWS(Integer id);
    public PluggableTaskTypeWS getPluginTypeWSByClassName(String className);
    public PluggableTaskTypeCategoryWS getPluginTypeCategory(Integer id);
    public PluggableTaskTypeCategoryWS getPluginTypeCategoryByInterfaceName(String interfaceName);
    
    /*
     * Subscription products
     */
    
    public Integer[] createSubscriptionAccountAndOrder(Integer parentAccountId, OrderWS order, boolean createInvoice, List<OrderChangeWS> orderChanges);
    public Long getMediationErrorRecordsCount(Integer mediationConfigurationId);
    public Integer createOrderPeriod(OrderPeriodWS orderPeriod);

    /*
     * Enumerations
     */
    public EnumerationWS getEnumeration(Integer enumerationId) throws SessionInternalError;
    public EnumerationWS getEnumerationByName(String name) throws SessionInternalError;
    public List<EnumerationWS> getAllEnumerations(Integer max, Integer offset);
    public Long getAllEnumerationsCount();
    public Integer createUpdateEnumeration(EnumerationWS enumerationWS) throws SessionInternalError;
    public boolean deleteEnumeration(Integer enumerationId) throws SessionInternalError;

    /*Copy Company*/
    public UserWS copyCompany(String childCompanyTemplateName, Integer entityId, List<String> importEntities, boolean isCompanyChild, boolean copyProducts, boolean copyPlans);

    //Customer Enrollment
    public CustomerEnrollmentWS getCustomerEnrollment(Integer customerEnrollmentId) throws SessionInternalError;
    public Integer createUpdateEnrollment(CustomerEnrollmentWS customerEnrollmentWS) throws SessionInternalError;
    public CustomerEnrollmentWS validateCustomerEnrollment(CustomerEnrollmentWS customerEnrollmentWS) throws SessionInternalError;
    public void deleteEnrollment(Integer customerEnrollmentId) throws SessionInternalError;

    /*
     * EDI File processor
     */

    public int generateEDIFile(Integer ediTypeId, Integer entityId, String fileName, Collection input) throws SessionInternalError;
    public int parseEDIFile(Integer ediTypeId, Integer entityId, File parserFile) throws SessionInternalError;

    public Integer createEDIType(EDITypeWS ediTypeWS, File ediFormatFile) throws SessionInternalError;
    public void deleteEDIType(Integer ediTypeId) throws SessionInternalError;
    public EDITypeWS getEDIType(Integer ediTypeId) throws SessionInternalError;

    public List<CompanyWS> getAllChildEntities(Integer parentId) throws SessionInternalError;

    /*
	 * Payment Transfer
	 */
    public void transferPayment(PaymentTransferWS paymentTransfer);


    public void updateEDIStatus(EDIFileWS ediFileWS, EDIFileStatusWS statusWS) throws SessionInternalError;

    /* migration related api */
    public Integer createAdjustmentOrderAndInvoice(String customerPrimaryAccount, OrderWS order, OrderChangeWS[] orderChanges);
    public String createPaymentForHistoricalDateMigration(String customerPrimaryAccount, Integer chequePmId, String amount, String date);
    public String adjustUserBalance(String customerPrimaryAccount, String amount, Integer chequePmId, String date);

    public EDIFileStatusWS findEdiStatusById(Integer ediStatusId);
}
