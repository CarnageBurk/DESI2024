package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Paquete;

public interface PaqueteRepo extends JpaRepository <Paquete, Long> {
	
	
	// JPQL: Buscar por origen y destino
    @Query("SELECT p FROM Paquete p WHERE p.origen = :origen AND p.destino = :destino")
    List<Paquete> findByOrigenAndDestino(@Param("origen") Ciudad origen, @Param("destino") Ciudad destino);

    // JPQL: Buscar paquetes por ciudad de origen
    @Query("SELECT p FROM Paquete p WHERE p.origen = :origen")
    List<Paquete> findByOrigen(@Param("origen") Ciudad origen);

    // JPQL: Buscar paquetes por ciudad de destino
    @Query("SELECT p FROM Paquete p WHERE p.destino = :destino")
    List<Paquete> findByDestino(@Param("destino") Ciudad destino);

    // JPQL: Buscar paquetes enviados entre un rango de fechas
    @Query("SELECT p FROM Paquete p WHERE p.fechaEnvio BETWEEN :inicio AND :fin")
    List<Paquete> findByFechaEnvioBetween(@Param("inicio") String inicio, @Param("fin") String fin);

    // SQL nativo: Buscar paquetes con peso mayor a un valor
    @Query(value = "SELECT * FROM paquete WHERE peso > :peso", nativeQuery = true)
    List<Paquete> findByPesoGreaterThan(@Param("peso") Double peso);

    // JPQL: Buscar paquetes por estado (Ejemplo: "En tránsito", "Entregado")
    @Query("SELECT p FROM Paquete p WHERE p.estado = :estado")
    List<Paquete> findByEstado(@Param("estado") String estado);

    // JPQL: Buscar paquetes urgentes
    @Query("SELECT p FROM Paquete p WHERE p.urgente = true")
    List<Paquete> findUrgentes();
}