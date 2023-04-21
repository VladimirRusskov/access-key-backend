package com.example.accesskeybackend.template.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;

@RestController
public class Ipv6CheckController {

    @GetMapping("/api/web/checkIpv6Support")
    public ResponseEntity<Boolean> checkIpv6Support(@RequestParam String siteUrl) {
        try {
            var inetAddress = InetAddress.getByName(new URL(siteUrl).getHost());
            if (inetAddress instanceof Inet6Address) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}