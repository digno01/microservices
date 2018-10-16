package com.stefanini.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stefanini.dto.EnderecoDTO;

@FeignClient("ENDERECO")
public interface FeignClient2 {

	@RequestMapping(value="/endereco", method = RequestMethod.GET)
	EnderecoDTO sayHyByEndereco();
}
