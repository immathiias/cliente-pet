package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {

	private final PetService petService;

	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetController - postPet");
		log.info("[idCliente] {}", idCliente);
		PetResponse pet = petService.criaPet(idCliente, petRequest);
		log.info("[finaliza] PetController - postPet");
		return pet;
	}

	@Override
	public List<PetClienteListResponse> getTodosPets(UUID idCliente) {
		log.info("[inicia] PetController - getTodosPets");
		log.info("[idCliente] {}", idCliente);
		List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoClienteComID(idCliente);
		log.info("[finaliza] PetController - getTodosPets");
		return petsDoCliente;
	}

	@Override
	public PetClienteDetalhadoResponse getPetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - getPetDoClientePorId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		PetClienteDetalhadoResponse pet = petService.buscaPetDoClienteComID(idCliente, idPet);
		log.info("[finaliza] PetController - getPetDoClientePorId");
		return pet;
	}

	@Override
	public void deletePetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - deletePetDoClienteComId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		petService.deletePetDoClienteComID(idCliente, idPet);
		log.info("[finaliza] PetController - deletePetDoClienteComId");
	}

	@Override
	public void patchAlteraPet(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petAlteracaoRequest) {
		log.info("[inicia] PetController - patchAlteraPet");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		petService.alteraPetDoClienteComID(idCliente, idPet, petAlteracaoRequest);
		log.info("[finaliza] PetController - patchAlteraPet");
	}

}
