package com.zhaoxiang;

import com.zhaoxiang.controller.SpittleController;
import com.zhaoxiang.data.SpittleRepository;
import com.zhaoxiang.entity.Spittle;
import org.junit.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/9/1 07:01
 */
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {

        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository repository = mock(SpittleRepository.class);
        when(repository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(repository);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles")).
                andExpect(view().name("spittles")).
                andExpect(model().attributeExists("spittleList")).
                andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {

        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository repository = mock(SpittleRepository.class);
        when(repository.findSpittles(238900, 50)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(repository);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles?max=238900&count=50")).
                andExpect(view().name("spittles")).
                andExpect(model().attributeExists("spittleList")).
                andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testSpittle() throws Exception {

        Spittle spittle = new Spittle("Hello", new Date());
        SpittleRepository repository = mock(SpittleRepository.class);
        when(repository.findOne(12345)).thenReturn(spittle);

        SpittleController spittleController = new SpittleController(repository);
        MockMvc mockMvc = standaloneSetup(spittleController).build();

        mockMvc.perform(get("/spittles/12345")).
                andExpect(view().name("spittle")).
                andExpect(model().attributeExists("spittle")).
                andExpect(model().attribute("spittle", spittle));
    }

    private List<Spittle> createSpittleList(int count) {

        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
