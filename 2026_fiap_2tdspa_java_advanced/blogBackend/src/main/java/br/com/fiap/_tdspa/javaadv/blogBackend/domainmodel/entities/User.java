package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SYS001_USER")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    private @Getter @Setter Long id;
    private @Getter @Setter String name;
    private @Getter @Setter String email;
    private @Getter @Setter String password;

    private @Getter @Setter Profile profile; // 1 usuário tem exatamente 1 profile
    private @Getter
    @Setter Set<Post> posts = new HashSet<>(); // mais rápido
    private @Getter @Setter Set<Role> roles = new HashSet<>();

}
// TreeSet + lento + ordenação;
// linkedList<"nome">; List<"nome">; Set<"nome">
