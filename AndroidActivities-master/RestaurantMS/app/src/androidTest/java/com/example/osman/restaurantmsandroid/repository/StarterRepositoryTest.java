package com.example.osman.restaurantmsandroid.repository;

import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.domain.Starter;
import com.example.osman.restaurantmsandroid.repositories.Impl.StarterRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.StarterRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-04-27.
 */
public class StarterRepositoryTest extends AndroidTestCase {
    private static final String TAG = "STARTER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        StarterRepository repo = new StarterRepositoryImpl(this.getContext());
        //CREATE
        Starter createEntity = new Starter.Builder()
                .starterID("100")
                .foodItem("samoosa")
                .build();
        Starter insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        //READ ALL
        Set<Starter> starterSet = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", starterSet.size()>0);

        //READ ENTITY
        Starter entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        //UPDATE ENTITY
        Starter updateEntity = new Starter.Builder()
                .copy(entity)
                .build();
        repo.update(updateEntity);
        Starter newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "100", newEntity.getStarterID());

        //DELETE ENTITY
        repo.delete(updateEntity);
        Starter deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE ", deletedEntity);

    }
}
