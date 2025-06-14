package practice6_3;

/**
 * This class tests various string analysis operations using lambda expressions.
 * It demonstrates how to pass different behaviors (contains, startsWith, etc.)
 * to a method via a functional interface.
 */
public class LambdaTest {
    public static void main ( String[] args ) {
        // Sample list of strings to search through
        String[] strList01 = {"tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"};

        AnalyzerTool stringTool = new AnalyzerTool();
        String searchStr = "to";

        System.out.println("Searching for: " + searchStr);

        // Lambda: check if string contains 'to'
        System.out.println("==Contains==");
        stringTool.showResult(strList01, searchStr,
                              ( t, s ) -> t.contains(s));

        // Lambda: check if string starts with 'to'
        System.out.println("==Starts With==");
        stringTool.showResult(strList01, searchStr,
                              ( t, s ) -> t.startsWith(s));

        // Lambda: check if string equals 'to'
        System.out.println("==Equals==");
        stringTool.showResult(strList01, searchStr,
                              ( t, s ) -> t.equals(s));

        // Lambda: check if string ends with 'to'
        System.out.println("==Ends With==");
        stringTool.showResult(strList01, searchStr,
                              ( t, s ) -> t.endsWith(s));

        // Lambda: contains 'to' and is shorter than 5 characters
        System.out.println("==Less than 5==");
        stringTool.showResult(strList01, searchStr,
                              ( t, s ) -> t.contains(s) && t.length() < 5);

        // Lambda: contains 'to' and is longer than 5 characters
        System.out.println("==Greater than 5==");
        stringTool.showResult(strList01, searchStr,
                              ( t, s ) -> t.contains(s) && t.length() > 5);
    }
}

