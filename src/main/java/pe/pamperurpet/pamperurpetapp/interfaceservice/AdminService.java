package pe.pamperurpet.pamperurpetapp.interfaceservice;

import pe.pamperurpet.pamperurpetapp.dtos.PropietarioDTO;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.exceptions.AdminNotFoundException;
import pe.pamperurpet.pamperurpetapp.exceptions.PropietarioNotFoundException;

public interface AdminService {
    public void deletePaseadorFromAdmin(Long id_admin) throws AdminNotFoundException;
}
