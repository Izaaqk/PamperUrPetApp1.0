package pe.pamperurpet.pamperurpetapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_memb;
    private String inicio_memb;
    private String fin_memb;
    private Long precio_memb;

    public Membresia(Long id_memb, String inicio_memb, String fin_memb, Long precio_memb) {
        this.id_memb = id_memb;
        this.inicio_memb = inicio_memb;
        this.fin_memb = fin_memb;
        this.precio_memb = precio_memb;
    }

    public Long getId_memb() {
        return id_memb;
    }

    public void setId_memb(Long id_memb) {
        this.id_memb = id_memb;
    }

    public String getInicio_memb() {
        return inicio_memb;
    }

    public void setInicio_memb(String inicio_memb) {
        this.inicio_memb = inicio_memb;
    }

    public String getFin_memb() {
        return fin_memb;
    }

    public void setFin_memb(String fin_memb) {
        this.fin_memb = fin_memb;
    }

    public Long getPrecio_memb() {
        return precio_memb;
    }

    public void setPrecio_memb(Long precio_memb) {
        this.precio_memb = precio_memb;
    }

    @Override
    public String toString() {
        return "Membresia{" +
                "id_memb=" + id_memb +
                ", inicio_memb='" + inicio_memb + '\'' +
                ", fin_memb='" + fin_memb + '\'' +
                ", precio_memb=" + precio_memb +
                '}';
    }
}
