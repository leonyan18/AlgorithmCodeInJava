package com.yan;

import com.yan.base.Solution;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AlgorithmCodeInJavaApplication {
    public static ConfigurableApplicationContext ac;

    public static void main(String[] args) {
        ac =SpringApplication.run(AlgorithmCodeInJavaApplication.class, args);
        ac.getBean(Solution.class).solve(System.in,System.out);
    }

}
