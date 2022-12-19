package mk.ukim.finki.veblabs;

import lombok.SneakyThrows;
import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.User;
import mk.ukim.finki.veblabs.repository.UserJpaRepository;
import mk.ukim.finki.veblabs.service.implementation.UserServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class LoginUserTest {


    private UserServiceImplementation userService;

    @Mock
    private UserJpaRepository userJpaRepository;



    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        User user = new User("username","name", "surname", "password", LocalDate.parse("2022-12-08"));
        Mockito.when(this.userJpaRepository.save(Mockito.any(User.class))).thenReturn(user);
        this.userService = Mockito.spy(new UserServiceImplementation(userJpaRepository));
    }
    @Test
    public void testRegister() throws NonExistentUserException {
        User user = this.userService.save("username","name", "surname", "password", LocalDate.parse("2022-12-08"));
        Mockito.verify(this.userService).save("username","name", "surname", "password", LocalDate.parse("2022-12-08"));
        Assert.assertNotNull(user);
        Assert.assertEquals("username",user.getUsername());
        Assert.assertEquals("name",user.getFullName().getName());
        Assert.assertEquals("surname",user.getFullName().getSurname());
        Assert.assertEquals("password",user.getPassword());
    }
    @SneakyThrows
    @Test
    public void testNullUsername() {
        Assertions.assertThrows(NonExistentUserException.class, () -> this.userService.login(null, "password"));
        Mockito.verify(this.userService).login(null, "password");
    }

    @SneakyThrows
    @Test
    public void testEmptyUsername() {
        Assertions.assertThrows(NonExistentUserException.class, () -> this.userService.login("", "password"));
        Mockito.verify(this.userService).login("", "password");
    }

    @SneakyThrows
    @Test
    public void testNullPassword() {
        Assertions.assertThrows(NonExistentUserException.class, () -> this.userService.login("username", null));
        Mockito.verify(this.userService).login("username", null);
    }

    @SneakyThrows
    @Test
    public void testEmptyPassword() {
        Assertions.assertThrows(NonExistentUserException.class, () -> this.userService.login("username", ""));
        Mockito.verify(this.userService).login("username", "");
    }

}
