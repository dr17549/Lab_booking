package com.dhammatorn.Dao;

import com.dhammatorn.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//telling spring that this is a repository for us
//spring instantiates spring beans for us without us telling it manually

@Repository
//Dao is database - the backend code
public class StudentDao {

    //key is the student id
    //and the actual student object
    private static Map<Integer, Student> students;

    //HTTP Put into database with these values
    static {

        students = new HashMap<Integer, Student>(){

            {
                // automatically put = command D
                put(1, new Student(1, "John", "Computer Science"));
                put(2, new Student(2, "Dave", "BiologyScience"));
            }
        };
    }

    //function to return all students
    public Collection<Student> getAllStudent(){
        return this.students.values();

    }
    //function to get Student by ID
    //copy this to service to connect them
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    //update student
    public void updateStudent(Student student){

        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(s.getName());
        students.put(student.getId(), student);

    }

}
