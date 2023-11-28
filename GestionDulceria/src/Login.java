import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	VendedorMetodos vDAO = new VendedorMetodos();
	Vendedor vendedor = new Vendedor();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordFieldContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 55, 273, 198);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(10, 10, 83, 13);
		panel.add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setBounds(10, 33, 253, 19);
		panel.add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblContraseña = new JLabel("CONTRASEÑA");
		lblContraseña.setBounds(10, 62, 83, 13);
		panel.add(lblContraseña);

		passwordFieldContraseña = new JPasswordField();
		passwordFieldContraseña.setBounds(10, 79, 253, 19);
		panel.add(passwordFieldContraseña);

		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}

			public void validar() {
				String dni = passwordFieldContraseña.getText();
				String user = textUsuario.getText();
				if (textUsuario.getText().equals("") | passwordFieldContraseña.getText().equals("")) {
					vacio();
					textUsuario.requestFocus();
				} else {
					vendedor = vDAO.ValidarVendedor(dni, user);
					if (vendedor.getUser() != null && vendedor.getDni() != null) {
						principal prin = new principal();
						prin.setVisible(true);
						dispose();
					} else {
						erroneo();
						textUsuario.requestFocus();
					}
				}
			}
		});
		btnIngresar.setBounds(91, 137, 85, 21);
		panel.add(btnIngresar);
	}

	public void vacio() {
		JOptionPane.showMessageDialog(this, "Debe ingresar datos");
	}

	public void erroneo() {
		JOptionPane.showMessageDialog(this, "Debe ingresar datos validos");
	}
}

