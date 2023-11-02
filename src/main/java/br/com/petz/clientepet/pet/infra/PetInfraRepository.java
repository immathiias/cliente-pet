package br.com.petz.clientepet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARepository petSpringDataJpaRepository;

	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[inicia] PetInfraRepository - salvaPet");
		petSpringDataJpaRepository.save(pet);
		log.info("[finaliza] PetInfraRepository - salvaPet");
		return pet;
	}

	@Override
	public List<Pet> buscaPetsDoClienteComID(UUID idCliente) {
		log.info("[inicia] PetInfraRepository - buscaPetsDoClienteComID");
		var pets = petSpringDataJpaRepository.findByIdClienteTutor(idCliente);
		log.info("[finaliza] PetInfraRepository - buscaPetsDoClienteComID");
		return pets;
	}

	@Override
	public Pet buscaPetPeloID(UUID idPet) {
		log.info("[inicia] PetInfraRepository - buscaPetPeloID");
		var pet = petSpringDataJpaRepository.findById(idPet)
					.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado para o id: " + idPet));
		log.info("[finaliza] PetInfraRepository - buscaPetPeloID");
		return pet;
	}

	@Override
	public void deletaPet(Pet pet) {
		log.info("[inicia] PetInfraRepository - deletaPet");
		log.info("[finaliza] PetInfraRepository - deletaPet");
	}

}
