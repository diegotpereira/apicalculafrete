package br.spring.com.apicalculafrete.form;

import javax.validation.constraints.*;

import lombok.Getter;

@Getter
public class FreteForm {

	@NotNull
	private Double peso;

	@NotNull @NotEmpty @Size(min = 8, max = 9)
	private String cepOrigem;

	@NotNull @NotEmpty @Size(min = 8, max = 9)
	private String cepDestino;

	@NotNull @NotEmpty
	private String nomeDestinatario;
	
}
