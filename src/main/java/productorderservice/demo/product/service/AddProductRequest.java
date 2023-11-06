package productorderservice.demo.product.service;

import org.springframework.util.Assert;
import productorderservice.demo.product.domain.DiscountPolicy;

public record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public AddProductRequest {
        Assert.hasText(name, "상품명은 필수");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
