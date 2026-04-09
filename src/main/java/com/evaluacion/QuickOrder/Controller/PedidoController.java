package com.evaluacion.QuickOrder.Controller;

import com.evaluacion.QuickOrder.Model.Pedido;
import com.evaluacion.QuickOrder.Service.PedidoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        return ResponseEntity.ok(pedidoService.getListaPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarID(@PathVariable int id){
        try {
            return ResponseEntity.ok(pedidoService.getPedidoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarPedido(@RequestBody Pedido pedido){
        pedidoService.postNuevoPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body("pedido guardo:"+pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPedido(@Validated @RequestBody Pedido pedido) {
        pedidoService.modificarPedido(pedido);
        return ResponseEntity.ok("pedido actualizado:"+pedido);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable int id) {
        try {
            pedidoService.borrarPedido(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pedido>> buscarPorEstado(@PathVariable String estado){
            return ResponseEntity.ok(pedidoService.getListaPedidos());
    }
}
