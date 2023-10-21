package com.example.interiorvisioniv.helper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.interiorvisioniv.data.User

val TAG = "DBHelper"
const val TABLE_USERDATA = "UserData"
const val COL_USERID = "userID"
const val COL_USERNAME = "name"
const val COL_EMAIL = "email"
const val COL_PASSWORD = "password"
const val TABLE_FURNITURE_DATA = "FurnitureData"
const val COL_FURNITURE_ID = "furnitureID"
const val COL_FURNITURE_NAME = "furnitureName"
const val COL_IMAGE_PATH = "imagePath"
const val COL_FURNITURE_DETAILS = "furnitureDetails"
const val COL_CATEGORY = "category"

class DBHelper(context: Context): SQLiteOpenHelper(context, "IVDatabase", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE " +
                "$TABLE_USERDATA (" +
                "$COL_USERID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL_USERNAME TEXT, " +
                "$COL_EMAIL TEXT, " +
                "$COL_PASSWORD TEXT)")

        db?.execSQL("CREATE TABLE " +
                "$TABLE_FURNITURE_DATA (" +
                "$COL_FURNITURE_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL_CATEGORY TEXT, " +
                "$COL_FURNITURE_NAME TEXT, " +
                "$COL_FURNITURE_DETAILS TEXT, " +
                "$COL_IMAGE_PATH TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERDATA")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_FURNITURE_DATA")

        onCreate(db)
    }

    fun insertUserData(user: User): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_USERNAME, user.name)
        contentValues.put(COL_EMAIL, user.email)
        contentValues.put(COL_PASSWORD, user.password)

        val result = db.insert(TABLE_USERDATA, null, contentValues)
        db.close()

        return result != -1L
    }

    fun checkUser(email: String, password: String): Boolean {
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_USERDATA WHERE $COL_EMAIL = '$email' AND $COL_PASSWORD = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    fun checkEmailValidate(email: String): Boolean {
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_USERDATA WHERE $COL_EMAIL = '$email'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    fun updatePass(email: String, password: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_PASSWORD, password)

        val result = db.update(TABLE_USERDATA, contentValues, "$COL_EMAIL = ?", arrayOf(email))
        db.close()

        return result != -1
    }

    fun updateName(currentEmail: String, newName: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_USERNAME, newName)

        val result = db.update(TABLE_USERDATA, contentValues, "$COL_EMAIL = ?", arrayOf(currentEmail))
        db.close()

        return result != -1
    }

    fun updateEmail(currentEmail: String, newEmail: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_EMAIL, newEmail)

        val result = db.update(TABLE_USERDATA, contentValues, "$COL_EMAIL = ?", arrayOf(currentEmail))
        db.close()

        return result != -1
    }

    fun insertFurniture(category: String, name: String, details: String, imagePath: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_CATEGORY, category)
        contentValues.put(COL_FURNITURE_NAME, name)
        contentValues.put(COL_FURNITURE_DETAILS, details)
        contentValues.put(COL_IMAGE_PATH, imagePath)

        val result = db.insert(TABLE_FURNITURE_DATA, null, contentValues)
        db.close()

        return result != -1L
    }

    fun getUserData(): List<User> {
        val userList = mutableListOf<User>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_USERDATA"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_USERID))
            val name = cursor.getString(cursor.getColumnIndexOrThrow(COL_USERNAME))
            val email = cursor.getString(cursor.getColumnIndexOrThrow(COL_EMAIL))
            val password = cursor.getString(cursor.getColumnIndexOrThrow(COL_PASSWORD))

            val user = User(id, name, email, password)
            userList.add(user)
        }
        cursor.close()
        db.close()
        return userList
    }
}