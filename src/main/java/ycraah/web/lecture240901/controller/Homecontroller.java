package ycraah.web.lecture240901.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/home")
public class Homecontroller {
  List<Person> people = new ArrayList<>();
  int count = 0;

  @GetMapping("/addPerson")
  @ResponseBody
  public String addPerson(String name, int age) {
    count++;
    Person person = new Person(count, name, age);
    people.add(person);
    return "응답 : %d번 사람이 추가되었습니다.".formatted(count);
  }

  @GetMapping("/showPeople")
  @ResponseBody
  public List<Person> showPeople() {
    return people;
  }
}



@Getter
@AllArgsConstructor
class Person {
  int id;
  String name;
  int age;
}

