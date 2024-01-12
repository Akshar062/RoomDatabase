package com.akshar.roomdatabase.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Represents the database for the application.
 * It is an abstract class that extends RoomDatabase.
 * It contains an abstract method to get the Data Access Object (DAO).
 * It also contains a method to get an instance of the database.
 */
@Database(entities = {CourseModal.class}, version = 1)
public abstract class CourseDatabase extends RoomDatabase {

    /**
     * The instance of the database.
     */
    private static CourseDatabase instance;

    /**
     * Returns the DAO for the database.
     *
     * @return The DAO for the database.
     */
    public abstract Dao getDao();

    /**
     * Returns an instance of the database.
     * If the instance is null, it creates a new instance.
     *
     * @param context The context.
     * @return The instance of the database.
     */
    public static synchronized CourseDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CourseDatabase.class, "course_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    /**
     * The callback for the database.
     * It creates a new PopulateDbAsyncTask when the database is created.
     */
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDbAsyncTask(instance).execute();
        }
    };

    /**
     * Represents an asynchronous task to populate the database.
     * It is a static class that extends AsyncTask.
     */
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        /**
         * The DAO for the database.
         */
        private Dao dao;

        /**
         * Creates a new PopulateDbAsyncTask.
         *
         * @param db The database.
         */
        private PopulateDbAsyncTask(CourseDatabase db) {
            dao = db.getDao();
        }

        /**
         * The task to be performed in the background.
         *
         * @param voids The parameters of the task.
         * @return null.
         */
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}