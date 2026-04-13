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
    //inicialización de pedidoRepository para acceder a sus metodos
    @Autowired
    private PedidoRepository pedidoRepository;
    //logica para obtener la lista de pedidos, no necesita nada más pues es lo que el usuario ve nada más iniciar
    public List<Pedido> getListaPedidos(){
        return pedidoRepository.obtenerListaDePedidos();
    }
    //logica para obtener un pedido por su id
    public Pedido getPedidoPorId(int id){
        //valida que el id entregado sea un id valido
        if(pedidoRepository.obtenerPedidoPorId(id) == null) {
            throw new RuntimeException("Pedido no encontrado");
        }
        return pedidoRepository.obtenerPedidoPorId(id);
    }
    //Agrega un nuevo pedido
    public void postNuevoPedido(Pedido pedido){
        //usamos un metodo validar campos, ya que las anotaciones no me funciona y o hice manual
        //para no tener que validar todo cada vez que se quiere agregar un objeto
        validarCampos(pedido);
        pedidoRepository.agregarPedido(pedido);
    }
    //Logica para modificar pedido
    public void modificarPedido(Pedido pedido){
        //valida que exista un pedido al cual reemplazar
        if (pedidoRepository.obtenerPedidoPorId(pedido.getId()) == null) {
            throw new RuntimeException("Pedido no encontrado");
        }
        //se asigna la misma fecha en la que fue creado el producto
        pedido.setFechaPedido(pedidoRepository.obtenerPedidoPorId(pedido.getId()).getFechaPedido());
        //valida los campos introducidos
        validarCampos(pedido);
        pedidoRepository.actualizarPedido(pedido);
    }

    public void borrarPedido(int id){
        //valida que exista un pedido con ese id
        if(pedidoRepository.obtenerPedidoPorId(id) == null){
            throw new RuntimeException("Pedido no encontrado");
        }
        pedidoRepository.eliminarPedido(id);
    }
    public List<Pedido> getListaPedidosOrdenado(String estado){
        //valida que no se ingrese un String nullo o vacio
        if(estado.isBlank()){
            throw new RuntimeException("Estado no encontrado");
        }
        return pedidoRepository.obtenerListaDePedidosPorEstado(estado);
    }
    //metodo de validacion, a falta de las anotaciones he agregado un metodo manual de validación
    //este verifica cada campo y su correspondiente dato, si cumple la condición suelta un error que será manejado en el controller
    //con ResponseEntity y visualizar mejor el error
    public void validarCampos(Pedido pedido){
        if(pedido.getMontoTotal() <= 0){
            throw new RuntimeException("Debe agregar un monto valido");
        }
        if(pedido.getNombreCliente()== null || pedido.getNombreCliente().isBlank()){
            throw new RuntimeException("Debe agregar el nombre del cliente");
        }
        if(pedido.getDescripcion()== null || pedido.getDescripcion().isBlank()){
            throw new RuntimeException("Debe agregar la descripcion del pedido");
        }
        if(pedido.getTipoPedido() == null){
            throw new RuntimeException("Debe agregar el Tipo de pedido");
        }
        if(pedido.getEstado()== null){
            throw new RuntimeException("Debe agregar el estado del pedido");
        }
    }
}
