package com.evaluacion.QuickOrder.Controller;

import com.evaluacion.QuickOrder.Model.Pedido;
import com.evaluacion.QuickOrder.Service.PedidoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que gestiona la comunicación con Http y endpoints
 * con ResponseEntity para tener un mejor manejo de las respuestas dadas por la maquina
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    //se incializa la clase Service para poder usar sus metodos
    @Autowired
    private PedidoService pedidoService;
    //obtiene la lista de pedidos y al no especificar ruta se abrirá siempre al inicio
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        //devuelve un ok (200) al ejecutarse
        return ResponseEntity.ok(pedidoService.getListaPedidos());
    }
    //a base de una id proporcionada busca un pedido en especifico
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarID(@PathVariable int id){
        //devuelve un ok si todo va bien
        try {
            return ResponseEntity.ok(pedidoService.getPedidoPorId(id));
            //atrapada aquí un error y devuelve un 404 notfound en caso de no encontrase un id
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    // a base de un cuerpo de pedido se crea un nuevo pedido
    @PostMapping
    public ResponseEntity<?> agregarPedido(@RequestBody Pedido pedido){
        try {
            //se ejecuta el metodo
            pedidoService.postNuevoPedido(pedido);
            //en caso de pasar sin errores devuelve la respuesta de status Created con el pedido para ver el pedido creado
            return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
        }catch (Exception e){
            //en caso de fallar en alguna parte de la validación devuelve un mensaje correspondiente a los throw agregados
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //a base un cuerpo de pedido se busca el pedido y se cambia por el ingresado
    @PutMapping()
    public ResponseEntity<?> actualizarPedido(@RequestBody Pedido pedido) {
        //ejecuta el metodo de pedido
        try {
            pedidoService.modificarPedido(pedido);
            //en caso de pasar sin errores devuelve un ok con con el pedidod actualizado
            return ResponseEntity.ok(pedido);
        }catch (Exception e){
            //en caso de fallar e igual que el metodo anterior devuelve un error con el mensaje respectivo
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //metodo para eliminar a base de una id
    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable int id) {
        try {
            //se ejecuta el metodo
            pedidoService.borrarPedido(id);
            //al finalizar se devuelve un mensaje de exito sin contenido, pues se acaba de borrar
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            //en caso de fallar en alguna parte del trayecto se devuelve un error con su respectivo mensaje
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //con un String de estado se busca los pedidos con los mismos estados
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pedido>> buscarPorEstado(@PathVariable String estado){
        //se ejecuta el metodo y en caso de no haber errores devuelve un ok
        try {
            return ResponseEntity.ok(pedidoService.getListaPedidosOrdenado(estado));
        }catch (Exception e){
            //al no encontrar ninguna coincidencia o fallar e alguna parte del trayecto lanzara un Not_found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
