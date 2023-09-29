package br.com.senac.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.senac.entity.AlunoEntity;
import br.com.senac.repository.AlunoRepository;

//Anotação que pode ser especificada em uma classe de teste que executa testes baseados em Spring Boot.
@SpringBootTest
class AlunoServiceTest {

	private static final Integer ID = 1;
	private static final String NOME = "Lucas";
	private static final String SOBRENOME = "Silva";
	private static final String EMAIL = "lucas@gmail.com";

	private AlunoEntity aluno;
	private Optional<AlunoEntity> alunoOptional;

//	Marca uma classe no qual a injeção deve ser realizada. Somente para classes de teste.
	@InjectMocks
	private AlunoService alunoService;

//	Marca uma classe como uma simulação.
	@Mock
	private AlunoRepository alunoRepository;

//	Marca uma classe como uma simulação.
	@Mock
	private ModelMapper mapper;

//	É usado para sinalizar que o método anotado deve ser executado antes de cada método 
//	@Test, @RepeatedTest, @ParameterizedTest, @TestFactory e @TestTemplate na classe de teste atual.
	@BeforeEach
	void setUp() {
//		Necessário para que possa inicializar os mocks acima
		MockitoAnnotations.openMocks(this);
		startAluno();
	}

	private void startAluno() {
		aluno = new AlunoEntity(ID, NOME, SOBRENOME, EMAIL);
		alunoOptional = Optional.of(new AlunoEntity(ID, NOME, SOBRENOME, EMAIL));
	}

//	@Test
//	void testSalvarAluno() {
//		fail("Not yet implemented");
//	}

//	É usado para sinalizar que o método anotado é um método de teste.
	@Test
	void whenCreateThenReturnScess() {
		Mockito.when(alunoRepository.save(any())).thenReturn(aluno);

		AlunoEntity response = alunoService.salvar(aluno);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(AlunoEntity.class, response.getClass());
		Assertions.assertEquals(ID, response.getId());
		Assertions.assertEquals(NOME, response.getNome());
		Assertions.assertEquals(SOBRENOME, response.getSobreNome());
		Assertions.assertEquals(EMAIL, response.getEmail());
	}

//	@Test
//	void testListarTodosAlunos() {
//		fail("Not yet implemented");
//	}

//	É usado para sinalizar que o método anotado é um método de teste.
	@Test
	void whenFindAllThenReturnListOfAluno() {
		Mockito.when(alunoRepository.findAll()).thenReturn(List.of(aluno));

		List<AlunoEntity> response = alunoService.buscarAlunos();
		Assertions.assertNotNull(response);
		Assertions.assertEquals(1, response.size());
		Assertions.assertEquals(ID, response.get(0).getId());
		Assertions.assertEquals(NOME, response.get(0).getNome());
		Assertions.assertEquals(SOBRENOME, response.get(0).getSobreNome());
		Assertions.assertEquals(EMAIL, response.get(0).getEmail());
	}

//	@Test
//	void testBuscarAlunoId() {
//		fail("Not yet implemented");
//	}

//	É usado para sinalizar que o método anotado é um método de teste.
	@Test
	void whenFindByIdThenReturnAnAlunoInstance() {
		Mockito.when(alunoRepository.findById(Mockito.anyInt())).thenReturn(alunoOptional);

		AlunoEntity response = alunoService.buscarAlunoId(ID);
		Assertions.assertEquals(AlunoEntity.class, response.getClass());
		Assertions.assertEquals(ID, response.getId());
		Assertions.assertEquals(NOME, response.getNome());
		Assertions.assertEquals(SOBRENOME, response.getSobreNome());
		Assertions.assertEquals(EMAIL, response.getEmail());
	}

//	É usado para sinalizar que o método anotado é um método de teste.
	@Test
	void testAtualizarAluno() {
		fail("Not yet implemented");
	}

//	É usado para sinalizar que o método anotado é um método de teste.
	@Test
	void testExcluirAluno() {
		fail("Not yet implemented");
	}

}