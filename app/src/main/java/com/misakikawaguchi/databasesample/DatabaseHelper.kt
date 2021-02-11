package com.misakikawaguchi.databasesample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// データベースヘルパークラス
// 第一引数：コンテキスト、第二引数：使用するデータベース名（DATABASE_NAME）
// 第三引数：カーソルファクトリオブジェクト（通常はnull）、第四引数：データベースのバージョン番号（DATABASE_VERSION）
class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // クラス内のprivate定数を宣言するためにcompanion objectブロックとする
    companion object {
        // データベースファイル名の定数フィールド
        private const val DATABASE_NAME = "cocktailmemo.db"
        // バージョン情報の定数フィールド
        private const val DATABASE_VERSION = 1
    }

    // Android端末内部に親クラスのコンストラクタで指定したデータベース名のデータベースが存在しないとき（初期状態に1回だけ実行される）
    // 初期設定に必要なSQLはonCreate()で実行する
    override fun onCreate(db: SQLiteDatabase) {
        // テーブル作成用SQL文字列の作成
        val sb = StringBuilder()
        sb.append("CREATE TABLE cocktailmemos(")
        // カラム名：_id, 内容：カクテルリストビュー上の行番号, データ型：INTEGER
        sb.append("_id INTEGER PRIMARY KEY,")
        // カラム名：name, 内容：カクテル名, データ型：TEXT
        sb.append("name TEXT,")
        // カラム名：note, 内容：感想, データ型：TEXT
        sb.append("note TEXT")
        sb.append(");")
        val sql = sb.toString()

        // SQLの実行（cocktailmemosテーブルを作成するSQL文を実行）
        db.execSQL(sql)
    }

    // 内部のデータベースのバージョン番号とコンストラクタの引数で渡されるバージョン番号に違いがある場合に実行される
    // 第一引数：データベース接続オブジェクト、第二引数：内部データベースの現在のバージョン番号、第三引数：コンストラクタで設定されたバージョン番号
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}