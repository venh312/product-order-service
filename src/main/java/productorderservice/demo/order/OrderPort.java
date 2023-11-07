package productorderservice.demo.order;

import productorderservice.demo.product.domain.Product;

interface OrderPort {
    public Product getProductById(Long productId);

    public void save(Order order);
}
