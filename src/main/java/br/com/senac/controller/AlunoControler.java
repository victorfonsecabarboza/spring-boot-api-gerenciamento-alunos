package br.com.senac.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.dto.AlunoDTO;
import br.com.senac.entity.AlunoEntity;
import br.com.senac.service.AlunoService;

//Responsável por designar o bean de compoment, que surporta requisições HTTP com base na arquitetura REST.
@RestController
//Determina qual a URI comum para todos os recursos disponibilizados pelo Controller.
@RequestMapping("alunos")
public class AlunoControler {

//	indica um ponto aonde a injeção automática de uma classe deve ser aplicada. Esta pode ser usada em métodos, atributos e construtores.
	@Autowired
	private ModelMapper mapper;

//	indica um ponto aonde a injeção automática de uma classe deve ser aplicada. Esta pode ser usada em métodos, atributos e construtores.
	@Autowired
	private AlunoService alunoService;

//	Determina que o método aceitará requisições HTTP do tipo POST.
	@PostMapping
//	@RequestBody - converte um JSON para o tipo do objeto esperado como parâmetro no método.
	public ResponseEntity<AlunoDTO> cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
		AlunoEntity aluno = mapper.map(alunoDTO, AlunoEntity.class);
		aluno = alunoService.salvar(aluno);
		AlunoDTO alunoNovo = mapper.map(aluno, AlunoDTO.class);
		return ResponseEntity.ok().body(alunoNovo);
	}

//	Determina que o método aceitará requisições HTTP do tipo GET.
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> listarTodosAlunos() {
		List<AlunoEntity> listarAlunos = alunoService.buscarAlunos();
		List<AlunoDTO> listarAlunoDTO = listarAlunos.stream().map(aluno -> mapper.map(aluno, AlunoDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listarAlunoDTO);
	}

//	Determina que o método aceitará requisições HTTP do tipo GET escolhido através de um ID específico.
	@GetMapping("/{id}")
//	@PathVariable - Consegue determinar que parte da URI será composta por parâmetros recebidos nas requisições. 
	public ResponseEntity<AlunoDTO> listarAlunoPId(@PathVariable("id") Integer id) {
		AlunoEntity aluno = alunoService.buscarAlunoId(id);
		AlunoDTO alunoDTO = mapper.map(aluno, AlunoDTO.class);
		return ResponseEntity.ok().body(alunoDTO);
	}

//	Determina que o método aceitará requisições HTTP do tipo PUT escolhido através de um ID específico.
	@PutMapping("/{id}")
//	@PathVariable - Consegue determinar que parte da URI será composta por parâmetros recebidos nas requisições. 
//	@RequestBody - converte um JSON para o tipo do objeto esperado como parâmetro no método.
	public ResponseEntity<AlunoDTO> updateAluno(@PathVariable("id") Integer id, @RequestBody AlunoDTO alunoDTO) {
		AlunoEntity aluno = mapper.map(alunoDTO, AlunoEntity.class);
		aluno = alunoService.atualizarAluno(id, aluno);
		AlunoDTO alunoAlteradoDTO = mapper.map(aluno, AlunoDTO.class);
		return ResponseEntity.ok().body(alunoAlteradoDTO);
	}

//	Determina que o método aceitará requisições HTTP do tipo DELETE escolhido através de um ID específico.
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluirAluno(@PathVariable("id") Integer id) {
		Boolean flag = alunoService.excluirAluno(id);
		return ResponseEntity.ok().body(flag);
	}

}
