package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tuti.desi.entidades.Camion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Flota;
import tuti.desi.servicios.CamionService;

import java.util.List;

@RestController
@RequestMapping("/camiones")
public class CamionController {

    @Autowired
    private CamionService camionService;

    // Crear un nuevo camión
    @PostMapping
    public ResponseEntity<String> agregarCamion(@RequestParam String patente,
                                                @RequestParam Long ciudadId,
                                                @RequestParam String marca,
                                                @RequestParam int modelo,
                                                @RequestParam(required = false) Long flotaId) {
        // Obtener las entidades Ciudad y Flota por sus ID
        Ciudad ciudad = new Ciudad();  // buscar la ciudad usando su ID en la base de datos
        Flota flota = flotaId != null ? new Flota() : null; // Si flotaId esta presente, buscar flota

        // Llamar al servicio para agregar el camión
        camionService.agregarCamion(patente, ciudad, marca, modelo, flota);

        return ResponseEntity.ok("Camión creado con éxito");
    }

    // Obtener todos los camiones
    @GetMapping
    public List<Camion> obtenerTodosLosCamiones() {
        return camionService.obtenerTodosLosCamiones();
    }

    // Buscar camiones por ciudad
    @GetMapping("/ciudad/{ciudadId}")
    public ResponseEntity<List<Camion>> buscarCamionesPorCiudad(@PathVariable Long ciudadId) {
        Ciudad ciudad = new Ciudad();  // Aquí deberías buscar la ciudad usando su ID
        List<Camion> camiones = camionService.buscarPorCiudad(ciudad);
        return ResponseEntity.ok(camiones);
    }

    // Buscar camiones por flota
    @GetMapping("/flota/{flotaId}")
    public ResponseEntity<List<Camion>> buscarCamionesPorFlota(@PathVariable Long flotaId) {
        Flota flota = new Flota();  // Aquí deberías buscar la flota usando su ID
        List<Camion> camiones = camionService.buscarPorFlota(flota);
        return ResponseEntity.ok(camiones);
    }

}