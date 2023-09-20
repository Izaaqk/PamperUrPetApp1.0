package pe.pamperurpet.pamperurpetapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.pamperurpet.pamperurpetapp.dtos.PropietarioDTO;
import pe.pamperurpet.pamperurpetapp.dtos.ReservaDTO;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.entities.Reserva;
import pe.pamperurpet.pamperurpetapp.exceptions.PropietarioNotFoundException;
import pe.pamperurpet.pamperurpetapp.exceptions.ReservaNotFoundException;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PropietarioService;
import pe.pamperurpet.pamperurpetapp.interfaceservice.ReservaService;
import pe.pamperurpet.pamperurpetapp.services.PropietarioServiceImpl;
import pe.pamperurpet.pamperurpetapp.services.ReservaServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ReservaController {
    @Autowired //inyectando
    private ReservaService reservaService;
    @Autowired //inyectando
    private ReservaServiceImpl reservaServiceImpl;

    @PostMapping("/reserva")
    public ResponseEntity<ReservaDTO> register(@RequestBody ReservaDTO reservaDTO){
        Reserva reserva = convertToEntity(reservaDTO);
        reserva = reservaServiceImpl.register(reserva);
        reservaDTO = convertToDto(reserva);
        return new ResponseEntity<ReservaDTO>(reservaDTO, HttpStatus.OK);
    }

    @GetMapping("/reservas")
    public ResponseEntity<List<ReservaDTO>> listReservas() {
        try {
            List<ReservaDTO> reservas = reservaServiceImpl.listReservas();
            return new ResponseEntity<>(reservas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/reservaupdate/{id_reser}")
    public ResponseEntity<ReservaDTO> updateDataReserva(@PathVariable Long id_reser, @RequestBody ReservaDTO nuevosDatos) {
        try {
            Reserva reservaActualizado = reservaServiceImpl.updateDataReserva(id_reser, nuevosDatos);
            ReservaDTO responseDTO = convertToDto(reservaActualizado);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (ReservaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/reservadelete/{id_reser}")
    ReservaDTO delete(@PathVariable(value = "id_reser") Long id_reser){
        ReservaDTO reserva;
        try{
            reserva = reservaService.deleteReserva(id_reser);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede eliminar");
        }
        return reserva;
    }

    private ReservaDTO convertToDto(Reserva reserva) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(reserva, ReservaDTO.class);
    }

    private Reserva convertToEntity(ReservaDTO reservaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(reservaDTO, Reserva.class);
    }

    private List<ReservaDTO> convertToLisDto(List<Reserva> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
