package com.scytalys.service;

import com.scytalys.model.Product;

import java.util.concurrent.Callable;

public class WorkerCallable implements Callable<Product>{
    private int id;

    public WorkerCallable(int id) {
        this.id = id;
    }

    @Override
    public  Product call() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return new Product();
    }
}
