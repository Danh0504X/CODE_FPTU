package LAB211week5;

public class OnlineCourse extends Course {
    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    @Override
    public void inputAll(java.util.Scanner sc) {
        super.inputAll(sc);
        while (true) {
            System.out.print("Platform: ");
            this.platform = sc.nextLine().trim();
            if (this.platform.isEmpty()) {
                System.out.println("Data input is invalid");
            } else break;
        }
        System.out.print("Instructors: ");
        this.instructors = sc.nextLine().trim();
        while (true) {
            System.out.print("Note: ");
            this.note = sc.nextLine().trim();
            if (this.note.isEmpty()) {
                System.out.println("Data input is invalid");
            } else break;
        }
    }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    public String getInstructors() { return instructors; }
    public void setInstructors(String instructors) { this.instructors = instructors; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
} 