package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import tuti.desi.entidades.Camion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Flota;

@Repository
public interface CamionRepo extends JpaRepository<Camion, Long> {  

    // Actualizar la flota de un camión
    @Query("UPDATE Camion c SET c.flota.id = :idFlota WHERE c.id = :idCamion")
    @Modifying
    @Transactional
    void agregarCamionAFlota(Long idFlota, Long idCamion);

    // Eliminar un camión de una flota (en realidad, desvincularlo)
    @Query("UPDATE Camion c SET c.flota = NULL WHERE c.id = :idCamion")
    @Modifying
    @Transactional
    void eliminarCamionDeLaFlota(Long idCamion);

    // Buscar camiones por ciudad
    List<Camion> findByCiudad(Ciudad ciudad);

    // Buscar camiones por flota
    List<Camion> findByFlota(Flota flota);
}