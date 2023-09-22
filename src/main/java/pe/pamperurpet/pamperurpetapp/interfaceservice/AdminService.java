package pe.pamperurpet.pamperurpetapp.interfaceservice;

import pe.pamperurpet.pamperurpetapp.entities.Mascota;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;

import java.util.List;

public interface AdminService {
    public Propietario register(Propietario propietario);
    public List<Propietario> listPropietarios();
    public Propietario updatePropietario(Propietario propietario) throws Exception;
    public Propietario deletePropietario(Long codigo) throws Exception;

    public Paseador register(Paseador paseador);
    public List<Paseador> listPaseador();
    public Paseador updatePaseador(Paseador paseador) throws Exception;
    public Paseador deletePaseador (Long codigo) throws Exception;

    public Mascota register(Mascota mascota);
    public List<Mascota> listMascota();
    public Mascota updateMascota(Mascota mascota) throws Exception;
    public Mascota deleteMascota(Long codigo) throws Exception;
}
