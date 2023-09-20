package pe.pamperurpet.pamperurpetapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.pamperurpet.pamperurpetapp.dtos.PropietarioDTO;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.exceptions.PropietarioNotFoundException;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PropietarioService;
import pe.pamperurpet.pamperurpetapp.services.PropietarioServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PropietarioController {
    @Autowired //inyectando
    private PropietarioService propietarioService;
    @Autowired //inyectando
    private PropietarioServiceImpl propietarioServiceImpl;

    @PostMapping("/propietario")
    public ResponseEntity<PropietarioDTO> register(@RequestBody PropietarioDTO propietarioDTO){
        Propietario propietario = convertToEntity(propietarioDTO);
        propietario = propietarioServiceImpl.register(propietario);
        propietarioDTO = convertToDto(propietario);
        return new ResponseEntity<PropietarioDTO>(propietarioDTO, HttpStatus.OK);
    }

    @GetMapping("/propietarios")
    public ResponseEntity<List<PropietarioDTO>> listPropietario() {
        try {
            List<PropietarioDTO> propietarios = propietarioServiceImpl.listPropietarios();
            return new ResponseEntity<>(propietarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/propietarioupdate/{propietarioid}")
    public ResponseEntity<PropietarioDTO> updateDataPropietario(@PathVariable Long propietarioid, @RequestBody PropietarioDTO nuevosDatos) {
        try {
            Propietario propietarioActualizado = propietarioServiceImpl.updateDataPropietario(propietarioid, nuevosDatos);
            PropietarioDTO responseDTO = convertToDto(propietarioActualizado);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (PropietarioNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/propietariodelete/{propietarioid}")
    PropietarioDTO delete(@PathVariable(value = "propietarioid") Long propietarioid){
        PropietarioDTO propietario;
        try{
            propietario = propietarioService.deletePropietario(propietarioid);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede eliminar");
        }
        return propietario;
    }


    private PropietarioDTO convertToDto(Propietario propietario) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(propietario, PropietarioDTO.class);
    }

    private Propietario convertToEntity(PropietarioDTO propietarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(propietarioDTO, Propietario.class);
    }

    private List<PropietarioDTO> convertToLisDto(List<Propietario> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
