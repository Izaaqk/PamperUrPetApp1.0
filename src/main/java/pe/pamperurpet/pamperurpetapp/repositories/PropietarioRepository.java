package pe.pamperurpet.pamperurpetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;

import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario,Long> {

}
