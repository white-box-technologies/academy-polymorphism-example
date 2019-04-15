package tech.whitebox.poly_example.atm_multiple_drawer;

class FiveDrawer extends AtmDrawer {
    private Integer denomination = 5;
    private Integer stock = 100;

    @Override
    public void commitExtraction() {
        //commit extraction;
        sendAlert();
    }

    private void sendAlert(){
        if (stock < 25){
            System.out.println("Stock less than 50");
        }
    }
}
