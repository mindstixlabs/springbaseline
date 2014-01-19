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
@RequestMapping("/api/1")
public class SampleRESTController {

    // Get log4j handler
    private static final Logger logger = Logger.getLogger(SampleController.class);

    /**
     * REST API without any Input Parameter.
     *
     * @return Enterprise
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public @ResponseBody Employee[] getEmployees() {

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
        Employee[] employeeArray = new Employee[]{emp1, emp2};
        return employeeArray;

    }

    /**
     * REST API that reads an input parameter received in a URL Segment.
     *
     * @param enterpriseId
     * @return Enterprise
     */
    @RequestMapping(value = "/enterprise/{enterpriseId}", method = RequestMethod.GET)
    public @ResponseBody Enterprise getEnterprise(@PathVariable int enterpriseId) {

        // Input Parameter Vaue
        logger.error("REST Request: Enterprise Id: " + enterpriseId);

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

        // Generate Response Root Object
        Enterprise myEnterprise = new Enterprise();
        myEnterprise.setName("Example Corporation " + enterpriseId);
        myEnterprise.setLocation("United States of America");
        myEnterprise.setEmployees(new Employee[]{emp1, emp2});

        // Generate Response
        return myEnterprise;
    }
}
