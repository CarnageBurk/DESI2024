package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.CamionRepo;
import tuti.desi.accesoDatos.FlotaRepo;
import tuti.desi.entidades.Camion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Flota;

@Service
public class CamionService {

	@Autowired
	public FlotaRepo flotaRepositorio;
	
	@Autowired
	public CamionRepo camionRepositorio;
	
	public void agregarCamion (String patente, Ciudad ciudad, String marca, int modelo, Flota flota) {
		
		Camion camion = new Camion ();
		
		camion.setPatente(patente);
		camion.setCiudad(ciudad);
		camion.setMarca(marca);
		camion.setModelo(modelo);
		
		 if (flota != null) {
	            camion.setFlota(flota);
	     }
		
		camionRepositorio.save(camion);  //llamamos al metodo save que recibe una entidad por parametro y la persiste en la BDD
		
		}
		 // Obtener todos los camiones
	    public List<Camion> obtenerTodosLosCamiones() {
	        return camionRepositorio.findAll();
	    }

	    // Buscar camiones por ciudad
	    public List<Camion> buscarPorCiudad(Ciudad ciudad) {
	        return camionRepositorio.findByCiudad(ciudad);
	    }

	    // Buscar camiones por flota
	    public List<Camion> buscarPorFlota(Flota flota) {
	        return camionRepositorio.findByFlota(flota);
	    }
	}
