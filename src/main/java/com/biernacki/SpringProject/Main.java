package com.biernacki.SpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @Override
//    public void run(String... args) {
//
//        List<User> users = userRepository.findAll();
//        users.forEach(System.out::println);
//
//
//        List<User> users2 = userRepository.findAllById(3);
//        users2.forEach(System.out::println);
//        userRepository.delete(users2.get(0));
//
////        userRepository.deleteById();
////
////        User someUser = getUser();
////
////        userRepository.save(someUser);
////
////        List<User> users2 = userRepository.findAll();
////        users2.forEach(System.out::println);
////
////        List<User> foundUsers = userRepository.findByUsername("Pogba");
////        foundUsers.forEach(System.out::println);
////
////        System.out.println();
////
//////        List<User> foundUsers2 = userRepository.findByUsernameContaining("kam");
//////        foundUsers2.forEach(System.out::println);
////
////        System.out.println();
////
////        List<User> foundUsers3 = userRepository.findByAgeGreaterThan(10);
////        foundUsers3.forEach(System.out::println);
////
////        System.out.println();
////
////        List<String> cities = new ArrayList<>();
////        cities.add("Kraków");
////        cities.add("Kielce");
////        List<User> foundUsers4 = userRepository.findByCityIn(cities);
////        foundUsers4.forEach(System.out::println);
//    }

    // private User getUser() {
    //     return new User("Paulina biernacki", 22, "ZAKO");
    // }
}
