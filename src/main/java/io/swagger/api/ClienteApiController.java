package io.swagger.api;

import io.swagger.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.dao.ClienteDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-18T02:52:12.827Z")

@Controller
public class ClienteApiController implements ClienteApi {

	private static final Logger log = LoggerFactory.getLogger(ClienteApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private ClienteDAO clienteDAO;

	@org.springframework.beans.factory.annotation.Autowired
	public ClienteApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.clienteDAO = new ClienteDAO();
	}

	public ResponseEntity<Cliente> alteraExistente(
			@ApiParam(value = "Id do cliente.", required = true) @PathVariable("id") Integer id,
			@ApiParam(value = "", required = true) @Valid @RequestBody Cliente cliente) {
		// TO DO
		return null;
	}

	public ResponseEntity<Cliente> alteraStatusPorId(
			@ApiParam(value = "Status do cliente.", required = true, allowableValues = "\"ativo\", \"inativo\"") @PathVariable("status") String status,
			@ApiParam(value = "Numero do id do cliente.", required = true) @PathVariable("id") Integer id) {
		// TO DO
		return null;
	}

	public ResponseEntity<Cliente> cadastraNovo(
			@ApiParam(value = "", required = true) @Valid @RequestBody Cliente cliente) {
		ResponseEntity<Cliente> responseEntity = null;

		try {

			if (cliValido(cliente)) {

				Cliente clienteNew = clienteDAO.salva(cliente);

				if (clienteNew == null) {
					throw new RuntimeException("Erro ao tentar cadastrar novo cliente.");
				}

				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(clienteNew.getId()).toUri();

				MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
				headers.add("location", location.getPath());

				// 202 Sucesso
				responseEntity = new ResponseEntity<Cliente>(clienteNew, headers, HttpStatus.CREATED);

			} else {
				responseEntity = new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			log.error("Falha ao tentar cadastrar cliente.", e);
			responseEntity = new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	private boolean cliValido(Cliente cliente) {

		if (cliente != null) {
			return true;
		}

		return false;
	}

	public ResponseEntity<Cliente> consultaPorId(
			@ApiParam(value = "Numero do id do cliente", required = true) @PathVariable("id") Integer id) {
		// TO DO
		return null;
	}

	public ResponseEntity<Cliente> consultaPorSobrenome(
			@ApiParam(value = "Sobrenome do cliente.", required = true) @PathVariable("sobrenome") String sobrenome) {
		// TO DO
		return null;
	}

	public ResponseEntity<Void> excluiExistente(
			@ApiParam(value = "Numero do id do cliente.", required = true) @PathVariable("id") Integer id) {
		// TO DO
		return null;
	}

}
