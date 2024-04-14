package co.com.ps.C22JA.repository;

import co.com.ps.C22JA.entity.Producto;
import co.com.ps.C22JA.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
