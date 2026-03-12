package servicio;

import com.practica.servicio.product.Objeto;

import java.util.ArrayList;

public class ServiceProducto {
        ArrayList<Objeto> objetos = new ArrayList<>();

        public ServiceProducto() {
                objetos.add(new Objeto(1, 100.0, "Producto 1", "Categoria 1"));
                objetos.add(new Objeto(2, 200.0, "Producto 2", "Categoria 2"));
                objetos.add(new Objeto(3, 300.0, "Producto 3", "Categoria 3"));
        }

        public ArrayList<Objeto> getProductos() {
                return objetos;
        }

        public Objeto getProducto(int id) {
                for (Objeto producto : objetos) {
                        if (producto.getId() == id) {
                                return producto;
                        }
                }
                return null;
        }
}
