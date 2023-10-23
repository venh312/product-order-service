package productorderservice.demo.product;

class ProductService {
    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    public void addProduct(AddProductRequest request) {
        Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);
    }

}
