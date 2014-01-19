/**
 * Released under the Creative Commons License.
 */
package com.mindstix.sample.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Enterprise DTO: Represents an Enterprise Entity.
 *
 * @author roshan
 */
@XmlRootElement
public class Enterprise {

    private String name;
    private String location;
    private Employee[] employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

}
