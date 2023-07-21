package br.com.accenture.desafiofullstack.controllers;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.accenture.desafiofullstack.model.Cep;

@RestController
@RequestMapping("/api/v1/cep")
public class CepController {

	@GetMapping("/{cep}")
	public Cep buscarCep(@PathVariable String cep) {
		String uri = "http://cep.la/"+cep;
		RestTemplate restTemplate = new RestTemplate();
//		Cep cepEncontrado = restTemplate.getForObject(uri, Cep.class);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity request = new HttpEntity(headers);
		ResponseEntity<Cep> response = restTemplate.exchange(
		        uri,
		        HttpMethod.GET,
		        request,
		        Cep.class,
		        1
		);
	
	Cep cepEncontrado = null;
	if(response.getStatusCode() == HttpStatus.OK) {
		cepEncontrado = response.getBody();
	}
		System.out.println("Cep: " + cepEncontrado);
		return cepEncontrado;
	}
	
}
