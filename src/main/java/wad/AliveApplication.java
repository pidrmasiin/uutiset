package wad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AliveApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliveApplication.class, args);
    }

    public static String githubUrl() {
        return "https://github.com/pidrmasiin/aliveTest";
    }

    public static String travisUrl() {
        return "https://travis-ci.org/pidrmasiin/aliveTest";
    }

    public static String herokuUrl() {
        return "https://young-forest-25181.herokuapp.com/";
    }
}
