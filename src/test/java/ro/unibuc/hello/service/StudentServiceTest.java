package ro.unibuc.hello.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.unibuc.hello.data.Student;
import ro.unibuc.hello.data.StudentRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStudent() {
        // Arrange
        Student student = new Student();
        student.setId("1");
        student.setName("John Doe");
        student.setFaculty("Computer Science");

        when(studentRepository.save(any(Student.class))).thenReturn(student);

        // Act
        Student savedStudent = studentService.saveStudent(student);

        // Assert
        assertEquals("1", savedStudent.getId());
        assertEquals("John Doe", savedStudent.getName());
        assertEquals("Computer Science", savedStudent.getFaculty());
    }
}
