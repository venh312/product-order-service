package productorderservice.demo.product;

interface ProductPort {
    public void save(Product product);
    Product getProduct(Long productId);
}
