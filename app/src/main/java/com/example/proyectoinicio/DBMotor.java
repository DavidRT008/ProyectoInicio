package com.example.proyectoinicio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBMotor extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "Motor.db";
    private static final int VERSION_BASE_DATOS = 1;
    private static final String TABLA_USUARIOS = "usuarios";

    public DBMotor(@Nullable Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLA_USUARIOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "correo TEXT UNIQUE NOT NULL," +
                "contrasena TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIOS);
        onCreate(db);
    }

    public boolean insertarUsuario(User usuario) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = crearValoresUsuario(usuario);
        long id;

        try {
            id = db.insertOrThrow(TABLA_USUARIOS, null, valores);
        } catch (SQLiteConstraintException exception) {
            return false;
        }

        usuario.setId(id);
        return true;
    }

    public ArrayList<User> obtenerUsuarios() {
        ArrayList<User> usuarios = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.query(
                TABLA_USUARIOS,
                new String[]{"id", "correo", "contrasena"},
                null,
                null,
                null,
                null,
                "id ASC")) {
            while (cursor.moveToNext()) {
                usuarios.add(crearUsuarioDesdeCursor(cursor));
            }
        }

        return usuarios;
    }

    public User obtenerUsuario(long id) {
        SQLiteDatabase db = getReadableDatabase();

        try (Cursor cursor = db.query(
                TABLA_USUARIOS,
                new String[]{"id", "correo", "contrasena"},
                "id=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null)) {
            if (cursor.moveToFirst()) {
                return crearUsuarioDesdeCursor(cursor);
            }
        }

        return null;
    }

    public boolean actualizarUsuario(User usuario) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = crearValoresUsuario(usuario);

        try {
            int filas = db.update(
                    TABLA_USUARIOS,
                    valores,
                    "id=?",
                    new String[]{String.valueOf(usuario.getId())});
            return filas > 0;
        } catch (SQLiteConstraintException exception) {
            return false;
        }
    }

    public boolean eliminarUsuario(long id) {
        SQLiteDatabase db = getWritableDatabase();
        int filas = db.delete(
                TABLA_USUARIOS,
                "id=?",
                new String[]{String.valueOf(id)});
        return filas > 0;
    }

    public int contarUsuarios() {
        SQLiteDatabase db = getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLA_USUARIOS);
    }

    private ContentValues crearValoresUsuario(User usuario) {
        ContentValues valores = new ContentValues();
        valores.put("correo", usuario.getMail());
        valores.put("contrasena", usuario.getPassword());
        return valores;
    }

    private User crearUsuarioDesdeCursor(Cursor cursor) {
        return new User(
                cursor.getLong(cursor.getColumnIndexOrThrow("id")),
                cursor.getString(cursor.getColumnIndexOrThrow("correo")),
                cursor.getString(cursor.getColumnIndexOrThrow("contrasena")));
    }
}
