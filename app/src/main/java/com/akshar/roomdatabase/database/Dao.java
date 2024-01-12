package com.akshar.roomdatabase.database;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Interface for the Data Access Object (DAO) that provides methods for interacting with the database.
 * It uses Room persistence library annotations to define SQL operations.
 */
@androidx.room.Dao
public interface Dao {

    /**
     * Inserts a new course into the database.
     *
     * @param courseModal The course to be inserted.
     */
    @Insert
    void insert(CourseModal courseModal);

    /**
     * Updates an existing course in the database.
     *
     * @param courseModal The course to be updated.
     */
    @Update
    void update(CourseModal courseModal);

    /**
     * Deletes a course from the database.
     *
     * @param courseModal The course to be deleted.
     */
    @Delete
    void delete(CourseModal courseModal);

    /**
     * Deletes all courses from the database.
     */
    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    /**
     * Retrieves all courses from the database, ordered by their ID in descending order.
     *
     * @return A LiveData list of all courses.
     */
    @Query("SELECT * FROM course_table ORDER BY id DESC")
    LiveData<List<CourseModal>> getAllCourses();
}