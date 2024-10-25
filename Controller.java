package com.org.institution.collegeInfo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.org.institution.collegeInfo.model.College;
import com.org.institution.collegeInfo.model.Student;
import com.org.institution.collegeInfo.model.StudentResponse;
import com.org.institution.collegeInfo.service.CollegeService;



@RestController
public class Controller {
	
	@Value("${student.service.url}")
    private String studentServiceUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	
	@Autowired
	private CollegeService collegeService;
	
	@GetMapping("/collegedata")
	public ResponseEntity<List<College>> getCollegeDetails(){
		
		List<College> cl= new ArrayList<>();
		
		cl= collegeService.getCollegeDetails();
		
		return new ResponseEntity<List<College>>(cl,HttpStatus.OK);
		
	}
	
	@PostMapping("/createcollege")
	public ResponseEntity<College> jj (@RequestBody College college){
		
		int i=collegeService.createCollege(college);
		if (i==1) {
			return new ResponseEntity<>(college, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/students/{cid}")
	public StudentResponse getStudentsByCollegeId(@PathVariable int cid) {
		 String url = studentServiceUrl + "/studentsByCid?cid=" + cid;
	        Student[] students = restTemplate.getForObject(url, Student[].class);
	        List<Student>sl=students != null ? List.of(students) : List.of();
	        String label= collegeService.getStream(cid);
	        return new StudentResponse(label, sl, sl.size());
	}
}
