import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel VentanaPrincipal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuPrincipal = new JMenuBar();
		setJMenuBar(menuPrincipal);

		JMenu mnMenu = new JMenu("Opciones");
		menuPrincipal.add(mnMenu);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnMenu.add(mntmSalir);

		JMenu mnNewMenu_1 = new JMenu("Ventas");
		menuPrincipal.add(mnNewMenu_1);

		JMenuItem mntmGenVenta = new JMenuItem("Generar venta");
		mntmGenVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentasINT venta = new VentasINT();
				centrarVentana(venta);
			}
		});
		mnNewMenu_1.add(mntmGenVenta);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuPrincipal.add(mnMantenimiento);

		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteINT cliente = new ClienteINT();
				centrarVentana(cliente);
			}
		});
		mnMantenimiento.add(mntmClientes);

		JMenuItem mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductosINT productos = new ProductosINT();
				centrarVentana(productos);
			}
		});
		mnMantenimiento.add(mntmProductos);

		JMenuItem mntmVendedor = new JMenuItem("Vendedor");
		mntmVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendedorINT vendedor = new VendedorINT();
				centrarVentana(vendedor);
			}
		});
		mnMantenimiento.add(mntmVendedor);

		JMenu mnReporte = new JMenu("Reporte");
		menuPrincipal.add(mnReporte);

		JMenuItem mntmDetalles = new JMenuItem("Detalles de ventas");

mntmDetalles.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        DetallesINT det = new DetallesINT();
        centrarDet(det);
        exportarDetallesAVentasTxt(det);
    }
});
mnReporte.add(mntmDetalles);

		mntmDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetallesINT det = new DetallesINT();
				centrarDet(det);
			}
		});
		mnReporte.add(mntmDetalles);

		VentanaPrincipal = new JPanel();
		VentanaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(VentanaPrincipal);
		VentanaPrincipal.setLayout(null);

		this.setExtendedState(MAXIMIZED_BOTH);
	}

	void centrarVentana(JInternalFrame frame) {
		VentanaPrincipal.add(frame);
		Dimension dimension = VentanaPrincipal.getSize();
		Dimension frmventas = frame.getSize();
		frame.setLocation((dimension.width - frmventas.height) / 2, (dimension.height - frmventas.width) / 2);
		frame.show();
	}

	void centrarDet(JInternalFrame frame) {
		VentanaPrincipal.add(frame);
		Dimension dimension = VentanaPrincipal.getSize();
		Dimension frmventas = frame.getSize();
		frame.setLocation((dimension.width - frmventas.height) / 2, (dimension.height - frmventas.width) / 2);
		frame.show();
	}

	public JPanel getVentanaPrincipal() {
		return VentanaPrincipal;
	}
  
	private void exportarDetallesAVentasTxt(DetallesINT detallesINT) {
    try {
        String detalles = detallesINT.obtenerDetallesComoTexto();
        FileWriter writer = new FileWriter("DetallesVentas.txt");
        writer.write(detalles);
        writer.close();

        JOptionPane.showMessageDialog(this, "Detalles de ventas exportados a DetallesVentas.txt correctamente.");
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al exportar detalles de ventas a DetallesVentas.txt");
    }
}
}

