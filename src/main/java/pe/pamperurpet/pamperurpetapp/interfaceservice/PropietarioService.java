package pe.pamperurpet.pamperurpetapp.interfaceservice;

import org.springframework.stereotype.Service;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;

import java.util.List;

public interface PropietarioService {
    public Propietario register(Propietario propietario);
    public List<Propietario> listPropietarios();
    public Propietario updatePropietario(Propietario propietario) throws Exception;
    public Propietario deletePropietario(Long codigo) throws Exception;

}
