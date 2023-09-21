package pe.pamperurpet.pamperurpetapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pe.pamperurpet.pamperurpetapp.dtos.MascotaDTO;
import pe.pamperurpet.pamperurpetapp.entities.Mascota;
import pe.pamperurpet.pamperurpetapp.interfaceservice.MascotaService;

@RestController
@RequestMapping("api")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;
    @PostMapping("/mascota")
   ResponseEntity<MascotaDTO> register(@RequestBody MascotaDTO mascotaDTO){
       Mascota mascota;
       MascotaDTO dto;
       try{
           mascota = convertToEntity(mascotaDTO);
           mascota = mascotaService.register(mascota);
           dto = convertToDto(mascota);
       } catch (Exception e){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar mascota");
       }
       return new ResponseEntity<MascotaDTO>(dto,HttpStatus.OK);

   }
   private Mascota convertToEntity(MascotaDTO mascotaDTO){
       ModelMapper modelMapper = new ModelMapper();
       Mascota post = modelMapper.map(mascotaDTO,Mascota.class);
       return post;
   }

   private MascotaDTO convertToDto(Mascota mascota){
       ModelMapper modelMapper=new ModelMapper();
       MascotaDTO mascotaDTO = modelMapper.map(mascota,MascotaDTO.class);
       return mascotaDTO;
   }
}
