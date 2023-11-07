package productorderservice.demo.order;

import org.springframework.util.Assert;
import productorderservice.demo.product.domain.Product;

class Order {
    private Long id;
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야합나디ㅏ.");
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
