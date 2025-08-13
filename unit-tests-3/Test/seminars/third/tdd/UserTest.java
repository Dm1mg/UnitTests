package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    void userCreationFailed(){
        User user = new User("user_0", "123psw", false);
        assertFalse(user.authenticate("user_0", "psw123"));
    }

    @Test
    void userRepository(){
        UserRepository userRepository = new UserRepository();
        User userNA = new User("user_0", "psw123", false);
        userRepository.addUser(userNA);
        assertFalse(userRepository.findByName(userNA.name));
    }

    @Test
    void userRepositoryNA(){
        UserRepository userRepository = new UserRepository();
        User userNA = new User("user_0", "psw123", false);
        userNA.authenticate("user_0", "123");
        userRepository.addUser(userNA);
        assertFalse(userRepository.findByName(userNA.name));
    }

    //HomeWork
    @Test
    void logOutTest(){
        UserRepository userRepository = new UserRepository();
        User userCommon = new User("user_0", "psw123", false);
        User userAdm = new User("user_1", "psw123", true);
        userCommon.authenticate("user_0", "psw123");
        userRepository.addUser(userCommon);
        userAdm.authenticate("user_1", "psw123");
        userRepository.addUser(userAdm);
        assertThat(userRepository.data.size()).isEqualTo(2);
        userRepository.logOutAll();
        assertThat(userRepository.data.size()).isEqualTo(1);
        assertThat(userRepository.data.get(0)).isEqualTo(userAdm);
    }
}