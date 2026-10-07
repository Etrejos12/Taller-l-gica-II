package modelos;

import java.text.DecimalFormat;

public class Maritimo extends Envio {

    private static final double TARIFA_KM = 800;
    private static final double RECARGO_KG = 1000;

    public Maritimo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        return (getDistancia() * TARIFA_KM) + (getPeso() * RECARGO_KG);
    }

    @Override
    public String[] getDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[]{
                "MARÍTIMO",
                getCodigo(),
                getCliente(),
                df.format(getPeso()),
                df.format(getDistancia()),
                "$ " + df.format(calcularTarifa())
        };
    }

    @Override
    public String toString() {
        return "MARÍTIMO #[" + getCodigo() + "] Cliente[" + getCliente() + "]";
    }
}
