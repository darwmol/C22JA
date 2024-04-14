package co.com.ps.C22JA.controller;

import co.com.ps.C22JA.entity.Producto;
import co.com.ps.C22JA.entity.Usuario;
import co.com.ps.C22JA.service.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @Operation(summary = "Aplicacion que me trae todo los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontro un Usuario",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class)) }),
            @ApiResponse(responseCode = "400", description = "No encontro un Usuario",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class)) }),

    })

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.getAllUsuario();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioService.getUsuario(id);
        //   .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id))
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizado) {
        return usuarioService.updateUsuario(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}
