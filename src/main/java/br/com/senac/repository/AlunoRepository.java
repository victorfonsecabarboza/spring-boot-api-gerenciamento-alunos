package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.AlunoEntity;

//Um mecanismo para encapsular armazenamento, recuperação e comportamento de pesquisa que emula uma coleção de objetos.
@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {

}