package br.spring.com.apicalculafrete.service.impl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.spring.com.apicalculafrete.dto.ViaCepDTO;
import br.spring.com.apicalculafrete.form.FreteForm;
import br.spring.com.apicalculafrete.model.Frete;
import br.spring.com.apicalculafrete.repository.FreteRepository;
import br.spring.com.apicalculafrete.service.FreteService;
import br.spring.com.apicalculafrete.utils.ViaCepClient;

@Service
public class FreteServiceImpl implements FreteService{

	@Autowired
	private FreteRepository repository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private ViaCepClient service;

	private final Double precoKg = 1.0;

	@Override
	public Frete consultaValorFrete(FreteForm form) {
		// TODO Auto-generated method stub
		Frete frete = toFrete(form);
		frete.setDataConsulta(LocalDate.now());

		ViaCepDTO cepOrigem = service.buscaCep(frete.getCepOrigem());
		ViaCepDTO cepDestino = service.buscaCep(frete.getCepDestino());

		frete = calcularFreteData(cepOrigem, cepDestino, frete);

		return repository.save(frete);
	}

	@Override
	public Frete toFrete(FreteForm form) {
		// TODO Auto-generated method stub
		return modelMapper.map(form, Frete.class);
	}

	@Override
	public Frete calcularFreteData(ViaCepDTO cepOrigem, ViaCepDTO cepDestino, Frete frete) {
		// TODO Auto-generated method stub
		frete.setVlTotalFrete(frete.getPeso() * precoKg);
		frete.setDataPrevistaEntrega(LocalDate.now().plusDays(10));

		if(cepOrigem.getDdd().equals(cepDestino.getDdd())) {
			frete.setVlTotalFrete((frete.getPeso() * precoKg) * 0.5);
			frete.setDataPrevistaEntrega(LocalDate.now().plusDays(1));

			return frete;
		}

		if (!cepOrigem.getDdd().equals(cepDestino.getDdd()) && cepOrigem.getUf()
		.equals(cepDestino.getUf())) {
			frete.setVlTotalFrete((frete.getPeso() * precoKg) * 0.25);
			frete.setDataPrevistaEntrega(LocalDate.now().plusDays(3));

			return frete;
		}

		return frete;
	}
	
}
