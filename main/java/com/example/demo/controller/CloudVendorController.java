package com.example.demo.controller;

import com.example.demo.model.CloudVendor;
import com.example.demo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")

public class CloudVendorController {
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

//get specific cloud vendor details from database.
    @GetMapping("{vendorId}")

    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){

      return  cloudVendorService.getCloudVendor(vendorId);

              //new CloudVendor("C1", "Vendor 1",
           // "Address 001","xxxxx");
    }

//get all cloud vendor details from the database
    @GetMapping()

    public List<CloudVendor> getAllCloudVendorDetails() {

        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
      cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor created successfully";
   }

   @PutMapping
   public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
      cloudVendorService.updateCloudVendor(cloudVendor);
       return "Cloud Vendor updated successfully";
    }

    @DeleteMapping ("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
       cloudVendorService.deleteCloudvendor(vendorId);
        return "Cloud Vendor deleted successfully";
    }


}
