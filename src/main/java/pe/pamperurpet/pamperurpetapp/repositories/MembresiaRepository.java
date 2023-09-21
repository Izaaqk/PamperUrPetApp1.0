package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.pamperurpet.pamperurpetapp.entities.Membresia;
import pe.pamperurpet.pamperurpetapp.entities.Reserva;

import java.util.Optional;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia,Long> {

    Optional<Membresia> findById(Long id_memb);
}
