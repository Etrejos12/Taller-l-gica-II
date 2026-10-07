package servicios;

import java.util.ArrayList;
import java.util.List;

import modelos.Aereo;
import modelos.Envio;
import modelos.Maritimo;
import modelos.Terrestre;
import modelos.TipoEnvio;

public class EnvioServicio {

    private static String[] encabezados = new String[]{
            "Tipo", "Código", "Cliente", "Peso", "Distancia", "Costo"
    };

    private static List<Envio> envios = new ArrayList<>();

    public static String[] getEncabezados() {
        return encabezados;
    }

    public static Envio get(int posicion) {
        if (posicion >= 0 && posicion < envios.size()) {
            return envios.get(posicion);
        }
        return null;
    }

    public static Envio agregar(TipoEnvio tipo, String codigo, String cliente,
                                double peso, double distancia) {
        Envio envio = null;
        switch (tipo) {
            case TERRESTRE:
                envio = new Terrestre(codigo, cliente, peso, distancia);
                break;
            case AEREO:
                envio = new Aereo(codigo, cliente, peso, distancia);
                break;
            case MARITIMO:
                envio = new Maritimo(codigo, cliente, peso, distancia);
                break;
        }
        if (envio != null) {
            envios.add(envio);
        }
        return envio;
    }

    public static String[][] getDatos() {
        String[][] datos = new String[envios.size()][encabezados.length];
        int fila = 0;
        for (var envio : envios) {
            int columna = 0;
            for (var dato : envio.getDatos()) {
                if (columna < encabezados.length) {
                    datos[fila][columna] = dato;
                }
                columna++;
            }
            fila++;
        }
        return datos;
    }

    public static boolean eliminar(int posicion) {
        if (posicion >= 0 && posicion < envios.size()) {
            envios.remove(posicion);
            return true;
        }
        return false;
    }

}
