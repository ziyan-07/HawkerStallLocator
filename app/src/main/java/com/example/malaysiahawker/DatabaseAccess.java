package com.example.malaysiahawker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c;

    //constructor
    DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //to open database
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    //closing the db connection
    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    public List<HawkerData> getsearchhawker(String name) {
        List<HawkerData> temp = new ArrayList<>();
        Cursor c;
        try {
            c = db.rawQuery("Select * from Hawker where lower(name) LIKE '%" + name + "%'", new String[]{});
            //if(c==null) return null;
            c.moveToFirst();
            do {
                String naming = c.getString(5);
                String addressing = c.getString(0);
                String descriptioning = c.getString(1);
                String displayphonenoing = c.getString(2);
                String isopening = c.getString(3);
                int favouritesing = c.getInt(4);
                String phoneing = c.getString(6);
                int recommendsing = c.getInt(7);
                String reviewing = c.getString(8);
                String openinghoursing = c.getString(9);

                byte[] photing = c.getBlob(10);

                byte[] photing1 = c.getBlob(11);
                if (c.getBlob(11) != null) {
                    photing1 = c.getBlob(11);
                }

                byte[] photing2 = c.getBlob(12);
                if (c.getBlob(12) != null) {
                    photing2 = c.getBlob(12);
                }

                byte[] photing3 = c.getBlob(13);
                if (c.getBlob(13) != null) {
                    photing3 = c.getBlob(13);
                }

                byte[] photing4 = c.getBlob(14);
                if (c.getBlob(14) != null) {
                    photing4 = c.getBlob(14);
                }

                HawkerData data = new HawkerData(naming, addressing, descriptioning, displayphonenoing, isopening, favouritesing, phoneing, recommendsing, reviewing, openinghoursing, photing, photing1, photing2, photing3, photing4);
                temp.add(data);
            } while (c.moveToNext());
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return temp;
    }

    public List<HawkerData> getsorthawker(String sortt) {
        List<HawkerData> temp = new ArrayList<>();
        Cursor c;

        try {
            if(sortt == "ascending") {
                c = db.rawQuery("Select * from Hawker order by name DESC", new String[]{});  //ascending order
            }
            else if (sortt == "descending" ) {
                c = db.rawQuery("Select * from Hawker order by name ", new String[]{});  //descending order
            }
            else return null;
            c.moveToFirst();
            do {
                String naming = c.getString(5);
                String addressing = c.getString(0);
                String descriptioning = c.getString(1);
                String displayphonenoing = c.getString(2);
                String isopening = c.getString(3);
                int favouritesing = c.getInt(4);
                String phoneing = c.getString(6);
                int recommendsing = c.getInt(7);
                String reviewing = c.getString(8);
                String openinghoursing = c.getString(9);

                byte[] photing = c.getBlob(10);

                byte[] photing1 = c.getBlob(11);
                if (c.getBlob(11) != null) {
                    photing1 = c.getBlob(11);
                }

                byte[] photing2 = c.getBlob(12);
                if (c.getBlob(12) != null) {
                    photing2 = c.getBlob(12);
                }

                byte[] photing3 = c.getBlob(13);
                if (c.getBlob(13) != null) {
                    photing3 = c.getBlob(13);
                }

                byte[] photing4 = c.getBlob(14);
                if (c.getBlob(14) != null) {
                    photing4 = c.getBlob(14);
                }

                HawkerData data = new HawkerData(naming, addressing, descriptioning, displayphonenoing, isopening, favouritesing, phoneing, recommendsing, reviewing, openinghoursing, photing, photing1, photing2, photing3, photing4);
                temp.add(data);
            } while (c.moveToNext());
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return temp;
    }

    public List<HawkerData> getrecommendshawker() {
        List<HawkerData> temp = new ArrayList<>();
        Cursor c;
        try {
                c = db.rawQuery("Select * from Hawker order by recommends DESC", null);  //highest recommendation start first

            c.moveToFirst();
            do {
                String naming = c.getString(5);
                String addressing = c.getString(0);
                String descriptioning = c.getString(1);
                String displayphonenoing = c.getString(2);
                String isopening = c.getString(3);
                int favouritesing = c.getInt(4);
                String phoneing = c.getString(6);
                int recommendsing = c.getInt(7);
                String reviewing = c.getString(8);
                String openinghoursing = c.getString(9);

                byte[] photing = c.getBlob(10);

                byte[] photing1 = c.getBlob(11);
                if (c.getBlob(11) != null) {
                    photing1 = c.getBlob(11);
                }

                byte[] photing2 = c.getBlob(12);
                if (c.getBlob(12) != null) {
                    photing2 = c.getBlob(12);
                }

                byte[] photing3 = c.getBlob(13);
                if (c.getBlob(13) != null) {
                    photing3 = c.getBlob(13);
                }

                byte[] photing4 = c.getBlob(14);
                if (c.getBlob(14) != null) {
                    photing4 = c.getBlob(14);
                }

                HawkerData data = new HawkerData(naming, addressing, descriptioning, displayphonenoing, isopening, favouritesing, phoneing, recommendsing, reviewing, openinghoursing, photing, photing1, photing2, photing3, photing4);
                temp.add(data);
            } while (c.moveToNext());
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return temp;
    }
}
