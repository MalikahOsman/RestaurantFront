package com.example.osman.restaurantmsandroid.repository;

import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.domain.MainCourse;
import com.example.osman.restaurantmsandroid.repositories.Impl.MainCourseRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.MainCourseRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-04-27.
 */
public class MainCourseRepositoryTest extends AndroidTestCase {
    private static final String TAG = "MAINCOURSE TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        MainCourseRepository repo = new MainCourseRepositoryImpl(this.getContext());
        //CREATE
        MainCourse createEntity = new MainCourse.Builder()
                .mainID("120")
                .foodItem("spare ribs")
                .build();
        MainCourse insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        //READ ALL
        Set<MainCourse> mainCourseSet = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", mainCourseSet.size()>0);

        //READ ENTITY
        MainCourse entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        //UPDATE ENTITY
        MainCourse updateEntity = new MainCourse.Builder()
                .copy(entity)
                .build();
        repo.update(updateEntity);
        MainCourse newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "120", newEntity.getMainID());

        //DELETE ENTITY
        repo.delete(updateEntity);
        MainCourse deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE ", deletedEntity);

    }
}
