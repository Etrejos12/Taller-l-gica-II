package controladores;

import servicios.EnvioServicio;
import vistas.EnvioVista;

public class EnvioControlador {

    private EnvioVista vista;

    public EnvioControlador(EnvioVista vista) {
        this.vista = vista;
        this.vista.setGuardarEnvioClick(evento -> agregarEnvio());
        this.vista.setEliminarEnvioClick(evento -> quitarEnvio());
        mostrarEnvios();
    }

    private void mostrarEnvios() {
        vista.mostrarEnvios(EnvioServicio.getDatos(), EnvioServicio.getEncabezados());
    }

    private void agregarEnvio() {
        var tipo = vista.getTipoEnvioSeleccionado();
        var codigo = vista.getCodigo();
        var cliente = vista.getCliente();
        var peso = vista.getPeso();
        var distancia = vista.getDistancia();

        var envioAgregado = EnvioServicio.agregar(tipo, codigo, cliente, peso, distancia);

        if (envioAgregado != null) {
            mostrarEnvios();
            vista.ocultarPanelEditarEnvio();
        } else {
            vista.mostrarMensaje("No se pudo agregar el envío");
        }
    }

    private void quitarEnvio() {
        if (vista.getFilaEnvioSeleccionada() >= 0) {
            if (vista.confirmar("¿Está seguro de eliminar el envío?")) {
                EnvioServicio.eliminar(vista.getFilaEnvioSeleccionada());
                mostrarEnvios();
            }
        } else {
            vista.mostrarMensaje("Debe seleccionar un envío");
        }
    }
}
