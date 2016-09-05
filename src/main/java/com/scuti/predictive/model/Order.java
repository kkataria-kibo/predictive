package com.scuti.predictive.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kkataria on 9/4/2016.
 */
@Slf4j
@Document(collection = "order")
public class Order {

    private String externalOrderId;
    private String status;
    private Item items;
    private Shipment shipments;
    private Tracking trackings;
    private Payment payments;
    private String charges;
    private String merhandiseTotal;
    private String shippingCostTotal;
    private String shippingMethodTotal;
    private String shippingWeightTotal;
    private String weightSurchargeTotal;
    private String shippingLocationTotal;
    private String shippingStateTotal;
    private String shippingTaxTotal;
    private String giftWrapTotal;
    private String additionalAddressTotal;
    private String additionalCharges;
    private String comment1;
    private String comment2;
    private String deferred;
    private String multipleAddresses;
    private String sourceCodes;
    private String deleted;
    private String dateOrdered;
    private String dateDeleted;
    private String billtoInfo;
    private String locale;
    private String channel;
    private String holdReason;
    private String locked;
    private String orderProviderType;
    private String refund;
    private String refundAmount;
    private String orderType;
    private String orderState;
    private String deliveryMethod;
    private String orderID;
    private String customerIP;
    private Customer customer;
    private String orderDiscount;

    public Order() {
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    private String tax;

    public String getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(String orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public Shipment getShipments() {
        return shipments;
    }

    public void setShipments(Shipment shipments) {
        this.shipments = shipments;
    }

    public Tracking getTrackings() {
        return trackings;
    }

    public void setTrackings(Tracking trackings) {
        this.trackings = trackings;
    }

    public Payment getPayments() {
        return payments;
    }

    public void setPayments(Payment payments) {
        this.payments = payments;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getShippingCostTotal() {
        return shippingCostTotal;
    }

    public void setShippingCostTotal(String shippingCostTotal) {
        this.shippingCostTotal = shippingCostTotal;
    }

    public String getShippingMethodTotal() {
        return shippingMethodTotal;
    }

    public void setShippingMethodTotal(String shippingMethodTotal) {
        this.shippingMethodTotal = shippingMethodTotal;
    }

    public String getShippingWeightTotal() {
        return shippingWeightTotal;
    }

    public void setShippingWeightTotal(String shippingWeightTotal) {
        this.shippingWeightTotal = shippingWeightTotal;
    }

    public String getWeightSurchargeTotal() {
        return weightSurchargeTotal;
    }

    public void setWeightSurchargeTotal(String weightSurchargeTotal) {
        this.weightSurchargeTotal = weightSurchargeTotal;
    }

    public String getShippingLocationTotal() {
        return shippingLocationTotal;
    }

    public void setShippingLocationTotal(String shippingLocationTotal) {
        this.shippingLocationTotal = shippingLocationTotal;
    }

    public String getShippingStateTotal() {
        return shippingStateTotal;
    }

    public void setShippingStateTotal(String shippingStateTotal) {
        this.shippingStateTotal = shippingStateTotal;
    }

    public String getShippingTaxTotal() {
        return shippingTaxTotal;
    }

    public void setShippingTaxTotal(String shippingTaxTotal) {
        this.shippingTaxTotal = shippingTaxTotal;
    }

    public String getGiftWrapTotal() {
        return giftWrapTotal;
    }

    public void setGiftWrapTotal(String giftWrapTotal) {
        this.giftWrapTotal = giftWrapTotal;
    }

    public String getAdditionalAddressTotal() {
        return additionalAddressTotal;
    }

    public void setAdditionalAddressTotal(String additionalAddressTotal) {
        this.additionalAddressTotal = additionalAddressTotal;
    }

    public String getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(String additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public String getDeferred() {
        return deferred;
    }

    public void setDeferred(String deferred) {
        this.deferred = deferred;
    }

    public String getMultipleAddresses() {
        return multipleAddresses;
    }

    public void setMultipleAddresses(String multipleAddresses) {
        this.multipleAddresses = multipleAddresses;
    }

    public String getSourceCodes() {
        return sourceCodes;
    }

    public void setSourceCodes(String sourceCodes) {
        this.sourceCodes = sourceCodes;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public String getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(String dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public String getBilltoInfo() {
        return billtoInfo;
    }

    public void setBilltoInfo(String billtoInfo) {
        this.billtoInfo = billtoInfo;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getHoldReason() {
        return holdReason;
    }

    public void setHoldReason(String holdReason) {
        this.holdReason = holdReason;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getOrderProviderType() {
        return orderProviderType;
    }

    public void setOrderProviderType(String orderProviderType) {
        this.orderProviderType = orderProviderType;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public void setCustomerIP(String customerIP) {
        this.customerIP = customerIP;
    }


    public String getMerhandiseTotal() {
        return merhandiseTotal;
    }

    public void setMerhandiseTotal(String merhandiseTotal) {
        this.merhandiseTotal = merhandiseTotal;
    }
}
