package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.CarteiraDTO;
import br.projeto.mywallet.Mappers.CarteiraMapper;
import br.projeto.mywallet.Model.Carteira;
import br.projeto.mywallet.Service.ICarteiraService;
import br.projeto.mywallet.repository.ICarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteiraService implements ICarteiraService {

    @Autowired
    private ICarteiraRepository carteiraRepository;
    
    @Autowired
    private CarteiraMapper carteiraMapper = CarteiraMapper.INSTANCE;
    
    @Override
    public CarteiraDTO criarCarteira(CarteiraDTO carteiraDTO) {
        Carteira carteira = carteiraMapper.toEntity(carteiraDTO);
        return carteiraMapper.toDTO(carteiraRepository.save(carteira));
    }

    @Override
    public CarteiraDTO buscarCarteiraPorId(Long id) {
        
        Optional<Carteira> carteira = carteiraRepository.findById(id);
        return carteira.isEmpty()
                ? null
                :carteiraMapper.toDTO(carteira.get());
    }

    @Override
    public List<CarteiraDTO> listarTodasCarteiras() {
        
        return carteiraRepository.findAll().stream()
                .map(carteiraMapper::toDTO)
                .toList();
    }

    @Override
    public CarteiraDTO atualizarCarteira(Long id, CarteiraDTO carteiraAtualizada) {
        
        CarteiraDTO carteiraDTO = buscarCarteiraPorId(id);

        carteiraDTO.setNome(carteiraAtualizada.getNome());
        carteiraDTO.setMeses(carteiraAtualizada.getMeses());
        carteiraDTO.setUsuarios(carteiraAtualizada.getUsuarios());

        return carteiraMapper
                .toDTO(carteiraRepository.save(carteiraMapper.toEntity(carteiraDTO))
        );
    }

    @Override
    public void deletarCarteira(Long id) {
        
        CarteiraDTO carteiraDTO = buscarCarteiraPorId(id);
        
        carteiraRepository.delete(carteiraMapper.toEntity(carteiraDTO));
    }

    @Override
    public List<CarteiraDTO> buscaCarteiraPorUsuario(String nomeUsuario) {
        List<Carteira> carteiras = carteiraRepository.findAll();
        
        return carteiras.stream()
                .filter(carteira-> carteira.getUsuarios().stream().anyMatch(usuario-> usuario.getUsername().equals(nomeUsuario)))
                .map(carteiraMapper::toDTO)
                .toList();
    }
}
