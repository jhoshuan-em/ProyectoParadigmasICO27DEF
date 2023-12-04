import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import javax.swing.JButton;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JSpinner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.SpinnerNumberModel;
import java.awt.Color;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class VentasINT extends JInternalFrame {
	
	ClienteDAO clienteM = new ClienteDAO();
	ProductoDAO productoM = new ProductoDAO();
	DefaultTableModel modelo = new DefaultTableModel();
	Producto producto = new Producto();
	Ventas venta = new Ventas();
	VentasDAO ventaM=new VentasDAO();
	DetalleVentas dVentas = new DetalleVentas();
	Cliente cliente = new Cliente();
	
	int idProducto;
	double totalPago;
	double precio;
	int cantidad;

	private static final long serialVersionUID = 1L;
	private JTextField textNoSerie;
	private JTextField textCodCliente;
	private JTextField textCliente;
	private JTextField textCodProducto;
	private JTextField textPrecio;
	private JTextField textFecha;
	private JTextField textProducto;
	private JTextField textStock;
	private JTextField textVende;
	private JTable table;
	private JTextField textTotal;
	private JTextField textCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentasINT frame = new VentasINT();
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
	
	public VentasINT() {
		
		setTitle("Sistema de Ventas");
		setBounds(100, 100, 629, 536);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 597, 63);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("VENTAS");
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblTitulo.setBounds(252, 0, 83, 29);
		panel.add(lblTitulo);
		
		textNoSerie = new JTextField();
		textNoSerie.setEditable(false);
		textNoSerie.setToolTipText("");
		textNoSerie.setBounds(446, 34, 141, 19);
		panel.add(textNoSerie);
		textNoSerie.setColumns(10);
		
		JLabel lblNoSerie = new JLabel("No.Serie:");
		lblNoSerie.setBounds(364, 37, 72, 13);
		panel.add(lblNoSerie);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 83, 597, 107);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodCliente = new JLabel("COD. CLIENTE");
		lblCodCliente.setBounds(10, 11, 115, 13);
		panel_1.add(lblCodCliente);
		
		textCodCliente = new JTextField();
		textCodCliente.setBounds(135, 8, 96, 19);
		panel_1.add(textCodCliente);
		textCodCliente.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		btnBuscar.setBounds(241, 7, 98, 21);
		panel_1.add(btnBuscar);
		
		textCliente = new JTextField();
		textCliente.setEditable(false);
		textCliente.setBounds(423, 8, 164, 19);
		panel_1.add(textCliente);
		textCliente.setColumns(10);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(349, 11, 64, 13);
		panel_1.add(lblCliente);
		
		textCodProducto = new JTextField();
		textCodProducto.setBounds(135, 34, 96, 19);
		panel_1.add(textCodProducto);
		textCodProducto.setColumns(10);
		
		JLabel lblCodProducto = new JLabel("COD. PRODUCTO");
		lblCodProducto.setBounds(10, 37, 115, 13);
		panel_1.add(lblCodProducto);
		
		JButton btnBuscarProducto = new JButton("BUSCAR");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		btnBuscarProducto.setBounds(241, 33, 96, 21);
		panel_1.add(btnBuscarProducto);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(10, 60, 115, 13);
		panel_1.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(135, 57, 96, 19);
		panel_1.add(textPrecio);
		textPrecio.setColumns(10);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
			}
		});
		btnAgregar.setBounds(243, 56, 96, 21);
		panel_1.add(btnAgregar);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(10, 83, 115, 13);
		panel_1.add(lblCantidad);
		
		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setBounds(243, 80, 96, 19);
		panel_1.add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblProducto = new JLabel("PRODUCTO");
		lblProducto.setBounds(349, 37, 71, 13);
		panel_1.add(lblProducto);
		
		textProducto = new JTextField();
		textProducto.setEditable(false);
		textProducto.setBounds(423, 34, 164, 19);
		panel_1.add(textProducto);
		textProducto.setColumns(10);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setBounds(349, 60, 45, 13);
		panel_1.add(lblStock);
		
		textStock = new JTextField();
		textStock.setEditable(false);
		textStock.setBounds(423, 57, 164, 19);
		panel_1.add(textStock);
		textStock.setColumns(10);
		
		JLabel lblVende = new JLabel("VENDE");
		lblVende.setBounds(349, 83, 45, 13);
		panel_1.add(lblVende);
		
		textVende = new JTextField();
		textVende.setEditable(false);
		textVende.setText("Diego");
		textVende.setBounds(423, 80, 164, 19);
		panel_1.add(textVende);
		textVende.setColumns(10);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(135, 80, 96, 19);
		panel_1.add(textCantidad);
		textCantidad.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 200, 597, 230);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NRO", "CODIGO", "PRODUCTO", "CANTIDAD", "P.UNITARIO", "TOTAL"
			}
		));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NRO", "CODIGO", "PRODUCTO", "CANTIDAD", "P.UNITARIO", "TOTAL"
			}
		));
		table.setBounds(10, 10, 577, 210);
		panel_2.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 440, 597, 57);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(491, 28, 96, 19);
		panel_3.add(textTotal);
		textTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setBounds(425, 31, 56, 13);
		panel_3.add(lblTotal);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajas();
			}
		});
		btnCancelar.setBounds(147, 27, 104, 21);
		panel_3.add(btnCancelar);
		
		JButton btnGenVenta = new JButton("GENERAR VENTA");
		btnGenVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textTotal.getText().equals("")) {
					mensajepago();
				}else{
					guardarVenta();
					guardarDetalle();
					actualizarStock();
					mensajepago2();
					limpiarCajas();
					generarSerie();
				}
				
			}
		});
		btnGenVenta.setBounds(261, 27, 154, 21);
		panel_3.add(btnGenVenta);
		
		generarSerie();
		fecha();
	}
	
	void mensaje () {
		JOptionPane.showMessageDialog(this, "Ingrese codigo del cliente");
		
	}
	void mensaje1 () {
		JOptionPane.showMessageDialog(this, "Cliente no registrado");
	}
	void buscarCliente() {
		int respuesta;
		String cod=textCodCliente.getText();
		if(textCodCliente.getText().equals("")) {
			mensaje();
		}else {
			cliente = clienteM.listarID(cod);
			if(cliente.getDni()!=null) {
				textCliente.setText(cliente.getNombre());
				textCodProducto.requestFocus();
			}else {
				respuesta = JOptionPane.showConfirmDialog(this, "Cliente no registrado, ¿Quiere registrar?", "Confirmar Registro", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_OPTION) {
				    ClienteINT cliInt = new ClienteINT();
				    principal.VentanaPrincipal.add(cliInt);
				    cliInt.setVisible(true);
				}
			}
		}
	}
	void buscarProducto() {
		int id=Integer.parseInt(textCodProducto.getText());
		if(textCodProducto.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Ingrese el codigo del producto");
		}else {
			producto = productoM.listarID(id);
			if(producto.getId()!=0) {
				textProducto.setText(producto.getNombre());
				textPrecio.setText(""+producto.getPrecio());
				textStock.setText(""+producto.getStock());
			}else {
				JOptionPane.showMessageDialog(this, "Producto no registrado");
				textCodProducto.requestFocus();
			}
		}
	}
	void agregarProducto() {
	    double total;
	    modelo = (DefaultTableModel) table.getModel();
	    int item = 0;
	    item = item + 1;
	    idProducto = producto.getId();
	    String nombreProducto = textProducto.getText();
	    precio = Double.parseDouble(textPrecio.getText());
	    cantidad = Integer.parseInt(textCantidad.getText());
	    int stock = Integer.parseInt(textStock.getText());
	    total = cantidad * precio;
	    ArrayList lista = new ArrayList();
	    if (stock > 0) {
	        lista.add(item);
	        lista.add(idProducto);
	        lista.add(nombreProducto);
	        lista.add(cantidad);
	        lista.add(precio);
	        lista.add(total);
	        Object[] objeto = new Object[6];
	        objeto[0] = lista.get(0);
	        objeto[1] = lista.get(1);
	        objeto[2] = lista.get(2);
	        objeto[3] = lista.get(3);
	        objeto[4] = lista.get(4);
	        objeto[5] = lista.get(5);
	        modelo.addRow(objeto);
	        table.setModel(modelo);
	        calcularTotal();
	    } else {
	        JOptionPane.showMessageDialog(this, "Stock no disponible");
	    }
	}

	void calcularTotal() {
		totalPago=0;
		for(int i=0; i<table.getRowCount(); i++) {
			cantidad=Integer.parseInt(table.getValueAt(i, 3).toString());
			precio=Double.parseDouble(table.getValueAt(i, 4).toString());
			totalPago=totalPago+(cantidad*precio);
		}
		textTotal.setText(""+totalPago);
	}
	void guardarVenta(){
		int idv=1;
		int idc=cliente.getId();
		String serie=textNoSerie.getText();
		String fecha=textFecha.getText();
		double monoto=totalPago;
		String estado="1";
		venta.setIdCliente(idc);
		venta.setIdVendedor(idv);
		venta.setSerie(serie);
		venta.setFecha(fecha);
		venta.setMonnto(monoto);
		venta.setEstado(estado);
		ventaM.GuardarVentas(venta);
	}
	void guardarDetalle() {
		String idv=ventaM.idVentas();
		int idve=Integer.parseInt(idv);
		for (int i=0;i<table.getRowCount();i++) {
			int idp=Integer.parseInt(table.getValueAt(i, 1).toString());
			int cant=Integer.parseInt(table.getValueAt(i, 3).toString());
			double prec=Double.parseDouble(table.getValueAt(i, 4).toString());
			dVentas.setIdVentas(idve);
			dVentas.setIdProducto(idp);
			dVentas.setCantidad(cant);
			dVentas.setPrecioVenta(prec);
			ventaM.GuardarDetlleVentas(dVentas);
		}
	}
	void generarSerie() {
		String serie=ventaM.NoSerie();
		if(serie==null) {
			textNoSerie.setText("0000001");
		}else {
			int increment=Integer.parseInt(serie);
			increment = increment + 1;
			textNoSerie.setText("000000"+increment);
		}
	}
	void fecha () {
		Calendar calendar=new GregorianCalendar();
		textFecha.setText(""+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH));
	}
	void actualizarStock() {
		for(int i=0;i<modelo.getRowCount();i++) {
			Producto producto=new Producto();
			idProducto=Integer.parseInt(table.getValueAt(i, 1).toString());
			cantidad=Integer.parseInt(table.getValueAt(i, 3).toString());
			producto=productoM.listarID(idProducto);
			int stockActual =producto.getStock()-cantidad;
			productoM.actualizarStock(stockActual, idProducto);
		}
	}
	
	void mensajepago() {
		JOptionPane.showMessageDialog(this, "Ingrese Datos");
	}
	void mensajepago2() {
		JOptionPane.showMessageDialog(this, "Realizado con exito!!!");
	}
	void limpiarTabla() {
		for (int i=0; i<modelo.getRowCount(); i++) {
			modelo.removeRow(i);
		}
	}
	void limpiarCajas() {
		limpiarTabla();
		textCodCliente.setText("");
		textCliente.setText("");
		textCantidad.setText("");
		textCodProducto.setText("");
		textPrecio.setText("");
		textProducto.setText("");
		textStock.setText("");
		textTotal.setText("");
		textCodCliente.requestFocus();
	}

}

