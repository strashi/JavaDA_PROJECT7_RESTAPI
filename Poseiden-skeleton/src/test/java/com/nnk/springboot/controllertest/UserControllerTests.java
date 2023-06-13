package com.nnk.springboot.controllertest;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.tools.PasswordConstraintValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import com.google.gson.Gson;

import javax.validation.ConstraintValidatorContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PasswordConstraintValidator passwordConstraintValidator;

    @Test
    public void testHome() throws Exception{

        mockMvc.perform(get("/user/list")).andExpect(status().isOk()).andDo(print());

    }

    @Test
    public void testAddUser() throws Exception{

        mockMvc.perform(get("/user/add")).andExpect(status().isOk()).andDo(print());

    }

    @Test
    public void testValidate() throws Exception{

        User user = new User("User","Password22!","user","USER");

        Gson gson = new Gson();
        String json = gson.toJson(user);
        when(passwordConstraintValidator.isValid(any(String.class),any(ConstraintValidatorContext.class))).thenReturn(true);

        mockMvc.perform(post("/user/validate").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isFound()).andDo(print())
                .andExpect(view().name("redirect:/user/list"));

    }


}
