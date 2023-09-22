package pe.pamperurpet.pamperurpetapp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class AdminDTO {
    private Long id_admin;
    private Long id_prop;
    private Long id_pas;
    private Long id_mas;

    public AdminDTO(Long id_admin, Long id_mas, Long id_prop, Long id_pas) {
        this.id_admin = id_admin;
        this.id_prop = id_prop;
        this.id_pas = id_pas;
        this.id_mas = id_mas;
    }

    public Long getId_admin() {return id_admin;}

    public void setId_admin(Long id_admin) {this.id_admin = id_admin;}

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

    public Long getId_mas() {return id_mas;}

    public void setId_mas(Long id_mas) {
        this.id_mas = id_mas;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "id_admin=" + id_admin +
                ", id_prop=" + id_prop +
                ", id_pas=" + id_pas +
                ", id_mas=" + id_mas +
                '}';
    }
}
