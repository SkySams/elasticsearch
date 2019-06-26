package com.elasticsearch.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.elasticsearch.app.entity.Employee;

@Component
public interface EmployeeRepository 
                 extends ElasticsearchRepository<Employee, String> {
	
	/**
	 * 查询雇员信息
	 */
	Employee queryEmployeeById(String id);
	
	/** 计算查询*/
	long  countByFirstName(String firstName);
	
	/** 派生 删除*/
	List<Employee> removeById(String id);
	
	/** 派生类删除 */
	List<Employee> removeByFirstName(String firstName);
	
	/** pageable 遍历分页*/
	Page<Employee> findByFirstName(String firstName,Pageable pageable);
	
	/** slice 分页*/
	Slice<Employee> findByLastName(String lastName,Pageable pageable);
	
	/** 使用sort 排序*/
	List<Employee> findByAbout(String about,Sort sort);
	
	List<Employee> findByAge(int age,Pageable pageable);
	
	/** 限制查询结果 */
	Employee findFirstByLastName(String lastName);

}
