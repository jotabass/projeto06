package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Pessoa;
import factories.ConnectionFactory;
import interfaces.IPessoaRepository;

public class PessoaRepository implements IPessoaRepository {

	@Override
	public void create(Pessoa pessoa) throws Exception {

		//abrir conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//executar um comando SQL para cadastrar pessoa
		PreparedStatement statement = connection.prepareStatement("insert into pessoa(nome, email) values(?, ?)");
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getEmail());
		statement.execute();
		
		//fechar a conexão
		connection.close();
	}

	@Override
	public void update(Pessoa pessoa) throws Exception {

		//abrir conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update pessoa set nome = ?, email = ? where idpessoa = ?");
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getEmail());
		statement.setInt(3, pessoa.getIdPessoa());
		statement.execute();
		
		//fechar a conexão
		connection.close();
	}

	@Override
	public void delete(Pessoa pessoa) throws Exception {

		//abrir conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("delete from pessoa where idpessoa = ?");
		statement.setInt(1, pessoa.getIdPessoa());
		statement.execute();
		
		//fechar a conexão
		connection.close();
	}

	@Override
	public List<Pessoa> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from pessoa");
		ResultSet resultSet = statement.executeQuery();
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		while(resultSet.next()) {			
			Pessoa pessoa = new Pessoa(resultSet.getInt("idpessoa"), resultSet.getString("nome"), resultSet.getString("email"));
			lista.add(pessoa);			
		}
		
		connection.close();
		return lista;
	}

	@Override
	public Pessoa findById(Integer idPessoa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from pessoa where idpessoa = ?");
		statement.setInt(1, idPessoa);
		ResultSet resultSet = statement.executeQuery();
		
		Pessoa pessoa = null;
		
		if(resultSet.next()) {			
			pessoa = new Pessoa(resultSet.getInt("idpessoa"), resultSet.getString("nome"), resultSet.getString("email"));
		}
		
		connection.close();
		return pessoa;
	}

}



