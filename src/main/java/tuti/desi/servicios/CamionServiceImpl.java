package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.ICamionRepo;
import tuti.desi.entidades.Camion;

@Service
public class CamionServiceImpl implements CamionService {

    @Autowired
    private ICamionRepo camionRepo;

    @Override
    public void agregarCamion(Camion camion) {
        camionRepo.save(camion);
    }
}