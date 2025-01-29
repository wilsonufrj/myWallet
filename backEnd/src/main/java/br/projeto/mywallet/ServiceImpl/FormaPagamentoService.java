package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.FormaPagamentoDTO;
import br.projeto.mywallet.Mappers.FormaPagamentoMapper;
import br.projeto.mywallet.Model.FormaPagamento;
import br.projeto.mywallet.Service.IFormaPagamentoService;
import br.projeto.mywallet.repository.IFormaPagamentoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService implements IFormaPagamentoService {


    @Autowired
    private IFormaPagamentoRepository formaPagamentoRepository;

    @Override
    public FormaPagamentoDTO criarFormaPagamento(FormaPagamentoDTO formaPagamentoDTO) {
        FormaPagamento formaPagamento = FormaPagamentoMapper.INSTANCE.toEntity(formaPagamentoDTO);
        return FormaPagamentoMapper.INSTANCE.toDTO(formaPagamentoRepository.save(formaPagamento));
    }

    @Override
    public FormaPagamentoDTO buscarFormaPagamentoPorId(Long id) {
        Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(id);
        return formaPagamento.map(FormaPagamentoMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada com ID: " + id));
    }

    @Override
    public List<FormaPagamentoDTO> listarTodasFormasPagamento() {
        return formaPagamentoRepository.findAll().stream()
                .map(FormaPagamentoMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public FormaPagamentoDTO atualizarFormaPagamento(Long id, FormaPagamentoDTO formaPagamentoAtualizada) {
        FormaPagamentoDTO formaPagamentoDTO = buscarFormaPagamentoPorId(id);

        formaPagamentoDTO.setNome(formaPagamentoAtualizada.getNome());
        formaPagamentoDTO.setTransacoes(formaPagamentoAtualizada.getTransacoes());

        return FormaPagamentoMapper.INSTANCE.toDTO(
                formaPagamentoRepository.save(FormaPagamentoMapper.INSTANCE.toEntity(formaPagamentoDTO))
        );
    }

    @Override
    public void deletarFormaPagamento(Long id) {
        FormaPagamentoDTO formaPagamentoDTO = buscarFormaPagamentoPorId(id);
        formaPagamentoRepository.delete(FormaPagamentoMapper.INSTANCE.toEntity(formaPagamentoDTO));
    }
}
