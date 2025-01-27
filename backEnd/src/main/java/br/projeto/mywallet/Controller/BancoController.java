package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Banco;
import br.projeto.mywallet.Service.IBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bancos")
public class BancoController {

    @Autowired
    private IBancoService bancoService;

    // Criar um novo banco
    @PostMapping
    public Banco criarBanco(@RequestBody Banco banco) {
        return bancoService.criarBanco(banco);
    }

    // Buscar banco por ID
    @GetMapping("/{id}")
    public Banco buscarBancoPorId(@PathVariable Long id) {
        return bancoService.buscarBancoPorId(id);
    }

    // Listar todos os bancos
    @GetMapping
    public List<Banco> listarTodosBancos() {
        return bancoService.listarTodosBancos();
    }

    // Atualizar banco
    @PutMapping("/{id}")
    public Banco atualizarBanco(@PathVariable Long id, @RequestBody Banco bancoAtualizado) {
        return bancoService.atualizarBanco(id, bancoAtualizado);
    }

    // Deletar banco
    @DeleteMapping("/{id}")
    public void deletarBanco(@PathVariable Long id) {
        bancoService.deletarBanco(id);
    }
}
