package cvter.intern.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by cvter on 2017/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath*:/applicationContext.xml", "classpath*:/spring-mvc.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Test
    public void bookSearch() throws Exception {

        String responseString = mockMvc.perform
                (
                        get("/book/v1/search")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("params", "作者")
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        System.out.println("-----返回---------\n " + responseString);
    }

    @Test
    public void bookPanic() throws Exception {
        String responseString = mockMvc.perform
                (
                        post("/book/v1/panic")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("userUid", "123456789")
                                .param("bookUid", "huzunrong")
                                .param("tokenUid", "huzunrong")
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        System.out.println("-----返回的json ---------\n " + responseString);
    }

}