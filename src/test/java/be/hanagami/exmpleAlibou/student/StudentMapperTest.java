package be.hanagami.exmpleAlibou.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    public StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        //Given
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "John@email.com",
                1
        );
        //When
        Student student = mapper.toStudent(dto);

        //Then
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    //must be change the toStudents method with a if
    @Test
    //public void shouldMapStudentDtoToStudentWhenStudentDtoIsNull(){
    public void shouldThrowNullPointerExceptionWhenStudentDtoIsNull(){
        assertThrows(NullPointerException.class, () -> mapper.toStudent(null));

        var exp =assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto should not be null", exp.getMessage());

//        Student student = mapper.toStudent(null);
//        assertEquals("", student.getFirstname());
//        assertEquals("", student.getLastname());

    }

    @Test
    public void shouldMapStudentToStudentResponseDto(){
        Student student = new Student(
                "Jane",
                "Doe",
                "jane@email.com",
                1
        );
        StudentResponseDto responseDto = mapper.toStudentResponseDto(student);

        assertEquals(responseDto.firstname(), student.getFirstname());
        assertEquals(responseDto.lastname(), student.getLastname());
        assertEquals(responseDto.email(), student.getEmail());
    }

}