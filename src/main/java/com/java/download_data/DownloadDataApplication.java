package com.java.download_data;

import com.java.download_data.dao.ServiceClass;
import com.java.download_data.model.ListUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DownloadDataApplication implements CommandLineRunner {
    private final ServiceClass serviceClass;

    @Autowired
    public DownloadDataApplication(ServiceClass serviceClass) {
        this.serviceClass = serviceClass;
    }

    public static void main(String[] args) {
        SpringApplication.run(DownloadDataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "ListUrl.xml");

        ((ListUrl) context.getBean("listUrl")).getUrls()
                .forEach(e -> serviceClass.getData(e).forEach(serviceClass::save));
    }
}

