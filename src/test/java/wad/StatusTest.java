/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author petteri
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusTest {
    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mockMvc;
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }
    
    @Test
    public void homeOk() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void lisaaUutinenOk() throws Exception {
        mockMvc.perform(get("/lisaaUutinen"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void uutistenMuokkaaminenOk() throws Exception {
        mockMvc.perform(get("/uutistenMuokkaaminen"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void hallinnoiKategorioitaOk() throws Exception {
        mockMvc.perform(get("/hallinnoiKirjoittajia"))
                .andExpect(status().isOk());
    }
    

}
