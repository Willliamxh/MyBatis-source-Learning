package com.bjp.Generic;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author XuHan
 * @date 2023/4/13 13:59
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //这里的上界 必须得是Person的上届 Comparator<? super E> E是在 TreeSet<E> extends AbstractSet<E> 定义TreeSet的时候定义的
        TreeSet<Person> ts1 = new TreeSet<>(new comparatorTest());
        // ts1.add(new Person("Tom", 20));
        // ts1.add(new Person("Jack", 25));
        // ts1.add(new Person("John", 22));
        // System.out.println(ts1);
        //
        // TreeSet<Student> ts2 = new TreeSet<>(new comparatorTest());
        // ts2.add(new Student("Susan", 23));
        // ts2.add(new Student("Rose", 27));
        // ts2.add(new Student("Jane", 19));
        // System.out.println(ts2);


        //https://blog.csdn.net/BASK2312/article/details/129294889
        List<? extends Person> list = Lists.newArrayList(new Person("123", 123), new Student("345", 345435));
        //这边注意向下转型问题 com.bjp.Generic.Person cannot be cast to com.bjp.Generic.Student
        Student student2 = (Student)list.get(0);
        System.out.println(student2);


        Student student = (Student) list.get(1);
        System.out.println(student);


    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class Student extends Person {
    public Student() {
        super();
    }

    public Student(String name, int age) {
        super(name, age);
    }
}


class comparatorTestStu implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int num = s1.getAge() - s2.getAge();
        return num == 0 ? s1.getName().compareTo(s2.getName()) :  num;
    }

    @Override
    public Comparator<Student> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Student> thenComparing(Comparator<? super Student> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Student> thenComparing(Function<? super Student, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Student> thenComparing(Function<? super Student, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Student> thenComparingInt(ToIntFunction<? super Student> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Student> thenComparingLong(ToLongFunction<? super Student> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Student> thenComparingDouble(ToDoubleFunction<? super Student> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
class comparatorTest implements Comparator<Person> {
    @Override
    public int compare(Person s1, Person s2) {
        int num = s1.getAge() - s2.getAge();
        return num == 0 ? s1.getName().compareTo(s2.getName()) :  num;
    }

    @Override
    public Comparator<Person> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Person> thenComparing(Comparator<? super Person> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Person> thenComparing(Function<? super Person, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Person> thenComparing(Function<? super Person, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Person> thenComparingInt(ToIntFunction<? super Person> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Person> thenComparingLong(ToLongFunction<? super Person> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Person> thenComparingDouble(ToDoubleFunction<? super Person> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}


