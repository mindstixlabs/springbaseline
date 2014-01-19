/**
 * Released under the Creative Commons License.
 */
package com.mindstix.sample.controller;

import com.mindstix.sample.dto.Employee;
import com.mindstix.sample.dto.Enterprise;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Sample REST Controller
 *
 * @author Roshan Kulkarni
 */
@Controller
@RequestMapping("/api/v1")
public class SampleRESTController {

    // Get log4j handler
    private static final Logger logger = Logger.getLogger(SampleController.class);

    /**
     * REST API without any Input Parameter.
     *
     * @return Enterprise
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @ResponseBody
    public Enterprise getEnterprise() {

        // Employee 1 (Assume this gets fetched from the DB)
        Employee emp1 = new Employee();
        emp1.setEmployeeId(1);
        emp1.setName("John Doe");
        emp1.setTitle("Software Engineer");

        // Employee 2 (Assume this gets fetched from the DB)
        Employee emp2 = new Employee();
        emp2.setEmployeeId(2);
        emp2.setName("Jane Doe");
        emp2.setTitle("Software Analyst");

        // Generate Response
        Enterprise myEnterprise = new Enterprise();
        myEnterprise.setName("Example Corporation");
        myEnterprise.setLocation("United States of America");
        myEnterprise.setEmployees(new Employee[]{emp1, emp2});
        return myEnterprise;

    }

    /**
     * REST API that reads an input parameter received in a URL Segment.
     *
     * @param employeeId
     * @return Employee
     */
    @RequestMapping(value = "/enterprise/{enterpriseId}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(@PathVariable int employeeId) {

        // Input Parameter Vaue
        logger.error("REST Request: Employee Id: " + employeeId);

        // Employee Record (Assume this gets fetched from the DB)
        Employee emp1 = new Employee();
        emp1.setEmployeeId(employeeId);
        emp1.setName("John Doe");
        emp1.setTitle("Software Engineer");

        // Generate Response
        return emp1;
    }
}
