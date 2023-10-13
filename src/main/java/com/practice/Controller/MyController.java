package com.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.Entity.Employee;
import com.practice.Service.EmployeeService;

// @Controller
@Controller
@RequestMapping("/employee")
public class MyController {
    
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }

    // Ref form
    @RequestMapping("/regForm")
    public String refForm()
    {
        return "EmployeeForm";
    }

    @PostMapping("/addEmp")
    public String addEmp(@ModelAttribute Employee employee)
    {
        employeeService.addEmployee(employee);
        return "redirect:/employee/allEmp";
    }

    // all emp
    @GetMapping("/allEmp")
    public String allEmp(Model model)
    {
        List<Employee> emp = employeeService.findAllEmployee();
        model.addAttribute("emp", emp);
        return "List_of_all_Emp";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id")Integer id)
    {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee/allEmp";
    }

    //update Emp
    @PostMapping("/update/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Model m)
    {
        Employee employee = employeeService.findEmployeeById(id);
        m.addAttribute("emp", employee);
        return "updateForm";
    }

    @RequestMapping(value ="/updateEmp", method = RequestMethod.POST)
    public String updateHandler(@ModelAttribute Employee employee)
    {
        System.out.println("Name :" + employee.toString());
        employeeService.addEmployee(employee);
        return "redirect:/employee/allEmp";
    }
}
