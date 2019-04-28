package com.follett.fss.diy2019.micronaut.hello;

import java.util.concurrent.atomic.AtomicLong;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class HelloController {

    private final AtomicLong counter = new AtomicLong();

    @Get(uri = "hello", produces = MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello DIYConf2019 (" + counter.incrementAndGet() + ")";
    }

    @Get(uri = "naptime", produces = MediaType.TEXT_PLAIN)
    public String naptime() {
        return "your slice of pi is " + pi_digits(20000);
    }

    private static String pi_digits(int digits) {
        int scale = 10000;
        int array_init = 2000;
        StringBuffer pi = new StringBuffer();
        int[] arr = new int[digits + 1];
        int carry = 0;

        for (int i = 0; i <= digits; ++i)
            arr[i] = array_init;

        for (int i = digits; i > 0; i -= 14) {
            int sum = 0;
            for (int j = i; j > 0; --j) {
                sum = sum * j + scale * arr[j];
                arr[j] = sum % (j * 2 - 1);
                sum /= j * 2 - 1;
            }

            pi.append(String.format("%04d", carry + sum / scale));
            carry = sum % scale;
        }
        return pi.toString();
    }
}