package com.ttn;

import com.ttn.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by diwakar on 29/04/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String username);
}
