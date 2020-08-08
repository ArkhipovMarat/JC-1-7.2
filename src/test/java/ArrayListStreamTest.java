import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ArrayListStreamTest {
    @Test
    void streamTest () {
    List<Integer> arrayListInput = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
//    List<Integer> arrayListResult = Arrays.asList(2, 4, 8, 16, 32);

    Stream<Integer> stream = arrayListInput.stream();
    List<Integer> arrayListStream = stream
            .filter(x -> x > 0)
            .filter(x -> (x % 2)==0)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());

//    Assertions.assertEquals(arrayListResult,arrayListStream);

    assertThat(arrayListStream, contains(2, 4, 8, 16, 32));
    }
}
