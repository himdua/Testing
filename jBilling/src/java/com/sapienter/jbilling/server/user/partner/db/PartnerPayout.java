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
package com.sapienter.jbilling.server.user.partner.db;


import com.sapienter.jbilling.server.payment.db.PaymentDTO;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@TableGenerator(
        name="partner_payout_GEN",
        table="jbilling_seqs",
        pkColumnName = "name",
        valueColumnName = "next_id",
        pkColumnValue="partner_payout",
        allocationSize=10
)
@Table(name="partner_payout")
public class PartnerPayout  implements java.io.Serializable {

    private int id;
    private PaymentDTO payment;
    private PartnerDTO partner;
    private Date startingDate;
    private Date endingDate;
    private BigDecimal paymentsAmount;
    private BigDecimal refundsAmount;
    private BigDecimal balanceLeft;
    private int versionNum;

    private Integer paymentId = null;
    private Integer partnerId = null;

    public PartnerPayout() {
    }

    public PartnerPayout(int id, Date startingDate, Date endingDate, BigDecimal paymentsAmount,
                         BigDecimal refundsAmount, BigDecimal balanceLeft) {
        this.id = id;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.paymentsAmount = paymentsAmount;
        this.refundsAmount = refundsAmount;
        this.balanceLeft = balanceLeft;
    }

    public PartnerPayout(int id, PaymentDTO payment, PartnerDTO partner, Date startingDate, Date endingDate,
                         BigDecimal paymentsAmount, BigDecimal refundsAmount, BigDecimal balanceLeft) {
        this.id = id;
        this.payment = payment;
        this.partner = partner;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.paymentsAmount = paymentsAmount;
        this.refundsAmount = refundsAmount;
        this.balanceLeft = balanceLeft;
    }

    @Id  @GeneratedValue(strategy=GenerationType.TABLE, generator="partner_payout_GEN")
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="payment_id")
    public PaymentDTO getPayment() {
        return this.payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="partner_id")
    public PartnerDTO getPartner() {
        return this.partner;
    }

    public void setPartner(PartnerDTO partner) {
        this.partner = partner;
    }

    @Column(name="starting_date", nullable=false, length=13)
    public Date getStartingDate() {
        return this.startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    @Column(name="ending_date", nullable=false, length=13)
    public Date getEndingDate() {
        return this.endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    @Column(name="payments_amount", nullable=false, precision=17, scale=17)
    public BigDecimal getPaymentsAmount() {
        return this.paymentsAmount;
    }

    public void setPaymentsAmount(BigDecimal paymentsAmount) {
        this.paymentsAmount = paymentsAmount;
    }

    @Column(name="refunds_amount", nullable=false, precision=17, scale=17)
    public BigDecimal getRefundsAmount() {
        return this.refundsAmount;
    }

    public void setRefundsAmount(BigDecimal refundsAmount) {
        this.refundsAmount = refundsAmount;
    }

    @Column(name="balance_left", nullable=false, precision=17, scale=17)
    public BigDecimal getBalanceLeft() {
        return this.balanceLeft;
    }

    public void setBalanceLeft(BigDecimal balanceLeft) {
        this.balanceLeft = balanceLeft;
    }

    @Version
    @Column(name="OPTLOCK")
    public Integer getVersionNum() {
        return versionNum;
    }
    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    @Transient
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Transient
    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Transient
    public BigDecimal getTotal() {
        return getBalanceLeft().add(getPayment().getAmount());
    }

    public void touch() {
        getStartingDate();
        if (getPayment() != null) {
            getPayment().getCurrency();
        }
    }

    public String getAuditKey(Serializable id) {
        StringBuilder key = new StringBuilder();
        key.append(getPartner().getBaseUser().getCompany().getId())
                .append("-prn-")
                .append(getPartner().getId())
                .append("-")
                .append(id);

        return key.toString();
    }
}


