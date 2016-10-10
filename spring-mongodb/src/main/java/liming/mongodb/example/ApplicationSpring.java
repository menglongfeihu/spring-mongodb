/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
package liming.mongodb.example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import liming.mongodb.example.data.UserDao;
import liming.mongodb.example.data.impl.UserDaoImpl;
import liming.mongodb.example.data.model.NameEntity;
import liming.mongodb.example.data.model.UserEntity;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationSpring {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        System.out.println("Bootstrapping HelloMongo");

        ConfigurableApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = context.getBean(UserDaoImpl.class);
        userDao._test();
        UserEntity entity1 = new UserEntity();
        entity1.setId("1");
        entity1.setAge(5);
        entity1.setBirth(new Date());
        entity1.setPassword("asdfasdf");
        entity1.setRegionName("北京");
        entity1.setWorks(1);
        NameEntity ne = new NameEntity();
        ne.setUsername("limingnihao");
        ne.setNickname("Peter Li");
        entity1.setName(ne);
        entity1.setSpecial(new String[] {"11", "22"});
        userDao.insert(entity1);
        userDao.update(entity1);

        List<UserEntity> list = userDao.findList(0, 10);
        System.out.println("list count = " + list.size());
        System.out.println("======findList======");
        for (UserEntity e : list) {
            System.out.println("all - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword()
                    + ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial())
                    + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth="
                    + e.getBirth());
        }

        list = userDao.findListByAge(5);
        System.out.println("======findListByAge======");
        for (UserEntity e : list) {
            System.out.println("age=1 - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword()
                    + ", regionName=" + e.getRegionName() + ", special="
                    + Arrays.toString(e.getSpecial()) + ", name=" + e.getName().getUsername() + "-"
                    + e.getName().getNickname() + ", birth=" + e.getBirth());
        }

        UserEntity e = userDao.findOne("1");
        System.out.println("======findOne======");
        if (e != null) {
            System.out.println("id=1 - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword()
                    + ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial())
                    + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth="
                    + e.getBirth());

        }

        e = userDao.findOneByUsername("limingnihao");
        System.out.println("======findOneByUsername======");
        if (e != null) {
            System.out.println("username=limingnihao - id=" + e.getId() + ", age=" + e.getAge() + ", password="
                    + e.getPassword() + ", regionName=" + e.getRegionName() + ", special="
                    + Arrays.toString(e.getSpecial()) + ", name=" + e.getName().getUsername() + "-"
                    + e.getName().getNickname() + ", birth=" + e.getBirth());

        }

        System.out.println("DONE!");
    }

}