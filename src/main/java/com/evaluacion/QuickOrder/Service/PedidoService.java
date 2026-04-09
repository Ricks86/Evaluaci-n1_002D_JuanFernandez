package com.evaluacion.QuickOrder.Service;

import com.evaluacion.QuickOrder.Model.Pedido;
import com.evaluacion.QuickOrder.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que cotiene la logica de negocio para la gestion de pedidos
 * Coordina las operaciones entre controller y el Repository
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    //devuelve la lista de productos
    public List<Pedido> getListaPedidos(){
        return pedidoRepository.obtenerListaDePedidos();
    }
    //Buscar un pedido en el sistema buscado su id
    public Pedido getPedidoPorId(int id){
        //valida que no este vacia la consulta
        if(pedidoRepository.obtenerPedidoPorId(id) == null) {
            throw new RuntimeException("Pedido no encontrado");
        }
        return pedidoRepository.obtenerPedidoPorId(id);
    }
    //Agrega un nuevo pedido
    public void postNuevoPedido(Pedido pedido){
        //verifica que no este vacio el objeto
        if(pedido == null){
            throw new RuntimeException("Debe agregar el pedido");
        //Verifica que el monto no sea 0
        } else if (pedido.getMontoTotal()<= 0) {
            throw new RuntimeException("Debe agregar el pedido");

        }
        pedidoRepository.agregarPedido(pedido);
    }

    public void modificarPedido(Pedido pedido){
        pedidoRepository.actualizarPedido(pedido);
    }

    public void borrarPedido(int id){
        if(pedidoRepository.obtenerPedidoPorId(id) == null){
            throw new RuntimeException("Pedido no encontrado");
        }
        pedidoRepository.eliminarPedido(id);
    }
    public List<Pedido> getListaPedidosOrdenado(String estado){
        return pedidoRepository.obtenerListaDePedidosPorEstado(estado);
    }
}
