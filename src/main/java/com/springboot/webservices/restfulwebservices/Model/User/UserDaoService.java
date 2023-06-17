package com.springboot.webservices.restfulwebservices.Model.User;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static ArrayList<Users> list_user = new ArrayList<>();

    private static Long count= Long.valueOf(0);

    static{
        list_user.add(new Users(++count, "Hung", LocalDate.now()));
        list_user.add(new Users(++count, "Trang", LocalDate.now()));
    }

    public List<Users> findAll(){
        return list_user;
    }

    public Users saver(Users user){
        user.setId(++count);
        list_user.add(user);
        return user;
    }

    public Users findOne(Long id){
        return list_user.stream()
                .filter(element -> element.getId() == id)
                .findFirst().get();
    }
}
