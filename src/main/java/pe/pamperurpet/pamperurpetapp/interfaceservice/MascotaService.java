package pe.pamperurpet.pamperurpetapp.interfaceservice;

import pe.pamperurpet.pamperurpetapp.entities.Mascota;

public interface MascotaService {
    public Mascota register(Mascota mascota);
    public Mascota updateMascota(Mascota mascota) throws Exception;
    public Mascota deleteMascota(Long id) throws Exception;
}
