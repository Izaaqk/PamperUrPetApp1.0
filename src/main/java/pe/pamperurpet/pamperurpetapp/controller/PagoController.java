package pe.pamperurpet.pamperurpetapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.pamperurpet.pamperurpetapp.dtos.PagoDTO;
import pe.pamperurpet.pamperurpetapp.dtos.PaseadorDTO;
import pe.pamperurpet.pamperurpetapp.entities.Pago;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PagoService;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PaseadorService;
import pe.pamperurpet.pamperurpetapp.services.PagoServiceImpl;
import pe.pamperurpet.pamperurpetapp.services.PaseadorServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PagoController {
    @Autowired //inyectando
    private PagoService pagoService;
    @Autowired //inyectando
    private PagoServiceImpl pagoServiceImpl;

    @PostMapping("/pago")
    public ResponseEntity<PagoDTO> register(@RequestBody PagoDTO pagoDTO){
        Pago pago = convertToEntity(pagoDTO);
        pago = pagoServiceImpl.register(pago);
        pagoDTO = convertToDto(pago);
        return new ResponseEntity<PagoDTO>(pagoDTO, HttpStatus.OK);
    }

    private PagoDTO convertToDto(Pago pago) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pago, PagoDTO.class);
    }

    private Pago convertToEntity(PagoDTO pagoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pagoDTO, Pago.class);
    }

    private List<PagoDTO> convertToLisDto(List<Pago> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
