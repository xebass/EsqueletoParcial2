package VentaView;
 
import VentaModel.Cliente;
import VentaModel.Partido;
import VentaModel.Ticket;
import VentaController.VentaController;
import VentaModel.Cliente;
import VentaModel.Partido;
import VentaModel.Ticket;
 
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
 
public class VentaView extends javax.swing.JFrame {
 
    private final VentaController controlador = new VentaController();
 
    // usuario logueado — en producción viene del login
    private final int usuarioId = 1;
    private final String usuarioNombre = "vendedor01";
 
    private final DefaultTableModel modeloDisponibles = new DefaultTableModel(
            new Object[]{"ID", "Asiento", "Sección", "Precio (Q)"}, 0);
    private final DefaultTableModel modeloSeleccionados = new DefaultTableModel(
            new Object[]{"ID", "Asiento", "Sección", "Precio (Q)"}, 0);
 
    private final List<Ticket> disponibles    = new ArrayList<>();
    private final List<Ticket> seleccionados  = new ArrayList<>();
 
    // Variables de componentes Swing
    private javax.swing.ButtonGroup buttonGroupCliente;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRecargarClientes;
    private javax.swing.JButton btnRecargarPartidos;
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JComboBox<Partido> cmbPartido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelPartido;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelResumen;
    private javax.swing.JPanel jPanelTickets;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtDisponibles;
    private javax.swing.JTable jtSeleccionados;
    private javax.swing.JLabel lblDescInfo;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblEstadio;
    private javax.swing.JLabel lblFase;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbExistente;
    private javax.swing.JRadioButton rbNuevo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
 
    public VentaView() {
        initComponents();
        jtDisponibles.setModel(modeloDisponibles);
        jtSeleccionados.setModel(modeloSeleccionados);
        cargarPartidos();
        cargarClientes();
    }
 
    @SuppressWarnings("unchecked")
    private void initComponents() {
 
        buttonGroupCliente = new javax.swing.ButtonGroup();
        jPanelPrincipal = new javax.swing.JPanel();
 
        // ── Partido ──
        jPanelPartido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbPartido = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblFase = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEstadio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnRecargarPartidos = new javax.swing.JButton();
 
        // ── Tickets ──
        jPanelTickets = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDisponibles = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtSeleccionados = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
 
        // ── Cliente ──
        jPanelCliente = new javax.swing.JPanel();
        rbExistente = new javax.swing.JRadioButton();
        rbNuevo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        btnRecargarClientes = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
 
        // ── Resumen ──
        jPanelResumen = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        lblDescInfo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
 
        // ── Botones ──
        btnConfirmar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
 
        // ── configuración ventana ──────────────────────────────────────────
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mundial 2026 — Venta de Tickets");
 
        // ── panel partido ─────────────────────────────────────────────────
        jPanelPartido.setBorder(javax.swing.BorderFactory.createTitledBorder("1. Selección de Partido"));
        jLabel1.setText("Partido:");
        jLabel2.setText("Fase:");
        jLabel3.setText("Estadio:");
        jLabel4.setText("Fecha:");
        lblFase.setText("—");
        lblEstadio.setText("—");
        lblFecha.setText("—");
        btnRecargarPartidos.setText("↻");
        btnRecargarPartidos.addActionListener(this::btnRecargarPartidosActionPerformed);
        cmbPartido.addActionListener(this::cmbPartidoActionPerformed);
 
        javax.swing.GroupLayout glPartido = new javax.swing.GroupLayout(jPanelPartido);
        jPanelPartido.setLayout(glPartido);
        glPartido.setHorizontalGroup(glPartido.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glPartido.createSequentialGroup()
                .addContainerGap()
                .addGroup(glPartido.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(glPartido.createSequentialGroup().addComponent(jLabel1).addGap(6,6,6).addComponent(cmbPartido, 0, 300, Short.MAX_VALUE).addGap(4,4,4).addComponent(btnRecargarPartidos))
                    .addGroup(glPartido.createSequentialGroup().addComponent(jLabel2).addGap(6,6,6).addComponent(lblFase))
                    .addGroup(glPartido.createSequentialGroup().addComponent(jLabel3).addGap(6,6,6).addComponent(lblEstadio))
                    .addGroup(glPartido.createSequentialGroup().addComponent(jLabel4).addGap(6,6,6).addComponent(lblFecha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        glPartido.setVerticalGroup(glPartido.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glPartido.createSequentialGroup()
                .addContainerGap()
                .addGroup(glPartido.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(cmbPartido).addComponent(btnRecargarPartidos))
                .addGap(6,6,6)
                .addGroup(glPartido.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(lblFase))
                .addGap(4,4,4)
                .addGroup(glPartido.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(lblEstadio))
                .addGap(4,4,4)
                .addGroup(glPartido.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(lblFecha))
                .addContainerGap())
        );
 
        // ── panel tickets ─────────────────────────────────────────────────
        jPanelTickets.setBorder(javax.swing.BorderFactory.createTitledBorder("2. Selección de Tickets"));
        jtDisponibles.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jtDisponibles);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Disponibles"));
        jtSeleccionados.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(jtSeleccionados);
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionados"));
        btnAgregar.setText("Agregar →");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);
        btnQuitar.setText("← Quitar");
        btnQuitar.addActionListener(this::btnQuitarActionPerformed);
 
        javax.swing.GroupLayout glTickets = new javax.swing.GroupLayout(jPanelTickets);
        jPanelTickets.setLayout(glTickets);
        glTickets.setHorizontalGroup(glTickets.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glTickets.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(glTickets.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        glTickets.setVerticalGroup(glTickets.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glTickets.createSequentialGroup()
                .addContainerGap()
                .addGroup(glTickets.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(glTickets.createSequentialGroup().addGap(40,40,40).addComponent(btnAgregar).addGap(10,10,10).addComponent(btnQuitar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
 
        // ── panel cliente ─────────────────────────────────────────────────
        jPanelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("3. Datos del Cliente"));
        buttonGroupCliente.add(rbExistente);
        buttonGroupCliente.add(rbNuevo);
        rbExistente.setSelected(true);
        rbExistente.setText("Cliente existente");
        rbNuevo.setText("Nuevo cliente");
        rbExistente.addActionListener(this::rbExistenteActionPerformed);
        rbNuevo.addActionListener(this::rbNuevoActionPerformed);
 
        jLabel5.setText("Cliente:");
        btnRecargarClientes.setText("↻");
        btnRecargarClientes.addActionListener(this::btnRecargarClientesActionPerformed);
        jLabel6.setText("Nombre:");
        jLabel7.setText("Apellido:");
        jLabel8.setText("Teléfono:");
        jLabel9.setText("Email:");
        jLabel10.setText("Dirección:");
 
        // campos nuevo cliente deshabilitados por defecto
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmail.setEnabled(false);
        txtDireccion.setEnabled(false);
 
        javax.swing.GroupLayout glCliente = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(glCliente);
        glCliente.setHorizontalGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glCliente.createSequentialGroup()
                .addContainerGap()
                .addGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(glCliente.createSequentialGroup().addComponent(rbExistente).addGap(18,18,18).addComponent(rbNuevo))
                    .addGroup(glCliente.createSequentialGroup()
                        .addGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(glCliente.createSequentialGroup().addComponent(jLabel5).addGap(6,6,6).addComponent(cmbCliente, 0, 220, Short.MAX_VALUE).addGap(4,4,4).addComponent(btnRecargarClientes))
                            .addGroup(glCliente.createSequentialGroup().addComponent(jLabel6).addGap(6,6,6).addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(glCliente.createSequentialGroup().addComponent(jLabel7).addGap(6,6,6).addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18,18,18)
                        .addGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(glCliente.createSequentialGroup().addComponent(jLabel8).addGap(6,6,6).addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(glCliente.createSequentialGroup().addComponent(jLabel9).addGap(6,6,6).addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(glCliente.createSequentialGroup().addComponent(jLabel10).addGap(6,6,6).addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        glCliente.setVerticalGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glCliente.createSequentialGroup()
                .addContainerGap()
                .addGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(rbExistente).addComponent(rbNuevo))
                .addGap(8,8,8)
                .addGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(cmbCliente).addComponent(btnRecargarClientes))
                .addGap(6,6,6)
                .addGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6).addComponent(txtNombre)
                    .addComponent(jLabel8).addComponent(txtTelefono))
                .addGap(6,6,6)
                .addGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7).addComponent(txtApellido)
                    .addComponent(jLabel9).addComponent(txtEmail))
                .addGap(6,6,6)
                .addGroup(glCliente.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10).addComponent(txtDireccion))
                .addContainerGap())
        );
 
        // ── panel resumen ─────────────────────────────────────────────────
        jPanelResumen.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen"));
        jLabel11.setText("Subtotal:");
        lblSubtotal.setText("Q 0.00");
        jLabel12.setText("Descuento:");
        lblDescuento.setText("Q 0.00");
        lblDescInfo.setText("");
        lblDescInfo.setForeground(new java.awt.Color(0, 130, 50));
        jLabel13.setText("IVA (12%):");
        lblIVA.setText("Q 0.00");
        jLabel14.setText("TOTAL:");
        jLabel14.setFont(jLabel14.getFont().deriveFont(java.awt.Font.BOLD, 13f));
        lblTotal.setText("Q 0.00");
        lblTotal.setFont(lblTotal.getFont().deriveFont(java.awt.Font.BOLD, 13f));
        lblTotal.setForeground(new java.awt.Color(160, 0, 0));
 
        javax.swing.GroupLayout glResumen = new javax.swing.GroupLayout(jPanelResumen);
        jPanelResumen.setLayout(glResumen);
        glResumen.setHorizontalGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glResumen.createSequentialGroup()
                .addContainerGap()
                .addGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(glResumen.createSequentialGroup()
                        .addGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11).addComponent(jLabel12).addComponent(jLabel13).addComponent(jLabel14))
                        .addGap(10,10,10)
                        .addGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtotal).addComponent(lblDescuento)
                            .addComponent(lblDescInfo).addComponent(lblIVA).addComponent(lblTotal))))
                .addContainerGap())
        );
        glResumen.setVerticalGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glResumen.createSequentialGroup()
                .addContainerGap()
                .addGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel11).addComponent(lblSubtotal))
                .addGap(4,4,4)
                .addGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel12).addComponent(lblDescuento))
                .addGap(2,2,2)
                .addComponent(lblDescInfo)
                .addGap(4,4,4)
                .addGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel13).addComponent(lblIVA))
                .addGap(4,4,4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4,4,4)
                .addGroup(glResumen.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel14).addComponent(lblTotal))
                .addContainerGap())
        );
 
        // ── botones ───────────────────────────────────────────────────────
        btnConfirmar.setText("✔  Confirmar Venta");
        btnConfirmar.setBackground(new java.awt.Color(0, 120, 55));
        btnConfirmar.setForeground(java.awt.Color.WHITE);
        btnConfirmar.setFont(btnConfirmar.getFont().deriveFont(java.awt.Font.BOLD));
        btnConfirmar.addActionListener(this::btnConfirmarActionPerformed);
 
        btnLimpiar.setText("✕  Limpiar");
        btnLimpiar.setBackground(new java.awt.Color(170, 0, 0));
        btnLimpiar.setForeground(java.awt.Color.WHITE);
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);
 
        // ── layout principal ──────────────────────────────────────────────
        javax.swing.GroupLayout glPrincipal = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(glPrincipal);
        glPrincipal.setHorizontalGroup(glPrincipal.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glPrincipal.createSequentialGroup()
                .addContainerGap()
                .addGroup(glPrincipal.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10,10,10)
                .addGroup(glPrincipal.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        glPrincipal.setVerticalGroup(glPrincipal.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(glPrincipal.createSequentialGroup()
                .addContainerGap()
                .addGroup(glPrincipal.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(glPrincipal.createSequentialGroup()
                        .addComponent(jPanelPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8,8,8)
                        .addComponent(jPanelTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8,8,8)
                        .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(glPrincipal.createSequentialGroup()
                        .addComponent(jPanelResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10,10,10)
                        .addComponent(btnConfirmar)
                        .addGap(6,6,6)
                        .addComponent(btnLimpiar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
 
        pack();
    }
 
    // ── action performed ──────────────────────────────────────────────────
    private void btnRecargarPartidosActionPerformed(java.awt.event.ActionEvent evt) {
        cargarPartidos();
    }
 
    private void cmbPartidoActionPerformed(java.awt.event.ActionEvent evt) {
        onPartidoCambiado();
    }
 
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        moverASeleccionados();
    }
 
    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {
        devolverADisponibles();
    }
 
    private void rbExistenteActionPerformed(java.awt.event.ActionEvent evt) {
        cmbCliente.setEnabled(true);
        btnRecargarClientes.setEnabled(true);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmail.setEnabled(false);
        txtDireccion.setEnabled(false);
        cargarClientes();
    }
 
    private void rbNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        cmbCliente.setEnabled(false);
        btnRecargarClientes.setEnabled(false);
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        txtDireccion.setEnabled(true);
    }
 
    private void btnRecargarClientesActionPerformed(java.awt.event.ActionEvent evt) {
        cargarClientes();
    }
 
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        confirmarVenta();
    }
 
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        limpiar();
    }
 
    // ── lógica ────────────────────────────────────────────────────────────
    private void cargarPartidos() {
        cmbPartido.removeAllItems();
        for (Partido p : controlador.obtenerPartidos()) {
            cmbPartido.addItem(p);
        }
        if (cmbPartido.getItemCount() > 0) cmbPartido.setSelectedIndex(0);
    }
 
    private void onPartidoCambiado() {
        Partido p = (Partido) cmbPartido.getSelectedItem();
        if (p == null) return;
        lblFase.setText(p.getFase() != null ? p.getFase() : "—");
        lblEstadio.setText(p.getEstadio() != null ? p.getEstadio() : "—");
        lblFecha.setText(p.getFecha() != null ? p.getFecha().toString() : "—");
        seleccionados.clear();
        modeloSeleccionados.setRowCount(0);
        cargarTickets(p);
        actualizarResumen();
    }
 
    private void cargarTickets(Partido p) {
        disponibles.clear();
        modeloDisponibles.setRowCount(0);
        for (Ticket t : controlador.obtenerTickets(p)) {
            disponibles.add(t);
            modeloDisponibles.addRow(new Object[]{
                t.getId(), t.getNumeroAsiento(), t.getSeccion(),
                String.format("%,.2f", t.getPrecio())
            });
        }
    }
 
    private void cargarClientes() {
        cmbCliente.removeAllItems();
        for (Cliente cl : controlador.obtenerClientes()) {
            cmbCliente.addItem(cl);
        }
    }
 
    private void moverASeleccionados() {
        int[] filas = jtDisponibles.getSelectedRows();
        List<Ticket> mover = new ArrayList<>();
        for (int f : filas) {
            int id = (int) modeloDisponibles.getValueAt(f, 0);
            disponibles.stream().filter(t -> t.getId() == id).findFirst().ifPresent(mover::add);
        }
        for (Ticket t : mover) {
            disponibles.remove(t);
            seleccionados.add(t);
            modeloSeleccionados.addRow(new Object[]{
                t.getId(), t.getNumeroAsiento(), t.getSeccion(),
                String.format("%,.2f", t.getPrecio())
            });
        }
        reconstruirTabla(modeloDisponibles, disponibles);
        actualizarResumen();
    }
 
    private void devolverADisponibles() {
        int[] filas = jtSeleccionados.getSelectedRows();
        List<Ticket> devolver = new ArrayList<>();
        for (int f : filas) {
            int id = (int) modeloSeleccionados.getValueAt(f, 0);
            seleccionados.stream().filter(t -> t.getId() == id).findFirst().ifPresent(devolver::add);
        }
        for (Ticket t : devolver) {
            seleccionados.remove(t);
            disponibles.add(t);
            modeloDisponibles.addRow(new Object[]{
                t.getId(), t.getNumeroAsiento(), t.getSeccion(),
                String.format("%,.2f", t.getPrecio())
            });
        }
        reconstruirTabla(modeloSeleccionados, seleccionados);
        actualizarResumen();
    }
 
    private void actualizarResumen() {
        lblSubtotal.setText(String.format("Q %,.2f", controlador.calcularSubtotal(seleccionados)));
        lblDescuento.setText(String.format("Q %,.2f", controlador.calcularDescuento(seleccionados)));
        lblIVA.setText(String.format("Q %,.2f", controlador.calcularIVA(seleccionados)));
        lblTotal.setText(String.format("Q %,.2f", controlador.calcularTotal(seleccionados)));
        int n = seleccionados.size();
        if (n >= 10)    lblDescInfo.setText("Desc. 7% (10+ tickets)");
        else if (n > 5) lblDescInfo.setText("Desc. 5% (más de 5)");
        else            lblDescInfo.setText("");
    }
 
    private void confirmarVenta() {
        if (seleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un ticket.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Cliente cliente = resolverCliente();
        if (cliente == null) return;
 
        int resp = JOptionPane.showConfirmDialog(this,
                String.format("¿Confirmar venta de %d ticket(s) a %s por Q %,.2f?",
                        seleccionados.size(), cliente.getNombre() + " " + cliente.getApellido(),
                        controlador.calcularTotal(seleccionados)),
                "Confirmar Venta", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) return;
 
        boolean ok = controlador.confirmarVenta(cliente, seleccionados, usuarioId);
        if (ok) {
            JOptionPane.showMessageDialog(this, "✔ Venta registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            mostrarRecibo(cliente);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    private Cliente resolverCliente() {
        if (rbExistente.isSelected()) {
            Cliente cl = (Cliente) cmbCliente.getSelectedItem();
            if (cl == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            return cl;
        }
        // nuevo cliente
        String nombre   = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String email    = txtEmail.getText().trim();
        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre, apellido y email son obligatorios.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        Cliente cl = new Cliente(0, nombre, apellido, txtTelefono.getText().trim(),
                                 email, txtDireccion.getText().trim());
        
        // CORREGIDO: Evaluar como boolean según firma de tu VentaController actual
        boolean ok = controlador.guardarCliente(cl);
        if (ok) {
            return cl;
        }
        return null;
    }
 
    private void mostrarRecibo(Cliente cliente) {
        StringBuilder sb = new StringBuilder();
        sb.append("══════════════════════════════════════\n");
        sb.append("     MUNDIAL 2026 — RECIBO DE COMPRA  \n");
        sb.append("══════════════════════════════════════\n");
        sb.append("Cliente:  ").append(cliente.getNombre()).append(" ").append(cliente.getApellido()).append("\n");
        sb.append("Vendedor: ").append(usuarioNombre).append("\n");
        sb.append("──────────────────────────────────────\n");
        for (Ticket t : seleccionados)
            sb.append(String.format("  %-8s  %-12s  Q %,.2f%n",
                    t.getNumeroAsiento(), t.getSeccion(), t.getPrecio()));
        sb.append("──────────────────────────────────────\n");
        sb.append(String.format("Subtotal:   Q %,.2f%n", controlador.calcularSubtotal(seleccionados)));
        sb.append(String.format("Descuento:  Q %,.2f%n", controlador.calcularDescuento(seleccionados)));
        sb.append(String.format("IVA (12%%):  Q %,.2f%n", controlador.calcularIVA(seleccionados)));
        sb.append(String.format("TOTAL:      Q %,.2f%n", controlador.calcularTotal(seleccionados)));
        sb.append("══════════════════════════════════════");
 
        JTextArea ta = new JTextArea(sb.toString());
        ta.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        ta.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(ta), "Recibo", JOptionPane.PLAIN_MESSAGE);
    }
 
    private void limpiar() {
        seleccionados.clear();
        modeloSeleccionados.setRowCount(0);
        txtNombre.setText(""); txtApellido.setText(""); txtTelefono.setText("");
        txtEmail.setText(""); txtDireccion.setText("");
        Partido p = (Partido) cmbPartido.getSelectedItem();
        if (p != null) cargarTickets(p);
        actualizarResumen();
        cargarClientes();
    }
 
    private void reconstruirTabla(DefaultTableModel model, List<Ticket> lista) {
        model.setRowCount(0);
        for (Ticket t : lista)
            model.addRow(new Object[]{t.getId(), t.getNumeroAsiento(), t.getSeccion(),
                    String.format("%,.2f", t.getPrecio())});
    }
 
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(VentaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(() -> {
            new VentaView().setVisible(true);
        });
    }
}