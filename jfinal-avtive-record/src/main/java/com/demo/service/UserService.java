package com.demo.service;

import com.demo.model.User;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public class UserService {
    private User dao = new User().dao();

    public void add() {
        new User().set("id", 4).set("name", "ddd").set("age", 4).save();
    }

    public void delete() {
        dao.deleteById(4);
    }

    public void findAndUpdate() {
        dao.findById(3).set("name", "cc").update();
    }

    public void findUser() {
        dao.findByIdLoadColumns(2, "name, age");
    }

    public void selectWhere() {
        List<User> list = dao.find("select * from user where id > 3");
    }

    public void page() {
        Page<User> page = dao.paginate(1, 10, "select *", "from user where id > ?", 3);
    }
}
