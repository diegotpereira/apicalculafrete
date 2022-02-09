package br.spring.com.apicalculafrete.dto;

import java.time.LocalDate;

import br.spring.com.apicalculafrete.model.Frete;
import lombok.*;

@Getter
@Setter
public class FreteDTO {
	
	private Double vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	private String cepOrigem;
	private String cepDestino;

	public FreteDTO(Frete frete) {
		vlTotalFrete = frete.getVlTotalFrete();
		dataPrevistaEntrega = frete.getDataPrevistaEntrega();
		cepOrigem = frete.getCepOrigem();
		cepDestino = frete.getCepDestino();
	}

}
