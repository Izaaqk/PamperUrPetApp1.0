package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.pamperurpet.pamperurpetapp.entities.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota,Long> {
}
