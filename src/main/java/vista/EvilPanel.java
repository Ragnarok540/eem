package vista;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import modelo.*;

/**
 *
 * @author AFNation
 */
public class EvilPanel extends JFrame {

	private static final long serialVersionUID = -4122499111158457454L;
	private JButton bAceptar;
	private JButton bChoose;
	private JButton bSave;
	private ButtonGroup grupo;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JLabel lClave;
	private JLabel lTitulo;
	private JPasswordField pfClave;
	private JRadioButton rbCrypt;
	private JRadioButton rbDecrypt;
	private JTextField tfChoose;
	private JTextField tfSave;

	public EvilPanel() {
		initComponents();
		grupo.add(rbCrypt);
		grupo.add(rbDecrypt);
		rbCrypt.setSelected(true);
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		grupo = new ButtonGroup();
		jPanel1 = new JPanel();
		tfChoose = new JTextField();
		tfSave = new JTextField();
		bChoose = new JButton();
		bSave = new JButton();
		jPanel2 = new JPanel();
		pfClave = new JPasswordField();
		lClave = new JLabel();
		jPanel3 = new JPanel();
		rbCrypt = new JRadioButton();
		rbDecrypt = new JRadioButton();
		bAceptar = new JButton();
		lTitulo = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("EVIL ENCRYPTOR MACHINE KILLS");

		bChoose.setText("Abrir");
		bChoose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				bChooseMouseClicked(evt);
			}
		});

		bSave.setText("Guardar");
		bSave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				bSaveMouseClicked(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(tfSave)
								.addComponent(tfChoose))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(bSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(bChoose, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(tfChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bChoose))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(tfSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(bSave))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		lClave.setText("Clave:");

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lClave)
								.addComponent(pfClave, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(22, Short.MAX_VALUE))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(22, 22, 22)
						.addComponent(lClave)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pfClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		rbCrypt.setText("Encriptar");
		rbDecrypt.setText("Desencriptar");
		bAceptar.setText("Aceptar");

		bAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				bAceptarMouseClicked(evt);
			}
		});

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(44, 44, 44)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(rbDecrypt)
								.addComponent(rbCrypt)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGap(8, 8, 8)
										.addComponent(bAceptar)))
										.addContainerGap(56, Short.MAX_VALUE))
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addGap(24, 24, 24)
						.addComponent(rbCrypt)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbDecrypt)
						.addGap(18, 18, 18)
						.addComponent(bAceptar)
						.addContainerGap(28, Short.MAX_VALUE))
				);

		lTitulo.setText("EVIL ENCRYPTOR MACHINE");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addContainerGap())
										.addGroup(layout.createSequentialGroup()
												.addGap(128, 128, 128)
												.addComponent(lTitulo)
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lTitulo)
						.addGap(18, 18, 18)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
				);
		pack();
	}

	/**
	 * Evento que se dispara cuando se presiona el boton Abrir
	 * */
	private void bChooseMouseClicked(MouseEvent evt) {
		JFileChooser fileChooser = new JFileChooser();    
		int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			//file es el archivo que se obriene del FileChooser
			File file = fileChooser.getSelectedFile();
			//Se guarda la ruta en el TextField
			tfChoose.setText(file.getAbsolutePath());
		} 
	}

	/**
	 * Evento que se dispara cuando se presiona el boton Guardar
	 * */
	private void bSaveMouseClicked(MouseEvent evt) {
		JFileChooser fileChooser = new JFileChooser();    
		//fileChooser.addChoosableFileFilter(new EncryptedFilter());
		int returnVal = fileChooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			//Se guarda la ruta en el TextField
			tfSave.setText(file.getAbsolutePath());
		} 
	}

	/**
	 * Evento que se dispara cuando se presiona el boton Aceptar
	 * */
	private void bAceptarMouseClicked(MouseEvent evt) {
		//Aqui se extrae la ruta del openfilechooser
		String pathFileOpen = tfChoose.getText();
		if (!new File(pathFileOpen).exists()) {
			JOptionPane.showMessageDialog(this, pathFileOpen +
					"\nNo se encuentra el archivo.\n" +
					"Asegúrese de haber dado el nombre de archivo correcto.");
			return;
		}
		//Aqui se extrae la ruta del savefilechooser
		String pathFileSave = tfSave.getText();
		if (!new File(pathFileSave).isAbsolute()) {
			JOptionPane.showMessageDialog(this, pathFileSave +
					"\nNo es una ruta válida.");
			return;
		}
		//Aqui se extrae la clave
		char[] key = pfClave.getPassword();
		if (key.length == 0) {
			JOptionPane.showMessageDialog(this, "Por favor digite la clave.");
			return;
		}
		if(rbCrypt.isSelected()) {
			//ENCRIPTAR
			AESEncrypter.encryptFile(pathFileOpen, pathFileSave, new String(key));
			JOptionPane.showMessageDialog(this, "El archivo ha sido encriptado.");
		} else if(rbDecrypt.isSelected()) {
			//DESENCRIPTAR
			byte[] sha1e = null;
			byte[] sha1o = null;
			try {
				sha1e = AESDecrypter.decryptFile(pathFileOpen, pathFileSave, new String(key));
			} catch (NotEncryptedException e) {
				JOptionPane.showMessageDialog(this, pathFileOpen+
						"\nNo es un archivo encriptado.\n" +
						"Asegúrese de haber dado el nombre de archivo correcto.");
				return;
			}
			sha1o = Utils.SHA1(pathFileSave);
			String expected = Utils.bytesToHex(sha1e);
			String observed = Utils.bytesToHex(sha1o);
			JOptionPane.showMessageDialog(this, "El archivo ha sido desencriptado." +
					"\nSHA1 esperado: " + expected +
					"\nSHA1 obtenido: " + observed + "\n" +
					(expected.equals(observed)?"Se ha comprobado la integridad del archivo.":"No se ha comprobado la integridad del archivo."));
		}
		key = null;
		tfChoose.setText("");
		tfSave.setText("");
		pfClave.setText("");
	}

}
