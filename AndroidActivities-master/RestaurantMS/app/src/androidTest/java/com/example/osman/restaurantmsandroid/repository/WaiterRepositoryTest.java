package com.example.osman.restaurantmsandroid.repository;

import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.domain.Waiter;
import com.example.osman.restaurantmsandroid.repositories.Impl.WaiterRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.WaiterRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-04-24.
 */
public class WaiterRepositoryTest extends AndroidTestCase {
    private static final String TAG="WAITER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        WaiterRepository repo = new WaiterRepositoryImpl(this.getContext());
        // CREATE
        Waiter createEntity = new Waiter.Builder()
                .userName("")
                .password("passWaiter")
                .empNum("001")
                .empName("Louise")
                .address("Pinelands")
                .telephone("0210000001")
                .build();
        Waiter insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Waiter> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Waiter entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Waiter updateEntity = new Waiter.Builder()
                .copy(entity)
                .password("passWaiter")
                .build();
        repo.update(updateEntity);
        Waiter newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","passWaiter",newEntity.getPassword());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Waiter deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
