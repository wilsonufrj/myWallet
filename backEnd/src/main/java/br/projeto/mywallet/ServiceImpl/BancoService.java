package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.Banco;
import br.projeto.mywallet.Service.IBancoService;
import br.projeto.mywallet.repository.IBancoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilsonramos
 */
@Service
public class BancoService implements IBancoService {

    @Autowired
    private IBancoRepository bancoRepository;

    @Override
    public Banco criarBanco(Banco banco) {
        return bancoRepository.save(banco); // Salva o banco no banco de dados
    }

    @Override
    public Banco buscarBancoPorId(Long id) {
        Optional<Banco> banco = bancoRepository.findById(id);
        return banco.orElseThrow(() -> new RuntimeException("Banco não encontrado com ID: " + id));
    }

    @Override
    public List<Banco> listarTodosBancos() {
        return bancoRepository.findAll();
    }

    @Override
    public Banco atualizarBanco(Long id, Banco bancoAtualizado) {
        Banco banco = buscarBancoPorId(id); // Verifica se o banco existe
        banco.setNomeBanco(bancoAtualizado.getNomeBanco());
        banco.setTranscacoes(bancoAtualizado.getTranscacoes());
        return bancoRepository.save(banco); // Atualiza e salva
    }

    @Override
    public void deletarBanco(Long id) {
        Banco banco = buscarBancoPorId(id); // Verifica se o banco existe
        bancoRepository.delete(banco); // Remove do banco de dados
    }
}
