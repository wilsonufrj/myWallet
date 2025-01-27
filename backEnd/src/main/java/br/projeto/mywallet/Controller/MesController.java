package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Mes;
import br.projeto.mywallet.Service.IMesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meses")
public class MesController {

    @Autowired
    private IMesService mesService;

    @PostMapping
    public ResponseEntity<Mes> criarMes(@RequestBody Mes mes) {
        return ResponseEntity.ok(mesService.criarMes(mes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mes> atualizarMes(@PathVariable Long id, @RequestBody Mes mes) {
        return ResponseEntity.ok(mesService.atualizarMes(id, mes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMes(@PathVariable Long id) {
        mesService.deletarMes(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mes> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mesService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Mes>> listarTodos() {
        return ResponseEntity.ok(mesService.listarTodos());
    }
}
