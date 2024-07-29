package com.prueba;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.Producto;




@Service
public class ServiceProducto {

    private  List<Producto> listProductos; 

    public ServiceProducto() throws IOException {
        this.listProductos = loadProductoFromJson();
        
    }

    private List<Producto> loadProductoFromJson() {
        String url = "https://api.jsonbin.io/v3/b/65d4d499266cfc3fde8ce1f6";
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);
        return loadProductoFromJson();
    }

    public Set<String> getCategories() {
        return listProductos.stream()
                .map(Producto::getCategory)
                .collect(Collectors.toSet());
    }

    public List<Producto> filterByBudget(double budget) {
        return listProductos.stream()
                .filter(product -> product.getPrice() <= budget)
                .collect(Collectors.toList());
    }

    public List<Producto> filterByRating(double rating) {
        return listProductos.stream()
                .filter(product -> product.getRate() >= rating)
                .collect(Collectors.toList());
    }
}
