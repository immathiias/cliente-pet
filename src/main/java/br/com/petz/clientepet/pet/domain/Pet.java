package br.com.petz.clientepet.pet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idPet;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idClienteTutor", nullable = false)
	private UUID idClienteTutor;
	@NotBlank
	private String nomePet;
	@Enumerated(EnumType.STRING)
	private Porte porte;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPet tipoPet;
	private String microchip;
	@NotBlank
	private String raca;
	@NotNull
	@Enumerated(EnumType.STRING)
	private SexoPet sexo;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private String rga;
	private Integer peso;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;
	
	public Pet(UUID idCliente, @Valid PetRequest petRequest) {
		this.idClienteTutor = idCliente;
		this.nomePet = petRequest.getNomePet();
		this.porte = petRequest.getPorte();
		this.tipoPet = petRequest.getTipoPet();
		this.microchip = petRequest.getMicrochip();
		this.raca = petRequest.getRaca();
		this.sexo = petRequest.getSexo();
		this.pelagemCor = petRequest.getPelagemCor();
		this.dataNascimento = petRequest.getDataNascimento();
		this.rga = petRequest.getRga();
		this.peso = petRequest.getPeso();
		
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(PetAlteracaoRequest petAlteracaoRequest) {
		this.nomePet = petAlteracaoRequest.getNomePet();
		this.porte = petAlteracaoRequest.getPorte();
		this.tipoPet = petAlteracaoRequest.getTipoPet();
		this.microchip = petAlteracaoRequest.getMicrochip();
		this.raca = petAlteracaoRequest.getRaca();
		this.sexo = petAlteracaoRequest.getSexo();
		this.pelagemCor = petAlteracaoRequest.getPelagemCor();
		this.dataNascimento = petAlteracaoRequest.getDataNascimento();
		this.rga = petAlteracaoRequest.getRga();
		this.peso = petAlteracaoRequest.getPeso();
		
		this.dataHoraUltimaAlteracao = LocalDateTime.now();
	}
}
