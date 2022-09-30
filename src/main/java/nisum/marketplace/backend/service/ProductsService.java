package nisum.marketplace.backend.service;

import nisum.marketplace.backend.model.products;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

public interface ProductsService {
    List<products> getProductsId(String id);
    List<products> getProducts();
}
