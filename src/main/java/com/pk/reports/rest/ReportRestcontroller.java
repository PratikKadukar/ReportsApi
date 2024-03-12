package com.pk.reports.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pk.reports.request.SearchRequest;
import com.pk.reports.response.SearchResponse;
import com.pk.reports.service.ReportService;

@RestController
public class ReportRestcontroller {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanNames(){
		List<String> planNames = reportService.getUniquePlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}
	
	@GetMapping("/statuses")
	public ResponseEntity<List<String>> getPlanStatuses(){
		List<String> PlanStatuses = reportService.getUniquePlanStatuses();
		return new ResponseEntity<>(PlanStatuses, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request){
		List<SearchResponse> response = reportService.search(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void excelReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename = data.xls";
		
		response.setHeader(headerKey, headerValue);
		reportService.generateExcel(response);
		
	}
	
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename = data.pdf";
		
		response.setHeader(headerkey, headervalue);
		reportService.generatePdf(response);
	}
	
	

}
