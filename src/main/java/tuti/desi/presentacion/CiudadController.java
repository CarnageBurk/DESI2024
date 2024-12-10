package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tuti.desi.servicios.CiudadService;
import tuti.desi.entidades.Ciudad;
import tuti.desi.excepciones.Excepcion;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;

	// Crear una nueva ciudad
	@PostMapping
	public ResponseEntity<String> agregarCiudad(@RequestBody Ciudad ciudad) {
		try {
			ciudadService.agregarCiudad(ciudad.getNombre());
			return ResponseEntity.ok("Ciudad creada con éxito");
		} catch (Excepcion e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	// Obtener todas las ciudades
	@GetMapping
	public List<Ciudad> obtenerTodasLasCiudades() {
		return ciudadService.obtenerTodasLasCiudades();
	}

	// Buscar ciudad por ID
	@GetMapping("/{id}")
	public ResponseEntity<Ciudad> buscarCiudadPorId(@PathVariable Long id) {
		try {
			Ciudad ciudad = ciudadService.buscarPorId(id);
			return ResponseEntity.ok(ciudad);
		} catch (Excepcion e) {
			return ResponseEntity.status(404).body(null);
		}
	}

	// Actualizar ciudad
	@PutMapping("/{id}")
	public ResponseEntity<String> actualizarCiudad(@PathVariable Long id, @RequestBody Ciudad ciudad) {
		try {
			ciudadService.actualizarCiudad(id, ciudad.getNombre());
			return ResponseEntity.ok("Ciudad actualizada con éxito");
		} catch (Excepcion e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	// Eliminar ciudad
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarCiudad(@PathVariable Long id) {
		try {
			ciudadService.eliminarCiudad(id);
			return ResponseEntity.ok("Ciudad eliminada con éxito");
		} catch (Excepcion e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}