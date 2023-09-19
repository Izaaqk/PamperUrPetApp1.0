package pe.pamperurpet.pamperurpetapp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PagoDTO {
    private Long id_pago;
    private Long id_serv;
    private String metodo_pago;
    private String estado_pago;

    public PagoDTO(Long id_pago, Long id_serv, String metodo_pago, String estado_pago) {
        this.id_pago = id_pago;
        this.id_serv = id_serv;
        this.metodo_pago = metodo_pago;
        this.estado_pago = estado_pago;
    }

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public Long getId_serv() {
        return id_serv;
    }

    public void setId_serv(Long id_serv) {
        this.id_serv = id_serv;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }

    @Override
    public String toString() {
        return "PagoDTO{" +
                "id_pago=" + id_pago +
                ", id_serv=" + id_serv +
                ", metodo_pago='" + metodo_pago + '\'' +
                ", estado_pago='" + estado_pago + '\'' +
                '}';
    }
}
