import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class holds the main program for the triangle analyzer.  It serves to setup the file input
 * and read the file, passing lines into the triangle analyzer as is appropriate.
 * @author schilling
 *
 */
public class MainProgram {
    public static void main(String[] args) {
        // Prompt the user for the file name.  The path can either be relative or absolute.
        Scanner kbd = new Scanner(System.in);
        System.out.println("Enter the name of the file you wish to process.");
        String filename = kbd.nextLine();

        File inputFile = new File(filename);
        try (Scanner theFile = new Scanner(inputFile)) {
            // Read in all of the lines from the file.
            while (theFile.hasNextLine()) {
                String textLine = theFile.nextLine();
                // Only process non-blank lines.
                if (textLine.length() > 0 && !textLine.startsWith("#")) {
                    // Instantiate a new object and print out the analysis of the triangle.
                    TriangleAnalyzer ta = new TriangleAnalyzer(textLine);
                    System.out.println(ta.getAnalysisString());
                }
            }
            // Catch the error in the case of not finding the file.
        } catch (FileNotFoundException e) {
            System.err.println("The file " + filename + " could not be found.");
        }
        // Close up open resources.
        kbd.close();
    }

}