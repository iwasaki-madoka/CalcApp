package jp.techacademy.madoka.iwasaki

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 計算式と数値のデータを受け取る
        val formula     = intent.getStringExtra("formula")
        val resultVal   = intent.getDoubleExtra("resultVal",0.0)

        // テキスト表示
        text1.text = formula
        text2.text = resultVal.toString()
    }
}
