package com.java.download_data;

import com.java.download_data.dao.ServiceClass;
import com.java.download_data.model.DataModel;
import com.java.download_data.model.ListUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DownloadDataApplication implements CommandLineRunner {
    @Autowired
    ServiceClass serviceClass;

    public static void main(String[] args) {
        SpringApplication.run(DownloadDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "ListUrl.xml");

        ((ListUrl) context.getBean("listUrl")).getUrls().stream()
                .forEach(e -> serviceClass.getData(e).stream().forEach(i -> serviceClass.save(i)));
    }
}

