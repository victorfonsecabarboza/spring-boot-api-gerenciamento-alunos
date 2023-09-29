package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.AlunoEntity;
import br.com.senac.repository.AlunoRepository;

//Serve para encapsular a lógica de negócios.
@Service
public class AlunoService {

//	Indica um ponto aonde a injeção automática de uma classe deve ser aplicada. Esta pode ser usada em métodos, atributos e construtores.
	@Autowired
	AlunoRepository repository;

//	Método para salvar o aluno cadastrado
	public AlunoEntity salvar(AlunoEntity aluno) {
		return repository.save(aluno);
	}

//	Método para listar todos os alunos
	public List<AlunoEntity> buscarAlunos() {
		return repository.findAll();
	}

//	Método para buscar um aluno específico 
	public AlunoEntity buscarAlunoId(Integer id) {
		return repository.findById(id).orElse(null);
	}

//	Método para alterar um aluno específico
	public AlunoEntity atualizarAluno(Integer id, AlunoEntity alunoAlteracao) {
		AlunoEntity aluno = repository.findById(id).orElse(null);
		if (aluno != null) {
			aluno.setNome(alunoAlteracao.getNome());
			aluno.setSobreNome(alunoAlteracao.getSobreNome());
			aluno.setEmail(alunoAlteracao.getEmail());
			return repository.save(aluno);
		} else {
			return null;
		}
	}

//	Método para deletar um aluno específico
	public boolean excluirAluno(Integer id) {
		AlunoEntity aluno = repository.findById(id).orElse(null);
		if (aluno != null) {
			repository.deleteById(id);
			return false;
		} else {
			return false;
		}
	}

}
