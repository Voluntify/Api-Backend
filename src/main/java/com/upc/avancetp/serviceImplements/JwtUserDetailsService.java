package com.upc.avancetp.serviceImplements;

import com.upc.avancetp.model.Organizaciones;
import com.upc.avancetp.model.Usuarios;
import com.upc.avancetp.repository.US01Repository;
import com.upc.avancetp.repository.US09Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private US01Repository us01Repository;
    @Autowired
    private US09Repository us09Repository;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuarios usuarios = us01Repository.findByNombre(nombre);
        Organizaciones organizaciones = us09Repository.findByNombre(nombre);

        if (usuarios == null && organizaciones == null) {
            throw new UsernameNotFoundException(String.format("User or organization not exists", nombre));
        }

        List<GrantedAuthority> roles = new ArrayList<>();


        // Obtener roles del usuario
        if (usuarios != null) {
            usuarios.getRole().forEach(rol -> {
                roles.add(new SimpleGrantedAuthority(rol.getRole()));
            });
        }

        // Obtener roles de la organización
        if (organizaciones != null) {
            organizaciones.getRole().forEach(rol -> {
                roles.add(new SimpleGrantedAuthority(rol.getRole()));
            });
        }

        String userName = (usuarios != null) ? usuarios.getNombre() : organizaciones.getNombre();
        String password = (usuarios != null) ? usuarios.getContrasena() : organizaciones.getContrasena();

        return new org.springframework.security.core.userdetails.User(userName, password, true, true, true, true, roles);
    }
}