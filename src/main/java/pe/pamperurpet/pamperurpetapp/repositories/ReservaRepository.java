package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;
import pe.pamperurpet.pamperurpetapp.entities.Reserva;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {

    Optional<Reserva> findById(Long id_reser);
}
