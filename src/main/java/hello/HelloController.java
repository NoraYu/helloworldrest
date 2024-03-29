package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private static final String template2 = "Do you want to have some %s?";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Hello hello(@RequestParam(value="name", defaultValue="World") String name) {
        return new Hello(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/food")
    public Hello Eat(@RequestParam(value="food", defaultValue="candy") String food) {
        return new Hello(counter.incrementAndGet(),
                String.format(template2, food));}
}

