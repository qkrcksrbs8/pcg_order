package cg.park.pcg_order.api.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Order Service !!", HttpStatus.OK);
    }

    @GetMapping("/info")
    public Mono<String> getInfo(ServerHttpRequest request, OrderController response) {
        logger.info("Order MicroService Start: ");
        HttpHeaders headers = request.getHeaders();
        headers.forEach((k, v) -> {
            logger.info(k + " : " + v);
        });
        logger.info("Order MicroService End: ");

        return Mono.just("This is Order MicroService!!!!!");
    }

}
