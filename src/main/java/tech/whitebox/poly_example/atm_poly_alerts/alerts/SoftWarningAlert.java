package tech.whitebox.poly_example.atm_poly_alerts.alerts;

import tech.whitebox.poly_example.atm_poly_alerts.AtmAlerts;
import tech.whitebox.poly_example.atm_poly_alerts.AtmDrawer;

public class SoftWarningAlert implements AtmAlerts {


    public static final int ALERT_THRESHOLD = 20;

    @Override
    public boolean isAplicable(AtmDrawer atmDrawer) {

        return atmDrawer.getStock() < ALERT_THRESHOLD && Math.random() < 0.5;
    }

    @Override
    public void send(AtmDrawer atmDrawer) {
        System.out.println("Mock Email - priority Normal <SOFT alert: Warning, stock is below " + ALERT_THRESHOLD +
                ". Please refill soon.>");
    }
}
