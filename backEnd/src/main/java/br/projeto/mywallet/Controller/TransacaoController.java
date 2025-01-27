package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Transacao;
import br.projeto.mywallet.Service.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {

    @Autowired
    private ITransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao) {
        return ResponseEntity.ok(transacaoService.criarTransacao(transacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizarTransacao(@PathVariable Long id, @RequestBody Transacao transacaoAtualizada) {
        return ResponseEntity.ok(transacaoService.atualizarTransacao(id, transacaoAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTransacao(@PathVariable Long id) {
        transacaoService.deletarTransacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTodas() {
        return ResponseEntity.ok(transacaoService.listarTodas());
    }
}
