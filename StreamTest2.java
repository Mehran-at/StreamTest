import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;

//      Create the StreamsTest class. Write the next points of this exercise as tests asserting the expectations.
class StreamTest2 {
    //      Use the FileReader to create an attribute called names that is a list of String reading the names.txt file.
    FileReader fileReader = new FileReader();
    //      Create a list with the names that are shorter than four characters. Check that the output is correct.
    List<String> names = fileReader.asList("source/names.txt");

    @Test
    void shorterThanFourWords() {
        List<String> actual = this.names.stream().filter(e -> e.length() < 4).collect(Collectors.toList());
        List<String> expected = Arrays.asList("El");
        assertEquals(expected, actual);
    }
    //      Create a list with the names that end with the letter “m” and make them upper case. Check that the output is correct.
    @Test
    void namesEndWithM() {
        List<String> actual = names.stream().filter(e -> e.endsWith("m")).map(e -> e.toUpperCase()).collect(Collectors.toList());
        List<String> expected = Arrays.asList("HOSAM", "TAMMAM");
        assertEquals(expected, actual);
    }

    //      Create a list with the names that contain the letters “e” and “r”. Check that the output is correct.
    @Test
    void namesWithLettersEandR() {
        List<String> actual = names.stream().filter(e -> e.contains("e") && e.contains("r")).collect(Collectors.toList());
        List<String> expected = Arrays.asList("Mehran", "Norbert", "Serife");
        assertEquals(expected, actual);
    }
//      Create a list with the names that are exactly four characters long, make them lower case, keep those that
// contain the letters “a” and “m” and duplicate the number of letter “a”s that they have.
        @Test void getNamesWith4Charecters() {
            List<String> actual = names.stream()
                    .filter(e -> e.length() == 4).map(e -> e.toLowerCase())
                    .filter(e -> e.contains("a") && e.contains("m"))
                    .map(e -> e.replaceAll("a", "aa"))
                    .collect(Collectors.toList());
            List<String> expected2 = Arrays.asList("maarj", "aamin", "omaar");
            assertEquals(expected2, actual);
        }
    }