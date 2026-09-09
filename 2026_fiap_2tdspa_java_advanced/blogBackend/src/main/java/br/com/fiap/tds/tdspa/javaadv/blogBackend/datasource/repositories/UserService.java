package br.com.fiap.tds.tdspa.javaadv.blogBackend.datasource.repositories;

import br.com.fiap.tds.tdspa.javaadv.blogBackend.domainmodel.entities.User;
import br.com.fiap.tds.tdspa.javaadv.blogBackend.datasource.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    // @Autowired
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id){
        return this.userRepository.findById(id);
    }

    public User persist(User user){
        return this.userRepository.save(user);
    }

    public void delete(User user){
        this.userRepository.delete(user);
    }

    public void deleteById(UUID id){
        this.userRepository.deleteById(id);
    }


    public boolean existsById(UUID id){
        return this.userRepository.existsById(id);
    }

    public boolean existsById(User user){
        return this.existsById(user.getId());
    }

    public Optional<User> partialUpdate(UUID id, Map<String, Object> updates){
        Optional<User> userOptional = this.userRepository.findById(id);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            updates.forEach((key, value) -> {
                switch(key){
                    case "name":
                        user.setName((String) value);
                        break;
                    case "email":
                        user.setEmail((String) value);
                        break;
                    case "password":
                        user.setPassword((String) value);
                        break;
                }
            });
            return Optional.of(this.userRepository.save(user));
        }
        return Optional.empty();
    }


}
