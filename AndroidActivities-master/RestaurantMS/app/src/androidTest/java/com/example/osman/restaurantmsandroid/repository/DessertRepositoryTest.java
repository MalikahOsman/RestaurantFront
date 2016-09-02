package com.example.osman.restaurantmsandroid.repository;

import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.domain.Dessert;
import com.example.osman.restaurantmsandroid.repositories.DessertRepository;
import com.example.osman.restaurantmsandroid.repositories.Impl.DessertRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-04-27.
 */
public class DessertRepositoryTest extends AndroidTestCase {
    private static final String TAG = "DESSERT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        DessertRepository repo = new DessertRepositoryImpl(this.getContext());
        //CREATE
        Dessert createEntity = new Dessert.Builder()
                .dessertID("100")
                .foodItem("chocolate cake")
                .build();
        Dessert insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        //READ ALL
        Set<Dessert> dessertSet = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", dessertSet.size()>0);

        //READ ENTITY
        Dessert entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        //UPDATE ENTITY
        Dessert updateEntity = new Dessert.Builder()
                .copy(entity)
                .build();
        repo.update(updateEntity);
        Dessert newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "100", newEntity.getDessertID());

        //DELETE ENTITY
        repo.delete(updateEntity);
        Dessert deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE ", deletedEntity);

    }
}
