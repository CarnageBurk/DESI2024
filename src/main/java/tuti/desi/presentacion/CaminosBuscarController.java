package tuti.desi.presentacion;

import tuti.desi.servicios.CaminoService;
import tuti.desi.entidades.Camino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import tuti.desi.servicios.CiudadService;
import tuti.desi.entidades.Ciudad;

@Controller
@RequestMapping("/caminosBuscar")
public class CaminosBuscarController {

    @Autowired
    private CaminoService caminoService;
    
    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    /*public String mostrarPagina() {
        return "caminosBuscar";
    }*/
    
    public String mostrarPagina(Model model) {
        List<Ciudad> ciudades = ciudadService.getAll();
        model.addAttribute("ciudades", ciudades);
        return "caminosBuscar";
    }
    
    @GetMapping("/resultados")
    public String listarResultados(
            //@RequestParam(name = "codigoPostal") Integer codigoPostal,
    		@RequestParam(name = "ciudadId") Long ciudadId,
    		Model model) {
        //List<Camino> caminos = caminoService.obtenerCaminosPorCodigoPostal(codigoPostal);
    	List<Ciudad> ciudades = ciudadService.getAll();
    	List<Camino> caminos = caminoService.obtenerCaminosPorCiudad(ciudadId);
    	if (caminos.isEmpty()) {
        	model.addAttribute("mensajeError", "No se encontraron caminos para el código postal proporcionado.");
        } else {
        	model.addAttribute("ciudades", ciudades);
        	model.addAttribute("caminos", caminos);
        }
        return "caminosBuscar";
    }
}
