package br.spring.com.apicalculafrete.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.spring.com.apicalculafrete.dto.ViaCepDTO;


@FeignClient(url="https://viacep.com.br/ws/", name = "viacep")
public interface ViaCepClient {
    
	@GetMapping("{cep}/json")
    ViaCepDTO buscaCep(@PathVariable("cep") String cep);
}
