package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Status;
import br.projeto.mywallet.Service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private IStatusService statusService;

    @PostMapping
    public ResponseEntity<Status> criarStatus(@RequestBody Status status) {
        return ResponseEntity.ok(statusService.criarStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> atualizarStatus(@PathVariable Long id, @RequestBody Status status) {
        return ResponseEntity.ok(statusService.atualizarStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarStatus(@PathVariable Long id) {
        statusService.deletarStatus(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(statusService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Status>> listarTodos() {
        return ResponseEntity.ok(statusService.listarTodos());
    }
}
