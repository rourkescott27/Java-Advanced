package practice6_3;

/**
 * A functional interface used for analyzing strings.
 * Accepts two string parameters: the target string and a search string.
 * Returns true if the target meets the specified condition.
 */
@FunctionalInterface
public interface StringAnalyzer {
    boolean analyze ( String target, String searchStr );
}

