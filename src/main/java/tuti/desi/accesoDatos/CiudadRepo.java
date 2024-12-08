package tuti.desi.accesoDatos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Ciudad;

@Repository
public interface CiudadRepo extends JpaRepository <Ciudad, Long> {
	
	    // Encuentra una ciudad por su nombre
	    Optional<Ciudad> findByNombre(String nombre);

	    // Encuentra todas las ciudades cuyo nombre contenga una cadena especifica
	    List<Ciudad> findByNombreContaining(String partialNombre);

	    // Encuentra una ciudad por su código postal
	    Optional<Ciudad> findByCodigoPostal(String codigoPostal);

	    // Encuentra todas las ciudades en un estado/provincia especifico
	    List<Ciudad> findByEstado(String estado);

	    // Encuentra todas las ciudades con una poblacion mayor a un numero dado
	    List<Ciudad> findByPoblacionGreaterThan(Long poblacion);

}
