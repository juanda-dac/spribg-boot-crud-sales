package ute.edu.java.corte2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = Product.TABLE_NAME)
public class Product {
    public static final String TABLE_NAME = "productos";

    @Id
    private int codigo;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "nitproveedor")
    private Proveedor proveedor;
    @Column(name = "precio_compra")
    private double precioCompra;
    private double iva;
    @Column(name = "precio_venta")
    private double precioVenta;

    public Product() {
        super();
    }

    public Product(int codigo, String nombre, Proveedor proveedor, double precioCompra, double iva, double precioVenta) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precioCompra = precioCompra;
        this.iva = iva;
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Product [codigo=" + codigo + ", iva=" + iva + ", nombre=" + nombre + ", precioCompra=" + precioCompra
                + ", precioVenta=" + precioVenta + ", proveedor=" + proveedor + "]";
    }


}
