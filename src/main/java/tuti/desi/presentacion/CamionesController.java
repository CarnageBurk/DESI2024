package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import tuti.desi.servicios.CamionService;
import tuti.desi.entidades.Camion;

@Controller
public class CamionesController {

    @Autowired
    private CamionService camionService;

    @GetMapping("/agregarCamion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("camion", new Camion());
        return "camionAgregar";
    }

    @PostMapping("/agregarCamion")
    public String agregarCamion(@ModelAttribute Camion camion, Model model) {
        camionService.agregarCamion(camion);
        model.addAttribute("mensaje", "Camión agregado exitosamente");
        return "camionAgregar";
    }
}
