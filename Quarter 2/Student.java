/* Assignment: Student Class Implementation
 *
 * Create a Student class that manages student course schedules.
 * Requirements:
 * 1. Private instance variables for:
 *    - name (String)
 *    - id (int)
 *    - courses (array of 8 Strings)
 *
 * 2. Implement:
 *    - Two constructors
 *    - Methods for managing courses (add, drop, swap)
 *    - Getters and setters for name and id
 *    - toString method
 */

import java.util.Arrays;

public class Student {
    // TODO: Declare private instance variables
    private String name;
    private int id;
    private String[] courses;

    // TODO: Create constructor that takes name and id
    // Initialize courses array with size 8 (periods 1-8)
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        courses = new String[8]; // faster than looping
    }

    // TODO: Create constructor that takes only name
    // Should call first constructor with id = -1
    public Student(String name) {
        this(name, -1);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // TODO: Implement addCourse method
    // Parameters: int periodNumber, String courseName
    // Should validate period number (1-8)
    // Should store course name in appropriate array index
    public void addCourse(int periodNumber, String courseName) {
        if (periodNumber > 8 || periodNumber < 1)
            throw new IllegalArgumentException("Period outside of valid range 1-8");
        courses[periodNumber - 1] = courseName;
    }

    // TODO: Implement dropCourse method
    // Parameter: int periodNumber
    // Should validate period number (1-8)
    // Should set course name of specified period to null
    // Should return dropped course name or null
    public String dropCourse(int periodNumber) {
        if (periodNumber > 8 || periodNumber < 1)
            throw new IllegalArgumentException("Period outside of valid range 1-8");
        String t=courses[periodNumber - 1];
        courses[periodNumber - 1] = null;
        return t;
    }
    // TODO: Implement swapCourses method
    // Parameters: int period1, int period2
    // Should validate both period numbers (1-8)
    // Should swap courses in the specified periods
    // Should return true if swap successful, false if either period invalid
    public boolean swapCourses(int period1, int period2){
        if(period1>8 || period1<1 || period2>8 || period2<1) return false;
        String t=courses[period1-1];
        courses[period1-1]=courses[period2-1];
        courses[period2-1]=t;
        return true;
    }
    // TODO: Implement toString method
    // Should return name, id, and list of courses by period
    @Override
    public String toString(){
        return "Student " + name +" with ID " + id + " taking courses " + Arrays.asList(courses).toString().substring(1, Arrays.asList(courses).toString().length()-1);
    }
}
