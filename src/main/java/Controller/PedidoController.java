package Controller;

import Model.Pedido;
import Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ApiEv1/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.getListaPedidos();
    }

    @GetMapping("/{id}")
    public Pedido buscarID(@PathVariable int id){
        return pedidoService.getPedidoPorId(id);
    }

    @PostMapping
    public void agregarPedido(@RequestBody Pedido pedido){
        pedidoService.postNuevoPedido(pedido);
    }

    @PutMapping("/{id}")
    public void actualizarPedido(@PathVariable int id, @RequestBody Pedido pedido) {
        pedidoService.modificarPedido(pedido);
    }

    @DeleteMapping("{id}")
    public void eliminarPedido(@PathVariable int id) {
        pedidoService.borrarPedido(id);
    }
    @GetMapping("/estado/{estado}")
    public List<Pedido> buscarPorEstado(@PathVariable String estado){
        return pedidoService.getListaPedidosOrdenado(estado);
    }
}
