package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private int age;

//    @Lob
//    @Column(columnDefinition="BLOB")
//    private Byte[] image = new Byte[200_000];

    public Customer() {
    }

    public Customer(long id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;

 //       for( int i = 0; i < image.length; i++){
//            image[i] = (byte)0;
//        }

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

 //   public Byte[] getImage() {
  //      return image;
 //   }

//    public void setImage(Byte[] image) {
   //     this.image = image;
  //  }
}
