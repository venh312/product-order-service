package productorderservice.demo.product.service;

import org.springframework.util.Assert;
import productorderservice.demo.product.domain.DiscountPolicy;

public record GetProductResponse(
        long id,
        String name,
        DiscountPolicy discountPolicy) {

    public GetProductResponse {
        Assert.notNull(id, "상품 ID는 필수입니다.");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
