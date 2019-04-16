package tech.whitebox.poly_example.atm_poly_alerts.alerts;

import tech.whitebox.poly_example.atm_poly_alerts.AtmAlerts;
import tech.whitebox.poly_example.atm_poly_alerts.AtmDrawer;

public class CriticalAlert implements AtmAlerts {
    @Override
    public boolean isAplicable(AtmDrawer atmDrawer) {

        return atmDrawer.getStock() == 0 && Math.random() < 0.5;
    }

    @Override
    public void send(AtmDrawer atmDrawer) {

        System.out.println("Mock Email - priority High, CC la Bank CEO <HARD alert: no more notes of in drawer: " + atmDrawer +
                ". Customers are unhappy :( >");

        System.out.println("SMS to Bank CEO: <Your customers are suffering>");

        System.out.println("Print to screen: no more banknotes in drawer " + atmDrawer);
    }
}
