package tech.whitebox.poly_example.atm_poly_alerts;

public class AtmDrawer {
    private Integer denomination;
    private Integer stock;

    public AtmDrawer(Integer denomination, Integer stock) {
        this.denomination = denomination;
        this.stock = stock;
    }

    public Integer remainingValue(){
        return denomination * stock;
    }
}
