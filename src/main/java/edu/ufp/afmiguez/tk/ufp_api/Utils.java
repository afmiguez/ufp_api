package edu.ufp.afmiguez.tk.ufp_api;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class Utils {

    public static <E> ResponseEntity<E> makeRequest(String path, HttpMethod method, Object body, HttpHeaders headers,
                                                    Class<E> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, new HttpEntity<>(body, headers), responseType);
    }

    @SuppressWarnings({"rawtypes" })
    public static <T> T getValue(InputStream inputStream, Class<? extends Collection> collection,Class<?> classz)
            throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionLikeType(collection,
                classz);
        return objectMapper.readValue(inputStream,type);
    }

    public static <T> T getValue(String inputStream, Class<T> classz)
            throws IOException {

                ObjectMapper objectMapper=new ObjectMapper();
                T entity=objectMapper.readValue(inputStream,classz);
                return entity;
            }


}
