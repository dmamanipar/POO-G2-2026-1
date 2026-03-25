package pe.edu.upeu.dependencia;

public class Cliente {
    /**
     *
     * @param paypal
     * @param monto
     */
    void realizarPago(Paypal paypal, double monto){
        paypal.procesarPago(monto);
    }

    public static void main(String[] args) {
        Cliente c=new Cliente();
        c.realizarPago(new Paypal(), 500);
    }
}
