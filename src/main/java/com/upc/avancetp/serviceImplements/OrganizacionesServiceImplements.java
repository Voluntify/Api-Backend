package com.upc.avancetp.serviceImplements;

import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.UsuariosRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class OrganizacionesServiceImplements {
    private UsuariosRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public OrganizacionesServiceImplements(UsuariosRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuarios save(Usuarios users) {
        users.setContrasena(passwordEncoder.encode(users.getContrasena()));
        return userRepository.save(users);
    }
}