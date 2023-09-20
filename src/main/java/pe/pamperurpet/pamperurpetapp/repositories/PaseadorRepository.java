package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.pamperurpet.pamperurpetapp.entities.Mascota;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;

import java.util.Optional;

@Repository
public interface PaseadorRepository extends JpaRepository<Paseador,Long> {
    Optional<Paseador> findById(Long id_pas);
}
