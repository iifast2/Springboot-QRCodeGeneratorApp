package com.pixeltrice.springbootqrcodegeneratorapp;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRCodeController {

    /*
             You can change the String to : link, file path, image path, ID, username
             , email address, secret client code, simple text, product name, product number, URL ..etc
               Testing Link using post man ( GET REQUEST ) :
               http://localhost:8080/genrateAndDownloadQRCode/SILVER_IMAGE_PATH/350/350
    */

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
    // private static final String GOLD_IMAGE_PATH = "./src/main/mybadges/goldbadge.png";
    private static final String SILVER_IMAGE_PATH = "i.imgur.com/lTZHFRk.png";
    // private static final String BRONZE_IMAGE_PATH = "file:///C:/Users/medaminebt/Downloads/SPRING%20QR%20CODE%20BADGES/GOLD%20BADGE.png";


    @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
    public void download(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        QRCodeGenerator.generateQRCodeImage(SILVER_IMAGE_PATH, width, height, QR_CODE_IMAGE_PATH);
    }

    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, width, height));
    }


}

