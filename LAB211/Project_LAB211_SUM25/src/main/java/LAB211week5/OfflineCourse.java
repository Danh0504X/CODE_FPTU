package LAB211week5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OfflineCourse extends Course {
    private LocalDate begin;
    private LocalDate end;
    private String campus;
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");

    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";
    }

    @Override
    public void inputAll(java.util.Scanner sc) {
        super.inputAll(sc);
        while (true) {
            System.out.print("Begin: ");
            try {
                this.begin = LocalDate.parse(sc.nextLine().trim(), fmt);
                if (this.begin.isAfter(LocalDate.now())) break;
            } catch (Exception e) {}
            System.out.println("Data input is invalid");
        }
        while (true) {
            System.out.print("End: ");
            try {
                this.end = LocalDate.parse(sc.nextLine().trim(), fmt);
                if (this.end.isAfter(this.begin)) break;
                else System.out.println("Data input is invalid, end must be after begin");
            } catch (Exception e) {
                System.out.println("Data input is invalid");
            }
        }
        while (true) {
            System.out.print("Campus: ");
            this.campus = sc.nextLine().trim();
            if (this.campus.isEmpty()) {
                System.out.println("Data input is invalid");
            } else break;
        }
    }

    public LocalDate getBegin() { return begin; }
    public void setBegin(LocalDate begin) { this.begin = begin; }
    public LocalDate getEnd() { return end; }
    public void setEnd(LocalDate end) { this.end = end; }
    public String getCampus() { return campus; }
    public void setCampus(String campus) { this.campus = campus; }
} 