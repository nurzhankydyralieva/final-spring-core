package com.epam.project.storage;

import com.epam.project.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StorageBeanPP implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Storage) {
            Map<Integer, User> users = new HashMap<>();
            users.put(1, new User(1, "Andrea", "Bocelli", "Music", "password", true));
            users.put(2, new User(2, "Sarah", "Conor", "Smith", "password", true));
            ((Storage) bean).writeDataToUserStorageFile(users);

        }
        //   System.out.println("Called postProcessBeforeInitialization() for: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //  System.out.println("Called postProcessAfterInitialization() for: " + beanName);
        return bean;
    }
}
