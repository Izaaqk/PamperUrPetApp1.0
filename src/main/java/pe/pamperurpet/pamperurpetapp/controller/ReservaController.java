package pe.pamperurpet.pamperurpetapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.pamperurpet.pamperurpetapp.dtos.PropietarioDTO;
import pe.pamperurpet.pamperurpetapp.dtos.ReservaDTO;
import pe.pamperurpet.pamperurpetapp.entities.Pago;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;
import pe.pamperurpet.pamperurpetapp.entities.Reserva;
import pe.pamperurpet.pamperurpetapp.exceptions.PropietarioNotFoundException;
import pe.pamperurpet.pamperurpetapp.exceptions.ReservaNotFoundException;
import pe.pamperurpet.pamperurpetapp.interfaceservice.PropietarioService;
import pe.pamperurpet.pamperurpetapp.interfaceservice.ReservaService;
import pe.pamperurpet.pamperurpetapp.services.PagoServiceImpl;
import pe.pamperurpet.pamperurpetapp.services.PaseadorServiceImpl;
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
    @Autowired //inyectando
    private PaseadorServiceImpl paseadorServiceImpl;
    @Autowired //inyectando
    private PagoServiceImpl pagoServiceImpl;
    @Autowired //inyectando
    private PropietarioServiceImpl propietarioServiceImpl;

    @PostMapping("/reserva")
    public ResponseEntity<ReservaDTO> register(@RequestBody ReservaDTO reservaDTO){
        Reserva reserva = convertToEntity(reservaDTO);
        reserva = reservaServiceImpl.register(reserva);
        reservaDTO = convertToDto(reserva);
        return new ResponseEntity<ReservaDTO>(reservaDTO, HttpStatus.OK);
    }

    @PostMapping("/reserva/paseador/{id_pas}")
    public ResponseEntity<ReservaDTO> createReservaWithPaseador(@PathVariable Long id_pas, @RequestBody ReservaDTO reservaDTO) {
        try {
            // Buscar al paseador por su ID utilizando paseadorServiceImpl
            Paseador paseador = paseadorServiceImpl.getPaseadorById(id_pas);

            // Convertir el DTO de reserva a entidad Reserva
            Reserva reserva = convertToEntity(reservaDTO);

            // Establecer la relación con el paseador
            reserva.setPaseador(paseador);

            // Registrar la reserva
            reserva = reservaServiceImpl.register(reserva);

            // Convertir la entidad reserva a DTO
            reservaDTO = convertToDto(reserva);

            return new ResponseEntity<>(reservaDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reserva/pago/{id_pago}")
    public ResponseEntity<ReservaDTO> createReservaWithPago(@PathVariable Long id_pago, @RequestBody ReservaDTO reservaDTO) {
        try {
            // Buscar el pago por su ID utilizando pagoServiceImpl
            Pago pago = pagoServiceImpl.getPagoById(id_pago);

            // Convertir el DTO de reserva a entidad Reserva
            Reserva reserva = convertToEntity(reservaDTO);

            // Establecer la relación con el pago
            reserva.setPago(pago);

            // Registrar la reserva
            reserva = reservaServiceImpl.register(reserva);

            // Convertir la entidad reserva a DTO
            reservaDTO = convertToDto(reserva);

            return new ResponseEntity<>(reservaDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reserva/propietario/{propietarioid}")
    public ResponseEntity<ReservaDTO> createReservaWithPropietario(@PathVariable Long propietarioid, @RequestBody ReservaDTO reservaDTO) {
        try {
            // Buscar al propietario por su ID utilizando propietarioServiceImpl
            Propietario propietario = propietarioServiceImpl.getPropietarioById(propietarioid);

            // Convertir el DTO de reserva a entidad Reserva
            Reserva reserva = convertToEntity(reservaDTO);

            // Establecer la relación con el propietario
            reserva.setPropietario(propietario);

            // Registrar la reserva
            reserva = reservaServiceImpl.register(reserva);

            // Convertir la entidad reserva a DTO
            reservaDTO = convertToDto(reserva);

            return new ResponseEntity<>(reservaDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reserva/{id_pago}/{id_pas}/{propietarioid}")
    public ResponseEntity<ReservaDTO> createReservaWithEntities(
            @PathVariable Long id_pago,
            @PathVariable Long id_pas,
            @PathVariable Long propietarioid,
            @RequestBody ReservaDTO reservaDTO) {
        try {
            // Buscar el pago por su ID utilizando pagoServiceImpl
            Pago pago = pagoServiceImpl.getPagoById(id_pago);

            // Buscar al paseador por su ID utilizando paseadorServiceImpl
            Paseador paseador = paseadorServiceImpl.getPaseadorById(id_pas);

            // Buscar al propietario por su ID utilizando propietarioServiceImpl
            Propietario propietario = propietarioServiceImpl.getPropietarioById(propietarioid);

            // Convertir el DTO de reserva a entidad Reserva
            Reserva reserva = convertToEntity(reservaDTO);

            // Establecer las relaciones
            reserva.setPaseador(paseador);
            reserva.setPago(pago);
            reserva.setPropietario(propietario);

            // Registrar la reserva
            reserva = reservaServiceImpl.register(reserva);

            // Convertir la entidad reserva a DTO
            reservaDTO = convertToDto(reserva);

            return new ResponseEntity<>(reservaDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
