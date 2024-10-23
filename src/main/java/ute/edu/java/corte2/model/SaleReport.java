package ute.edu.java.corte2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = SaleReport.TABLE_NAME)
public class SaleReport {
    
    public static final String TABLE_NAME = "detalleventa";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Product producto;
    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Sale venta;
    @Column(name = "cantidadProducto")
    private int cantidadProducto;
    @Column(name = "valorTotal")
    private double valorTotal;
    @Column(name = "valorVenta")
    private double valorVenta;
    @Column(name = "valorIva")
    private double valorIva;

    public SaleReport() {
        super();
    }

    public SaleReport(int id, Product producto, Sale venta, int cantidadProducto, double valorTotal, double valorVenta,
            double valorIva) {
        super();
        this.id = id;
        this.producto = producto;
        this.venta = venta;
        this.cantidadProducto = cantidadProducto;
        this.valorTotal = valorTotal;
        this.valorVenta = valorVenta;
        this.valorIva = valorIva;
    }

    @Override
    public String toString() {
        return "SaleReport [cantidadProducto=" + cantidadProducto + ", id=" + id + ", producto=" + producto.toString()
                + ", valorIva=" + valorIva + ", valorTotal=" + valorTotal + ", valorVenta=" + valorVenta
                + ", venta=" + venta.toString() + "]";
    }
}
