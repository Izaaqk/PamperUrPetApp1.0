package pe.pamperurpet.pamperurpetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PropietarioService;
import pe.pamperurpet.pamperurpetapp.repositories.PropietarioRepository;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {
    @Autowired
    private PropietarioRepository propietarioRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Propietario register(Propietario propietario){
        return propietarioRepository.save(propietario);
    }
    public List<Propietario> listPropietarios(){
        return propietarioRepository.findAll();
    }
    public Propietario updatePropietario(Propietario propietario) throws Exception {
        propietarioRepository.findById(propietario.getPropietarioid()).
                orElseThrow(()-> new Exception("Se encontró entidad"));
        return propietarioRepository.save(propietario);
    }
    public Propietario deletePropietario(Long id) throws Exception {
        Propietario propietario = propietarioRepository.findById(id).
                orElseThrow(()->new Exception("No se encontró entidad"));
        propietarioRepository.delete(propietario);
        return propietario;
    }
}