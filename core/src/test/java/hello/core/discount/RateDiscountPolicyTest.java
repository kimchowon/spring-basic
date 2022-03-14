package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_discount() {
        // given
        Member member = new Member(1L, "memverVIP", Grade.VIP);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        assertEquals(discount, 1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void basic_not_discount() {
        // given
        Member member = new Member(1L, "memverBASIC", Grade.BASIC);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        assertEquals(discount, 0);
    }
}