package pe.pamperurpet.pamperurpetapp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MascotaDTO {
    private Long id_mas;
    private Long id_prop;
    private Long id_pas;
    private Long edad_mas;

    public MascotaDTO(Long id_mas, Long id_prop, Long id_pas, Long edad_mas) {
        this.id_mas = id_mas;
        this.id_prop = id_prop;
        this.id_pas = id_pas;
        this.edad_mas = edad_mas;
    }

    public Long getId_mas() {
        return id_mas;
    }

    public void setId_mas(Long id_mas) {
        this.id_mas = id_mas;
    }

    public Long getId_prop() {
        return id_prop;
    }

    public void setId_prop(Long id_prop) {
        this.id_prop = id_prop;
    }

    public Long getId_pas() {
        return id_pas;
    }

    public void setId_pas(Long id_pas) {
        this.id_pas = id_pas;
    }

    public Long getEdad_mas() {
        return edad_mas;
    }

    public void setEdad_mas(Long edad_mas) {
        this.edad_mas = edad_mas;
    }

    @Override
    public String toString() {
        return "MascotaDTO{" +
                "id_mas=" + id_mas +
                ", id_prop=" + id_prop +
                ", id_pas=" + id_pas +
                ", edad_mas=" + edad_mas +
                '}';
    }
}
