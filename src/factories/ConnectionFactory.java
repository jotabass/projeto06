package factories;



import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// atributos
	private static final String HOST = "jdbc:mysql://localhost:3306/bd_aula06?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "coti";

	// m�todo para fazer a conex�o com o banco de dados
	public static Connection getConnection() throws Exception {
		// abrir e retornar uma conex�o com o banco de dados
		return DriverManager.getConnection(HOST, USER, PASS);
	}
}

