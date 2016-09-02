package com.example.osman.restaurantmsandroid.repository;

import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.domain.POS_Cashier;
import com.example.osman.restaurantmsandroid.repositories.Impl.PosRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.PosRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-04-24.
 */
public class PosRepositoryTest extends AndroidTestCase {
    private static final String TAG = "CASHIER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        PosRepository repo = new PosRepositoryImpl(this.getContext());
        //CREATE
        POS_Cashier createEntity = new POS_Cashier.Builder()
                .userName("cashierFeeqah")
                .password("12")
                .empNum("12")
                .empName("Mushfeeqah")
                .address("Maitland")
                .telephone("0830000007")
                .build();
        POS_Cashier insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        //READ ALL
        Set<POS_Cashier> pos_cashierSet = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", pos_cashierSet.size()>0);

        //READ ENTITY
        POS_Cashier entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        //UPDATE ENTITY
        POS_Cashier updateEntity = new POS_Cashier.Builder()
                .copy(entity)
                .password("12")
                .build();
        repo.update(updateEntity);
        POS_Cashier newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "12", newEntity.getPassword());

        //DELETE ENTITY
        repo.delete(updateEntity);
        POS_Cashier deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE ", deletedEntity);

    }
}
