package LAB211week5;

public class Course {
    protected String courseID;
    protected String courseName;
    protected int credits;

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }

    public void inputAll(java.util.Scanner sc) {
        // Để CourseManager gọi và kiểm tra tính duy nhất
        System.out.print("Course ID: ");
        this.courseID = sc.nextLine().trim();
        System.out.print("Course name: ");
        this.courseName = sc.nextLine().trim();
        while (true) {
            System.out.print("Credits: ");
            try {
                this.credits = Integer.parseInt(sc.nextLine().trim());
                if (this.credits > 0) break;
            } catch (Exception e) {}
            System.out.println("Data input is invalid");
        }
    }

    public String getCourseID() { return courseID; }
    public void setCourseID(String courseID) { this.courseID = courseID; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
} 