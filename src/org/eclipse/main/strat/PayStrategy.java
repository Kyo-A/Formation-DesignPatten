package org.eclipse.main.strat;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}