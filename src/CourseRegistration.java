import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> students;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.students = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
            return true;
        }
        return false;
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description
                + "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        registeredCourses.add(course);
        course.addStudent(this);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.removeStudent(this);
    }

    @Override
    public String toString() {
        return "Student ID: " + id + "\nName: " + name;
    }
}

public class CourseRegistration {
    public static void main(String[] args) {
        Course mathCourse = new Course("MATH101", "Mathematics", "Basic math course", 30, "MWF 9:00 AM");
        Course physicsCourse = new Course("PHYS101", "Physics", "Introductory physics course", 25, "TTH 2:00 PM");
        Course chemCourse = new Course("Chem101", "Chemistry", "Introductory chemistry course", 25, "TTH 4:00 PM");


        Student student1 = new Student(1, "Ram");
        Student student2 = new Student(2, "Lakshman");
        Student student3 = new Student(3, "Sita");

        student1.registerForCourse(mathCourse);
        student2.registerForCourse(physicsCourse);
        student3.registerForCourse(chemCourse);

        System.out.println("Course Listings:");
        System.out.println("---------------");
        System.out.println(mathCourse);
        System.out.println();
        System.out.println(physicsCourse);
        System.out.println();
        System.out.println(chemCourse);

        System.out.println("\nStudent Registrations:");
        System.out.println("----------------------");
        System.out.println(student1.getName() + " registered for " + student1.getRegisteredCourses().size() + " course(s):");
        for (Course course : student1.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.println();
        System.out.println(student2.getName() + " registered for " + student2.getRegisteredCourses().size() + " course(s):");
        for (Course course : student2.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.println();
        System.out.println(student3.getName() + " registered for " + student3.getRegisteredCourses().size() + " course(s):");
        for (Course course : student3.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }

        student1.dropCourse(mathCourse);
        student2.dropCourse(physicsCourse);
        student3.dropCourse(chemCourse);

        System.out.println("\nUpdated Student Registrations:");
        System.out.println("-----------------------------");
        System.out.println(student1.getName() + " registered for " + student1.getRegisteredCourses().size() + " course(s):");
        for (Course course : student1.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.println();
        System.out.println(student2.getName() + " registered for " + student2.getRegisteredCourses().size() + " course(s):");
        for (Course course : student2.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.println();
        System.out.println(student3.getName() + " registered for " + student3.getRegisteredCourses().size() + " course(s):");
        for (Course course : student3.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
    }
}
