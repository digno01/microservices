package com.stefanini.service;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.dto.PessoaDTO;


@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class RestService {

	@Autowired
	private FeignClient2 feignClient2;
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<PessoaDTO> sayHy(){
		PessoaDTO p1 = new PessoaDTO();
		p1.setIdade(12);
		p1.setNome("Freitas");
		p1.setEndereco(feignClient2.sayHyByEndereco());
		return new ResponseEntity<PessoaDTO>(p1, HttpStatus.OK);
	}
	
	@RequestMapping(value="/busca", method = RequestMethod.GET)
	public ResponseEntity<String> sayHyBusca(){
		return new ResponseEntity<>(" Busca", HttpStatus.OK);
	}
	
}
