/**
 * Released under the Creative Commons License.
 */
package com.mindstix.sample.dto;

/**
 * Employee DTO: Represents an Employee Entity.
 *
 * @author roshan
 */
public class Employee {

    private int employeeId;
    private String name;
    private String title;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
