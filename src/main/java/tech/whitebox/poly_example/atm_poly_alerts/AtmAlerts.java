package tech.whitebox.poly_example.atm_poly_alerts;

public interface AtmAlerts {
    boolean isAplicable(AtmDrawer atmDrawer);

    void send(AtmDrawer atmDrawer);
}
