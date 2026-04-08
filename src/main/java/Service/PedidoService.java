package Service;

import Model.Pedido;
import Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getListaPedidos(){
        return pedidoRepository.obtenerListaDePedidos();
    }

    public Pedido getPedidoPorId(int id){
        return pedidoRepository.obtenerPedidoPorId(id);
    }

    public void postNuevoPedido(Pedido pedido){
        pedidoRepository.agregarPedido(pedido);
    }

    public void modificarPedido(Pedido pedido){
        pedidoRepository.actualizarPedido(pedido);
    }

    public void borrarPedido(int id){
        pedidoRepository.eliminarPedido(id);
    }
    public List<Pedido> getListaPedidosOrdenado(String estado){
        return pedidoRepository.obtenerListaDePedidosPorEstado(estado);
    }
}
