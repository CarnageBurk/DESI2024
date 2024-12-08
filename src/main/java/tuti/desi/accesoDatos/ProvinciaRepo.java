package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Provincia;

@Repository
public interface ProvinciaRepo extends JpaRepository <Provincia, Long> {

}
