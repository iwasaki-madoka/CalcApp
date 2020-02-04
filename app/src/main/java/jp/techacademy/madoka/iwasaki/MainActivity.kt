package jp.techacademy.madoka.iwasaki

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.content.Intent
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 四則演算のボタンにイベントリスナーをセット
        button_add.setOnClickListener(this)
        button_sub.setOnClickListener(this)
        button_mul.setOnClickListener(this)
        button_div.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        // EditText2つに値が入力されていない場合
        if(editText1.text.toString().equals("") || editText2.text.toString().equals("")){
            // Snackbarにメッセージを表示してイベントを終了
            Snackbar.make(v, "数値を2つ入力してください", Snackbar.LENGTH_SHORT).show()
            return
        }

        // 変数に入力された数値を格納
        var val1 = editText1.text.toString().toDouble()
        var val2 = editText2.text.toString().toDouble()

        // 変数の宣言と初期化
        var resultVal = 0.toDouble()
        var formula = ""

        // ボタンの種類に応じて計算
        when(v.id){
            R.id.button_add -> {resultVal = val1 + val2; formula = "${val1} + ${val2}"}
            R.id.button_sub -> {resultVal = val1 - val2; formula = "${val1} - ${val2}"}
            R.id.button_mul -> {resultVal = val1 * val2; formula = "${val1} × ${val2}"}
            R.id.button_div -> {resultVal = val1 / val2; formula = "${val1} / ${val2}"}
        }

        // resultアクティビティに遷移
        val intent = Intent(this, result::class.java)
        intent.putExtra("formula", formula)
        intent.putExtra("resultVal", resultVal)
        startActivity(intent)
    }
}
