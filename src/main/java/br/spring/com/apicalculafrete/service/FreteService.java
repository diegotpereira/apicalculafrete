package br.spring.com.apicalculafrete.service;

import org.springframework.stereotype.Service;

import br.spring.com.apicalculafrete.dto.ViaCepDTO;
import br.spring.com.apicalculafrete.form.FreteForm;
import br.spring.com.apicalculafrete.model.Frete;

@Service
public interface FreteService {

	Frete consultaValorFrete(FreteForm form);
	Frete toFrete(FreteForm form);
	Frete calcularFreteData(ViaCepDTO cepOrigem, ViaCepDTO cepDestino, Frete frete);
	
}
