package com.example.osman.restaurantmsandroid.repository;

import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.domain.Chef;
import com.example.osman.restaurantmsandroid.repositories.ChefRepository;
import com.example.osman.restaurantmsandroid.repositories.Impl.ChefRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-04-24.
 */
public class ChefRepositoryTest extends AndroidTestCase {
    private static final String TAG = "CHEF TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        ChefRepository repo = new ChefRepositoryImpl(this.getContext());
        //CREATE
        Chef createEntity = new Chef.Builder()
                .userName("chefGouwa")
                .password("21")
                .empNum("21")
                .empName("Gouwa")
                .address("Maitland")
                .telephone("0833300000")
                .build();
        Chef insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        //READ ALL
        Set<Chef> chef = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", chef.size()>0);

        //READ ENTITY
        Chef entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        //UPDATE ENTITY
        Chef updateEntity = new Chef.Builder()
                .copy(entity)
                .password("22")
                .build();
        repo.update(updateEntity);
        Chef newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "22", newEntity.getPassword());

        //DELETE ENTITY
        repo.delete(updateEntity);
        Chef deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE ", deletedEntity);

    }
}
