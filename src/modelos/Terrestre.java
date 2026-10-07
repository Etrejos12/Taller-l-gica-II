package modelos;

import java.text.DecimalFormat;

public class Terrestre extends Envio {

    private static final double TARIFA_KM = 1500;
    private static final double RECARGO_KG = 2000;

    public Terrestre(String codigo, String cliente, double peso, double distancia) {
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
                "TERRESTRE",
                getCodigo(),
                getCliente(),
                df.format(getPeso()),
                df.format(getDistancia()),
                "$ " + df.format(calcularTarifa())
        };
    }

    @Override
    public String toString() {
        return "TERRESTRE #[" + getCodigo() + "] Cliente[" + getCliente() + "]";
    }
}
