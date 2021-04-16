import java.util.Scanner;

/**
 * Main class for IST 146 HOA 1.
 *
 * @author Mark M. Meysenburg
 * @version 1.0
 */
class Main {
  /**
   * Application entry point.
   *
   * @param args Command-line arguments; ignored by this
   * application.
   */
  public static void main(String[] args) {
    // Prompt for and get number of students
    Scanner stdin = new Scanner(System.in);
    System.out.print("Enter number of students: ");
    int n = stdin.nextInt();

    // Create the ExamGrades object
    ExamGrades eg = new ExamGrades(n);

    // Populate ExamGrades object from user input
    for(int i = 0; i < n; i++) {
      System.out.printf("Enter grade %d: ", i + 1);
      int grade = stdin.nextInt();
      if(!eg.setGrade(i, grade)) {
        // invalid grade? bug user until it is correct
        do {
          System.out.println("Each grade must be in" +
            " [0, 100]. Please try again.");
          System.out.printf("Enter grade %d: ", i + 1);
          grade = stdin.nextInt();
        } while(!eg.setGrade(i, grade));
      }
    }

    // Test the ExamGrades object's primary methods
    System.out.printf("Here are the %d grades you entered:",
      eg.getNumberOfGrades());
    System.out.println(eg);
    System.out.printf("The minimum grade was: %3d\n", 
      eg.getLowestGrade());
    System.out.printf("The maximum grade was: %3d\n",
      eg.getHighestGrade());
    System.out.printf("The mean grade is: %3.2f\n",
      eg.getMeanGrade());
  }
}