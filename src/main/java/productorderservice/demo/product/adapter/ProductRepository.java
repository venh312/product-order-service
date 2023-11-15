package productorderservice.demo.product.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import productorderservice.demo.product.domain.Product;

//@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    private Long sequence = 0L;
//    private Map<Long, Product> persistence = new HashMap<>();
//
//    public void save(Product product) {
//        product.assignId(++sequence);
//        persistence.put(product.getId(), product);
//    }
}
