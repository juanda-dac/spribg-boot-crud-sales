package ute.edu.java.corte2.model;

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
@Table(name = Sale.TABLE_NAME)
public class Sale {
    public static final String TABLE_NAME = "venta";

    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "cedulaCliente")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private User user;
    private double ivaVenta;
    private double totalVenta;
    private double valorVenta;

    public Sale() {
        super();
    }

    public Sale(int id, Client client, User user, double ivaVenta, double totalVenta, double valorVenta) {
        super();
        this.id = id;
        this.client = client;
        this.user = user;
        this.ivaVenta = ivaVenta;
        this.totalVenta = totalVenta;
        this.valorVenta = valorVenta;
    }

    @Override
    public String toString() {
        return "Sale [client=" + client.toString() + ", id=" + id + ", ivaVenta=" + ivaVenta + ", totalVenta="
                + totalVenta + ", user=" + user.toString() + ", valorVenta=" + valorVenta + "]";
    }
}
