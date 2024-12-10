package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IPaqueteRepo;
import tuti.desi.entidades.Paquete;

@Service
public class PaqueteServiceImpl implements PaqueteService {

    @Autowired
    private IPaqueteRepo paqueteRepo;

    @Override
    public void registrarPaquete(Paquete paquete) {
        paqueteRepo.save(paquete);
    }
}
