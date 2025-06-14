package practice6_3;

/**
 * This class contains a utility method to process an array of strings
 * using a functional interface (StringAnalyzer) to apply different string analysis operations.
 */
public class AnalyzerTool {

    /**
     * Iterates over the given list of strings and applies the analyzer's logic.
     * Prints matching strings based on the condition defined by the analyzer.
     *
     * @param strList   Array of strings to analyze
     * @param searchStr String to search for in each element
     * @param analyzer  Functional interface used to define custom comparison logic
     */
    public void showResult ( String[] strList, String searchStr, StringAnalyzer analyzer ) {
        for (String current : strList) {
            if (analyzer.analyze(current, searchStr)) {
                System.out.println("Match: " + current);
            }
        }
    }
}

