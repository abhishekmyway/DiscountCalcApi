package com.example.discount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.example.discount.pojo.Bill;
import com.example.discount.service.BillDiscountImpl;

import java.util.Arrays;
 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class DiscountControllerTest {
 
    private MockMvc mockMvc;
 
    @Autowired
    private BillDiscountImpl billServiceMock;
 
    //Add WebApplicationContext field here.
 
    //The setUp() method is omitted.
 
    @Test
    public void findAll_TodosFound_ShouldReturnFoundTodoEntries() throws Exception {
    	Bill first = new BillBuilder()
                .amount(1D)
                .customerType("Lorem ipsum")
                .countOfyear("Foo")
                .itemType("Grocery")
                .isDiscounted("Y")
                .build();
    	Bill second = new BillBuilder()
                .amount(1L)
                .customerType("employee")
                .countOfyear("2")
                .itemType("Grocery")
                .isDiscounted("N")
                .build();
 
        when(todoServiceMock.findAll()).thenReturn(Arrays.asList(first, second));
 
        mockMvc.perform(get("/discount/employee"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].amount", is(1)))
                .andExpect(jsonPath("$[0].customerType", is("Employee")))
                .andExpect(jsonPath("$[0].countOfyear", is("2")))
                .andExpect(jsonPath("$[1].itemType", is("Grocery")))
                .andExpect(jsonPath("$[1].isDiscounted", is("950")))
                .andExpect(jsonPath("$[1].title", is("Bar")));
 
        verify(billServiceMock, times(1)).findAll();
        verifyNoMoreInteractions(billServiceMock);
    }
}
