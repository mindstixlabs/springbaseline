/**
 * Released under the Creative Commons License.
 */
package com.mindstix.sample.dto;

/**
 * Enterprise DTO: Represents an Enterprise Entity.
 *
 * @author roshan
 */
public class Enterprise {

    private Employee[] employees;

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

}
