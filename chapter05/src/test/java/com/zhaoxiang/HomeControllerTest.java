package com.zhaoxiang;

import com.zhaoxiang.controller.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Author: Rivers
 * Date: 2017/8/31 22:13
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {

        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
    }
}
