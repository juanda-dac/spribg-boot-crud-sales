package ute.edu.java.corte2.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "usuario";

    @Id
    @Column(name = "idUsuario", length = 11)
    private int idUsuario;
    @Column(name = "nombreUsuario", length = 50)
    private String nombreUsuario;
    @Column(name = "clave", length = 50)
    private String clave;
    @Column(name = "correo", length = 50)
    private String correo;
    @Column(name = "tipoUsuario", length = 50)
    private String tipoUsuario;

    public User() {
        super();
    }

    public User(int idUsuario, String nombreUsuario, String clave, String correo, String tipoUsuario) {
        super();
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "User [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave + ", correo="
                + correo + ", tipoUsuario=" + tipoUsuario + "]";
    }
}
