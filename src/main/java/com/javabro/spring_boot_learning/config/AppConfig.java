package com.javabro.spring_boot_learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.http.HttpClient;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Configuration
public class AppConfig {

    /*@Bean
    public RestClient getRestClient() {

        RestClient restClient = null;
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyStore keystore = KeyStore.getInstance("PKCS12");
            keystore.load(new FileInputStream("src/main/resources/keystore.p12"), "keystorePassword".toCharArray());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keystore);

            sslContext.init(null, tmf.getTrustManagers(), null);
            HttpClient httpClient = HttpClient.newBuilder().sslContext(sslContext).build();

            JdkClientHttpRequestFactory jdkClientHttpRequestFactory = new JdkClientHttpRequestFactory(httpClient);

            restClient = RestClient.builder().requestFactory(jdkClientHttpRequestFactory).build();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CertificateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
        return restClient;
    }*/
}
