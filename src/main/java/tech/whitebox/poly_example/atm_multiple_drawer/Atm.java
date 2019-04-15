package tech.whitebox.poly_example.atm_multiple_drawer;

import java.util.List;

public class Atm {
    List<AtmDrawer> drawers;

    public Atm() {
        this.drawers = DrawerFactory.instantiateDrawers();
    }


    public String extractSum(Integer sum){
        if (enoughBanknotes(sum)){
            String extracted = prepareExtraction(sum);
            drawers.forEach(AtmDrawer::commitExtraction);
            return extracted;
        } else {
            return "Not enough money left in ATM";
        }
    }

    private String prepareExtraction(Integer sum) {
        return "Works";
    }

    private boolean enoughBanknotes(Integer sum) {
        return true;
    }

}
