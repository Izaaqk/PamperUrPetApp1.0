package pe.pamperurpet.pamperurpetapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reser;
    private Long id_pas;
    private Long id_prop;
    private String inicio_reser;
    private String fin_reser;

    public Reserva(Long id_reser, Long id_pas, Long id_prop, String inicio_reser, String fin_reser) {
        this.id_reser = id_reser;
        this.id_pas = id_pas;
        this.id_prop = id_prop;
        this.inicio_reser = inicio_reser;
        this.fin_reser = fin_reser;
    }

    public Long getId_reser() {
        return id_reser;
    }

    public void setId_reser(Long id_reser) {
        this.id_reser = id_reser;
    }

    public Long getId_pas() {
        return id_pas;
    }

    public void setId_pas(Long id_pas) {
        this.id_pas = id_pas;
    }

    public Long getId_prop() {
        return id_prop;
    }

    public void setId_prop(Long id_prop) {
        this.id_prop = id_prop;
    }

    public String getInicio_reser() {
        return inicio_reser;
    }

    public void setInicio_reser(String inicio_reser) {
        this.inicio_reser = inicio_reser;
    }

    public String getFin_reser() {
        return fin_reser;
    }

    public void setFin_reser(String fin_reser) {
        this.fin_reser = fin_reser;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id_reser=" + id_reser +
                ", id_pas=" + id_pas +
                ", id_prop=" + id_prop +
                ", inicio_reser='" + inicio_reser + '\'' +
                ", fin_reser='" + fin_reser + '\'' +
                '}';
    }
}
