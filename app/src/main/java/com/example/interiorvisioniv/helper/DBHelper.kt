package com.example.interiorvisioniv.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.interiorvisioniv.data.User

val TAG = "DBHelper"
const val TABLE_USERDATA = "UserData"
const val COL_USERID = "userID"
const val COL_USERNAME = "name"
const val COL_EMAIL = "email"
const val COL_PASSWORD = "password"
const val TABLE_FURNITURE = "favoritesTable"
const val COL_FURNITURE_ID = "furnitureID"
const val COL_FURNITURE_NAME = "furnitureName"
const val COL_IMAGE_PATH = "imagePath"
const val COL_CATEGORY = "category"
const val COL_PRICE = "itemPrice"
const val COL_FAV_STATUS = "favStatus"

class DBHelper(context: Context): SQLiteOpenHelper(context, "IVDatabase", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE " +
                "$TABLE_USERDATA (" +
                "$COL_USERID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL_USERNAME TEXT, " +
                "$COL_EMAIL TEXT, " +
                "$COL_PASSWORD TEXT)")

        db?.execSQL("CREATE TABLE " +
                "$TABLE_FURNITURE (" +
                "$COL_FURNITURE_ID TEXT PRIMARY KEY, " +
                "$COL_CATEGORY TEXT, " +
                "$COL_IMAGE_PATH INT, " +
                "$COL_FURNITURE_NAME TEXT, " +
                "$COL_PRICE DOUBLE, " +
                "$COL_FAV_STATUS TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERDATA")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_FURNITURE")

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

    fun updateUserNameByEmail(email: String, newName: String): Boolean {
        if (email.isBlank() || newName.isBlank()) {
            return false
        }

        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_USERNAME, newName)

        val result = db.update(TABLE_USERDATA, contentValues, "$COL_EMAIL = ?", arrayOf(email))
        db.close()

        return result != -1
    }

    fun insertFurnitureData(id: String, category: String, imagePath: Int, itemName: String, price: Double, favStatus: String) {
        val db = this.writableDatabase

        val existingRecordCursor = db.rawQuery("SELECT * FROM $TABLE_FURNITURE WHERE $COL_FURNITURE_ID = ?", arrayOf(id))

        if (existingRecordCursor.count > 0) {
            val contentValues = ContentValues()
            contentValues.put(COL_CATEGORY, category)
            contentValues.put(COL_IMAGE_PATH, imagePath)
            contentValues.put(COL_FURNITURE_NAME, itemName)
            contentValues.put(COL_PRICE, price)
            contentValues.put(COL_FAV_STATUS, favStatus)

            db.update(TABLE_FURNITURE, contentValues, "$COL_FURNITURE_ID = ?", arrayOf(id))
        } else {

            val contentValues = ContentValues()
            contentValues.put(COL_FURNITURE_ID, id)
            contentValues.put(COL_CATEGORY, category)
            contentValues.put(COL_IMAGE_PATH, imagePath)
            contentValues.put(COL_FURNITURE_NAME, itemName)
            contentValues.put(COL_PRICE, price)
            contentValues.put(COL_FAV_STATUS, favStatus)

            db.insert(TABLE_FURNITURE, null, contentValues)
        }

        existingRecordCursor.close()
    }

    fun readAllFurnitureData(id: String): Cursor {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_FURNITURE WHERE $COL_FURNITURE_ID = $id"
        return db.rawQuery(query, null, null)
    }

    fun removeFromFaves(id: String) {
        val db = this.writableDatabase
        val query = "UPDATE $TABLE_FURNITURE SET $COL_FAV_STATUS='0' WHERE $COL_FURNITURE_ID=$id"
        db.execSQL(query)
    }

    fun selectAllFaves(): Cursor {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_FURNITURE WHERE $COL_FAV_STATUS = '1'"
        return db.rawQuery(query, null, null)
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

    fun getUserIdByEmail(email: String): Int {
        val db = readableDatabase
        val query = "SELECT $COL_USERID FROM $TABLE_USERDATA WHERE $COL_EMAIL = ?"
        val cursor = db.rawQuery(query, arrayOf(email))
        var userId = -1 // Default value to indicate user not found

        if (cursor.moveToFirst()) {
            userId = cursor.getInt(0) // Assuming COL_USERID is the first column (index 0)
        }

        cursor.close()
        db.close()

        return userId
    }

}