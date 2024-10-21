package ute.edu.java.corte2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = Client.TABLE_NAME)
public class Client {
    public static final String TABLE_NAME = "cliente";

    @Id
    private int cedula;
    private String nombrecompleto;
    private String direccion;
    private String telefono;
    private String correo;
}
