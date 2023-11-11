package productorderservice.demo.product.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {
    @Test
    void noneDiscountPolicy() {
        int price = 1000;
        int discountPrice = DiscountPolicy.NONE.applyDiscount(price);
        Assertions.assertThat(discountPrice).isEqualTo(price);
    }

    @Test
    void fixDiscountPolicy() {
        int price = 2000;
        int discountPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }
}