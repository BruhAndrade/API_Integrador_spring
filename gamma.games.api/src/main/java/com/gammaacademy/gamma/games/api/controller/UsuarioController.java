    package com.gammaacademy.gamma.games.api.controller;

    import com.gammaacademy.gamma.games.api.entities.Usuario;
    import com.gammaacademy.gamma.games.api.services.UsuarioService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/usuario")
    public class UsuarioController {

        private final UsuarioService usuarioService;

        @Autowired
        public UsuarioController(UsuarioService usuarioService) {
            this.usuarioService = usuarioService;
        }

        @GetMapping
        public List<Usuario> getAllUsuarios() {
            return usuarioService.getAllUsuarios();
        }

        @GetMapping("/{id}")
        public Usuario getUsuarioById(@PathVariable long id) {
            return usuarioService.getUsuarioById(id);
        }

        @PostMapping
        public Usuario createUsuario(@RequestBody Usuario usuario) {
            return usuarioService.createUsuario(usuario);
        }

        @PutMapping("/{id}")
        public Usuario updateUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
            return usuarioService.updateUsuario(id, usuario);
        }

        @DeleteMapping("/{id}")
        public void deleteUsuario(@PathVariable long id) {
            usuarioService.deleteUsuario(id);
        }
    }
