package br.com.senac.dto;

import lombok.Data;

//Gera getters e setters para todos os campos
@Data
public class AlunoDTO {

	private Integer id;
	private String nome;
	private String sobreNome;
	private String email;

}