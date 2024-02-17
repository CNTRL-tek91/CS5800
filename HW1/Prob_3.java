import org.w3c.dom.Text;

class Instructor{
    private String firstName, lastName, officeNumber;

    public Instructor(String firstName, String lastName, String officeNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getOfficeNumber(){
        return officeNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}

class Textbook{
    private String title, author, publisher;

    public Textbook(String title, String author, String publisher){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

class Course{
    private String courseName;
    private Instructor instructor;
    private Textbook textbook;

    public Course(String courseName, Instructor instructor, Textbook textbook){
        this.courseName = courseName;
        this.instructor = instructor;
        this.textbook = textbook;
    }

    public void display(){
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor Name(First and Last): " + instructor.getFirstName() + " " + instructor.getLastName());
        System.out.println("Textbook(Title and Author): " + textbook.getTitle() + " " + textbook.getAuthor());
    }
}


public class Prob_3 {
    public static void main(String[] args){
        Instructor instructor = new Instructor("Nima", "Davarpanah", " 3-2636");
        Textbook textbook = new Textbook("Clean Code", "Robert Martin", "Publisher 1");
        Course course = new Course ("CS5800", instructor, textbook);


        //Modify
        Instructor instructor2 = new Instructor("Albert", "Einstein", "1-2345");
        Textbook textbook2 = new Textbook("General Relativity", "Albert Einstein", "Publisher 2");
        Course course2 = new Course("PHYS100", instructor2, textbook2);

        course.display();
        System.out.println("\n");
        course2.display();
    }
}
