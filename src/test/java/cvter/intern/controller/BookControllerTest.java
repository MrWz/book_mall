package cvter.intern.controller;

import cvter.intern.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cvter on 2017/5/19.
 */
public class BookControllerTest extends BaseTest {

    @Test
    public void bookList() throws Exception {
        MvcResult mvcResult = super.mockMvc.perform(
                get("/book/v1/list")
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void bookSearch() throws Exception {

        String responseString = super.mockMvc.perform
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