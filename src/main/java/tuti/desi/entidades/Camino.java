package tuti.desi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "caminos")
public class Camino {
	
	@ManyToOne
    @JoinColumn(name = "ciudad_destino_id")
	private Ciudad ciudadDestino;
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCamino;
    
    //private String ciudadDestino;
    private String estadoCamino;
    private String estadoClima;
    private int codigoPostal;

    // Getters y Setters
    public Long getIdCamino() {
        return idCamino;
    }

    public void setIdCamino(Long idCamino) {
        this.idCamino = idCamino;
    }

    /*public String getCiudadDestino() {
        return ciudadDestino;
    }*/
    

    /*public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }*/
    public void getCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    
    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getEstadoCamino() {
        return estadoCamino;
    }

    public void setEstadoCamino(String estadoCamino) {
        this.estadoCamino = estadoCamino;
    }

    public String getEstadoClima() {
        return estadoClima;
    }

    public void setEstadoClima(String estadoClima) {
        this.estadoClima = estadoClima;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
