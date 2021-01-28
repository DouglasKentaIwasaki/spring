package br.dev.kenta.api.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.dev.kenta.api.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	Pessoa findByCpf(String cpf);
	Pessoa findByEmail(String email);
	@Query("SELECT p.nome FROM Pessoa p where p.nome = :nome and p.email = :email")
    Pessoa findNomeByNameAndEmail(@Param("nome") String nome, @Param("email") String email);
}
