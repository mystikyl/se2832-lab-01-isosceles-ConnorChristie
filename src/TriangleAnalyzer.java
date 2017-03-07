import java.util.Scanner;

/**
 * This class is responsible for helping to analyze whether a definition for a
 * triangle is valid or not. The suer will instantiate this class with an
 * instance of a line that represents a triangle definition. The program will
 * then analyze that to determine whether or not a valid triangle is defined.
 *
 * @author schilling
 *
 */
public class TriangleAnalyzer {

    private String triangledef = "";
    private String comment = "";
    private boolean validTriangle = true;
    private boolean equalateral = false;
    private boolean scalene = false;
    private boolean isosceles = false;
    private double triangleSides[] = new double[3];

    /**
     * This method will determine if the triangle is valid.
     *
     * @return The return will be true if the triangle is valid.
     */
    public boolean isValidTriangle() {
        return validTriangle;
    }

    /**
     * This method will determine if the triangle is equilateral.
     *
     * @return The return will be true if the triangle is equilateral.
     */
    public boolean isEqualateral() {
        return equalateral;
    }

    /**
     * This method will determine if the triangle is scalene.
     *
     * @return The return will be true if the triangle is scalene.
     */
    public boolean isScalene() {
        return scalene;
    }

    /**
     * This method will determine if the triangle is isosceles.
     *
     * @return The return will be true if the triangle is isosceles.
     */
    public boolean isIsosceles() {
        return isosceles;
    }

    /**
     * This method will return an analysis string. It will include n
     *
     * @return
     */
    public String getAnalysisString() {
        StringBuffer retString = new StringBuffer("The triangle ");

        retString.append(this.triangledef);

        if (validTriangle) {
            retString.append("is a valid triangle. ");

            if (equalateral) {
                retString.append("The triangle is an equilateral triangle.");
            } else if (isosceles) {
                retString.append("The triangle is an isosceles triangle.");
            } else {
                retString.append("The triangle is a scalene triangle.");
            }
        } else {
            retString.append("is not a valid triangle. ");
        }
        return retString.toString();
    }

    /**
     * This method will return the 3 sides of the triangle.
     *
     * @return The three sides will be returned as an array of doubles.
     */
    public double[] getTriangleSides() {
        return triangleSides;
    }

    /**
     * This method will return the definition of the sides of the given
     * triangle.
     *
     * @return The return is a copy of the string representing the triangle
     *         sides.
     */
    public String getTriangledef() {
        return triangledef;
    }

    /**
     * This method will return the comments related to the triangle definition.
     *
     * @return The return will be the triangle comments.
     */
    public String getComment() {
        return comment;
    }

    /**
     * This is the constructor for the class. It takes in a single parameter,
     * namely the definition for the triangle. This definition will then be used
     * to instantiate a new TrianglewAnalyzer which will analyze the given
     * entry.
     *
     * @param textLine
     *            This is the line of test representing the triangle. It
     *            consists of 3 numbers (a, b, c) which are whitespace separated
     *            representing the three sides of the triangle as well as an
     *            optional comments segment that follows.
     */
    public TriangleAnalyzer(String textLine) {
        // Start by splitting based on a hash character. ANything before the
        // hash is valid. Anything after the hash is a comment.
        int hashLocation = textLine.indexOf("#");

        if (hashLocation >= 0) {
            // There is both a definition and a comment on the line.
            triangledef = textLine.substring(0, hashLocation);
            comment = textLine.substring(hashLocation, textLine.length());
        } else {
            triangledef = textLine;
        }

        // Start by reading in the 3 sides of the triangle from the line.
        Scanner sideScanner = new Scanner(triangledef);
        triangleSides[0] = sideScanner.nextDouble();
        triangleSides[1] = sideScanner.nextDouble();
        triangleSides[2] = sideScanner.nextDouble();

        // Close the scanner now that we are done with the given line.
        sideScanner.close();

        // Now that we have the three sides, sort them in ascending order.
        // This way, the Hypotenuse will be in the last location as the longest
        // side.
        java.util.Arrays.sort(triangleSides);

        // Now determine if the triangle is valid.
        if ((triangleSides[0] + triangleSides[2] >= triangleSides[1])
                && (triangleSides[1] + triangleSides[2] >= triangleSides[0])) {
            validTriangle = true;
        }

        if (validTriangle) {
            // Now that we know that the triangle is valid, lets analyze it.
            // Determine if all three sides are the same.
            if ((triangleSides[0] == triangleSides[1]) && (triangleSides[1] == triangleSides[2])) {
                equalateral = true;
            }

            // Now lets determine if two of the sides are the same.
            if ((triangleSides[0] == triangleSides[1]) || (triangleSides[0] == triangleSides[2])) {
                isosceles = true;
            }

            // Now lets determine if all three sides are different.
            if ((triangleSides[0] != triangleSides[1]) && (triangleSides[1] != triangleSides[2])
                    && (triangleSides[0] != triangleSides[2])) {
                scalene = true;
            }
        }
    }
}