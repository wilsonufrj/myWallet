package br.projeto.mywallet.Controller;

import br.projeto.mywallet.DTO.BancoDTO;
import br.projeto.mywallet.Mappers.BancoMapper;
import br.projeto.mywallet.Model.Banco;
import br.projeto.mywallet.Service.IBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/bancos")
public class BancoController {

    @Autowired
    private IBancoService bancoService;

    @PostMapping
    public ResponseEntity<BancoDTO> criarMes(@RequestBody BancoDTO bancoDTO) {
        return ResponseEntity.ok(bancoService.criarBanco(bancoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoDTO> buscarBancoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bancoService.buscarBancoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<BancoDTO>> listarTodosBancos() {
        return ResponseEntity.ok(bancoService.listarTodosBancos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BancoDTO> atualizarBanco(@PathVariable Long id, @RequestBody BancoDTO bancoAtualizado) {
        return ResponseEntity.ok(bancoService.atualizarBanco(id, bancoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarBanco(@PathVariable Long id) {
        bancoService.deletarBanco(id);
        return ResponseEntity.noContent().build();
    }
}
