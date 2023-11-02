package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {

	private final ClienteService clienteService;
	private final PetRepository petRepository;
	
	@Override
	public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetApplicationService - criaPet");
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[finaliza] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());
	}

	@Override
	public List<PetClienteListResponse> buscaPetsDoClienteComID(UUID idCliente) {
		log.info("[inicia] PetApplicationService - buscaPetsDoClienteComID");
		clienteService.buscaClientePorId(idCliente);
		List<Pet> petsDoCliente = petRepository.buscaPetsDoClienteComID(idCliente);
		log.info("[finaliza] PetApplicationService - buscaPetsDoClienteComID");
		return PetClienteListResponse.converte(petsDoCliente);
	}

	@Override
	public PetClienteDetalhadoResponse buscaPetDoClienteComID(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - buscaPetDoClienteComID");
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.buscaPetPeloID(idPet);
		log.info("[finaliza] PetApplicationService - buscaPetDoClienteComID");
		return new PetClienteDetalhadoResponse(pet);
	}

	@Override
	public void deletePetDoClienteComID(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - deletePetDoClienteComID");
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.buscaPetPeloID(idPet);
		petRepository.deletaPet(pet);
		log.info("[finaliza] PetApplicationService - deletePetDoClienteComID");
	}

	@Override
	public void alteraPetDoClienteComID(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest) {
		log.info("[inicia] PetApplicationService - alteraPetDoClienteComID");
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.buscaPetPeloID(idPet);
		pet.altera(petAlteracaoRequest);
		petRepository.salvaPet(pet);
		log.info("[finaliza] PetApplicationService - alteraPetDoClienteComID");
	}

}
