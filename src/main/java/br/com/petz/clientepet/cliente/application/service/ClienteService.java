package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import jakarta.validation.Valid;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	
	List<ClienteListResponse> buscaTodosClientes();

	ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);
	
	void deleteClientePorId(UUID idCliente);

	void patchAlteraCliente(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest);
}
