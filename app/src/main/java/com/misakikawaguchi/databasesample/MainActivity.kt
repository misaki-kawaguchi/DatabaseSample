package com.misakikawaguchi.databasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // 選択されたカクテルの主キーIDを表すフィールド
    private var _cocktailId = -1

    // 選択されたカクテル名を表すフィールド
    private var _cocktailName  = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}