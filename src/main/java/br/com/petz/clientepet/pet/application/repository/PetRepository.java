package br.com.petz.clientepet.pet.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.domain.Pet;

public interface PetRepository {

	Pet salvaPet(Pet pet);

	List<Pet> buscaPetsDoClienteComID(UUID idCliente);

	Pet buscaPetPeloID(UUID idPet);

	void deletaPet(Pet pet);

}
