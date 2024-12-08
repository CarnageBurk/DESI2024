package tuti.desi.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paquete")
public class Paquete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "nombre")
    private String nombre;

	@ManyToOne
	private Ciudad origen;

	@ManyToOne
	private Ciudad destino;

	private BigDecimal peso;
	private boolean fragil;
	private String dniRemitente;
	private String dniDestinatario;

	public Paquete() {
	}

	public Paquete(Ciudad origen, Ciudad destino, Long id, BigDecimal peso, boolean fragil, String dniRemitente,
			String dniDestinatario, String nombre) {
		this.origen = origen;
		this.destino = destino;
		Id = id;
		this.peso = peso;
		this.fragil = fragil;
		this.dniRemitente = dniRemitente;
		this.dniDestinatario = dniDestinatario;
	}

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public boolean isFragil() {
		return fragil;
	}

	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}

	public String getDniRemitente() {
		return dniRemitente;
	}

	public void setDniRemitente(String dniRemitente) {
		this.dniRemitente = dniRemitente;
	}

	public String getDniDestinatario() {
		return dniDestinatario;
	}

	public void setDniDestinatario(String dniDestinatario) {
		this.dniDestinatario = dniDestinatario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Paquete [Id=" + Id + ", nombre=" + nombre + ", origen=" + origen + ", destino=" + destino + ", peso="
				+ peso + ", fragil=" + fragil + ", dniRemitente=" + dniRemitente + ", dniDestinatario="
				+ dniDestinatario + "]";
	}
	

}
