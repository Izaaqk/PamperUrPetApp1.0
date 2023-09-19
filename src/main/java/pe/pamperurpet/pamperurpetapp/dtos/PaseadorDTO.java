package pe.pamperurpet.pamperurpetapp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PaseadorDTO {
    private Long id_pas;
    private String apellido_pas;
    private String ubicacion_pas;
    private Long telefono_pas;

    public PaseadorDTO(Long id_pas, String apellido_pas, String ubicacion_pas, Long telefono_pas) {
        this.id_pas = id_pas;
        this.apellido_pas = apellido_pas;
        this.ubicacion_pas = ubicacion_pas;
        this.telefono_pas = telefono_pas;
    }

    public Long getId_pas() {
        return id_pas;
    }

    public void setId_pas(Long id_pas) {
        this.id_pas = id_pas;
    }

    public String getApellido_pas() {
        return apellido_pas;
    }

    public void setApellido_pas(String apellido_pas) {
        this.apellido_pas = apellido_pas;
    }

    public String getUbicacion_pas() {
        return ubicacion_pas;
    }

    public void setUbicacion_pas(String ubicacion_pas) {
        this.ubicacion_pas = ubicacion_pas;
    }

    public Long getTelefono_pas() {
        return telefono_pas;
    }

    public void setTelefono_pas(Long telefono_pas) {
        this.telefono_pas = telefono_pas;
    }

    @Override
    public String toString() {
        return "PaseadorDTO{" +
                "id_pas=" + id_pas +
                ", apellido_pas='" + apellido_pas + '\'' +
                ", ubicacion_pas='" + ubicacion_pas + '\'' +
                ", telefono_pas=" + telefono_pas +
                '}';
    }
}
