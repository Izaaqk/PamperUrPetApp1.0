package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.pamperurpet.pamperurpetapp.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
}
