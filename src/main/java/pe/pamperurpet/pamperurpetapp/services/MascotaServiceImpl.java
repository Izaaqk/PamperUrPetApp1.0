package pe.pamperurpet.pamperurpetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.pamperurpet.pamperurpetapp.entities.Mascota;
import pe.pamperurpet.pamperurpetapp.interfaceservice.MascotaService;
import pe.pamperurpet.pamperurpetapp.repositories.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    public Mascota register(Mascota mascota){
        return mascotaRepository.save(mascota);
    }
    public Mascota updateMascota(Mascota mascota) throws Exception{
        mascotaRepository.findById(mascota.getId_mas()).orElseThrow(()->new Exception("No se encontro entidad"));
        return mascotaRepository.save(mascota);
    }
}
