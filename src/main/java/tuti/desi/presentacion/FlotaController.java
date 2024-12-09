package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tuti.desi.entidades.Flota;
import tuti.desi.servicios.FlotaService;

import java.util.List;

@RestController
@RequestMapping("/flotas")
public class FlotaController {

    @Autowired
    private FlotaService flotaService;

    // Obtener todas las flotas
    @GetMapping
    public List<Flota> obtenerTodasLasFlotas() {
        return flotaService.obtenerTodasLasFlotas();
    }


}
