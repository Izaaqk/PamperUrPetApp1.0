package pe.pamperurpet.pamperurpetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.pamperurpet.pamperurpetapp.entities.Admin;
import pe.pamperurpet.pamperurpetapp.entities.Mascota;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.interfaceservice.AdminService;
import pe.pamperurpet.pamperurpetapp.repositories.AdminRepository;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Propietario register(Propietario propietario) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Propietario> listPropietarios() {
        return null;
    }

    @Override
    public Propietario updatePropietario(Propietario propietario) throws Exception {
        return null;
    }

    @Override
    public Propietario deletePropietario(Long codigo) throws Exception {
        return null;
    }

    @Override
    public Paseador register(Paseador paseador) {
        return null;
    }

    @Override
    public List<Paseador> listPaseador() {
        return null;
    }

    @Override
    public Paseador updatePaseador(Paseador paseador) throws Exception {
        return null;
    }

    @Override
    public Paseador deletePaseador(Long codigo) throws Exception {
        return null;
    }

    @Override
    public Mascota register(Mascota mascota) {
        return null;
    }

    @Override
    public List<Mascota> listMascota() {
        return null;
    }

    @Override
    public Mascota updateMascota(Mascota mascota) throws Exception {
        return null;
    }

    @Override
    public Mascota deleteMascota(Long codigo) throws Exception {
        return null;
    }
}
