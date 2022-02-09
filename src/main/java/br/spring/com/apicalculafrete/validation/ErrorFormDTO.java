package br.spring.com.apicalculafrete.validation;

import lombok.*;

@AllArgsConstructor
@Getter
public class ErrorFormDTO {
	
	private String campo;
	private String erro;
}
