import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DetallesINT extends JInternalFrame {
	ProductoMetodos productoM = new ProductoMetodos();
	Producto producto = new Producto();
	DefaultTableModel modelo = new DefaultTableModel();
	DetalleVentas dVentas = new DetalleVentas();

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetallesINT frame = new DetallesINT();
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
	public DetallesINT() {
		setBounds(100, 100, 450, 540);
		getContentPane().setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "NUMERO", "ID VENTA", "ID PRODUCTO", "CANTIDAD", "PRECIO" }));
		table.setBounds(10, 10, 418, 491);
		getContentPane().add(table);

		listar();
	}

	void listar() {
		List<DetalleVentas> lista = dVentas.listar();
		modelo = (DefaultTableModel) table.getModel();
		Object[] objeto = new Object[5];
		for (int i = 0; i < lista.size(); i++) {
			objeto[0] = lista.get(i).getId();
			objeto[1] = lista.get(i).getIdVentas();
			objeto[2] = lista.get(i).getIdProducto();
			objeto[3] = lista.get(i).getCantidad();
			objeto[4] = lista.get(i).getPrecioVenta();
			modelo.addRow(objeto);
		}
	}

	public String obtenerDetallesComoTexto() {
		// Obtener los datos de la tabla de detalles
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		StringBuilder detalles = new StringBuilder();
	
		detalles.append("NRO\tCODIGO\tPRODUCTO\tCANTIDAD\tP.UNITARIO\tTOTAL\n");
	
		for (int i = 0; i < modelo.getRowCount(); i++) {
			for (int j = 0; j < modelo.getColumnCount(); j++) {
				detalles.append(modelo.getValueAt(i, j)).append("\t");
			}
			detalles.append("\n");
		}
	
		return detalles.toString();
	}
	

}
