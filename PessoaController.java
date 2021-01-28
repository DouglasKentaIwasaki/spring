package br.dev.kenta.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.dev.kenta.api.repository.PessoaRepository;
import br.dev.kenta.api.model.Pessoa;

@RestController
@RequestMapping("/api")
public class PessoaController {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	public List<Pessoa> ListarPessoas(){
		return new ArrayList<Pessoa>();
	}
	
	@GetMapping("/{id}")
	public Pessoa listaPessoas(Long id){
		return pessoaRepository.findById(id).get();
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarPessoa(@RequestBody Pessoa pessoaRecebida){
		ArrayList<String> erros = new ArrayList();
		if(replicado(pessoaRecebida)) {
			erros.add("CPF ou EMAIL duplicado");
		}
		if(!validaNascimento(pessoaRecebida)) {
			erros.add("Insira uma data de nascimento válida");
		}
		if(erros.isEmpty()) {
			pessoaRepository.save(pessoaRecebida);
		}
		return erros.toString();
		
		
	}

	private Boolean replicado(Pessoa p) {
		List<Pessoa> cadastrados = ListarPessoas();
		
		return true;
	}
	private Boolean validaNascimento(Pessoa p) {
		return true;
	}
	
}
