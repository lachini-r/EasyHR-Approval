package test;

import HR.HRManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private HRManagement hrManagement;

    @BeforeEach
    public void setUp() {
        hrManagement = new HRManagement();
    }

    @Test
    public void testAddEmployee() {
        System.out.println("Testing:testAddEmployee");
        hrManagement.addEmployee("Lachini", "SE");
        assertEquals(1, hrManagement.getEmployees().size(), "Employee list size should be 1");
        assertEquals("Lachini", hrManagement.getEmployees().get(0).getName(), "Employee name should be 'Lachini'");
        System.out.println("______________________");
    }

    @Test
    public void testApproveEmployeeById() {
        System.out.println("Testing:testApproveEmployeeById");
        hrManagement.addEmployee("Lachini", "SE");
        int id = hrManagement.getEmployees().get(0).getId();
        hrManagement.approveEmployeeById(id);
        assertTrue(hrManagement.getEmployees().get(0).isApproved(), "Employee should be approved");
        System.out.println("______________________");
    }

    @Test
    public void testViewEmployees() {
        System.out.println("Testing:testViewEmployees");
        hrManagement.addEmployee("Lachini", "SE");
        // Did not test the console output here, instead verify the employee count.
        assertEquals(1, hrManagement.getEmployees().size(), "Employee list size should be 1");
        System.out.println("______________________");
    }

    @Test
    public void testApproveNonExistentEmployeeById() {
        System.out.println("Testing:testApproveNonExistentEmployeeById");
        hrManagement.approveEmployeeById(100);
        assertTrue(hrManagement.getEmployees().size() > 0, "No such employee");
        System.out.println("______________________");
    }


    @Test
    public void testAddEmployeeWithoutName() {
        System.out.println("Testing:testAddEmployeeWithoutName");
        hrManagement.addEmployee("", "SE");
        assertTrue(hrManagement.getEmployees().isEmpty(), "Compulsory to add the name of an employee");
        System.out.println("______________________");
    }
}