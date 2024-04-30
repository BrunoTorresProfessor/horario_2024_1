package br.com.horario.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.horario.entity.CepDTO;

@Service
public class CepServiceImpl implements CepService{

	@Override
	public CepDTO consultaCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CepDTO> resp =
				restTemplate
					.getForEntity(
							String.format("https://viacep.com.br/ws/%s/json/",cep), 
							CepDTO.class);
		return resp.getBody();
	}

}
