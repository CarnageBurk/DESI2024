package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Paquete;
import tuti.desi.servicios.PaqueteService;


@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteService paqueteService;

    // Crear un nuevo paquete
    @PostMapping
    public ResponseEntity<String> agregarPaquete(@RequestBody Paquete paquete) {
        paqueteService.agregarPaquete(paquete);
        return ResponseEntity.ok("Paquete creado con éxito");
    }

    // Eliminar paquete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaquete(@PathVariable Long id) {
        paqueteService.eliminarPaquete(id);
        return ResponseEntity.ok("Paquete eliminado con éxito");
    }

    // Registrar un paquete con parámetros específicos
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPaquete(@RequestParam Long origenId, 
                                                   @RequestParam Long destinoId, 
                                                   @RequestParam boolean fragil, 
                                                   @RequestParam String dniRemitente,
                                                   @RequestParam String dniDestinatario) {
        // buscar las ciudades por su ID
        Ciudad origen = new Ciudad();  // Necesitarías un servicio o repositorio para obtener la ciudad por ID
        Ciudad destino = new Ciudad();  // Lo mismo para la ciudad destino
        
        // Llama al servicio para registrar el paquete
        paqueteService.registrarPaquete(origen, destino, fragil, dniRemitente, dniDestinatario);
        return ResponseEntity.ok("Paquete registrado con éxito");
    }
}