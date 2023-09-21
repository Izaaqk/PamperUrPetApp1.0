package pe.pamperurpet.pamperurpetapp.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.pamperurpet.pamperurpetapp.dtos.AdminDTO;
import pe.pamperurpet.pamperurpetapp.dtos.MascotaDTO;
import pe.pamperurpet.pamperurpetapp.dtos.PagoDTO;
import pe.pamperurpet.pamperurpetapp.dtos.PropietarioDTO;
import pe.pamperurpet.pamperurpetapp.entities.Admin;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;
import pe.pamperurpet.pamperurpetapp.dtos.PaseadorDTO;
import pe.pamperurpet.pamperurpetapp.entities.Mascota;
import pe.pamperurpet.pamperurpetapp.entities.Pago;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.exceptions.AdminNotFoundException;
import pe.pamperurpet.pamperurpetapp.exceptions.MascotaNotFoundException;
import pe.pamperurpet.pamperurpetapp.exceptions.PropietarioNotFoundException;
import pe.pamperurpet.pamperurpetapp.interfaceservice.AdminService;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PagoService;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PropietarioService;
import pe.pamperurpet.pamperurpetapp.repositories.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PropietarioRepository propietarioRepository;
    @Autowired
    private PaseadorRepository paseadorRepository;
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<AdminDTO> listAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePaseadorFromAdmin(Long id_admin) throws AdminNotFoundException {
        // Busca el Admin por ID
        Optional<Admin> adminOptional = adminRepository.findById(id_admin);

        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();

            // Establece el paseador en null
            admin.setPaseador(null);

            // Guarda el Admin actualizado en la base de datos
            adminRepository.save(admin);
        } else {
            throw new AdminNotFoundException("No se encontró el Admin con ID " + id_admin);
        }
    }




    private List<AdminDTO> convertToLisDto(List<Admin> admins){
        return admins.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private AdminDTO convertToDto(Admin admin) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(admin, AdminDTO.class);
    }
}
