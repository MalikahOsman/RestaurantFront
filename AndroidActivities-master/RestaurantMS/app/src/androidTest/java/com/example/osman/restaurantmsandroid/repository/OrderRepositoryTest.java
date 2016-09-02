package com.example.osman.restaurantmsandroid.repository;

import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.domain.Order;
import com.example.osman.restaurantmsandroid.repositories.Impl.OrderRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.OrderRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-04-24.
 */
public class OrderRepositoryTest extends AndroidTestCase {
    public static final String TAG = "ORDER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        OrderRepository repo = new OrderRepositoryImpl(this.getContext());
        //CREATE
        Order createEntity = new Order.Builder()
                .orderNum(10)
                .orderDate("12/12/2012")
                .build();
        Order insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "CREATE", insertedEntity);

        //READ ALL
        Set<Order> order = repo.findAll();
        Assert.assertTrue(TAG + "READ ALL" , order.size()>0);

        //READ ENTITY
        Order entity = repo.findById(id);
        Assert.assertNotNull(TAG + "READ ENTITY", entity);

        //UPDATE ENTITY
        Order updateEntity = new Order.Builder()
                .copy(entity)
                .orderNum(10)
                .build();
        repo.update(updateEntity);
        Order newEntity = repo.findById(id);
        Assert.assertEquals(TAG + "UPDATE ENTITY", "12/12/2012", newEntity.getOrderDate());

        //DELETE ENTITY
        repo.delete(updateEntity);
        Order deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + "DELETE", deletedEntity);
    }


}
