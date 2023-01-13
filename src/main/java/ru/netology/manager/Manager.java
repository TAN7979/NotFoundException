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

    public Product[] searchBy(String text) {// методо поиска по тексту
        Product[] result = new Product[0]; // массив где будут храниться найденные продукты
        for (Product product : repo.findAll()) {//цикл поиска в массиве продукт
            if (matches(product, text)) {//если текст в продукте соответсвует
                Product[] tmp = new Product[result.length + 1];// добавляем найденные товары в массив
                for (int i = 0; i < result.length; i++) {//цикл суммирования найденных товаров
                    tmp[i] = result[i];//скопировали все найденные товары в ячейку tmp
                }
                tmp [result.length] = product;//
                result = tmp;//меняем старый массив на новый (найденные товары)
            }
        }
        return result;//массив найденных товаров
    }
    public boolean matches(Product product, String search) { // метод определения соответствия товара запросу
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}

