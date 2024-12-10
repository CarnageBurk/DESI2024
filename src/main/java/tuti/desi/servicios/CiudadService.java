package tuti.desi.servicios;

<<<<<<< HEAD

import java.util.List;

import tuti.desi.entidades.Ciudad;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.CiudadesBuscarForm;
/**
 * Clase que permite gestionar la entidad Ciudad en el sistema.
 * @author kuttel
 * @version 1.0
 */

public interface CiudadService {

	

	/**
	 * Obtiene la lista completa de ciudades
	 * @return Todas las ciudades
	 */
	List<Ciudad> getAll();
	
	/**
	 * Obtiene una ciudad determinada
	 * @param idCiudad Identificador de la ciudad buscada
	 * @return Ciudad encontrada
	 */
	Ciudad getById(Long idCiudad) ;
	
	List<Ciudad> filter(CiudadesBuscarForm filter) throws Excepcion;

	void deleteByid(Long id);

	void save(Ciudad c) throws Excepcion;

}
=======
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tuti.desi.accesoDatos.CiudadRepo;
import tuti.desi.entidades.Ciudad;
import tuti.desi.excepciones.Excepcion;

public class CiudadService {

	@Autowired
    private CiudadRepo ciudadRepo;

    // Agregar una nueva ciudad
    public void agregarCiudad(String nombre) throws Excepcion {
        if (ciudadRepo.findByNombre(nombre).isPresent()) {
            throw new Excepcion("La ciudad con nombre '" + nombre + "' ya existe.");
        }

        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre);
        ciudadRepo.save(ciudad);
    }

    // Obtener todas las ciudades
    public List<Ciudad> obtenerTodasLasCiudades() {
        return ciudadRepo.findAll();
    }

    // Buscar ciudad por ID
    public Ciudad buscarPorId(Long id) throws Excepcion {
        return ciudadRepo.findById(id)
                .orElseThrow(() -> new Excepcion("No se encontró la ciudad con ID " + id));
    }

    // Buscar ciudad por nombre
    public Optional<Ciudad> buscarPorNombre(String nombre) {
        return ciudadRepo.findByNombre(nombre);
    }

    // Actualizar una ciudad
    public void actualizarCiudad(Long id, String nuevoNombre) throws Excepcion {
        Ciudad ciudad = ciudadRepo.findById(id)
                .orElseThrow(() -> new Excepcion("No se encontró la ciudad con ID " + id));

        if (ciudadRepo.findByNombre(nuevoNombre).isPresent()) {
            throw new Excepcion("Ya existe una ciudad con el nombre '" + nuevoNombre + "'.");
        }

        ciudad.setNombre(nuevoNombre);
        ciudadRepo.save(ciudad);
    }

    // Eliminar una ciudad por ID
    public void eliminarCiudad(Long id) throws Excepcion {
        if (!ciudadRepo.existsById(id)) {
            throw new Excepcion("No se encontró la ciudad con ID " + id);
        }

        ciudadRepo.deleteById(id);
    }
}
>>>>>>> 17f7e9b (agrego archivos)
