import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class VendedorINT extends JInternalFrame {
	VendedorDAO vendedorM = new VendedorDAO();
	Vendedor vendedor = new Vendedor();
	DefaultTableModel modelo = new DefaultTableModel();

	private static final long serialVersionUID = 1L;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTable tableVendedor;
	private JTextField textID;
	private JTextField textEstado;
	private JTextField textUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteINT frame = new ClienteINT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VendedorINT() {
		setTitle("Modulo Vendedor");
		setBounds(100, 100, 450, 429);
		getContentPane().setLayout(null);

		JPanel panelCRUDCliente = new JPanel();
		panelCRUDCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCRUDCliente.setBounds(10, 10, 418, 149);
		getContentPane().add(panelCRUDCliente);
		panelCRUDCliente.setLayout(null);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(10, 33, 102, 13);
		panelCRUDCliente.add(lblDNI);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 56, 102, 13);
		panelCRUDCliente.add(lblNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 79, 102, 13);
		panelCRUDCliente.add(lblTelefono);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 102, 102, 13);
		panelCRUDCliente.add(lblEstado);

		textDNI = new JTextField();
		textDNI.setBounds(122, 30, 140, 19);
		panelCRUDCliente.add(textDNI);
		textDNI.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(122, 53, 140, 19);
		panelCRUDCliente.add(textNombre);
		textNombre.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setBounds(122, 76, 140, 19);
		panelCRUDCliente.add(textTelefono);
		textTelefono.setColumns(10);

		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
				limpiarCajas();
				limpiar();
				listar();
			}
		});
		btnAgregar.setBounds(272, 6, 136, 21);
		panelCRUDCliente.add(btnAgregar);

		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
				limpiarCajas();
				limpiar();
				listar();
			}
		});
		btnActualizar.setBounds(272, 29, 136, 21);
		panelCRUDCliente.add(btnActualizar);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
				limpiarCajas();
				limpiar();
				listar();
			}
		});
		btnEliminar.setBounds(272, 52, 136, 21);
		panelCRUDCliente.add(btnEliminar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajas();
			}
		});
		btnLimpiar.setBounds(295, 75, 90, 21);
		panelCRUDCliente.add(btnLimpiar);

		JLabel lblid = new JLabel("ID:");
		lblid.setBounds(10, 10, 102, 13);
		panelCRUDCliente.add(lblid);

		textID = new JTextField();
		textID.setBounds(122, 7, 140, 19);
		panelCRUDCliente.add(textID);
		textID.setColumns(10);

		textEstado = new JTextField();
		textEstado.setBounds(122, 99, 140, 19);
		panelCRUDCliente.add(textEstado);
		textEstado.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 126, 102, 13);
		panelCRUDCliente.add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setBounds(122, 123, 140, 19);
		panelCRUDCliente.add(textUsuario);
		textUsuario.setColumns(10);

		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTabla.setBounds(10, 169, 418, 221);
		getContentPane().add(panelTabla);
		panelTabla.setLayout(null);

		tableVendedor = new JTable();
		tableVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tableVendedor.getSelectedRow();
				if (fila == -1) {
					mensaje();
				} else {
					String id = tableVendedor.getValueAt(fila, 0).toString();
					String dni = tableVendedor.getValueAt(fila, 1).toString();
					String nombre = tableVendedor.getValueAt(fila, 2).toString();
					String telefono = tableVendedor.getValueAt(fila, 3).toString();
					String estado = tableVendedor.getValueAt(fila, 4).toString();
					String user = tableVendedor.getValueAt(fila, 5).toString();
					textID.setText(id);
					textDNI.setText(dni);
					textNombre.setText(nombre);
					textTelefono.setText(telefono);
					textEstado.setText(estado);
					textUsuario.setText(user);

				}
			}
		});
		tableVendedor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tableVendedor.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "DNI", "NOMBRES", "TELEFONO", "ESTADO", "USUARIO" }));
		tableVendedor.setBounds(10, 10, 398, 201);
		panelTabla.add(tableVendedor);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnOpcion = new JMenu("Opciones");
		menuBar.add(mnOpcion);

		JMenuItem mntmExit = new JMenuItem("Salir");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnOpcion.add(mntmExit);

		listar();

	}

	void listar() {
		List<Vendedor> lista = vendedorM.listar();
		modelo = (DefaultTableModel) tableVendedor.getModel();
		Object[] objeto = new Object[6];
		for (int i = 0; i < lista.size(); i++) {
			objeto[0] = lista.get(i).getId();
			objeto[1] = lista.get(i).getDni();
			objeto[2] = lista.get(i).getNombre();
			objeto[3] = lista.get(i).getTelefono();
			objeto[4] = lista.get(i).getEstado();
			objeto[5] = lista.get(i).getUser();
			modelo.addRow(objeto);
		}
		tableVendedor.setModel(modelo);
	}

	void agregar() {
		String id = textID.getText();
		String dni = textDNI.getText();
		String nombre = textNombre.getText();
		String telefono = textTelefono.getText();
		String estado = textEstado.getText();
		String user = textUsuario.getText();

		Object[] objeto = new Object[6];
		objeto[0] = id;
		objeto[1] = dni;
		objeto[2] = nombre;
		objeto[3] = telefono;
		objeto[4] = estado;
		objeto[5] = user;
		vendedorM.add(objeto);
	}

	void actualizar() {
		int fila = tableVendedor.getSelectedRow();
		if (fila == -1) {
			mensaje();
		} else {
			String id = textID.getText();
			String dni = textDNI.getText();
			String nombre = textNombre.getText();
			String telefono = textTelefono.getText();
			String estado = textEstado.getText();
			String user = textUsuario.getText();

			Object[] objeto = new Object[6];
			objeto[0] = dni;
			objeto[1] = nombre;
			objeto[2] = telefono;
			objeto[3] = estado;
			objeto[4] = user;
			objeto[5] = id;
			vendedorM.actualizar(objeto);
		}

	}

	void eliminar() {
		int fila = tableVendedor.getSelectedRow();
		int ids = (int) tableVendedor.getValueAt(fila, 0);
		if (fila == -1) {
			mensaje();
		} else {
			vendedorM.eliminar(ids);
		}
	}

	void limpiar() {
		for (int i = 0; i < modelo.getRowCount(); i++) {
			modelo.removeRow(i);
			i = i - 1;
		}
	}

	public void mensaje() {
		JOptionPane.showMessageDialog(this, "Seleciona una fila primero");
	}

	void limpiarCajas() {
		textID.setText("");
		textDNI.setText("");
		textNombre.setText("");
		textTelefono.setText("");
		textEstado.setText("");
		textUsuario.setText("");
	}
}
