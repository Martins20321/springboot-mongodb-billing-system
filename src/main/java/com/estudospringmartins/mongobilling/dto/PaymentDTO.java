package com.estudospringmartins.mongobilling.dto;

import com.estudospringmartins.mongobilling.domain.Charge;
import com.estudospringmartins.mongobilling.domain.enums.PaymentMethod;
import com.estudospringmartins.mongobilling.domain.enums.PaymentStatus;

import java.io.Serializable;
import java.util.Date;

public class PaymentDTO implements Serializable {

    private Date paymentDate;
    private Double amount;
    private PaymentMethod method;
    private PaymentStatus status;

    private Charge charge;

    public PaymentDTO(){

    }

    public PaymentDTO(Date paymentDate, Double amount, PaymentMethod method, PaymentStatus status) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }
}
