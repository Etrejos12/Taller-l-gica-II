import controladores.EnvioControlador;
import vistas.EnvioVista;

public class Logistica {
    public static void main(String[] args) {
        EnvioVista vista = new EnvioVista();
        EnvioControlador controlador = new EnvioControlador(vista);
        vista.setVisible(true);
    }
}
