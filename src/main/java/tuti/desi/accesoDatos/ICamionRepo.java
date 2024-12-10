package tuti.desi.accesoDatos;

import org.springframework.data.repository.CrudRepository;
import tuti.desi.entidades.Camion;

public interface ICamionRepo extends CrudRepository<Camion, String> {
    // 
}
