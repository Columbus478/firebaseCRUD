package com.example.firebaseCRUD.objects;

import org.springframework.context.annotation.ComponentScan;
import lombok.Getter;
import lombok.Setter;

@ComponentScan
@Getter
@Setter
public class Person {
  public Person() {
    super();
  }

  public Person(String name, String age, String location) {
    this.name = name;
    this.age = age;
    this.location = location;
  }

  private String name;
  private String age;
  private String location;

}
