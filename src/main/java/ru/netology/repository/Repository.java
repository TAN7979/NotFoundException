package ru.netology.repository;

import ru.netology.product.Product;

public class Repository {

    private Product[] products = new Product[0];

    public void save(Product product){// метод добавать продукт
        Product[] tmp = new Product[products.length +1]; // массив для добавления
        for (int i = 0; i < products.length; i++) { // счетчик
            tmp[i] = products[i]; // скопировать все эл-ты из старого в новый

        }
        tmp[products.length] = product;
        products = tmp; // присвоить полю Продукт новый массив
    }

    public void removeById(int id){ // метод удаление по ID

        if(findById(id) == null){//если в методе findById(id) результат равен null
            throw new NotFoundException(id);//тогда вызываем ошибку NotFoundException(id)
        }

        Product[] tmp = new Product[products.length -1];// новый масси для удаления
        int indexInsert = 0;// переменная для удаления
        for (Product product : products){//счетчик
            if(product.getId() != id){//если ID совпадает
                tmp[indexInsert] = product;//то в масси не заносить
                indexInsert++;//посчитать новые  эл-ты
            }
        }
        products = tmp; //присвоить полю Продукт новый массив
    }

    public Product findById(int id) {//метод поска по ID
        for (Product product : products) {//в каком массиве ищем
            if (product.getId() == id) {// если ID продукта равно ID которое ищем
                return product;//продукт возвращаем
            }
        }
        return null;// если нет ID не совпадает возвращаем null
    }

    public Product[] findAll(){ //метод получать все сохраненные
        return products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }


}

