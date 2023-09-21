package pe.pamperurpet.pamperurpetapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.pamperurpet.pamperurpetapp.dtos.AdminDTO;
import pe.pamperurpet.pamperurpetapp.dtos.MascotaDTO;
import pe.pamperurpet.pamperurpetapp.dtos.PropietarioDTO;
import pe.pamperurpet.pamperurpetapp.dtos.PaseadorDTO;
import pe.pamperurpet.pamperurpetapp.entities.Admin;
import pe.pamperurpet.pamperurpetapp.entities.Mascota;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.exceptions.AdminNotFoundException;
import pe.pamperurpet.pamperurpetapp.exceptions.PropietarioNotFoundException;
import pe.pamperurpet.pamperurpetapp.interfaceservice.AdminService;
import pe.pamperurpet.pamperurpetapp.interfaceservice.MascotaService;
import pe.pamperurpet.pamperurpetapp.repositories.AdminRepository;
import pe.pamperurpet.pamperurpetapp.repositories.MascotaRepository;
import pe.pamperurpet.pamperurpetapp.repositories.PaseadorRepository;
import pe.pamperurpet.pamperurpetapp.repositories.PropietarioRepository;
import pe.pamperurpet.pamperurpetapp.services.AdminServiceImpl;
import pe.pamperurpet.pamperurpetapp.services.MascotaServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired //inyectando
    private AdminRepository adminRepository;
    @Autowired //inyectando
    private AdminService adminService;
    @Autowired //inyectando
    private PropietarioRepository propietarioRepository;
    @Autowired
    private PaseadorRepository paseadorRepository;
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @PostMapping("/admin/propietario")
    public ResponseEntity<AdminDTO> register(@RequestBody AdminDTO adminDTO) {
        try {
            // Convertir AdminDTO a entidad Admin
            Admin admin = new Admin();
            admin.setId_admin(adminDTO.getId_admin());

            // Convertir PropietarioDTO a entidad Propietario
            Propietario propietario = new Propietario();
            propietario.setPropietarioid(adminDTO.getPropietarioDTO().getPropietarioid());
            propietario.setNombreapellido_prop(adminDTO.getPropietarioDTO().getNombreapellido_prop());
            propietario.setTelefono_prop(adminDTO.getPropietarioDTO().getTelefono_prop());
            propietario.setCorreo_prop(adminDTO.getPropietarioDTO().getCorreo_prop());
            propietario.setContraseña_prop(adminDTO.getPropietarioDTO().getContraseña_prop());

            // Establecer la relación entre Admin y Propietario
            admin.setPropietario(propietario);

            // Guardar Admin en la base de datos
            admin = adminRepository.save(admin);

            // Convertir el resultado a AdminDTO
            AdminDTO resultDTO = new AdminDTO();
            resultDTO.setId_admin(admin.getId_admin());

            // Crear y configurar el PropietarioDTO en el resultado
            PropietarioDTO propietarioDTO = new PropietarioDTO();
            propietarioDTO.setPropietarioid(propietario.getPropietarioid());
            propietarioDTO.setNombreapellido_prop(propietario.getNombreapellido_prop());
            propietarioDTO.setTelefono_prop(propietario.getTelefono_prop());
            propietarioDTO.setCorreo_prop(propietario.getCorreo_prop());
            propietarioDTO.setContraseña_prop(propietario.getContraseña_prop());

            resultDTO.setPropietarioDTO(propietarioDTO);

            return new ResponseEntity<>(resultDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/paseador")
    public ResponseEntity<AdminDTO> register1(@RequestBody AdminDTO adminDTO) {
        try {
            // Convertir AdminDTO a entidad Admin
            Admin admin = new Admin();
            admin.setId_admin(adminDTO.getId_admin());

            // Convertir PaseadorDTO a entidad Paseador
            Paseador paseador = new Paseador();
            paseador.setId_pas(adminDTO.getPaseadorDTO().getId_pas());
            paseador.setNombreapellido_pas(adminDTO.getPaseadorDTO().getNombreapellido_pas());
            paseador.setTelefono_pas(adminDTO.getPaseadorDTO().getTelefono_pas());
            paseador.setCorreo_pas(adminDTO.getPaseadorDTO().getCorreo_pas());
            paseador.setContraseña_pas(adminDTO.getPaseadorDTO().getContraseña_pas());

            // Establecer la relación entre Admin y Paseador
            admin.setPaseador(paseador);

            // Guardar Admin en la base de datos
            admin = adminRepository.save(admin);

            // Convertir el resultado a AdminDTO
            AdminDTO resultDTO = new AdminDTO();
            resultDTO.setId_admin(admin.getId_admin());

            // Crear y configurar el PaseadorDTO en el resultado
            PaseadorDTO paseadorDTO = new PaseadorDTO();
            paseadorDTO.setId_pas(paseador.getId_pas());
            paseadorDTO.setNombreapellido_pas(paseador.getNombreapellido_pas());
            paseadorDTO.setTelefono_pas(paseador.getTelefono_pas());
            paseadorDTO.setCorreo_pas(paseador.getCorreo_pas());
            paseadorDTO.setContraseña_pas(paseador.getContraseña_pas());

            resultDTO.setPaseadorDTO(paseadorDTO);

            return new ResponseEntity<>(resultDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/mascota")
    public ResponseEntity<AdminDTO> register2(@RequestBody AdminDTO adminDTO) {
        try {
            // Convertir AdminDTO a entidad Admin
            Admin admin = new Admin();
            admin.setId_admin(adminDTO.getId_admin());

            // Convertir MascotaDTO a entidad Mascota
            Mascota mascota = new Mascota();
            mascota.setId_mas(adminDTO.getMascotaDTO().getId_mas());
            mascota.setNombre_mas(adminDTO.getMascotaDTO().getNombre_mas());
            mascota.setRaza_mas(adminDTO.getMascotaDTO().getRaza_mas());
            mascota.setEdad_mas(adminDTO.getMascotaDTO().getEdad_mas());

            // Establecer la relación entre Admin y Mascota
            admin.setMascota(mascota);

            // Guardar Admin en la base de datos
            admin = adminRepository.save(admin);

            // Convertir el resultado a AdminDTO
            AdminDTO resultDTO = new AdminDTO();
            resultDTO.setId_admin(admin.getId_admin());

            // Crear y configurar el MascotaDTO en el resultado
            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId_mas(mascota.getId_mas());
            mascotaDTO.setNombre_mas(mascota.getNombre_mas());
            mascotaDTO.setRaza_mas(mascota.getRaza_mas());
            mascotaDTO.setEdad_mas(mascota.getEdad_mas());

            resultDTO.setMascotaDTO(mascotaDTO);

            return new ResponseEntity<>(resultDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @GetMapping("/admins/propietarios")
    public ResponseEntity<List<AdminDTO>> listAdmins() {
        try {
            List<AdminDTO> admins = adminServiceImpl.listAdmins();

            // Iterar sobre la lista de AdminDTO y cargar los datos del Propietario en cada uno
            for (AdminDTO adminDTO : admins) {
                // Obtener el Admin correspondiente al AdminDTO
                Admin admin = adminRepository.findById(adminDTO.getId_admin()).orElse(null);

                if (admin != null) {
                    // Obtener el Propietario asociado al Admin
                    Propietario propietario = admin.getPropietario();
                    if (propietario != null) {
                        // Crear y configurar un PropietarioDTO con los datos del Propietario
                        PropietarioDTO propietarioDTO = new PropietarioDTO();
                        propietarioDTO.setPropietarioid(propietario.getPropietarioid());
                        propietarioDTO.setNombreapellido_prop(propietario.getNombreapellido_prop());
                        propietarioDTO.setTelefono_prop(propietario.getTelefono_prop());
                        propietarioDTO.setCorreo_prop(propietario.getCorreo_prop());
                        propietarioDTO.setContraseña_prop(propietario.getContraseña_prop());

                        // Establecer el PropietarioDTO en el AdminDTO correspondiente
                        adminDTO.setPropietarioDTO(propietarioDTO);
                    }
                }
            }

            return new ResponseEntity<>(admins, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admins/paseadores")
    public ResponseEntity<List<AdminDTO>> listAdmins1() {
        try {
            List<AdminDTO> admins = adminServiceImpl.listAdmins();

            // Iterar sobre la lista de AdminDTO y cargar los datos del Paseador en cada uno
            for (AdminDTO adminDTO : admins) {
                // Obtener el Admin correspondiente al AdminDTO
                Admin admin = adminRepository.findById(adminDTO.getId_admin()).orElse(null);

                if (admin != null) {
                    // Obtener el Paseador asociado al Admin
                    Paseador paseador = admin.getPaseador();
                    if (paseador != null) {
                        // Crear y configurar un PaseadorDTO con los datos del Paseador
                        PaseadorDTO paseadorDTO = new PaseadorDTO();
                        paseadorDTO.setId_pas(paseador.getId_pas());
                        paseadorDTO.setNombreapellido_pas(paseador.getNombreapellido_pas());
                        paseadorDTO.setTelefono_pas(paseador.getTelefono_pas());
                        paseadorDTO.setCorreo_pas(paseador.getCorreo_pas());
                        paseadorDTO.setContraseña_pas(paseador.getContraseña_pas());

                        // Establecer el PaseadorDTO en el AdminDTO correspondiente
                        adminDTO.setPaseadorDTO(paseadorDTO);
                    }
                }
            }

            return new ResponseEntity<>(admins, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admins/mascotas")
    public ResponseEntity<List<AdminDTO>> listAdmins2() {
        try {
            List<AdminDTO> admins = adminServiceImpl.listAdmins();

            // Iterar sobre la lista de AdminDTO y cargar los datos de la Mascota en cada uno
            for (AdminDTO adminDTO : admins) {
                // Obtener el Admin correspondiente al AdminDTO
                Admin admin = adminRepository.findById(adminDTO.getId_admin()).orElse(null);

                if (admin != null) {
                    // Obtener la Mascota asociada al Admin
                    Mascota mascota = admin.getMascota();
                    if (mascota != null) {
                        // Crear y configurar un MascotaDTO con los datos de la Mascota
                        MascotaDTO mascotaDTO = new MascotaDTO();
                        mascotaDTO.setId_mas(mascota.getId_mas());
                        mascotaDTO.setNombre_mas(mascota.getNombre_mas());
                        mascotaDTO.setRaza_mas(mascota.getRaza_mas());
                        mascotaDTO.setEdad_mas(mascota.getEdad_mas());

                        // Establecer el MascotaDTO en el AdminDTO correspondiente
                        adminDTO.setMascotaDTO(mascotaDTO);
                    }
                }
            }

            return new ResponseEntity<>(admins, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/admin/paseadordelete/{id_admin}")
    public ResponseEntity<String> deletePaseadorFromAdmin(@PathVariable Long id_admin) {
        try {
            adminService.deletePaseadorFromAdmin(id_admin);
            return new ResponseEntity<>("El Paseador ha sido eliminado correctamente del Admin.", HttpStatus.OK);
        } catch (AdminNotFoundException e) {
            return new ResponseEntity<>("No se encontró el Admin con ID " + id_admin, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Se produjo un error al eliminar el Paseador del Admin.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    private AdminDTO convertToDto(Admin admin) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(admin, AdminDTO.class);
    }

    private Admin convertToEntity(AdminDTO adminDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(adminDTO, Admin.class);
    }

    private List<AdminDTO> convertToLisDto(List<Admin> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
