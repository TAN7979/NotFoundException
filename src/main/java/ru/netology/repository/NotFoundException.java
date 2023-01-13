package ru.netology.repository;

public class NotFoundException extends RuntimeException{//базовый класс RuntimeException с наследником NotFoundException
    public NotFoundException(int id) {//в каком элементе ищем ошибку ID
        super("Element witx id" + id + "not found");//сообщение об ошибке
    }
}
