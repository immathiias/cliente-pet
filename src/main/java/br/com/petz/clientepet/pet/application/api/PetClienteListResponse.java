package br.com.petz.clientepet.pet.application.api;

import java.util.List;

import br.com.petz.clientepet.pet.domain.Pet;
import lombok.Value;

@Value
public class PetClienteListResponse {
	
	public static List<PetClienteListResponse> converte(List<Pet> petsDoCliente) {
		return null;
	}

}
