package com.java.download_data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ServiceClassTest {
    ServiceClass serviceClass = mock(ServiceClass.class);
    String url = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/47fa8764e1b74f4db58f84c9db460566/documents";

    @Test(expected = IllegalArgumentException.class)
    public void getData() {
        when(serviceClass.getData(anyString())).thenThrow(new IllegalArgumentException());
        System.out.println(serviceClass.getData(anyString()));
    }

    @Test(expected = NullPointerException.class)
    public void getData2() {
        when(serviceClass.getData("https://junit.org")).thenThrow(new NullPointerException());
        System.out.println(serviceClass.getData("https://junit.org"));
    }

    @Test
    public void getData1() {
        assertNotNull(serviceClass.getData(url));
    }

}