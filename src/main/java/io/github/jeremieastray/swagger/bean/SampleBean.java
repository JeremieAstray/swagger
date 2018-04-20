package io.github.jeremieastray.swagger.bean;

import java.math.BigDecimal;

/**
 * @author guanhong 2018/4/19.
 */
public class SampleBean {
    private String planId;
    private String planName;
    private BigDecimal amount;
    private BigDecimal balance;
    private Integer canRecvQuick;
    private String planConfig;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getCanRecvQuick() {
        return canRecvQuick;
    }

    public void setCanRecvQuick(Integer canRecvQuick) {
        this.canRecvQuick = canRecvQuick;
    }

    public String getPlanConfig() {
        return planConfig;
    }

    public void setPlanConfig(String planConfig) {
        this.planConfig = planConfig;
    }

    @Override
    public String toString() {
        return "SampleBean{" +
                "planId='" + planId + '\'' +
                ", planName='" + planName + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", canRecvQuick=" + canRecvQuick +
                ", planConfig='" + planConfig + '\'' +
                '}';
    }
}
