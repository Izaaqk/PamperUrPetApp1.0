package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.pamperurpet.pamperurpetapp.entities.Pago;

public interface PagoRepository extends JpaRepository<Pago,Long> {
}
