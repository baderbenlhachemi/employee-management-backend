package com.giantlink.grh.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;

import com.giantlink.grh.dto.request.CompanyRequest;
import com.giantlink.grh.dto.response.CompanyImageResponse;
import com.giantlink.grh.dto.response.CompanyResponse;
import com.giantlink.grh.entities.Company;
import com.giantlink.grh.entities.CompanyImage;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import com.giantlink.grh.services.CompanyImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.giantlink.grh.services.CompanyService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	private final CompanyService companyService;

	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@Autowired
	CompanyImageService companyImageService;


	@GetMapping()
		public ResponseEntity<List<CompanyResponse>> get() throws NotFoundException {
		return new ResponseEntity<List<CompanyResponse>>(companyService.get(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CompanyResponse> get(@PathVariable Integer id) throws NotFoundException {
		return new ResponseEntity<CompanyResponse>(companyService.get(id), HttpStatus.OK);
	}

	@GetMapping("/getname/{name}")
	public ResponseEntity<CompanyResponse> getByName(@PathVariable String name) throws NotFoundException {
		return new ResponseEntity<CompanyResponse>(companyService.getByName(name), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<CompanyResponse> add(@RequestBody @Valid CompanyRequest companyRequest) throws AlreadyExistsException {
		return new ResponseEntity<CompanyResponse>(companyService.add(companyRequest), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CompanyResponse> update(@PathVariable Integer id, @RequestBody @Valid CompanyRequest companyRequest) throws AlreadyExistsException, NotFoundException {
		return new ResponseEntity<CompanyResponse>(companyService.update(id,companyRequest), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		companyService.delete(id);
	}

	@PostMapping("/upload/{id}")
	public ResponseEntity<CompanyImageResponse> upload(@PathVariable("id") Integer companyId,
													   @RequestParam("image") MultipartFile image) throws IOException {
		CompanyImageResponse save = companyImageService.saveDb(image, companyId);
		String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/company/")
				.path("/download/").path(save.getId()).toUriString();
		save.setImageLink(imageUrl);
		return new ResponseEntity<CompanyImageResponse>(save, HttpStatus.OK);
	}

	@PostMapping("/uploadFile/{id}")
	public ResponseEntity<CompanyImageResponse> uploadFile(@PathVariable("id") Integer companyId,
														   @RequestParam("image") MultipartFile image) throws IOException {
		CompanyImageResponse save = companyImageService.saveLocal(image, companyId);
		String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/company/")
				.path("/downloadFile/").path(save.getId()).toUriString();
		save.setImageLink(imageUrl);
		return new ResponseEntity<CompanyImageResponse>(save, HttpStatus.OK);
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> download(@PathVariable("id") String imageId) {
		CompanyImage image = companyImageService.getImage(imageId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getImageType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + image.getImageName())
				.body(new ByteArrayResource(image.getImageFile()));
	}

	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") String imageId) throws MalformedURLException {
		CompanyImage image = companyImageService.getImage(imageId);
		Path imageFile = companyImageService.getUploadPath().resolve(image.getImageName());
		Resource resource = new UrlResource(imageFile.toUri());
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getImageType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + image.getImageName())
				.body(resource);
	}

	// page=1&size=3
	@GetMapping("/getPage/{page}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<Page<Company>> get(@RequestParam(name = "page", defaultValue = "0") int page,
											 @RequestParam(name = "size", defaultValue = "3") int size) {
		Pageable pageable = PageRequest.of(page, size);

		return new ResponseEntity<Page<Company>>(companyService.get(pageable), HttpStatus.OK);
	}
}
