package vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import modelos.TipoEnvio;

public class EnvioVista extends JFrame {

    private JTable tblEnvios;
    private JPanel pnlEditarEnvio;

    private JTextField txtCodigo, txtCliente, txtDistancia, txtPeso;
    private JComboBox cmbTipoEnvio;

    private JButton btnGuardarEnvio, btnQuitarEnvio;

    public EnvioVista() {
        setSize(700, 450);
        setTitle("Operador Logístico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar tbLogistica = new JToolBar();

        JButton btnAgregarEnvio = new JButton();
        btnAgregarEnvio.setIcon(new ImageIcon(getClass().getResource("/iconos/AgregarEnvio.png")));
        btnAgregarEnvio.setToolTipText("Agregar Envío");
        btnAgregarEnvio.addActionListener(evento -> {
            btnAgregarEnvioClick();
        });
        tbLogistica.add(btnAgregarEnvio);

        btnQuitarEnvio = new JButton();
        btnQuitarEnvio.setIcon(new ImageIcon(getClass().getResource("/iconos/QuitarEnvio.png")));
        btnQuitarEnvio.setToolTipText("Quitar Envío");
        tbLogistica.add(btnQuitarEnvio);

        // Contenedor principal con BoxLayout (vertical)
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.Y_AXIS));

        // Panel de edición (oculto por defecto)
        pnlEditarEnvio = new JPanel();
        pnlEditarEnvio.setPreferredSize(new Dimension(pnlEditarEnvio.getWidth(), 100));
        pnlEditarEnvio.setLayout(null);

        JLabel lblNumero = new JLabel("Número");
        lblNumero.setBounds(10, 10, 100, 25);
        pnlEditarEnvio.add(lblNumero);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(110, 10, 100, 25);
        pnlEditarEnvio.add(txtCodigo);

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(220, 10, 100, 25);
        pnlEditarEnvio.add(lblTipo);

        cmbTipoEnvio = new JComboBox();
        cmbTipoEnvio.setBounds(320, 10, 150, 25);
        DefaultComboBoxModel mdlTipoEnvio = new DefaultComboBoxModel(TipoEnvio.values());
        cmbTipoEnvio.setModel(mdlTipoEnvio);
        pnlEditarEnvio.add(cmbTipoEnvio);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(10, 40, 100, 25);
        pnlEditarEnvio.add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(110, 40, 100, 25);
        pnlEditarEnvio.add(txtCliente);

        JLabel lblDistancia = new JLabel("Distancia en Km");
        lblDistancia.setBounds(220, 40, 110, 25);
        pnlEditarEnvio.add(lblDistancia);

        txtDistancia = new JTextField();
        txtDistancia.setBounds(330, 40, 140, 25);
        pnlEditarEnvio.add(txtDistancia);

        JLabel lblPeso = new JLabel("Peso");
        lblPeso.setBounds(10, 70, 100, 25);
        pnlEditarEnvio.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(110, 70, 100, 25);
        pnlEditarEnvio.add(txtPeso);

        btnGuardarEnvio = new JButton("Guardar");
        btnGuardarEnvio.setBounds(220, 70, 100, 25);
        pnlEditarEnvio.add(btnGuardarEnvio);

        JButton btnCancelarEnvio = new JButton("Cancelar");
        btnCancelarEnvio.setBounds(330, 70, 100, 25);
        btnCancelarEnvio.addActionListener(evt -> {
            btnCancelarEnvioClick();
        });
        pnlEditarEnvio.add(btnCancelarEnvio);

        pnlEditarEnvio.setVisible(false);

        // Tabla de envíos (siempre visible)
        tblEnvios = new JTable();
        JScrollPane spListaEnvios = new JScrollPane(tblEnvios);

        pnlPrincipal.add(pnlEditarEnvio);
        pnlPrincipal.add(spListaEnvios);

        JScrollPane spEnvios = new JScrollPane(pnlPrincipal);
        spEnvios.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        getContentPane().add(tbLogistica, BorderLayout.NORTH);
        getContentPane().add(spEnvios, BorderLayout.CENTER);
    }

    // getters

    public TipoEnvio getTipoEnvioSeleccionado() {
        return (TipoEnvio) cmbTipoEnvio.getSelectedItem();
    }

    public String getCodigo() {
        return txtCodigo.getText();
    }

    public String getCliente() {
        return txtCliente.getText();
    }

    public double getDistancia() {
        try {
            return Double.parseDouble(txtDistancia.getText());
        } catch (Exception ex) {
        }
        return 0;
    }

    public double getPeso() {
        try {
            return Double.parseDouble(txtPeso.getText());
        } catch (Exception ex) {
        }
        return 0;
    }

    public int getFilaEnvioSeleccionada() {
        return tblEnvios.getSelectedRow();
    }

    // setters
    public void setGuardarEnvioClick(ActionListener escuchadorEventos) {
        btnGuardarEnvio.addActionListener(escuchadorEventos);
    }

    public void setEliminarEnvioClick(ActionListener escuchadorEventos) {
        btnQuitarEnvio.addActionListener(escuchadorEventos);
    }

    // metodos públicos

    public boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void mostrarEnvios(String[][] datos, String[] encabezados) {
        DefaultTableModel dtm = new DefaultTableModel(datos, encabezados);
        tblEnvios.setModel(dtm);
    }

    public void ocultarPanelEditarEnvio() {
        pnlEditarEnvio.setVisible(false);
    }

    // eventos
    private void btnAgregarEnvioClick() {
        pnlEditarEnvio.setVisible(true);
    }

    private void btnCancelarEnvioClick() {
        ocultarPanelEditarEnvio();
    }

}
