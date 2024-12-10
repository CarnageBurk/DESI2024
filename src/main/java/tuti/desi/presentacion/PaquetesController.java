package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import tuti.desi.servicios.PaqueteService;
import tuti.desi.entidades.Paquete;

@Controller
public class PaquetesController {

    @Autowired
    private PaqueteService paqueteService;

    @GetMapping("/registrarPaquete")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paquete", new Paquete());
        return "paqueteRegistrar";
    }

    @PostMapping("/registrarPaquete")
    public String registrarPaquete(@ModelAttribute Paquete paquete, Model model) {
        paqueteService.registrarPaquete(paquete);
        model.addAttribute("mensaje", "Paquete registrado exitosamente");
        return "paqueteRegistrar";
    }
}
