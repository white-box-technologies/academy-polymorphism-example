package tech.whitebox.poly_example.atm_poly_alerts;

import org.reflections.Reflections;

import java.util.*;
import java.util.stream.IntStream;

public class Atm {
    List<AtmDrawer> drawers = new ArrayList<>();
    List<AtmAlerts> alerts = new ArrayList<>();
    private List<Integer> denominations = Arrays.asList(1,5,10,50,100);
    private List<Integer> stock = Arrays.asList(100,100,100,100,100);


    public Atm (){
        IntStream.range(0,denominations.size())
                .forEach(i ->drawers.add(new AtmDrawer(denominations.get(i),stock.get(i))) );
        Reflections reflection = new Reflections("tech.whitebox.poly_example.atm_poly_alerts");
        Set<Class<? extends AtmAlerts>> atmAlerts = reflection.getSubTypesOf(AtmAlerts.class);
        atmAlerts.forEach(clazz -> {
            try {
                alerts.add(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public String extractSum(Integer sum){
        if (enoughBanknotes(sum)){
            String extracted = prepareExtraction(sum);
            commitExtraction(sum);
            sendAlerts();
            return extracted;
        } else {
            return "Not enough money left in ATM";
        }
    }

    private void sendAlerts() {
        for (AtmDrawer drawer : drawers) {
            alerts.stream().filter(alert -> alert.isAplicable(drawer)).forEach(alert-> alert.send(drawer));
        }
    }

    private void commitExtraction(Integer sum) {
        //Commit the Extraction
    }

    private String prepareExtraction(Integer sum) {
        //Extract money from AtmDrawer
        return "100 de ron";
    }

    private boolean enoughBanknotes(Integer sum) {
        Integer leftBanknotes = drawers.stream()
                                .reduce(0, (partialSum,drawer) -> partialSum + drawer.remainingValue(),Integer::sum);
        return leftBanknotes>= sum;
    }
}
