package com.restaurantServices.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurantServices.MenuItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuItemController.class)
public class MenuItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        // nothing yet!
    }
    @Test
    public void shouldReturnAllItemsOnTheMenu() throws Exception {

        mockMvc.perform(get("/menuitems"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());

    }

    @Test
    public void shouldReturnNewMenuItemOnPost() throws Exception {
        // Arrange
        MenuItem menuItemInput = new MenuItem("fries", 4.29, "delicious, golden, fried, potatoes");
        MenuItem menuItemOutput = new MenuItem("fries", 4.29, "delicious, golden, fried, potatoes");

        String inputJson = mapper.writeValueAsString(menuItemInput);

        String outputJson = mapper.writeValueAsString(menuItemOutput);

        // Act
        mockMvc.perform(post("/menuitems")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetMenuItemById() throws Exception {
        // Arrange
        //menuItems.add(new MenuItem(menuItemId++, "Ice cream sundae", 20.00, "Two scoops, no bananas"));
        MenuItem expectedMenuItem = new MenuItem(3, "Ice cream sundae", 20.00, "Two scoops, no bananas");
        String expectedOutputJson = mapper.writeValueAsString(expectedMenuItem);

        // Act
        mockMvc.perform(get("/menuitems/3"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedOutputJson));   // Assert
    }

    @Test
    public void shouldUpdateMenuItem() throws Exception {
        // Arrange
        MenuItem updatedMenuItem = new MenuItem("hot pocket", 14.99, "pastry with meat and cheese");
        String jsonInput = mapper.writeValueAsString(updatedMenuItem);

        int menuItemToChange = 1;
        MenuItem expectedOutputMenuItem = new MenuItem("hot pocket", 14.99, "pastry with meat and cheese");
        expectedOutputMenuItem.setId(menuItemToChange);
        String expectedOutputJson = mapper.writeValueAsString(expectedOutputMenuItem);

        // Act
        mockMvc.perform(put("/menuitems/" + menuItemToChange)
                        .content(jsonInput)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())                     // Assert
                .andExpect(content().json(expectedOutputJson)); // Assert
    }

    @Test
    public void shouldGetMenuItemByName() throws Exception {
        // Arrange
        MenuItem expectedMenuItem = new MenuItem(2, "Cheeseburger", 12.00, "To all be fatty special sauce");
        String expectedOutputJson = mapper.writeValueAsString(expectedMenuItem);

        // Act
        mockMvc.perform(get("/menuitems/byname/cheesebuRGER"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedOutputJson));   // Assert
    }

}