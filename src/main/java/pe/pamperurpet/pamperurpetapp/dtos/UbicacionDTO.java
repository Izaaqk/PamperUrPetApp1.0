package pe.pamperurpet.pamperurpetapp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UbicacionDTO {
    private Long id_ubicacion;
    private String coordenada;
    private String fecha;

    public UbicacionDTO(Long id_ubicacion, String coordenada, String fecha) {
        this.id_ubicacion = id_ubicacion;
        this.coordenada = coordenada;
        this.fecha = fecha;
    }

    public Long getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(Long id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "UbicacionDTO{" +
                "id_ubicacion=" + id_ubicacion +
                ", coordenada='" + coordenada + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
