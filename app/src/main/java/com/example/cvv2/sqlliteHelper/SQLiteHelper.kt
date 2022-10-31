package com.suis.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.cvv2.dataCalss.Experience

class SQLiteHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "cvv2.db"


        private const val TBL_EXPERIENCE = "tbl_experience"
        private const val ID = "id"
        private const val NAME = "name"
        private const val ADDRESS = "address"
        private const val  END_DATE= "end_date"
        private const val DESCRIPTION = "description"
        private const val START_DATE = "start_date"
        private const val IMAGE = "image"

        //table experience
        private const val TBL_EDUCATION = "tbl_education"
        private const val ID_EDUCATION = "id"
        private const val NAME_EDUCATION = "name"
        private const val ADDRESS_EDUCATION = "address"
        private const val  END_DATE_EDUCATION= "end_date"
        private const val DESCRIPTION_EDUCATION = "description"
        private const val START_DATE_EDUCATION = "start_date"
        private const val IMAGE_EDUCATION = "image_education"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val createTblStudent = ("CREATE TABLE " + TBL_EXPERIENCE + " ("
                + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, "
                + ADDRESS + " TEXT, "+ DESCRIPTION + " TEXT, "+ START_DATE + " TEXT, "+ END_DATE + " TEXT, "+ IMAGE + " INTEGER" +")"
                )
        db?.execSQL(createTblStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_EXPERIENCE")
        onCreate(db)
    }

    fun insertExperience(expr: Experience): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(ID, expr.id)
        contentValues.put(NAME, expr.name)
        contentValues.put(ADDRESS, expr.adress)
        contentValues.put(DESCRIPTION, expr.description)
        contentValues.put(START_DATE, expr.startDate)
        contentValues.put(END_DATE, expr.endDate)
        contentValues.put(IMAGE, expr.img)

        val success = db.insert(TBL_EXPERIENCE, null, contentValues)
        db.close()
        return success
    }

    fun getAllExperiences(): ArrayList<Experience> {
        val exprList: ArrayList<Experience> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_EXPERIENCE"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var name: String
        var address: String
        var description: String
        var startDate: String
        var endDate: String
        var image: Int

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                address = cursor.getString(cursor.getColumnIndexOrThrow("address"))
                description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
                startDate = cursor.getString(cursor.getColumnIndexOrThrow("start_date"))
                endDate = cursor.getString(cursor.getColumnIndexOrThrow("end_date"))
                image = cursor.getInt(cursor.getColumnIndexOrThrow("image"))
                val std = Experience(id = id, name = name, adress = address, description = description, startDate = startDate, endDate = endDate, img = image)
                exprList.add(std)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return exprList
    }

    fun deleteExperience(expr: Experience): Int {
        val db = this.writableDatabase
        val success = db.delete(TBL_EXPERIENCE, ID + "=" + expr.id, null)
        db.close()
        return success
    }

}