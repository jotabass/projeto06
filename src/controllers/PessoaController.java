package controllers;


import entities.Pessoa;
import helpers.PessoaHelper;
import repositories.PessoaRepository;

public class PessoaController {

	//Fluxo de cadastro de pessoa
	public void cadastrar() {
		
		try {
			
			System.out.println("\n *** CADASTRO DE PESSOA *** \n");
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome(PessoaHelper.lerNome());
			pessoa.setEmail(PessoaHelper.lerEmail());
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.create(pessoa);
			
			System.out.println("Pessoa cadastrado com sucesso!");
		}
		catch(Exception e) {
			
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}		
	}
	
	//Fluxo para atualização de pessoa
	public void atualizar() {
		
		try {
			
			System.out.println("\n *** ATUALIZAÇÃO DE PESSOA *** \n");
			
			Integer idPessoa = PessoaHelper.lerIdPessoa();
			
			//consultando a pessoa no banco de dados atraves do id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(idPessoa);
			
			//verificando se a pessoa foi encontrada
			if(pessoa != null) {
				
				pessoa.setNome(PessoaHelper.lerNome());
				pessoa.setEmail(PessoaHelper.lerEmail());
				
				pessoaRepository.update(pessoa);
				
				System.out.println("Pessoa atualizada com sucesso!");
			}
			else {
				System.out.println("Pessoa não foi encontrada!");
			}
		}
		catch(Exception e) {
			
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}
	}
	
	//Fluxo de exclusão
	public void excluir() {
		
		try {
			
			System.out.println("\n *** EXCLUSÃO DE PESSOA *** \n");
			
			Integer idPessoa = PessoaHelper.lerIdPessoa();
			
			//consultando a pessoa no banco de dados atraves do id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(idPessoa);
			
			if(pessoa != null) {
				
				pessoaRepository.delete(pessoa);
				
				System.out.println("Pessoa excluída com sucesso!");
			}
			else {
				System.out.println("Pessoa não foi encontrada!");
			}
		}
		catch(Exception e) {
			
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}		
	}
	
	//Fluxo de consulta
	public void consultar() {
		
		try {
			
			System.out.println("\n *** CONSULTA DE PESSOAS *** \n");
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			
			for(Pessoa pessoa : pessoaRepository.findAll()) {
				System.out.println(pessoa.toString());
			}			
		}
		catch(Exception e) {
			
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}
		
	}
	
}

