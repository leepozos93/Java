package com.prueba.examen;

// ProductController.java
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import com.Producto;
import com.prueba.ServiceProducto;

@RestController
@RequestMapping("/listaProductos")
public class ControllerProducto {

    private final ServiceProducto listProductos;

    public ControllerProducto(ServiceProducto listProductos) {
        this.listProductos = listProductos;
    }

    @GetMapping("/categories")
    public Set<String> getCategories() {
        return listProductos.getCategories();
    }

    @PostMapping("/filterByBudget")
    public List<Producto> filterByBudget(@RequestBody BudgetRequest budgetRequest) {
        return listProductos.filterByBudget(budgetRequest.getBudget());
    }

    @PostMapping("/filterByRating")
    public List<Producto> filterByRating(@RequestBody RatingRequest ratingRequest) {
        return listProductos.filterByRating(ratingRequest.getRating());
    }
}
