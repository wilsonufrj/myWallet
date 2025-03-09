package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.CarteiraDTO;
import br.projeto.mywallet.Mappers.CarteiraMapper;
import br.projeto.mywallet.Model.Carteira;
import br.projeto.mywallet.Model.Usuario;
import br.projeto.mywallet.Service.ICarteiraService;
import br.projeto.mywallet.repository.ICarteiraRepository;
import br.projeto.mywallet.repository.IUsuarioRepository;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CarteiraService implements ICarteiraService {

    @Autowired
    private ICarteiraRepository carteiraRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private CarteiraMapper carteiraMapper = CarteiraMapper.INSTANCE;

    @Override
    public CarteiraDTO criarCarteira(Long usuarioId, CarteiraDTO carteiraDTO) throws Exception {

        Usuario usuarioLogged = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new Exception("Usuario não encontrado"));

        Carteira carteira = carteiraMapper.toEntity(carteiraDTO);

        Set<Usuario> usuarios = new HashSet<>();
        usuarios.add(usuarioLogged);

        carteiraDTO.getUsuarios()
                .stream()
                .forEach(usuario -> {
                    Usuario auxUsuario;
                    try {
                        auxUsuario = usuarioRepository.findById(usuario.getId())
                                .orElseThrow(() -> new Exception("Usuario não encontrado"));

                        usuarios.add(auxUsuario);

                    } catch (Exception ex) {
                        Logger.getLogger(CarteiraService.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                    }
                });

        carteira.setUsuarios(usuarios);

        Carteira carteiraSaved = carteiraRepository.save(carteira);
        
        carteiraSaved.getUsuarios().stream()
                .forEach(usuario -> {
                    Usuario auxUsuario;
                    try {
                        auxUsuario = usuarioRepository.findById(usuarioId)
                                .orElseThrow(() -> new Exception("Usuario não encontrado"));

                        usuario.adicionarCarteira(carteiraSaved);
                        usuarioRepository.save(auxUsuario);

                    } catch (Exception ex) {
                        Logger.getLogger(CarteiraService.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                    }

                });

        return carteiraMapper.toDTO(carteiraSaved);
    }


    @Override
    public void deletarCarteira(Long id) throws Exception{
        Carteira carteira = carteiraRepository.findById(id)
                .orElseThrow(()-> new Exception("Usuario não encontrado"));

        carteira.getUsuarios()
                .forEach(usuario -> {
                    usuario.removerCarteira(carteira);

                    usuarioRepository.save(usuario);
                });

        carteiraRepository.deleteById(id);
    }

    @Override
    public List<CarteiraDTO> buscaCarteiraPorIDUsuario(Long idUsuario) {
        List<Carteira> carteiras = carteiraRepository.findAll();

        return carteiras.stream()
                .filter(carteira -> carteira.getUsuarios().stream().anyMatch((Usuario usuario) -> usuario.getId().equals(idUsuario)))
                .map(carteiraMapper::toDTO)
                .toList();
    }
}
