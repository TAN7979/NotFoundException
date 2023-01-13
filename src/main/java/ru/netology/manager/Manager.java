package ru.netology.manager;

import ru.netology.product.Product;
import ru.netology.repository.Repository;

public class Manager {

    private Repository repo;// добавли репозиторий

    public Manager(Repository repo) {//конструктор
        this.repo = repo; //объект метод которого используем
    }


    public void add(Product product){//метод добавить продукт
        repo.save(product);
    }

    public Product[] searchBy(String text) {// методо поиска по названию
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp [result.length] = product;
                result = tmp;
            }
        }
        return result;
    }
    public boolean matches(Product product, String search) { // метод определения соответствия товара запросу
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}

