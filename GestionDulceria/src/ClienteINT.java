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

public class ClienteINT extends JInternalFrame {
	ClienteMetodos clienteM= new ClienteMetodos();
	Cliente cliente = new Cliente();
	DefaultTableModel modelo=new DefaultTableModel();

	private static final long serialVersionUID = 1L;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTable tableClientes;
	private JTextField textID;
	private JTextField textMPago;

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
	public ClienteINT() {
		setTitle("Modulo Cliente");
		setBounds(100, 100, 450, 429);
		getContentPane().setLayout(null);
		
		JPanel panelCRUDCliente = new JPanel();
		panelCRUDCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCRUDCliente.setBounds(10, 10, 418, 133);
		getContentPane().add(panelCRUDCliente);
		panelCRUDCliente.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(10, 33, 102, 13);
		panelCRUDCliente.add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 56, 102, 13);
		panelCRUDCliente.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 79, 102, 13);
		panelCRUDCliente.add(lblDireccion);
		
		JLabel lblNewLabel = new JLabel("Metodo de pago:");
		lblNewLabel.setBounds(10, 106, 102, 13);
		panelCRUDCliente.add(lblNewLabel);
		
		textDNI = new JTextField();
		textDNI.setBounds(122, 30, 140, 19);
		panelCRUDCliente.add(textDNI);
		textDNI.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(122, 53, 140, 19);
		panelCRUDCliente.add(textNombre);
		textNombre.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(122, 76, 140, 19);
		panelCRUDCliente.add(textDireccion);
		textDireccion.setColumns(10);
		
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
		
		textMPago = new JTextField();
		textMPago.setBounds(122, 103, 140, 19);
		panelCRUDCliente.add(textMPago);
		textMPago.setColumns(10);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTabla.setBounds(10, 153, 418, 237);
		getContentPane().add(panelTabla);
		panelTabla.setLayout(null);
		
		tableClientes = new JTable();
		tableClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila=tableClientes.getSelectedRow();
				if (fila==-1) {
					mensaje();
				}else {
					String id=tableClientes.getValueAt(fila,0).toString();
					String dni=tableClientes.getValueAt(fila,1).toString();
					String nombre=tableClientes.getValueAt(fila,2).toString();
					String direccion=tableClientes.getValueAt(fila,3).toString();
					String MetodoPago=tableClientes.getValueAt(fila,4).toString();
					textID.setText(id);
					textDNI.setText(dni);
					textNombre.setText(nombre);
					textDireccion.setText(direccion);
					textMPago.setText(MetodoPago);
					
				}
			}
		});
		tableClientes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tableClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DNI", "NOMBRES", "DIRECCION", "METODO DE PAGO"
			}
		));
		tableClientes.setBounds(10, 10, 398, 217);
		panelTabla.add(tableClientes);
		
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
		List<Cliente> lista=clienteM.listar();
		modelo=(DefaultTableModel)tableClientes.getModel();
		Object[]objeto=new Object[5];
		for (int i = 0; i<lista.size(); i++) {
		    objeto[0]=lista.get(i).getId();
		    objeto[1]=lista.get(i).getDni();
		    objeto[2]=lista.get(i).getNombre();
		    objeto[3]=lista.get(i).getDireccion();
		    objeto[4]=lista.get(i).getMetodoPago();
		    modelo.addRow(objeto);
		}
		tableClientes.setModel(modelo);
	}
	void agregar() {
		String id=textID.getText();
		String dni=textDNI.getText();
		String nombre=textNombre.getText();
		String direccion=textDireccion.getText();
		String MetodoPago=textMPago.getText();
		
		Object[] objeto = new Object[5];
		objeto[0]=id;
		objeto[1]=dni;
		objeto[2]=nombre;
		objeto[3]=direccion;
		objeto[4]=MetodoPago;
		clienteM.add(objeto);
	}
	void actualizar() {
		int fila=tableClientes.getSelectedRow();
		if(fila==-1) {
			mensaje();
		}else {
			String id=textID.getText();
			String dni=textDNI.getText();
			String nombre=textNombre.getText();
			String direccion=textDireccion.getText();
			String MetodoPago=textMPago.getText();
			
			Object[] objeto = new Object[5];
			objeto[0]=dni;
			objeto[1]=nombre;
			objeto[2]=direccion;
			objeto[3]=MetodoPago;
			objeto[4]=id;
			clienteM.actualizar(objeto);
		}
		
	}
	
	void eliminar() {
		int fila=tableClientes.getSelectedRow();
		int ids = (int) tableClientes.getValueAt(fila, 0);
		if(fila==-1) {
			mensaje();
		}else {
			clienteM.eliminar(ids);
		}
	}
	
	void limpiar() {
		for(int i=0; i<modelo.getRowCount();i++) {
			modelo.removeRow(i);
			i=i-1;
		}
	}
	
	public void mensaje() {
		JOptionPane.showMessageDialog(this, "Seleciona una fila primero");
	}
	void limpiarCajas() {
		textID.setText("");
		textDNI.setText("");
		textNombre.setText("");
		textDireccion.setText("");
		textMPago.setText("");
	}
}
