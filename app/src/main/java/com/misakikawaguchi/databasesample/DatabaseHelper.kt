package com.misakikawaguchi.databasesample

import android.content.Context
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
}