package wad;


import org.junit.*;
import static org.junit.Assert.assertTrue;

public class AliveTest {


    @Test
    public void hasGithub() {
        assertTrue(AliveApplication.githubUrl().contains("github.com/"));
    }

    @Test
    public void hasTravis() {
        assertTrue(AliveApplication.travisUrl().contains("travis-ci.org/"));
    }

    @Test
    public void hasHerokuapp() {
        assertTrue(AliveApplication.herokuUrl().contains("herokuapp.com"));
    }

}
