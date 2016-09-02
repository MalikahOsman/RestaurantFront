package com.example.osman.restaurantmsandroid.repository;

import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.domain.RestaurantManager;
import com.example.osman.restaurantmsandroid.repositories.Impl.ManagerRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.ManagerRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-04-24.
 */
public class ManagerRepositoryTest extends AndroidTestCase {
    private static final String TAG = "MANAGER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        ManagerRepository repo = new ManagerRepositoryImpl(this.getContext());
        //CREATE
        RestaurantManager createEntity = new RestaurantManager.Builder()
                .userName("managerMalz")
                .password("16")
                .empNum("16")
                .empName("Malikah")
                .address("Maitland")
                .telephone("0830000000")
                .build();
        RestaurantManager insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        //READ ALL
        Set<RestaurantManager> restaurantManagers = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", restaurantManagers.size()>0);

        //READ ENTITY
        RestaurantManager entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        //UPDATE ENTITY
        RestaurantManager updateEntity = new RestaurantManager.Builder()
                .copy(entity)
                .password("17")
                .build();
        repo.update(updateEntity);
        RestaurantManager newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "17", newEntity.getPassword());

        //DELETE ENTITY
        repo.delete(updateEntity);
        RestaurantManager deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE ", deletedEntity);

    }
}
