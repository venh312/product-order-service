package productorderservice.demo.payment;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;
import productorderservice.demo.payment.service.PaymentRequest;

public class PaymentSteps {
    public static PaymentRequest 주문결제요청_생성() {
        Long orderId = 1L;
        String cardNumber = "1100-2302-0032";
        return new PaymentRequest(orderId, cardNumber);
    }

    public static ExtractableResponse<Response> 주문결제요청(PaymentRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/payments")
                .then().log().all()
                .extract();
    }
}