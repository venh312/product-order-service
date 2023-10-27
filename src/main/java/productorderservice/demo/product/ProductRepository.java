package productorderservice.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Repository
interface ProductRepository extends JpaRepository<Product, Long> {
//    private Long sequence = 0L;
//    private Map<Long, Product> persistence = new HashMap<>();
//
//    public void save(Product product) {
//        product.assignId(++sequence);
//        persistence.put(product.getId(), product);
//    }
}
