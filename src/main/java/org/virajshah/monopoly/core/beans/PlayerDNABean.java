package org.virajshah.monopoly.core.beans;

import java.util.Random;

public class PlayerDNABean {
    private static Random random = new Random();
    private double spendingTolerance;
    private double negotiationSettlement;
    private double quickBuilder;

    /**
     * Generates random values for the bean
     */
    public PlayerDNABean() {
        spendingTolerance = random.nextDouble();
        negotiationSettlement = 1 + random.nextDouble();
        quickBuilder = (random.nextDouble() * 11) + 1;
    }

    /**
     * @return the spendingTolerance
     */
    public double getSpendingTolerance() {
        return spendingTolerance;
    }

    /**
     * @param spendingTolerance the spendingTolerance to set
     */
    public void setSpendingTolerance(double spendingTolerance) {
        this.spendingTolerance = spendingTolerance;
    }

    /**
     * @return the negotiationSettlement
     */
    public double getNegotiationSettlement() {
        return negotiationSettlement;
    }

    /**
     * @param negotiationSettlement the negotiationSettlement to set
     */
    public void setNegotiationSettlement(double negotiationSettlement) {
        this.negotiationSettlement = negotiationSettlement;
    }

    /**
     * @return the quickBuilder
     */
    public double getQuickBuilder() {
        return quickBuilder;
    }

    /**
     * @param quickBuilder the quickBuilder to set
     */
    public void setQuickBuilder(double quickBuilder) {
        this.quickBuilder = quickBuilder;
    }
}
