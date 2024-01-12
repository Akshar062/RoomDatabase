package com.akshar.roomdatabase.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Repository for managing data operations in the Course database.
 * It provides a clean API to the rest of the app for app data handling.
 */
public class CourseRepository {
    /**
     * DAO to access database operations
     */
    private Dao dao;

    /**
     * LiveData list of all courses
     */
    private LiveData<List<CourseModal>> allCourses;

    /**
     * Constructor for the CourseRepository.
     *
     * @param application Application context.
     */
    public CourseRepository(Application application) {
        CourseDatabase database = CourseDatabase.getInstance(application);
        dao = database.getDao();
        allCourses = dao.getAllCourses();
    }

    /**
     * Insert a course into the database.
     *
     * @param courseModal The course to be inserted.
     */
    public void insert(CourseModal courseModal) {
        new InsertCourseAsyncTask(dao).execute(courseModal);
    }

    /**
     * Update a course in the database.
     *
     * @param courseModal The course to be updated.
     */
    public void update(CourseModal courseModal) {
        new UpdateCourseAsyncTask(dao).execute(courseModal);
    }

    /**
     * Delete a course from the database.
     *
     * @param courseModal The course to be deleted.
     */
    public void delete(CourseModal courseModal) {
        new DeleteCourseAsyncTask(dao).execute(courseModal);
    }

    /**
     * Delete all courses from the database.
     */
    public void deleteAllCourses() {
        new DeleteAllCoursesAsyncTask(dao).execute();
    }

    /**
     * Get all courses from the database.
     *
     * @return LiveData list of all courses.
     */
    public LiveData<List<CourseModal>> getAllCourses() {
        return allCourses;
    }

    /**
     * AsyncTask to insert a course into the database.
     */
    public static class InsertCourseAsyncTask extends AsyncTask<CourseModal, Void, Void> {
        private Dao dao;

        private InsertCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CourseModal... courseModals) {
            dao.insert(courseModals[0]);
            return null;
        }
    }

    /**
     * AsyncTask to update a course in the database.
     */
    public static class UpdateCourseAsyncTask extends AsyncTask<CourseModal, Void, Void> {
        private Dao dao;

        private UpdateCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CourseModal... courseModals) {
            dao.update(courseModals[0]);
            return null;
        }
    }

    /**
     * AsyncTask to delete a course from the database.
     */
    public static class DeleteCourseAsyncTask extends AsyncTask<CourseModal, Void, Void> {
        private Dao dao;

        private DeleteCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CourseModal... courseModals) {
            dao.delete(courseModals[0]);
            return null;
        }
    }

    /**
     * AsyncTask to delete all courses from the database.
     */
    public static class DeleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;

        private DeleteAllCoursesAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllCourses();
            return null;
        }
    }
}