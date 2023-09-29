package br.com.senac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//Definição da classe como uma entidade
@Entity
//Gera getters e setters para todos os campos
@Data
public class AlunoEntity {

//	Especifica a chave primária de uma entidade (private Integer id).
	@Id
//	Informa que a geração do valor do identificador único da entidade (private Integer id) será gerenciada pelo provedor de persistência. 
//	Essa anotação deve ser adicionada logo após a anotação @Id.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobreNome;
	private String email;

}