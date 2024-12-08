package tuti.desi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "camion")
public class Camion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String patente;
	private Ciudad ciudad;
	private String marca;
	private int modelo;
	private boolean disponible;
	
	@ManyToOne
    @JoinColumn(name = "flota_id") // Relación con Flota
    private Flota flota;
	
	
	public Camion() {	
	}
	
	public Camion(Long id, String patente, Ciudad ciudad, String marca, int modelo, boolean disponible, Flota flota) {
		super();
		this.id = id;
		this.patente = patente;
		this.ciudad = ciudad;
		this.marca = marca;
		this.modelo = modelo;
		this.disponible = true;
		this.flota = flota;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
		
	public Flota getFlota() {
		return flota;
	}

	public void setFlota(Flota flota) {
		this.flota = flota;
	}

	@Override
	public String toString() {
		return "Camion [id=" + id + ", patente=" + patente + ", ciudad=" + ciudad + ", marca=" + marca + ", modelo="
				+ modelo + ", disponible=" + disponible + "]";
	}
	
	

}
