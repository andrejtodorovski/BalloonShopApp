package mk.ukim.finki.veblabs;

import mk.ukim.finki.veblabs.model.Balloon;
import mk.ukim.finki.veblabs.model.Manufacturer;
import mk.ukim.finki.veblabs.service.BalloonService;
import mk.ukim.finki.veblabs.service.ManufacturerService;
import mk.ukim.finki.veblabs.service.OrderService;
import mk.ukim.finki.veblabs.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class VeblabsApplicationTests {

    MockMvc mockMvc;


    @Autowired
    UserService userService;

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    OrderService orderService;


    @Autowired
    BalloonService balloonService;

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetBalloons() throws Exception {
        MockHttpServletRequestBuilder balloonRequest = MockMvcRequestBuilders.get("/balloons");
        this.mockMvc.perform(balloonRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("balloons"))
                .andExpect(MockMvcResultMatchers.view().name("listBalloons"));

    }

    @Test
    void contextLoads() {
    }


}
