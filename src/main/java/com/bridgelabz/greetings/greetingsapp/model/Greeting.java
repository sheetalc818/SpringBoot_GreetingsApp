package com.bridgelabz.greetings.greetingsapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Greeting")
public class Greeting {

    @Id
    private long id;
    @Column(name="message")
    private String message;

    public Greeting(){

    }
    public Greeting(long incrementAndGet, String format) {
    this.id = incrementAndGet;
    this.message = format;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
