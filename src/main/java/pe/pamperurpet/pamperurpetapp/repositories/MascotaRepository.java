package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.pamperurpet.pamperurpetapp.entities.Mascota;
@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {
}
