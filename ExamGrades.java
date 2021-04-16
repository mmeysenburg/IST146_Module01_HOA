import java.util.*;

/**
 * Class encapsulating a collection of exam grades.
 *
 * @author Mark M. Meysenburg
 * @version 1.0
 */
public class ExamGrades {
  // Array holding the exam grades
  private int[] grades;

  /**
   * Construct an instance of ExamGrades to hold a 
   * specified number of students, and randomly
   * populate the grades with values in [0, 100].
   *
   * @param numStudents Number of student exam scores
   * to store.
   */
  public ExamGrades(int numStudents) {
    // create the array to hold grades
    grades = new int[numStudents];

    // fill with random values between 0 and 100
    Random prng = new Random();
    for(int i = 0; i < grades.length; i++) {
      setGrade(i, prng.nextInt(101));
    }
  }

  /**
   * Get the number of exam grades stored in this 
   * object.
   *
   * @return Number of grades stored
   */
  public int getNumberOfGrades() {
    return grades.length;
  }

  /**
   * Return the exam grade associated with a specific 
   * student.
   *
   * @param studentNum Index of student exam grade 
   * to get
   * @return Grade associated with studentNum
   */
  public int getGrade(int studentNum) {
    return grades[studentNum];
  }

  /**
   * Change the exam grade associated with a specific
   * student.
   *
   * @param studentNum Indext of the student exam 
   * grade to change
   * @param grade New grade for the specified student;
   * must be in [0, 100].
   * @return true if the grade was set successfully, false
   * if it an invalid grade was provided
   */
  public boolean setGrade(int studentNum, int grade) {
    // TODO: write this method

    // TODO: this is a stub statement - remove / modify
    return true;
  }

  /**
   * Get the lowest exam score stored in this object.
   *
   * @return Lowest exam score stored.
   */
  public int getLowestGrade() {
    int min = Integer.MAX_VALUE;
    for(int grade : grades) {
      if(grade < min) {
        min = grade;
      }
    }
    return min;
  }

  /**
   * Get the highest exam score stored in this object.
   *
   * @return Highest exam score stored.
   */
  public int getHighestGrade() {
    // TODO: write this method

    // TODO: this is a stub statement - remove / modify
    return Integer.MIN_VALUE;
  }

  /**
   * Get the mean of the exam grades stored in this
   * object.
   *
   * @return Mean exam score.
   */
  public double getMeanGrade() {
    // TODO: write this method

    // TODO: this is a stub statement - remove / modify
    return Double.NEGATIVE_INFINITY;
  }

  @Override
  public boolean equals(Object obj) {
    // only proceed if obj is an ExamGrades object
    if(obj instanceof ExamGrades) {
      // typecast to shorten code below
      ExamGrades other = (ExamGrades)obj;

      // if the number of grades in each object aren't 
      // the same, they are not equal
      if(grades.length != other.grades.length) {
        return false;
      }

      // if the grades in each are not the same, and in
      // the same order, they are not equal
      for(int i = 0; i < grades.length; i++) {
        if(grades[i] != other.grades[i]) {
          return false;
        }
      }

      // if we got through all of the above, they are equal
      return true;
    }

    // default: objects aren't equal
    return false;
  }

  @Override
  public String toString() {
    // use the Arrays.toString() method to send back
    // a String representation of the grades in this
    // object
    return Arrays.toString(grades);
  }
}