package pe.pamperurpet.pamperurpetapp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@Data
public class PropietarioDTO {
    private Long propietarioid;
    private String nombreprop;
    private String apellidoprop;
    private String ubicacionprop;
    private Long telefonoprop;

    public PropietarioDTO(Long propietarioid, String nombreprop, String apellidoprop, String ubicacionprop, Long telefonoprop) {
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
        return "PropietarioDTO{" +
                "propietarioid=" + propietarioid +
                ", nombreprop='" + nombreprop + '\'' +
                ", apellidoprop='" + apellidoprop + '\'' +
                ", ubicacionprop='" + ubicacionprop + '\'' +
                ", telefonoprop=" + telefonoprop +
                '}';
    }
}
