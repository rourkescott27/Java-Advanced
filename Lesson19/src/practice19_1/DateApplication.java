package practice19_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class DateApplication {
    // PrintWriter to output text to the console with automatic flushing
    PrintWriter pw = new PrintWriter(System.out, true);
    // BufferedReader to read input from the console (keyboard)
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Locale object for Russian language and Russia country
    Locale ruLocale = new Locale("ru", "RU");
    // Current locale set to US English by default
    Locale currentLocale = Locale.US;
    // ResourceBundle to load localized messages for the current locale
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", Locale.US);

    // Current date and time when the program starts
    LocalDateTime today = LocalDateTime.now();
    // DateTimeFormatter used to format date and time in different styles/locales
    DateTimeFormatter df;

    public static void main ( String[] args ) {
        // Create an instance of DateApplication
        DateApplication dateApp = new DateApplication();
        // Run the main program loop
        dateApp.run();
    }

    public void run () {
        String line = "";

        // Main loop that continues until user inputs "q" to quit
        while (!(line.equals("q"))) {
            // Display the date menu with formatted dates and language options
            this.printMenu();
            try {
                // Read user input from console
                line = this.br.readLine();
            } catch (IOException e) {
                // Print error message if reading input fails
                System.out.println("Error: " + e.getMessage());
            }

            // Switch statement to handle user's language choice
            switch (line) {
                case "1":
                    this.setEnglish();  // Change locale to English (US)
                    break;
                case "2":
                    this.setFrench();   // Change locale to French (France)
                    break;
                case "3":
                    this.setChinese();  // Change locale to Simplified Chinese
                    break;
                case "4":
                    this.setRussian();  // Change locale to Russian (Russia)
                    break;
            }
        }
    }

    public void printMenu () {
        pw.println("=== Date App ===");

        // Format and print the date in FULL style using the current locale
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(currentLocale);
        pw.println(messages.getString("date1") + " " + today.format(df));

        // Format and print the date in LONG style
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(currentLocale);
        pw.println(messages.getString("date2") + " " + today.format(df));

        // Format and print the date in SHORT style
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(currentLocale);
        pw.println(messages.getString("date3") + " " + today.format(df));

        // Format and print date and time in MEDIUM style
        df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(currentLocale);
        pw.println(messages.getString("date4") + " " + today.format(df));

        // Format and print the time only in MEDIUM style
        df = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(currentLocale);
        pw.println(messages.getString("date5") + " " + today.format(df));

        // Print the language selection menu using localized message strings
        pw.println("\n--- Choose Language Option ---");
        pw.println("1. " + messages.getString("menu1"));
        pw.println("2. " + messages.getString("menu2"));
        pw.println("3. " + messages.getString("menu3"));
        pw.println("4. " + messages.getString("menu4"));
        pw.println("q. " + messages.getString("menuq"));

        // Prompt the user to enter their choice
        System.out.print(messages.getString("menucommand") + " ");
    }

    public void setEnglish () {
        // Change the current locale to English (United States)
        currentLocale = Locale.US;
        // Reload the messages ResourceBundle for the new locale
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setFrench () {
        // Change the current locale to French (France)
        currentLocale = Locale.FRANCE;
        // Reload the messages ResourceBundle for the new locale
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setChinese () {
        // Change the current locale to Simplified Chinese
        currentLocale = Locale.SIMPLIFIED_CHINESE;
        // Reload the messages ResourceBundle for the new locale
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setRussian () {
        // Change the current locale to Russian (Russia)
        currentLocale = ruLocale;
        // Reload the messages ResourceBundle for the new locale
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }
}
