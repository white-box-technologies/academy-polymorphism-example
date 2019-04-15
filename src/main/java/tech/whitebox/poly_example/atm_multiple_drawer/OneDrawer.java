package tech.whitebox.poly_example.atm_multiple_drawer;

class OneDrawer extends AtmDrawer {
    private Integer denomination = 1;
    private Integer stock = 100;

    @Override
    public void commitExtraction() {
        //commit extraction;
        sendAlert();
    }

    private void sendAlert(){
        if (stock < 50){
            System.out.println("Stock less than 50");
        }
    }
}
