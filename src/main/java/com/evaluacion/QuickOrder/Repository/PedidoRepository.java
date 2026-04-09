package com.evaluacion.QuickOrder.Repository;

import com.evaluacion.QuickOrder.Model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {
    public List<Pedido> pedidoRepository = new ArrayList<>();

    public List<Pedido> obtenerListaDePedidos(){
        return pedidoRepository;
    }

    public Pedido obtenerPedidoPorId(int id){
        for (Pedido pedido : pedidoRepository) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public void agregarPedido (Pedido pedido){
        pedido.setId(pedidoRepository.size()+1);
        pedidoRepository.add(pedido);
    }

    public void actualizarPedido (Pedido pedidoActualizado){
        int idPedido = 0;
        int idPoscicion = 0;

        for (int i = 0; i < pedidoRepository.size(); i++) {
            if (pedidoRepository.get(i).getId() == pedidoActualizado.getId()){
                idPedido = pedidoRepository.get(i).getId();
                idPoscicion = i;
                break;
            }
        }
        Pedido pedidoCambiado = new Pedido();
        pedidoCambiado.setId(pedidoActualizado.getId());
        pedidoCambiado.setNombreCliente(pedidoActualizado.getNombreCliente());
        pedidoCambiado.setDescripcion(pedidoActualizado.getDescripcion());
        pedidoCambiado.setEstado(pedidoActualizado.getEstado());
        pedidoCambiado.setTipoPedido(pedidoActualizado.getTipoPedido());
        pedidoCambiado.setMontoTotal(pedidoActualizado.getMontoTotal());
        pedidoCambiado.setFechaPedido(pedidoActualizado.getFechaPedido());
    }

    public void eliminarPedido (int idPedido){
        Pedido pedidoEliminado = obtenerPedidoPorId(idPedido);
        if (pedidoEliminado != null) {
            pedidoRepository.remove(pedidoEliminado);
        }
    }

    public List<Pedido> obtenerListaDePedidosPorEstado(String estado){
        List<Pedido> pedidosOrdenados = new ArrayList<>();
        for (Pedido pedido : pedidoRepository) {
            if (pedido.getEstado().equals(estado)){
                pedidosOrdenados.add(pedido);
            }
        }
        return pedidosOrdenados;
    }
}
