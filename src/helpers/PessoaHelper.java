package helpers;


import javax.swing.JOptionPane;

public class PessoaHelper {

	public static Integer lerIdPessoa() throws Exception {
		String value = JOptionPane.showInputDialog("Informe o ID da pessoa:");
		return Integer.parseInt(value);
	}

	public static String lerNome() throws Exception {
		return JOptionPane.showInputDialog("Informe o Nome da pessoa:");
	}

	public static String lerEmail() throws Exception {
		return JOptionPane.showInputDialog("Informe o Email da pessoa:");
	}
}
