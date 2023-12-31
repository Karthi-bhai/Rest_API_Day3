package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo er;
	
	public EmployeeEntity saveinfo(EmployeeEntity es)
	{
		return er.save(es);
	}
	
	public List<EmployeeEntity> showinfo()
	{
		return er.findAll();
	}
	public List<Integer> showEmployeeIds() {
        List<EmployeeEntity> employees = er.findAll();
        List<Integer> employeeIds = employees.stream()
                                         .map(EmployeeEntity::getId)
                                         .collect(Collectors.toList());
        return employeeIds;
    }
}
