package pe.pamperurpet.pamperurpetapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Data
@Transactional
@NoArgsConstructor
@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id_admin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_propietario_id")
    private Propietario propietario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_pas")
    private Paseador paseador;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_mas")
    private Mascota mascota;

    public Admin(Long id_admin) {
        this.id_admin = id_admin;
    }

    public Long getId_admin() {
        return id_admin;
    }

    public void setId_admin(Long id_admin) {
        this.id_admin = id_admin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id_admin=" + id_admin +
                '}';
    }
}
