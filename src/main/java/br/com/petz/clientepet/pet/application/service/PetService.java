package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import jakarta.validation.Valid;

public interface PetService {

	public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);

	public List<PetClienteListResponse> buscaPetsDoClienteComID(UUID idCliente);

}
