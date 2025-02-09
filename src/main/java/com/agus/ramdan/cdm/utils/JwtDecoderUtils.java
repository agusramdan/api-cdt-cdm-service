package com.agus.ramdan.cdm.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtDecoderUtils {

    // ObjectMapper untuk konversi JSON ke Map
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Fungsi untuk mendecode token JWT tanpa verifikasi signature,
     * serta memparsing header dan payload ke dalam Map.
     *
     * @param jwt token JWT dalam format header.payload.signature
     * @return Map dengan kunci "header" dan "payload" yang masing-masing berisi Map dari hasil parsing JSON.
     * @throws IllegalArgumentException jika token JWT tidak valid atau parsing JSON gagal.
     */
    public static Map<String, Map<String, Object>> decodeJwt(String jwt) {
        if (jwt == null || jwt.isEmpty()) {
            throw new IllegalArgumentException("JWT token kosong atau null.");
        }

        // Token JWT biasanya memiliki tiga bagian: header.payload.signature
        String[] parts = jwt.split("\\.");
        if (parts.length < 2) {
            throw new IllegalArgumentException("JWT tidak valid. Pastikan token memiliki format header.payload.signature.");
        }

        try {
            // Decode bagian header dan payload menggunakan Base64 URL-safe decoder
            String headerJson = new String(Base64.getUrlDecoder().decode(parts[0]), StandardCharsets.UTF_8);
            String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);

            // Parsing JSON ke dalam Map menggunakan Jackson
            Map<String, Object> headerMap = objectMapper.readValue(headerJson, new TypeReference<Map<String, Object>>() {});
            Map<String, Object> payloadMap = objectMapper.readValue(payloadJson, new TypeReference<Map<String, Object>>() {});

            Map<String, Map<String, Object>> result = new HashMap<>();
            result.put("header", headerMap);
            result.put("payload", payloadMap);
            return result;
        } catch (IllegalArgumentException | JsonProcessingException e) {
            throw new IllegalArgumentException("Gagal mendecode atau parsing JSON token JWT.", e);
        }
    }

}
