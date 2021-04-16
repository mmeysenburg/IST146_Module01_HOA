import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExamGradesTest {

  private ExamGrades eg1, eg2, eg3, eg4;
  private String expectedG3String;

  @Before
  public void setUp() throws Exception {
    // eg1 will have 101 "synthetic" grades, [0, 1, 2, ..., 100]
    eg1 = new ExamGrades(101);
    for(int i = 0; i < 101; i++) {
      eg1.setGrade(i, i);
    }

    // eg2 will have the normal random grades
    eg2 = new ExamGrades(50);

    // eg3 will be identical to eg2
    eg3 = new ExamGrades(50);
    int[] arr = new int[50];
    for(int i = 0; i < 50; i++) {
      eg3.setGrade(i, eg2.getGrade(i));
      arr[i] = eg2.getGrade(i);
    }

    // String for testing toString() method
    expectedG3String = Arrays.toString(arr);

    // eg4 will be same size as eg2, eg3, but different contents
    eg4 = new ExamGrades(50);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetNumberOfGrades() {
    assertEquals(101, eg1.getNumberOfGrades());
    assertEquals(50, eg2.getNumberOfGrades());
    assertEquals(50, eg3.getNumberOfGrades());
    assertEquals(50, eg3.getNumberOfGrades());
  }

  @Test
  public void testGetGrade() {
    assertEquals(0, eg1.getGrade(0));
    assertEquals(100, eg1.getGrade(100));
  }

  @Test
  public void testSetGrade() {
    assertTrue(eg1.setGrade(0, 1));
    assertEquals(1, eg1.getGrade(0));
    eg1.setGrade(0, 0);
    eg1.setGrade(100, 1);
    assertEquals(1, eg1.getGrade(100));
    eg1.setGrade(100, 100);

    // should return false if we provide an invalid grade
    assertFalse(eg1.setGrade(0, -1));
    assertFalse(eg1.setGrade(0, 101));
  }

  @Test
  public void testGetLowestGrade() {
    assertEquals(0, eg1.getLowestGrade());
  }

  @Test
  public void testGetHighestGrade() {
    assertEquals(100, eg1.getHighestGrade());
  }

  @Test
  public void testGetMeanGrade() {
    assertEquals(50.0, eg1.getMeanGrade(), 0.0);
  }

  @Test
  public void testEquals() {
    assertFalse(eg1.equals("NOPE"));
    assertTrue(eg2.equals(eg3));
    assertFalse(eg1.equals(eg2));
    assertFalse(eg2.equals(eg4));
  }

  @Test
  public void testToString() {
    assertEquals(expectedG3String, eg3.toString());
  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("ExamGradesTest");
  }

}