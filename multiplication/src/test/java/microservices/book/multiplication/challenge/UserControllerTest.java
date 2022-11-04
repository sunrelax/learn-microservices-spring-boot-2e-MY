package microservices.book.multiplication.challenge;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import microservices.book.multiplication.user.Users;
import microservices.book.multiplication.user.UserController;
import microservices.book.multiplication.user.UserRepository;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<List<Users>> jsonRequestUser;

    @Test
    public void getUserIds() throws Exception {
        // given
        Users user1 = new Users(UUID.randomUUID().toString(), "jane");
        Users user2 = new Users(UUID.randomUUID().toString(), "john");
        given(userRepository.findAllByIdIn(List.of("cbdc41a9-4955-4d87-9e0c-9e448008e5fd", "5fb740df-5221-405d-8afb-e99d8dc4b712")))
                .willReturn(List.of(user1, user2));

        // when
        MockHttpServletResponse response = mvc.perform(get("/users/1,2"))
                .andReturn().getResponse();

        // then
        then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        then(response.getContentAsString()).isEqualTo(
                jsonRequestUser.write(
                        List.of(user1, user2)
                ).getJson());
    }
}
