package aptech.data.manager;

import aptech.data.impl.Student;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Say Rattana
 */
public class StudentManager {
    private ArrayList<Student> students = new ArrayList<Student>();
    private int numberOfStudents = 0;
    private Scanner scanner = new Scanner(System.in);
    
    public void addStudent(){
        System.out.print("Number of Students: ");
        this.numberOfStudents = scanner.nextInt();
        for(int i = 0; i < numberOfStudents; i++) {
            Student newStudent = new Student();
            newStudent.input();
            this.students.add(newStudent);
        }
    }
    
    public void displayAllStudent() {
              
        //iterate an arraylist
        int i = 0;
        for(Student eachStudent: this.students) {
            //iterate a list of Students
            System.out.print("Student: "+(i+1));
            eachStudent.show();
            System.out.println("");
            i++;
            
        }   
    }
    
    public  void searchByClassName(String className) {
        //search = filter = "query"        
        ArrayList<Student> result = (ArrayList<Student>)this.students.stream().filter(
                //lambda function = anonymous function
                eachStudent -> {
                    return (eachStudent.getClassName().toLowerCase()).equals(className.toLowerCase());
                }
        ).collect(Collectors.toList());     
        if(result.isEmpty()) {
            System.out.println("Cannot find students with class's name : " + className + "\n");
        } else {
            for(Student eachStudent: result) {
            //iterate a list of books            
                eachStudent.show();           
            }
        }
    }
    
    //How to delete/remove an item in ArrayList ?
    public void deleteByClassName( String className) {
        
        ArrayList<Student> result = (ArrayList<Student>)this.students
                .stream()
                .filter(eachReclassName -> {
                        //this function return to true/false
                        return !eachReclassName.getClassName().equals(className);
                })
                .collect(Collectors.toList());
        if(result.size() < this.students.size()) {            
            this.students = result;
            System.out.println("Delete successfully !");
        } else {
            System.out.println("Cannot find class's name to delete: "+ className);
        }
    }
    
/*    
    public void deleteByID( int stuid) {        
        ArrayList<Student> result = (ArrayList<Student>)this.students
                .stream()
                .filter(eachID -> {
                        //this function return to true/false
                        return !(eachID.getId()==stuid);
                })
                .collect(Collectors.toList());
        if(result.size() < this.students.size()) {            
            this.students = result;
            System.out.println("Delete successfully");
        } else {
            System.out.println("Cannot find ID to delete");
        }
    }
*/    
    
    
    
    
}
