package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.PaqueteRepo;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Paquete;

import java.util.List;

@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepo paqueteRepositorio; // Asegúrate de que el nombre sea consistente

    // Agregar un nuevo paquete
    public void agregarPaquete(Paquete paquete) {
        paqueteRepositorio.save(paquete);
    }

    // Obtener todos los paquetes
    public List<Paquete> obtenerTodosLosPaquetes() {
        return paqueteRepositorio.findAll();
    }

    // Eliminar paquete
    public void eliminarPaquete(Long id) {
        paqueteRepositorio.deleteById(id);
    }

    // Registrar un nuevo paquete (método adicional)
    public void registrarPaquete(Ciudad origen, Ciudad destino, boolean fragil, String dniRemitente, String dniDestinatario) {
        Paquete paquete = new Paquete();

        paquete.setOrigen(origen);
        paquete.setDestino(destino);
        paquete.setFragil(fragil);
        paquete.setDniRemitente(dniRemitente);
        paquete.setDniDestinatario(dniDestinatario);

        paqueteRepositorio.save(paquete);
    }
}