package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.pamperurpet.pamperurpetapp.entities.Paseador;

@Repository
public interface PaseadorRepository extends JpaRepository<Paseador,Long> {
}
