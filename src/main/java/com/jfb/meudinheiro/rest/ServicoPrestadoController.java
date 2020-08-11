package com.jfb.meudinheiro.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jfb.meudinheiro.dto.ServicoPrestadoDTO;
import com.jfb.meudinheiro.model.entities.Cliente;
import com.jfb.meudinheiro.model.entities.ServicoPrestado;
import com.jfb.meudinheiro.model.repositories.ClienteRepository;
import com.jfb.meudinheiro.model.repositories.ServicoPrestadoRepository;
import com.jfb.meudinheiro.utils.BigDecimalConverter;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository servicoPrestadoRepository;
	private final BigDecimalConverter bigDecimalConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO objDto) {
		LocalDate data = LocalDate.parse(objDto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = objDto.getIdCliente();

		Cliente cliente = clienteRepository.findById(idCliente)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));

		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(objDto.getDescricao());
		servicoPrestado.setData(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(objDto.getPreco()));
		return servicoPrestadoRepository.save(servicoPrestado);
	}

}
