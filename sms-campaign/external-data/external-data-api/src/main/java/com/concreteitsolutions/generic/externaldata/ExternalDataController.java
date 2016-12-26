package com.concreteitsolutions.generic.externaldata;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/external-data")
public interface ExternalDataController {

    @RequestMapping(value = "/excel/{dataModel}", method = RequestMethod.POST)
    ResponseEntity<String> importDataFromExcel(@RequestParam("fileInput") MultipartFile file, @PathVariable("dataModel") String dataModel);
}
