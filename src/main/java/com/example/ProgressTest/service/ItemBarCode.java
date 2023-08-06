package com.example.ProgressTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.EnumMap;

@Service
public class ItemBarCode {

    public String generateBarcode(String barcodeText) {
        try {
            int width = 300;
            int height = 100;

            // Set barcode options
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            EnumMap<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            // Generate the barcode matrix
            BitMatrix bitMatrix = multiFormatWriter.encode(barcodeText, BarcodeFormat.CODE_128, width, height, hints);

            // Convert the matrix to a Base64-encoded string representation
            return matrixToBase64(bitMatrix);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String matrixToBase64(BitMatrix matrix) {
        // Convert the matrix to a byte array and then Base64-encoded string
        byte[] byteArray = matrixToByteArray(matrix);
        return java.util.Base64.getEncoder().encodeToString(byteArray);
    }

    private byte[] matrixToByteArray(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        byte[] byteArray = new byte[width * height];
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                byteArray[offset + x] = (byte) (matrix.get(x, y) ? 0 : 1);
            }
        }
        return byteArray;
    }
}
