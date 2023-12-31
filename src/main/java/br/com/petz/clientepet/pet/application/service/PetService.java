package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import jakarta.validation.Valid;

public interface PetService {

	public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);

	public List<PetClienteListResponse> buscaPetsDoClienteComID(UUID idCliente);

	public PetClienteDetalhadoResponse buscaPetDoClienteComID(UUID idCliente, UUID idPet);

	public void deletePetDoClienteComID(UUID idCliente, UUID idPet);

	public void alteraPetDoClienteComID(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest);

}
