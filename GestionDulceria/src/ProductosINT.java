import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ProductosINT extends JInternalFrame {
	ProductoDAO productoM = new ProductoDAO();
	Producto producto = new Producto();
	DefaultTableModel modelo = new DefaultTableModel();

	private static final long serialVersionUID = 1L;
	private JTextField textNombres;
	private JTextField textPrecip;
	private JTextField textStock;
	private JTable tableProductos;
	private JTextField textID;
	private JTextField textEstado;

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
	public ProductosINT() {
		setTitle("Modulo Productos");
		setBounds(100, 100, 450, 445);
		getContentPane().setLayout(null);

		JPanel panelCRUDCliente = new JPanel();
		panelCRUDCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCRUDCliente.setBounds(10, 10, 418, 133);
		getContentPane().add(panelCRUDCliente);
		panelCRUDCliente.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 33, 102, 13);
		panelCRUDCliente.add(lblNombre);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 56, 102, 13);
		panelCRUDCliente.add(lblPrecio);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 79, 102, 13);
		panelCRUDCliente.add(lblStock);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 106, 102, 13);
		panelCRUDCliente.add(lblEstado);

		textNombres = new JTextField();
		textNombres.setBounds(122, 30, 140, 19);
		panelCRUDCliente.add(textNombres);
		textNombres.setColumns(10);

		textPrecip = new JTextField();
		textPrecip.setBounds(122, 53, 140, 19);
		panelCRUDCliente.add(textPrecip);
		textPrecip.setColumns(10);

		textStock = new JTextField();
		textStock.setBounds(122, 76, 140, 19);
		panelCRUDCliente.add(textStock);
		textStock.setColumns(10);

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
		textEstado.setBounds(122, 103, 140, 19);
		panelCRUDCliente.add(textEstado);
		textEstado.setColumns(10);

		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTabla.setBounds(10, 153, 418, 237);
		getContentPane().add(panelTabla);
		panelTabla.setLayout(null);

		tableProductos = new JTable();
		tableProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tableProductos.getSelectedRow();
				if (fila == -1) {
					mensaje();
				} else {
					String id = tableProductos.getValueAt(fila, 0).toString();
					String nombre = tableProductos.getValueAt(fila, 1).toString();
					String precio = tableProductos.getValueAt(fila, 2).toString();
					String stock = tableProductos.getValueAt(fila, 3).toString();
					String estado = tableProductos.getValueAt(fila, 4).toString();
					textID.setText(id);
					textNombres.setText(nombre);
					textPrecip.setText(precio);
					textStock.setText(stock);
					textEstado.setText(estado);

				}
			}
		});
		tableProductos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tableProductos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "NOMBRE", "PRECIO", "STOCK", "ESTADO" }));
		tableProductos.setBounds(10, 10, 398, 217);
		panelTabla.add(tableProductos);

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
		List<Producto> lista = productoM.listar();
		modelo = (DefaultTableModel) tableProductos.getModel();
		Object[] objeto = new Object[5];
		for (int i = 0; i < lista.size(); i++) {
			objeto[0] = lista.get(i).getId();
			objeto[1] = lista.get(i).getNombre();
			objeto[2] = lista.get(i).getPrecio();
			objeto[3] = lista.get(i).getStock();
			objeto[4] = lista.get(i).getEstado();
			modelo.addRow(objeto);
		}
		tableProductos.setModel(modelo);
	}

	void agregar() {
		String id = textID.getText();
		String nombre = textNombres.getText();
		String precio = textPrecip.getText();
		String stock = textStock.getText();
		String estado = textEstado.getText();

		Object[] objeto = new Object[5];
		objeto[0] = id;
		objeto[1] = nombre;
		objeto[2] = precio;
		objeto[3] = stock;
		objeto[4] = estado;
		productoM.add(objeto);
	}

	void actualizar() {
		int fila = tableProductos.getSelectedRow();
		if (fila == -1) {
			mensaje();
		} else {
			String id = textID.getText();
			String nombre = textNombres.getText();
			String precio = textPrecip.getText();
			String stock = textStock.getText();
			String estado = textEstado.getText();

			Object[] objeto = new Object[5];
			objeto[0] = nombre;
			objeto[1] = precio;
			objeto[2] = stock;
			objeto[3] = estado;
			objeto[4] = id;
			productoM.actualizar(objeto);
		}

	}

	void eliminar() {
		int fila = tableProductos.getSelectedRow();
		int ids = (int) tableProductos.getValueAt(fila, 0);
		if (fila == -1) {
			mensaje();
		} else {
			productoM.eliminar(ids);
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
		textNombres.setText("");
		textPrecip.setText("");
		textStock.setText("");
		textEstado.setText("");
	}
}
