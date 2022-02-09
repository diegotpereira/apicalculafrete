package br.spring.com.apicalculafrete.model;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_frete")
public class Frete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double peso;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;
	private Double vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	private LocalDate dataConsulta;
}
