package pe.pamperurpet.pamperurpetapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propietarioid;
    @Column(name = "nombreprop", length = 20)
    private String nombreprop;
    @Column(name = "apellidoprop", length = 20)
    private String apellidoprop;
    @Column(name = "ubicacionprop", length = 35)
    private String ubicacionprop;
    private Long telefonoprop;



    public Propietario(Long propietarioid, String nombreprop, String apellidoprop, String ubicacionprop, Long telefonoprop) {
        this.propietarioid = propietarioid;
        this.nombreprop = nombreprop;
        this.apellidoprop = apellidoprop;
        this.ubicacionprop = ubicacionprop;
        this.telefonoprop = telefonoprop;
    }

    public Long getPropietarioid() {
        return propietarioid;
    }

    public void setPropietarioid(Long propietarioid) {
        this.propietarioid = propietarioid;
    }

    public String getNombreprop() {
        return nombreprop;
    }

    public void setNombreprop(String nombreprop) {
        this.nombreprop = nombreprop;
    }

    public String getApellidoprop() {
        return apellidoprop;
    }

    public void setApellidoprop(String apellidoprop) {
        this.apellidoprop = apellidoprop;
    }

    public String getUbicacionprop() {
        return ubicacionprop;
    }

    public void setUbicacionprop(String ubicacionprop) {
        this.ubicacionprop = ubicacionprop;
    }

    public Long getTelefonoprop() {
        return telefonoprop;
    }

    public void setTelefonoprop(Long telefonoprop) {
        this.telefonoprop = telefonoprop;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "propietarioid=" + propietarioid +
                ", nombreprop='" + nombreprop + '\'' +
                ", apellidoprop='" + apellidoprop + '\'' +
                ", ubicacionprop='" + ubicacionprop + '\'' +
                ", telefonoprop=" + telefonoprop +
                '}';
    }
}
