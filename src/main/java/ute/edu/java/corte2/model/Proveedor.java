package ute.edu.java.corte2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = Proveedor.TABLE_NAME)
public class Proveedor {
    public static final String TABLE_NAME = "proveedor";

    @Id
    private int nit;
    private String ciudad;
    private String direccion;
    private String nombre;
    private String telefono;

    public Proveedor() {
        super();
    }

    public Proveedor(int nit, String ciudad, String direccion, String nombre, String telefono) {
        super();
        this.nit = nit;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedor [ciudad=" + ciudad + ", direccion=" + direccion + ", nit=" + nit + ", nombre=" + nombre
                + ", telefono=" + telefono + "]";
    }
}
