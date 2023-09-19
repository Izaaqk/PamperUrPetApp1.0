package pe.pamperurpet.pamperurpetapp.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PropietarioService;
import pe.pamperurpet.pamperurpetapp.repositories.PropietarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropietarioController {
    @Autowired //inyectando
    private PropietarioService propietarioService;
    @PostMapping("/propietario")
    public Propietario register(@RequestBody Propietario propietario) {return propietarioService.register(propietario);}
    @GetMapping("/propietarios")
    public List<Propietario> getPropietarios(){
        return propietarioService.listPropietarios();
    }
    @PutMapping("/updatepropietario/{propietarioID}")
    public Propietario updatePropietario(@PathVariable Long propietarioID, @RequestBody Propietario propietario) throws Exception {
        propietario.setPropietarioid(propietarioID); // Set the ID from the path variable to the entity
        return propietarioService.updatePropietario(propietario);
    }



    @DeleteMapping("/deletepropietario/{id}")
    public Propietario deletePropietario(@PathVariable Long id) throws Exception {
        return propietarioService.deletePropietario(id);
    }


}
