package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.CompraDTO;
import obligatorio2.EntitiesDTOs.UsuarioDTO;
import obligatorio2.Entity.UsuarioEntity;
import obligatorio2.Repository.CompraRepository;
import obligatorio2.Repository.UsuarioRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CompraServiceImpl compraService;

    public UsuarioDTO save(UsuarioEntity usuarioEntity) {
        Optional<UsuarioEntity> usuarioExiste = usuarioRepository.findById(usuarioEntity.getId());
        if(usuarioExiste.isPresent()) {
            usuarioExiste.get().setNombre(usuarioEntity.getNombre());
            usuarioExiste.get().setApellido(usuarioEntity.getApellido());
            usuarioExiste.get().setTipoUsuario(usuarioEntity.getTipoUsuario());

            UsuarioEntity usuario = usuarioRepository.save(usuarioExiste.get());
            return getUsuarioDTO(usuario);
        }

        UsuarioEntity usuario = usuarioRepository.save(usuarioEntity);
        return getUsuarioDTO(usuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public UsuarioDTO getById (Integer id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById( id);
        return getUsuarioDTO(usuario.get());
    }

    public List<UsuarioDTO> getAll() {
        List<UsuarioEntity> usuarioEntityList = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

        for (UsuarioEntity usuario : usuarioEntityList) {
            UsuarioDTO usuarioDTO = getUsuarioDTO(usuario);
            usuarioDTOList.add(usuarioDTO);
        }
        return usuarioDTOList;
    }

    public UsuarioDTO getUsuarioDTO(UsuarioEntity usuarioEntity) {
        UsuarioEntity usuario = usuarioRepository.save(usuarioEntity);
        List<CompraDTO> compraDTOList = new ArrayList<>();

        compraDTOList = compraService.getByUsuarioId(usuario.getId());

        try {
            return new UsuarioDTO(
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getEmail(),
                    usuario.getFechaNacimiento(),
                    usuario.getFechaRegistro(),
                    usuario.getTipoUsuario(),
                    compraDTOList,
                    usuario.getFechaMembresia(),
                    usuario.getFechaVencimientoMembresia(),
                    usuario.getDescuento(),
                    usuario.getTarjetaCredito()
            );
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteUsuario (Integer id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        usuario.ifPresent(usuarioEntity -> usuarioRepository.delete(usuarioEntity));
    }

    public UsuarioDTO login(UsuarioEntity usuarioEntity) throws BadRequestException {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByEmailAndPassword(
                usuarioEntity.getEmail(),
                usuarioEntity.getPassword()
        );

        if (usuario.isPresent()) {
            return getUsuarioDTO(usuario.get());
        } else {
            throw new BadRequestException("Credenciales incorrectas");
        }
    }

}
