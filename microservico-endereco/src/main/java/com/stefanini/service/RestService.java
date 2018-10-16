package com.stefanini.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.dto.EnderecoDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/endereco")
public class RestService {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<EnderecoDTO> sayHy(){
		EnderecoDTO p = new EnderecoDTO();
		p.setCidade("Brasilia");
		p.setBairro("Asa Sul");
		return new ResponseEntity<EnderecoDTO>( p, HttpStatus.OK);
	}
}
