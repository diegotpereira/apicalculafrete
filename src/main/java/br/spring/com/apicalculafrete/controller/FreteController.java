package br.spring.com.apicalculafrete.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.spring.com.apicalculafrete.dto.FreteDTO;
import br.spring.com.apicalculafrete.form.FreteForm;
import br.spring.com.apicalculafrete.model.Frete;
import br.spring.com.apicalculafrete.service.FreteService;

@RestController
@RequestMapping("/consultar")
public class FreteController {

	@Autowired
	private FreteService service;

	@PostMapping
	@Transactional
	public ResponseEntity<FreteDTO> recebeDados(@RequestBody @Valid FreteForm form, 
	UriComponentsBuilder uriBuilder) {
		Frete frete = service.consultaValorFrete(form);
		URI uri = uriBuilder.path("/frete/{id}").buildAndExpand(frete.getId()).toUri();

		return ResponseEntity.created(uri).body(new FreteDTO(frete));
	}
	
}
