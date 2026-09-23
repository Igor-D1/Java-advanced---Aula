package br.com.fiap.tds.tdspa.javaadv.blogBackend.datasource.repositories;

import br.com.fiap.tds.tdspa.javaadv.blogBackend.domainmodel.entities.QRole;
import br.com.fiap.tds.tdspa.javaadv.blogBackend.domainmodel.entities.QUser;
import br.com.fiap.tds.tdspa.javaadv.blogBackend.domainmodel.entities.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private static final QUser user = QUser.user;
    private static final QRole role = QRole.role;

    public List<User> findUserByRoleName(final String roleName){

        return new JPAQueryFactory(this.entityManager)
                .selectFrom(user)
                .join(role)
                .where(user.roles.any().name.eq(roleName))
                .fetch();
    }
}
