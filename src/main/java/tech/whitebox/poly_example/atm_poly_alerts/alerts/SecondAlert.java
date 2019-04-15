package tech.whitebox.poly_example.atm_poly_alerts.alerts;

import tech.whitebox.poly_example.atm_poly_alerts.AtmAlerts;
import tech.whitebox.poly_example.atm_poly_alerts.AtmDrawer;

public class SecondAlert implements AtmAlerts {
    @Override
    public boolean isAplicable(AtmDrawer atmDrawer) {
        return atmDrawer.remainingValue() > 1000 && Math.random() < 0.5;
    }

    @Override
    public void send(AtmDrawer atmDrawer) {
        System.out.println("Alerta 2");
    }
}
