class InvalidCourseException extends Exception {
    InvalidCourseException(String msg) {
        super(msg);
    }
}

abstract class Course {
    private String subject;
    private String courseCode;
    private int credits;

    public Course(String subject, String courseCode, int credits) throws InvalidCourseException {
        setCourseCode(courseCode);
        setCredits(credits);
        setSubject(subject);
    }

    public int getCredits() {
        return credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setCourseCode(String courseCode) throws InvalidCourseException {
        if (courseCode == null || courseCode.isEmpty()) {
            throw new InvalidCourseException("Course code cannot be empty");
        }
        this.courseCode = courseCode;
    }

    public void setCredits(int credits) throws InvalidCourseException {
        if (credits <= 0) {
            throw new InvalidCourseException("Credit of course must be greater than zero");
        }
        this.credits = credits;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.isEmpty()) {
            subject = "Unknown";
        }
        this.subject = subject;
    }

    abstract void calculateWorkLoad();

    public void display() {
        System.out.println("Course : " + subject);
        System.out.println("Code   : " + courseCode);
        System.out.println("Credit : " + credits);
    }
}

class TheoryCourse extends Course {
    public TheoryCourse(String subject, String courseCode, int credits) throws InvalidCourseException {
        super(subject, courseCode, credits);
    }

    void calculateWorkLoad() {
        System.out.println("Workload : " + (getCredits() * 1.5));
    }
}

class LabCourse extends Course {
    public LabCourse(String subject, String courseCode, int credits) throws InvalidCourseException {
        super(subject, courseCode, credits);
    }

    void calculateWorkLoad() {
        System.out.println("Workload : " + (getCredits() * 1.2));
    }
}

public class universityCourseSystem {
    public static void main(String[] args) {
        try {
            Course lab = new LabCourse("Physics", "1024A", 15);
            Course theory = new TheoryCourse("Physics", "1024B", 2);

            lab.display();
            lab.calculateWorkLoad();

            theory.display();
            theory.calculateWorkLoad();

        } catch (InvalidCourseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
