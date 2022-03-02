package learn.demo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName(" Simple control Test")
public class SimlpeTest {

    @Test
    @DisplayName("Ожидаемый зеленый")
    void SimlpeGreenTest() {
        assertTrue(3 > 2);
    }

    @Test
    @DisplayName(" Ожидаемый красный")
     void SimlpeRedTest() {
        assertTrue(3 < 2);
    }

    @Test
    @Disabled(" Jira bug -- ")
    void SimlpeBrokenTest() {
        throw new IllegalStateException( " Broken : (");
    }

}
