package com.evaluacion.QuickOrder.Repository;

import com.evaluacion.QuickOrder.Model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//clase Repository para crear todo los metodos CRUD
@Repository
public class PedidoRepository {
    //Creamos nueva Arraylist para guardar los pedidos
    public List<Pedido> pedidoRepository = new ArrayList<>();
    //metodo que devuelve la lista de pedidos
    public List<Pedido> obtenerListaDePedidos(){
        return pedidoRepository;
    }
    //Metodo que obtiene el id, recorriendo la lista y comparando id consultada con las id de las listas
    public Pedido obtenerPedidoPorId(int id){
        for (Pedido pedido : pedidoRepository) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
    //Metodo para agregar el pedido el id se asigna en este metodo
    public void agregarPedido (Pedido pedido){
        pedido.setId(pedidoRepository.size()+1);
        pedidoRepository.add(pedido);
    }
    //Metodo para actualizar un pedido, recorre todo el largo de la lista comparando la id entregada y si encuentra cambia el objeto encontrado por el nuevo
    public void actualizarPedido (Pedido pedidoActualizado){
        for (int i = 0; i < pedidoRepository.size(); i++) {
            if (pedidoRepository.get(i).getId() == pedidoActualizado.getId()){
                pedidoRepository.set(i, pedidoActualizado);
                break;
            }
        }
    }
    //Metodo para eliminar un pedido, usando el metodo anterior para buscr un pedido por id
    public void eliminarPedido (int idPedido){
        Pedido pedidoEliminado = obtenerPedidoPorId(idPedido);
        if (pedidoEliminado != null) {
            pedidoRepository.remove(pedidoEliminado);
        }
    }
    //Metodo para obtener una lista ordenada con el estado correspondiendo, crea una nueva lista donde iran los pedidos solicitados
    public List<Pedido> obtenerListaDePedidosPorEstado(String estado){
        List<Pedido> pedidosOrdenados = new ArrayList<>();
        for (Pedido pedido : pedidoRepository) {
            if (pedido.getEstado().name().equalsIgnoreCase(estado)) {
                pedidosOrdenados.add(pedido);
            }
        }
        return pedidosOrdenados;
    }
}
