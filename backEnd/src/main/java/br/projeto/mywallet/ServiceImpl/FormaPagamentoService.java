package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.FormaPagamento;
import br.projeto.mywallet.Service.IFormaPagamentoService;
import br.projeto.mywallet.repository.IFormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService implements IFormaPagamentoService {

    @Autowired
    private IFormaPagamentoRepository formaPagamentoRepository;

    @Override
    public FormaPagamento criarFormaPagamento(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento); // Salva no banco de dados
    }

    @Override
    public FormaPagamento buscarFormaPagamentoPorId(Long id) {
        Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(id);
        return formaPagamento.orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada com ID: " + id));
    }

    @Override
    public List<FormaPagamento> listarTodasFormasPagamento() {
        return formaPagamentoRepository.findAll();
    }

    @Override
    public FormaPagamento atualizarFormaPagamento(Long id, FormaPagamento formaPagamentoAtualizada) {
        FormaPagamento formaPagamento = buscarFormaPagamentoPorId(id); // Verifica se existe
        formaPagamento.setNome(formaPagamentoAtualizada.getNome());
        formaPagamento.setTransacoes(formaPagamentoAtualizada.getTransacoes());
        return formaPagamentoRepository.save(formaPagamento); // Atualiza e salva
    }

    @Override
    public void deletarFormaPagamento(Long id) {
        FormaPagamento formaPagamento = buscarFormaPagamentoPorId(id); // Verifica se existe
        formaPagamentoRepository.delete(formaPagamento); // Deleta do banco de dados
    }
}
