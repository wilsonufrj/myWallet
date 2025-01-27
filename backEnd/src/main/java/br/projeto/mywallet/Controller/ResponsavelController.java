package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Responsavel;
import br.projeto.mywallet.Service.IResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsaveis")
public class ResponsavelController {

    @Autowired
    private IResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<Responsavel> criarResponsavel(@RequestBody Responsavel responsavel) {
        return ResponseEntity.ok(responsavelService.criarResponsavel(responsavel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> atualizarResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        return ResponseEntity.ok(responsavelService.atualizarResponsavel(id, responsavel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarResponsavel(@PathVariable Long id) {
        responsavelService.deletarResponsavel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(responsavelService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> listarTodos() {
        return ResponseEntity.ok(responsavelService.listarTodos());
    }
}
