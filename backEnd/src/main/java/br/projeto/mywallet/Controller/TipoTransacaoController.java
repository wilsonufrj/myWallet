package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.TipoTransacao;
import br.projeto.mywallet.Service.ITipoTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-transacao")
public class TipoTransacaoController {

    @Autowired
    private ITipoTransacaoService tipoTransacaoService;

    @PostMapping
    public ResponseEntity<TipoTransacao> criarTipoTransacao(@RequestBody TipoTransacao tipoTransacao) {
        return ResponseEntity.ok(tipoTransacaoService.criarTipoTransacao(tipoTransacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoTransacao> atualizarTipoTransacao(@PathVariable Long id, @RequestBody TipoTransacao tipoTransacao) {
        return ResponseEntity.ok(tipoTransacaoService.atualizarTipoTransacao(id, tipoTransacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoTransacao(@PathVariable Long id) {
        tipoTransacaoService.deletarTipoTransacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTransacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoTransacaoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TipoTransacao>> listarTodos() {
        return ResponseEntity.ok(tipoTransacaoService.listarTodos());
    }
}
