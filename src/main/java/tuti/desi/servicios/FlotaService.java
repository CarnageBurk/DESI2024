package tuti.desi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.FlotaRepo;
import tuti.desi.entidades.Flota;

@Service
public class FlotaService {
	
	@Autowired
    private FlotaRepo flotaRepositorio;

    // Crear una nueva flota
    public void agregarFlota(String nombre, String descripcion) {
        Flota flota = new Flota();
        flota.setNombre(nombre);
        flotaRepositorio.save(flota);
    }

    // Obtener todas las flotas
    public List<Flota> obtenerTodasLasFlotas() {
        return flotaRepositorio.findAll();
    }

    // Buscar flota por ID
    public Optional<Flota> buscarFlotaPorId(Long id) {
        return flotaRepositorio.findById(id);
    }

    // Buscar flotas por nombre
    public List<Flota> buscarFlotasPorNombre(String nombre) {
        return flotaRepositorio.findByNombre(nombre);
    }

}

