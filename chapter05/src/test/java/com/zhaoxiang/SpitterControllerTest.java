package com.zhaoxiang;

import com.zhaoxiang.controller.SpitterController;
import com.zhaoxiang.data.SpitterRepository;
import com.zhaoxiang.entity.Spitter;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Author: Rivers
 * Date: 2017/9/1 21:54
 */
public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {

        SpitterRepository repository = mock(SpitterRepository.class);

        SpitterController controller = new SpitterController(repository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register")).andExpect(view().name("register_form"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {

        SpitterRepository repository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");

        when(repository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(repository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(
                post("/spitter/register").
                        param("firstName", "").
                        param("lastName", "Bauer").
                        param("username", "jbauer").
                        param("password", "24hours")).
                andExpect(redirectedUrl("/spitter/jbauer"));

        verify(repository, atLeastOnce()).save(unsaved);
    }
}
