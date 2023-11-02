package br.com.petz.clientepet.pet.infra;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class PetInfraRepository implements PetRepository {

	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[inicia] PetInfraRepository - salvaPet");
		log.info("[finaliza] PetInfraRepository - salvaPet");
		return pet;
	}

}
