package com.prueba.examen;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Producto;
import com.prueba.ServiceProducto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductoServiceTest {

    @InjectMocks
    private ServiceProducto serviceProducto;

    @Mock
    private List<Producto> products;

    @Test
    void testGetCategories() {
        MockitoAnnotations.openMocks(this);
        Set<String> mockCategories = new HashSet<>();
        mockCategories.add("Electronics");
        mockCategories.add("Books");

        when(products.stream()
                     .map(Producto::getCategory)
                     .collect(Collectors.toSet()))
            .thenReturn(mockCategories);

        Set<String> categories = serviceProducto.getCategories();
        Set<String> expectedCategories = new HashSet<>();
        expectedCategories.add("Electronics");
        expectedCategories.add("Books");

        assertEquals(expectedCategories, categories);
    }

    @Test
    void testFilterByBudget() {
        MockitoAnnotations.openMocks(this);
        List<Producto> mockFilteredProducts = new ArrayList<>();
        mockFilteredProducts.add(
            new Producto("1", "Product1", "Electronics", 50, 4.5));

        when(products.stream()
                     .filter(product -> product.getPrice() <= 100)
                     .collect(Collectors.toList()))
            .thenReturn(mockFilteredProducts);

        List<Producto> filteredProducts = serviceProducto.filterByBudget(100);
        List<Producto> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Producto("1", "Product1", "Electronics", 50, 4.5));

        assertEquals(expectedProducts, filteredProducts);
    }

    @Test
    void testFilterByRating() {
        MockitoAnnotations.openMocks(this);
        List<Producto> mockFilteredProducts = new ArrayList<>();
        mockFilteredProducts.add(new Producto("2", "Product2", "Books", 20, 4.5));

        when(products.stream()
                     .filter(product -> product.getRate() >= 4)
                     .collect(Collectors.toList()))
            .thenReturn(mockFilteredProducts);

        List<Producto> filteredProducts = serviceProducto.filterByRating(4);
        List<Producto> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Producto("2", "Product2", "Books", 20, 4.5));

        assertEquals(expectedProducts, filteredProducts);
    }
}