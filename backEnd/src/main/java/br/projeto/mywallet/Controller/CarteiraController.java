package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Carteira;
import br.projeto.mywallet.Service.ICarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carteiras")
public class CarteiraController {

    @Autowired
    private ICarteiraService carteiraService;

    // Criar nova carteira
    @PostMapping
    public Carteira criarCarteira(@RequestBody Carteira carteira) {
        return carteiraService.criarCarteira(carteira);
    }

    // Buscar carteira por ID
    @GetMapping("/{id}")
    public Carteira buscarCarteiraPorId(@PathVariable Long id) {
        return carteiraService.buscarCarteiraPorId(id);
    }

    // Listar todas as carteiras
    @GetMapping
    public List<Carteira> listarTodasCarteiras() {
        return carteiraService.listarTodasCarteiras();
    }

    // Atualizar carteira
    @PutMapping("/{id}")
    public Carteira atualizarCarteira(@PathVariable Long id, @RequestBody Carteira carteiraAtualizada) {
        return carteiraService.atualizarCarteira(id, carteiraAtualizada);
    }

    // Deletar carteira
    @DeleteMapping("/{id}")
    public void deletarCarteira(@PathVariable Long id) {
        carteiraService.deletarCarteira(id);
    }
}
