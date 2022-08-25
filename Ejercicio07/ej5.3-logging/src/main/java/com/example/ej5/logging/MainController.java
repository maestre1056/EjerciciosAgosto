package com.example.ej5.logging;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {

        @RequestMapping("/mapping")
        public String index() {
            log.trace("Mensaje a nivel de TRACE");
            log.debug("Mensaje a nivel de DEBUG");
            log.info("Mensaje a nivel de INFO");
            log.warn("Mensaje a nivel de WARNING");
            log.error("Mensaje a nivel de ERROR");

            return "Hola! Mira los logs para ver los resultados";
        }
}