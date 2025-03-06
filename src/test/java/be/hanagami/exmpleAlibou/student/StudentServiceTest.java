package be.hanagami.exmpleAlibou.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSuccessfullySaveAStudent() {
        //Given
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "John@email.com",
                1
        );
        Student student =  new Student(
                "John",
                "Doe",
                "John@email.com",
                1
        );
        Student saveStudent =  new Student(
                "John",
                "Doe",
                "John@email.com",
                1
        );
        saveStudent.setId(1);

        //Mock the calls
        //because in isolation so using mock
        when(studentMapper.toStudent(dto))
                .thenReturn(student);
        when(studentRepository.save(student))
                .thenReturn(saveStudent);
        when(studentMapper.toStudentResponseDto(saveStudent))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "John@email.com"
                ));

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstname(), responseDto.firstname());
        assertEquals(dto.lastname(), responseDto.lastname());
        assertEquals(dto.email(), responseDto.email());

        verify(studentMapper, Mockito.times(1))
                .toStudent(dto);
        verify(studentRepository, Mockito.times(1))
                .save(student);
        verify(studentMapper, Mockito.times(1))
                .toStudentResponseDto(saveStudent);
    }

    @Test
    public void shouldReturnAllStudent() {
        List<Student> students = new ArrayList<>();
        Student student =  new Student(
                "John",
                "Doe",
                "John@email.com",
                1
        );
        students.add(student);

        when(studentRepository.findAll())
                .thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "John@email.com"
                ));

        List<StudentResponseDto> responseDtos = studentService.findAllStudents();

        assertEquals(students.size(), responseDtos.size());
        verify(studentRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldReturnStudentById() {
        Integer studentId = 1;
        Student student =  new Student(
                "John",
                "Doe",
                "John@email.com",
                20
        );
        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "John@email.com"
                ));

        StudentResponseDto dto = studentService.findStudentsById(studentId);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());

        verify(studentRepository, Mockito.times(1)).findById(studentId);
    }

    // /!!!\
    @Test
    public void shouldReturnStudentByName() {
        String firstName = "k";
        List<Student> students = new ArrayList<>();
        Student student =  new Student(
                "John",
                "Doe",
                "John@email.com",
                1
        );
        students.add(student);

        when(studentRepository.findAllByFirstnameContaining(firstName))
                .thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "John@email.com"
                ));

        var responseDtos = studentService.findStudentsByName(firstName);

        assertEquals(students.size(), responseDtos.size());

        verify(studentRepository, Mockito.times(1)).findAllByFirstnameContaining(firstName);
    }
}